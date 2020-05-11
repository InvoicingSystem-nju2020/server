package com.serviceImpl.suppliers;

import com.bean.suppliers.*;
import com.repository.suppliers.SupplierRepository;
import com.service.suppliers.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

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

        return null;
    }

    @Override
    public SuppliersReturnBean getSuppliers(GetSuppliersBean bean) {

        return null;
    }

    @Override
    public SingleSupplierBean getSingleSupplier(String supplierNumber) {

        return null;
    }

    @Override
    public String updateSingleSupplierBySupplierNumber(UpdateSingleSupplierBean bean) {

        return null;
    }

    @Override
    public boolean deleteSingleSupplierBySupplierNumber(String supplierNumber) {

        return false;
    }
}
