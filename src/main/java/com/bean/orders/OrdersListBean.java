package com.bean.orders;

public class OrdersListBean {
    private String ordersNumber;
    private String clientName;
    private String salesPerson;
    private String goodsNumber;
    private String brand;
    private String goodsName;
    private double finalPrice;
    private String unit;
    private int numbers;
    private double totalAmount;
    private String typeOfPayment;
    private String typeOfShipping;
    private String createTime;
    private String dealTime;
    private String state;

    public OrdersListBean(){

    }

    public OrdersListBean(String _ordersNumber, String _clientName, String _salesPerson, String _goodsNumber,
                          String _brand, String _goodsName, double _finalPrice, String _unit, int _numbers, double _totalAmount,
                          String _typeOfPayment, String _typeOfShipping, String _createTime, String _dealTime, String _state){
        this.ordersNumber = _ordersNumber;
        this.clientName = _clientName;
        this.salesPerson = _salesPerson;
        this.goodsNumber = _goodsNumber;
        this.brand = _brand;
        this.goodsName = _goodsName;
        this.finalPrice = _finalPrice;
        this.unit = _unit;
        this.numbers = _numbers;
        this.totalAmount = _totalAmount;
        this.typeOfPayment = _typeOfPayment;
        this.typeOfShipping = _typeOfShipping;
        this.createTime = _createTime;
        this.dealTime = _dealTime;
        this.state = _state;
    }

    public void setOrdersNumber(String _ordersNumber) {
        this.ordersNumber = _ordersNumber;
    }

    public String getOrdersNumber() {
        return ordersNumber;
    }

    public void setClientName(String _clientName) {
        this.clientName = _clientName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setSalesPerson(String _salesPerson) {
        this.salesPerson = _salesPerson;
    }

    public String getSalesPerson() {
        return salesPerson;
    }

    public void setGoodsNumber(String _goodsNumber) {
        this.goodsNumber = _goodsNumber;
    }

    public String getGoodsNumber() {
        return goodsNumber;
    }

    public void setBrand(String _brand) {
        this.brand = _brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setGoodsName(String _goodsName) {
        this.goodsName = _goodsName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setFinalPrice(double _finalPrice) {
        this.finalPrice = _finalPrice;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setUnit(String _unit) {
        this.unit = _unit;
    }

    public String getUnit() {
        return unit;
    }

    public void setNumbers(int _numbers) {
        this.numbers = _numbers;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setTotalAmount(double _totalAmount) {
        this.totalAmount = _totalAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTypeOfPayment(String _typeOfPayment) {
        this.typeOfPayment = _typeOfPayment;
    }

    public String getTypeOfPayment() {
        return typeOfPayment;
    }

    public void setTypeOfShipping(String _typeOfShipping) {
        this.typeOfShipping = _typeOfShipping;
    }

    public String getTypeOfShipping() {
        return typeOfShipping;
    }

    public void setCreateTime(String _createTime) {
        this.createTime = _createTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setDealTime(String _dealTime) {
        this.dealTime = _dealTime;
    }

    public String getDealTime() {
        return dealTime;
    }

    public void setState(String _state) {
        this.state = _state;
    }

    public String getState() {
        return state;
    }

}
