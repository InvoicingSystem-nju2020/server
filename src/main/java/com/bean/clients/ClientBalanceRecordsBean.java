package com.bean.clients;

import java.util.List;

public class ClientBalanceRecordsBean {
    private List<ClientBalanceRecordsListBean> clientBalanceRecordsList;
    private int total;

    public ClientBalanceRecordsBean(){

    }

    public ClientBalanceRecordsBean(List<ClientBalanceRecordsListBean> _clientBalanceRecordsList, int _total){
        this.clientBalanceRecordsList = _clientBalanceRecordsList;
        this.total = _total;
    }

    public void setClientBalanceRecordsList(List<ClientBalanceRecordsListBean> _clientBalanceRecordsList) {
        this.clientBalanceRecordsList = _clientBalanceRecordsList;
    }

    public List<ClientBalanceRecordsListBean> getClientBalanceRecordsList() {
        return clientBalanceRecordsList;
    }

    public void setTotal(int _total) {
        this.total = _total;
    }

    public int getTotal() {
        return total;
    }
}
