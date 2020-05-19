package com.serviceImpl.suppliers;

import com.bean.suppliers.*;
import com.entity.BuyerEntity;
import com.repository.suppliers.SupplierRepository;
import com.service.suppliers.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class SupplierImpl implements SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    private static SupplierImpl supplierImpl;
    private static int idLength = 6;

    @PostConstruct
    public void init(){
        supplierImpl = this;
        supplierImpl.supplierRepository = this.supplierRepository;
    }

    @Override
    public String addSupplier(AddSupplierBean bean) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = dateFormat.format(new Date());
        String id = "";
        for(int i = 0; i < idLength; i++) id = id + "" + (int)(Math.random() * 10);
        id = time + id;

        BuyerEntity supplier = new BuyerEntity();
        supplier.setId(id);
        supplier.setBuyerNumber(id);
        supplier.setBuyerName(bean.getSupplierName());
        supplier.setContactInformation(bean.getContactInformation());
        supplier.setProductionCategory(bean.getProductionCategory());
        supplier.setPurchasingCategories(bean.getPurchasingCategories());
        supplier.setLegalPerson(bean.getLegalPerson());
        supplier.setContact(bean.getContact());
        supplier.setSex(bean.getSex());
        supplier.setPost(bean.getPost());
        supplier.setMail(bean.getMail());
        supplier.setRemarks(bean.getRemarks());
        try{
            supplierImpl.supplierRepository.save(supplier);
            return supplier.getBuyerNumber();
        }catch (Exception ex){
            ex.printStackTrace();
            return "录入供应商出错";
        }

    }

    @Override
    public SuppliersReturnBean getSuppliers(GetSuppliersBean bean) {
        List<SuppliersReturnListBean> totalSuppliersList = new ArrayList<>();
        List<SuppliersReturnListBean> resultSuppliersList = new ArrayList<>();
        List<BuyerEntity> suppliersEntitiesList = new ArrayList<>();
        int total = 0;

        String supplierNumber = bean.getSupplierNumber();
        String supplierName = bean.getSupplierName();
        String productionCategory = bean.getProductionCategory();
        String purchasingCategories = bean.getPurchasingCategories();
        String contact = bean.getContact();
        String contactInformation = bean.getContactInformation();
        String mail = bean.getMail();
        int sex = bean.getSex();
        String sorter = bean.getSorter();
        int desc = bean.getDesc();
        int startIndex = bean.getStartIndex();
        int num = bean.getNum();

            suppliersEntitiesList = supplierImpl.supplierRepository.findAll();

        for (BuyerEntity supplier : suppliersEntitiesList) {
            SuppliersReturnListBean returnListBean = new SuppliersReturnListBean();
            returnListBean.setSupplierNumber(supplier.getBuyerNumber());
            returnListBean.setSupplierName(supplier.getBuyerName());
            returnListBean.setContactInformation(supplier.getContactInformation());
            returnListBean.setRemarks(supplier.getRemarks());
            returnListBean.setProductionCategory(supplier.getProductionCategory());
            returnListBean.setPurchasingCategories(supplier.getPurchasingCategories());
            returnListBean.setLegalPerson(supplier.getLegalPerson());
            returnListBean.setContact(supplier.getContact());
            returnListBean.setSex(supplier.getSex());
            returnListBean.setPost(supplier.getPost());
            returnListBean.setMail(supplier.getMail());

            totalSuppliersList.add(returnListBean);
        }

        SuppliersReturnBean suppliersReturnBean = new SuppliersReturnBean(totalSuppliersList, totalSuppliersList.size());

        return suppliersReturnBean;
    }

    @Override
    public SingleSupplierBean getSingleSupplier(String supplierNumber) {
        Optional<BuyerEntity> optionalSupplier = supplierImpl.supplierRepository.findById(supplierNumber);
        BuyerEntity supplier = optionalSupplier.isPresent() ? optionalSupplier.get() : null;
        if(supplier != null){
            SingleSupplierBean singleSupplierBean = new SingleSupplierBean();

            singleSupplierBean.setSupplierNumber(supplier.getBuyerNumber());
            singleSupplierBean.setSupplierName(supplier.getBuyerName());
            singleSupplierBean.setContactInformation(supplier.getContactInformation());
            singleSupplierBean.setRemarks(supplier.getRemarks());
            singleSupplierBean.setProductionCategory(supplier.getProductionCategory());
            singleSupplierBean.setPurchasingCategories(supplier.getPurchasingCategories());
            singleSupplierBean.setLegalPerson(supplier.getLegalPerson());
            singleSupplierBean.setContact(supplier.getContact());
            singleSupplierBean.setSex(supplier.getSex());
            singleSupplierBean.setPost(supplier.getPost());
            singleSupplierBean.setMail(supplier.getMail());

            return singleSupplierBean;
        }
        return null;
    }

    @Override
    public String updateSingleSupplierBySupplierNumber(String supplierNumber, UpdateSingleSupplierBean bean) {
        Optional<BuyerEntity> optionalSupplier = supplierImpl.supplierRepository.findById(supplierNumber);
        BuyerEntity supplier = optionalSupplier.isPresent() ? optionalSupplier.get() : null;
        if(supplier != null){
            try{
                supplierImpl.supplierRepository.updateSingleSupplier(supplierNumber, bean.getSupplierName(), bean.getContactInformation(),
                        bean.getRemarks(), bean.getProductionCategory(), bean.getPurchasingCategories(), bean.getLegalPerson(), bean.getContact(),
                        bean.getSex(), bean.getPost(), bean.getMail());

                return supplierNumber;
            }catch (Exception ex){
                ex.printStackTrace();
                return "更新错误";
            }
        }
        return "未检索到供应商";
    }

    @Override
    public String deleteSingleSupplierBySupplierNumber(String supplierNumber) {
        Optional<BuyerEntity> optionalSupplier = supplierImpl.supplierRepository.findById(supplierNumber);
        BuyerEntity supplier = optionalSupplier.isPresent() ? optionalSupplier.get() : null;
        if(supplier != null){
            try {
                supplierImpl.supplierRepository.deleteById(supplierNumber);

                return "成功删除" + supplierNumber + "供应商";
            }catch (Exception ex){
                ex.printStackTrace();
                return "删除" + supplierNumber + "出错";
            }
        }

        return "删除" + supplierNumber + "出错";
    }
}
