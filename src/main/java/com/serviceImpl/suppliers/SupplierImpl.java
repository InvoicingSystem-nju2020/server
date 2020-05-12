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
        int desc = bean.getDesc();
        int startIndex = bean.getStartIndex();
        int num = bean.getNum();

        if(desc == 1) suppliersEntitiesList = supplierImpl.supplierRepository.findBySupplierNumberDesc();
        else suppliersEntitiesList = supplierImpl.supplierRepository.findBySupplierNumberInc();

        for(BuyerEntity supplier : suppliersEntitiesList){
            String entitySupplierNumber = supplier.getBuyerNumber();
            String entitySupplierName = supplier.getBuyerName();
            String entityContactInformation = supplier.getContactInformation();
            String entityProductionCategory = supplier.getProductionCategory();
            String entityPurchasingCategories = supplier.getPurchasingCategories();
            String entityLegalPerson = supplier.getLegalPerson();
            String entityContact = supplier.getContact();
            String entitySex = supplier.getSex();
            String entityPost = supplier.getPost();
            String entityMail = supplier.getMail();
            String entityRemarks = supplier.getRemarks();

            if(entitySupplierNumber.equals(supplierNumber) && entitySupplierName.equals(supplierName) &&
            entityContactInformation.equals(contactInformation) && entityProductionCategory.equals(productionCategory) &&
            entityPurchasingCategories.equals(purchasingCategories) && entityContact.equals(contact) &&
            entityMail.equals(mail) && entitySex.equals(sex)){
                SuppliersReturnListBean listBean = new SuppliersReturnListBean();

                listBean.setSupplierNumber(entitySupplierNumber);
                listBean.setSupplierName(entitySupplierName);
                listBean.setContactInformation(entityContactInformation);
                listBean.setRemarks(entityRemarks);
                listBean.setProductionCategory(entityProductionCategory);
                listBean.setPurchasingCategories(entityPurchasingCategories);
                listBean.setLegalPerson(entityLegalPerson);
                listBean.setContact(entityContact);
                listBean.setSex(entitySex);
                listBean.setPost(entityPost);
                listBean.setMail(entityMail);

                totalSuppliersList.add(listBean);
            }
        }

        total = totalSuppliersList.size();
        if(startIndex + num < total){
            for(int index = startIndex; index < startIndex + num; index++)
                resultSuppliersList.add(totalSuppliersList.get(index));
        }
        SuppliersReturnBean suppliersReturnBean = new SuppliersReturnBean(resultSuppliersList, total);

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
    public String updateSingleSupplierBySupplierNumber(UpdateSingleSupplierBean bean) {
        Optional<BuyerEntity> optionalSupplier = supplierImpl.supplierRepository.findById(bean.getSupplierNumber());
        BuyerEntity supplier = optionalSupplier.isPresent() ? optionalSupplier.get() : null;
        if(supplier != null){
            try{
                supplierImpl.supplierRepository.updateSingleSupplier(bean.getSupplierNumber(), bean.getSupplierName(), bean.getContactInformation(),
                        bean.getRemarks(), bean.getProductionCategory(), bean.getPurchasingCategories(), bean.getLegalPerson(), bean.getContact(),
                        bean.getSex(), bean.getPost(), bean.getMail());

                return bean.getSupplierNumber();
            }catch (Exception ex){
                ex.printStackTrace();
                return "更新错误";
            }
        }
        return "未检索到供应商";
    }

    @Override
    public boolean deleteSingleSupplierBySupplierNumber(String supplierNumber) {
        Optional<BuyerEntity> optionalSupplier = supplierImpl.supplierRepository.findById(supplierNumber);
        BuyerEntity supplier = optionalSupplier.isPresent() ? optionalSupplier.get() : null;
        if(supplier != null){
            try {
                supplierImpl.supplierRepository.deleteById(supplierNumber);

                return true;
            }catch (Exception ex){
                ex.printStackTrace();
                return false;
            }
        }

        return false;
    }
}
