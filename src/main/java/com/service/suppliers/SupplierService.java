package com.service.suppliers;

import com.bean.suppliers.*;

public interface SupplierService {
    String addSupplier(AddSupplierBean bean);

    SuppliersReturnBean getSuppliers(GetSuppliersBean bean);

    SingleSupplierBean getSingleSupplier(String supplierNumber);

    String updateSingleSupplierBySupplierNumber(UpdateSingleSupplierBean bean);

    boolean deleteSingleSupplierBySupplierNumber(String supplierNumber);
}
