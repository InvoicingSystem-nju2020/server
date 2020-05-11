package com.bean.suppliers;

import java.util.List;

public class SuppliersReturnBean {
    private List<SuppliersReturnListBean> suppliersList;
    private int total;

    public SuppliersReturnBean(){

    }

    public SuppliersReturnBean(List<SuppliersReturnListBean> _suppliersList, int _total){
        this.suppliersList = _suppliersList;
        this.total = _total;
    }

    public void setSuppliersList(List<SuppliersReturnListBean> _suppliersList) {
        this.suppliersList = _suppliersList;
    }

    public List<SuppliersReturnListBean> getSuppliersList() {
        return suppliersList;
    }

    public void setTotal(int _total) {
        this.total = _total;
    }

    public int getTotal() {
        return total;
    }
}
