package com.serviceImpl.purchase;

import com.bean.purchase.*;
import com.bean.suppliers.SuppliersReturnBean;
import com.bean.suppliers.SuppliersReturnListBean;
import com.entity.BuyerEntity;
import com.entity.GoodsEntity;
import com.entity.PurchaseRecordEntity;
import com.repository.goods.GoodsRepository;
import com.repository.purchase.PurchaseRecordRepository;
import com.service.purchase.PurchaseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class PurchaseRecordImpl implements PurchaseRecordService {
    @Autowired
    private PurchaseRecordRepository purchaseRecordRepository;

    @Autowired
    private GoodsRepository goodsRepository;

    private static PurchaseRecordImpl purchaseRecordImpl;
    private static int idLength = 6;

    @PostConstruct
    public void init(){
        purchaseRecordImpl = this;
        purchaseRecordImpl.purchaseRecordRepository = this.purchaseRecordRepository;
        purchaseRecordImpl.goodsRepository = this.goodsRepository;
    }

    @Override
    public String addPurchaseRecord(AddPurchaseRecordBean bean) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = dateFormat.format(new Date());
        String id = "";
        for(int i = 0; i < idLength; i++) id = id + "" + (int)(Math.random() * 10);
        id = time + id;

        PurchaseRecordEntity entity = new PurchaseRecordEntity();
        entity.setId(id);
        entity.setCreateTime(time);
        entity.setPurchaseTime(bean.getPurchaseTime());
        entity.setGoodsNumber(bean.getGoodsNumber());
        entity.setNumbers(bean.getNumbers());
        entity.setDiscount(bean.getDiscount());
        entity.setUnitPrice(bean.getUnitPrice());
        entity.setBalance(bean.getDiscount());
        entity.setTaxIncluded(bean.getTaxIncluded());
        entity.setPrecautionsForPreservation(bean.getPrecautionsForPreservation());
        entity.setRemarks(bean.getRemarks());

        try{
            purchaseRecordImpl.purchaseRecordRepository.save(entity);
            return id;
        }catch (Exception addException){
            addException.printStackTrace();
            return "录入进货记录出错";
        }
    }

    @Override
    public PurchaseRecordsBean getPurchaseRecords(GetPurchaseRecordsBean bean) {
        List<PurchaseRecordsListBean> listBeans = new ArrayList<>();
        List<PurchaseRecordEntity> purchaseRecordEntityList = purchaseRecordImpl.purchaseRecordRepository.findAll();

        for (PurchaseRecordEntity purchaseRecord: purchaseRecordEntityList) {
            PurchaseRecordsListBean returnListBean = new PurchaseRecordsListBean();
            returnListBean.setId(purchaseRecord.getId());
            returnListBean.setPurchaseTime(purchaseRecord.getPurchaseTime());
            returnListBean.setCreateTime(purchaseRecord.getCreateTime());
            returnListBean.setGoodsNumber(purchaseRecord.getGoodsNumber());
            returnListBean.setBrand(purchaseRecord.getGoodsNumber());
            returnListBean.setGoodsName(purchaseRecord.getGoodsNumber());
            returnListBean.setUnitPrice(purchaseRecord.getUnitPrice());
            returnListBean.setNumbers(purchaseRecord.getNumbers());
            returnListBean.setTotalAmount(purchaseRecord.getBalance());
            returnListBean.setSupplier(purchaseRecord.getBuyer());

           listBeans.add(returnListBean);
        }

       PurchaseRecordsBean purchaseRecordsBean = new PurchaseRecordsBean(listBeans, listBeans.size());
        return purchaseRecordsBean;
    }

    @Override
    public SinglePurchaseRecordByIdBean getSinglePurchaseRecordById(String id) {
        Optional<PurchaseRecordEntity> optionalPurchaseRecord = purchaseRecordImpl.purchaseRecordRepository.findById(id);
        PurchaseRecordEntity purchaseRecord = optionalPurchaseRecord.isPresent() ? optionalPurchaseRecord.get() : null;
        if(purchaseRecord != null){
            Optional<GoodsEntity> optionalGoods = purchaseRecordImpl.goodsRepository.findById(purchaseRecord.getGoodsNumber());
            GoodsEntity goods = optionalGoods.isPresent() ? optionalGoods.get() : null;
            if(goods != null){
                SinglePurchaseRecordByIdBean bean = new SinglePurchaseRecordByIdBean();
                bean.setId(id);
                bean.setPurchaseTime(purchaseRecord.getPurchaseTime());
                bean.setGoodsNumber(goods.getGoodsNumber());
                bean.setBrand(goods.getBrand());
                bean.setGoodsName(goods.getGoodsName());
                bean.setModel(goods.getModel());
                bean.setGoodsNo(goods.getGoodsNo());
                bean.setMaterial(goods.getMaterial());
                bean.setUnit(goods.getUnit());
                bean.setRetailPrice(goods.getRetailPrice());
                bean.setNumbers(goods.getStock());
                bean.setDiscount(purchaseRecord.getDiscount());
                bean.setUnitPrice(purchaseRecord.getUnitPrice());
                bean.setTotalAmount(purchaseRecord.getBalance());
                bean.setTaxIncluded(purchaseRecord.getTaxIncluded());
                bean.setPrecautionForPreservation(purchaseRecord.getPrecautionsForPreservation());
                bean.setSupplier(purchaseRecord.getBuyer());
                bean.setRemarks(purchaseRecord.getRemarks());
                bean.setCreateTime(purchaseRecord.getCreateTime());

                return bean;
            }
        }
        return null;
    }

    @Override
    public String updateSinglePurchaseRecordById(UpdateSinglePurchaseRecordsBean bean) {
        Optional<PurchaseRecordEntity> optionalPurchaseRecord = purchaseRecordImpl.purchaseRecordRepository.findById(bean.getId());
        PurchaseRecordEntity purchaseRecord = optionalPurchaseRecord.isPresent() ? optionalPurchaseRecord.get() : null;
        if(purchaseRecord != null){
            try{
                purchaseRecordImpl.purchaseRecordRepository.updateSinglePurchaseRecord(bean.getId(),bean.getPurchaseTime(),
                        bean.getGoodsNumber(),bean.getNumbers(), bean.getDiscount(),bean.getUnitPrice(),bean.getTotalAmount(),
                        bean.getTaxIncluded(),bean.getPrecautionForPreservation(),bean.getSupplierNumber(),bean.getRemarks());

                return bean.getId();
            }catch (Exception ex){
                ex.printStackTrace();
                return "修改单个进货记录出错";
            }
        }
        return "修改单个进货记录出错";
    }

    @Override
    public boolean deleteSinglePurchaseRecordById(String id) {
        try{
            purchaseRecordImpl.purchaseRecordRepository.deleteById(id);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

}
