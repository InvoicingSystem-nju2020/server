package com.bean.purchase;

import java.util.List;

public class PurchaseRecordsBean {
    private List<PurchaseRecordsListBean> purchaseRecordsList;
    private int total;

    public PurchaseRecordsBean(){

    }

    public PurchaseRecordsBean(List<PurchaseRecordsListBean> _purchaseRecordsList, int _total){
        this.purchaseRecordsList = _purchaseRecordsList;
        this.total = _total;
    }

    public void setPurchaseRecordsList(List<PurchaseRecordsListBean> _purchaseRecordsList){
        this.purchaseRecordsList = _purchaseRecordsList;
    }

    public List<PurchaseRecordsListBean> getPurchaseRecordsList(){
        return purchaseRecordsList;
    }

    public void setTotal(int _total){
        this.total = _total;
    }

    public int getTotal(){
        return total;
    }
}

