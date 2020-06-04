package com.bean.clients;

import java.util.List;

public class ClientsBean {
    private List<ClientsListBean> clientsList;
    private int total;

    public ClientsBean(){

    }

    public ClientsBean(List<ClientsListBean> _clientsList, int _total){
        this.clientsList = _clientsList;
        this.total = _total;
    }

    public void setClientsList(List<ClientsListBean> _clientsList) {
        this.clientsList = _clientsList;
    }

    public List<ClientsListBean> getClientsList() {
        return clientsList;
    }

    public void setTotal(int _total) {
        this.total = _total;
    }

    public int getTotal() {
        return total;
    }
}
