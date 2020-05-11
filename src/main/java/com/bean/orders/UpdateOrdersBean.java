package com.bean.orders;

import java.util.List;

public class UpdateOrdersBean {
    private List<String> orderNumbersList;
    private String state;

    public UpdateOrdersBean(){

    }

    public UpdateOrdersBean(List<String> _orderNumbersList, String _state){
        this.orderNumbersList = _orderNumbersList;
        this.state = _state;
    }

    public void setOrderNumbersList(List<String> _orderNumbersList) {
        this.orderNumbersList = _orderNumbersList;
    }

    public List<String> getOrderNumbersList() {
        return orderNumbersList;
    }

    public void setState(String _state) {
        this.state = _state;
    }

    public String getState() {
        return state;
    }
}
