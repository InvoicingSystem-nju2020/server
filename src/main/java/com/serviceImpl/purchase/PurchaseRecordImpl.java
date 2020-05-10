package com.serviceImpl.purchase;

import com.bean.purchase.*;
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
        List<PurchaseRecordsListBean> totalBeanList = new ArrayList<>();
        List<PurchaseRecordsListBean> resultBeanList = new ArrayList<>();
        List<PurchaseRecordEntity> entityList = new ArrayList<>();

        String recordGoodsName = bean.getGoodsName();
        String recordBrand = bean.getBrand();
        String recordSupplier = bean.getSupplier();
        int recordMinNumbers = bean.getMinNumbers();
        int recordMaxNumbers = bean.getMaxNumbers();
        double recordMinRetailPrice = bean.getMinRetailPrice();
        double recordMaxRetailPrice = bean.getMaxRetailPrice();
        double recordMinDiscount = bean.getMinDiscount();
        double recordMaxDiscount = bean.getMaxDiscount();
        double recordMinUnitPrice = bean.getMinUnitPrice();
        double recordMaxUnitPrice = bean.getMaxUnitPrice();
        double recordMinTotalAmount = bean.getMinTotalAmount();
        double recordMaxTotalAmount = bean.getMaxTotalAmount();
        int recordTaxIncluded = bean.getTaxIncluded();
        String recordSorter = bean.getSorter();
        int recordDesc = bean.getDesc();
        int recordStartIndex = bean.getStartIndex();
        int recordNum = bean.getNum();

        if(recordSorter.equals("purchaseTime")) entityList = purchaseRecordImpl.purchaseRecordRepository.findAll();
        else if(recordSorter.equals("createTime")) entityList = purchaseRecordImpl.purchaseRecordRepository.findAll();
        else if(recordSorter.equals("") || recordSorter == null){
            if(recordDesc == 1) entityList = purchaseRecordImpl.purchaseRecordRepository.findByIdDesc();
            else entityList = purchaseRecordImpl.purchaseRecordRepository.findByIdInc();
        }
        else if(recordSorter.equals("goodsNumber")){
            if(recordDesc == 1) entityList = purchaseRecordImpl.purchaseRecordRepository.findByGoodsNumberDesc();
            else entityList = purchaseRecordImpl.purchaseRecordRepository.findByGoodsNumberInc();
        }
        else if(recordSorter.equals("numbers")){
            if(recordDesc == 1) entityList = purchaseRecordImpl.purchaseRecordRepository.findByNumbersDesc();
            else entityList = purchaseRecordImpl.purchaseRecordRepository.findByNumbersInc();
        }
        else if(recordSorter.equals("retailPrice")){
            if(recordDesc == 1) entityList = purchaseRecordImpl.purchaseRecordRepository.findByRetailPriceDesc();
            else entityList = purchaseRecordImpl.purchaseRecordRepository.findByRetailPriceInc();
        }
        else if(recordSorter.equals("discount")){
            if(recordDesc == 1) entityList = purchaseRecordImpl.purchaseRecordRepository.findByDiscountDesc();
            else entityList = purchaseRecordImpl.purchaseRecordRepository.findByDiscountInc();
        }
        else if(recordSorter.equals("unitPrice")){
            if(recordDesc == 1) entityList = purchaseRecordImpl.purchaseRecordRepository.findByUnitPriceDesc();
            else entityList = purchaseRecordImpl.purchaseRecordRepository.findByUnitPriceInc();
        }
        else if(recordSorter.equals("totalAmount")){
            if(recordDesc == 1) entityList = purchaseRecordImpl.purchaseRecordRepository.findByTotalAmountDesc();
            else entityList = purchaseRecordImpl.purchaseRecordRepository.findByTotalAmountInc();
        }

        for(PurchaseRecordEntity entity : entityList){
            String entityId = entity.getId();
            String entityCreateTime = entity.getCreateTime();
            String entityPurchaseTime = entity.getPurchaseTime();
            String entityGoodsNumber = entity.getGoodsNumber();
            int entityNumbers= entity.getNumbers();
            double entityDiscount = entity.getDiscount();
            double entityUnitPrice = entity.getUnitPrice();
            double entityBalance = entity.getBalance();
            int entityTaxIncluded = entity.getTaxIncluded();

            boolean taxIncludedFlag = recordTaxIncluded == entityTaxIncluded;
            boolean numbersFlag = recordMinNumbers < entityNumbers && recordMaxNumbers > entityNumbers;
            boolean retailPriceFlag = recordMinRetailPrice < entityUnitPrice && recordMaxRetailPrice > entityUnitPrice;
            boolean discountFlag = recordMinDiscount < entityDiscount && recordMaxDiscount > entityDiscount;
            boolean unitPriceFlag = recordMinUnitPrice < entityUnitPrice && recordMaxUnitPrice > entityUnitPrice;
            boolean totalAmountFlag = recordMinTotalAmount < entityBalance && recordMaxTotalAmount> entityBalance;

            if(taxIncludedFlag && numbersFlag && retailPriceFlag && discountFlag && unitPriceFlag && totalAmountFlag){
                PurchaseRecordsListBean purchaseRecordsListBean = new PurchaseRecordsListBean();
                purchaseRecordsListBean.setId(entityId);
                purchaseRecordsListBean.setPurchaseTime(entityPurchaseTime);
                purchaseRecordsListBean.setCreateTime(entityCreateTime);
                purchaseRecordsListBean.setGoodsNumber(entityGoodsNumber);
                purchaseRecordsListBean.setBrand(recordBrand);
                purchaseRecordsListBean.setGoodsName(recordGoodsName);
                purchaseRecordsListBean.setUnitPrice(Double.valueOf(entityUnitPrice));
                purchaseRecordsListBean.setNumbers(Integer.valueOf(entityNumbers));
                purchaseRecordsListBean.setTotalAmount(Double.valueOf(entityBalance));
                purchaseRecordsListBean.setSupplier(recordSupplier);

                totalBeanList.add(purchaseRecordsListBean);
            }
        }

        int total =totalBeanList.size();
        if(recordStartIndex + recordNum < total){
            for(int index = recordStartIndex; index < recordStartIndex + recordNum; index++)
                resultBeanList.add(totalBeanList.get(index));
        }

        PurchaseRecordsBean recordsBean = new PurchaseRecordsBean(resultBeanList, total);
        return recordsBean;
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
                        bean.getTaxIncluded(),bean.getPrecautionForPreservation(),bean.getSupplier(),bean.getRemarks());

                return bean.getId();
            }catch (Exception ex){
                ex.printStackTrace();
                return "修改单个进货记录出错";
            }
        }
        return "修改单个进货记录出错";
    }

}
