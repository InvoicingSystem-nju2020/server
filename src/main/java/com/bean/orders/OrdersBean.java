package com.bean.orders;

import java.util.List;

public class OrdersBean {
    private List<OrdersListBean> ordersList;
    private int total;

    public OrdersBean(){

    }

    public OrdersBean(List<OrdersListBean> _ordersList, int _total){
        this.ordersList = _ordersList;
        this.total = _total;
    }

    public void setOrdersList(List<OrdersListBean> _ordersList) {
        this.ordersList = _ordersList;
    }

    public List<OrdersListBean> getOrdersList() {
        return ordersList;
    }

    public void setTotal(int _total) {
        this.total = _total;
    }

    public int getTotal() {
        return total;
    }
}
