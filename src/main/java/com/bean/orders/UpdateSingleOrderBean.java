package com.bean.orders;

public class UpdateSingleOrderBean {
    private String orderNumber;
    private String state;
    private String salesPerson;
    private String clientName;
    private String writeAnInvoice;
    private String goodsNumber;
    private String brand;
    private String goodsName;
    private String goodsNo;
    private double buyingPrice;
    private double retailPrice;
    private double finalPrice;
    private int numbers;
    private double totalAmount;
    private String typeOfPayment;
    private String typeOfShipping;

    public UpdateSingleOrderBean(){

    }

    public UpdateSingleOrderBean(String _orderNumber, String _state, String _salesPerson, String _clientName,
                                 String _writeAnInvoice, String _goodsNumber, String _brand, String _goodsName, String _goodsNo,
                                 double _buyingPrice, double _retailPrice, double _finalPrice, int _numbers, double _totalAmount,
                                 String _typeOfPayment, String _typeOfShipping){
        this.orderNumber = _orderNumber;
        this.state = _state;
        this.salesPerson = _salesPerson;
        this.clientName = _clientName;
        this.writeAnInvoice = _writeAnInvoice;
        this.goodsNumber = _goodsNumber;
        this.brand = _brand;
        this.goodsName = _goodsName;
        this.goodsNo = _goodsNo;
        this.buyingPrice = _buyingPrice;
        this.retailPrice = _retailPrice;
        this.finalPrice = _finalPrice;
        this.numbers = _numbers;
        this.totalAmount = _totalAmount;
        this.typeOfPayment = _typeOfPayment;
        this.typeOfShipping = _typeOfShipping;
    }

    public void setOrderNumber(String _orderNumber) {
        this.orderNumber = _orderNumber;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setState(String _state) {
        this.state = _state;
    }

    public String getState() {
        return state;
    }

    public void setSalesPerson(String _salesPerson) {
        this.salesPerson = _salesPerson;
    }

    public String getSalesPerson() {
        return salesPerson;
    }

    public void setClientName(String _clientName) {
        this.clientName = _clientName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setWriteAnInvoice(String _writeAnInvoice) {
        this.writeAnInvoice = _writeAnInvoice;
    }

    public String getWriteAnInvoice() {
        return writeAnInvoice;
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

    public void setGoodsNo(String _goodsNo) {
        this.goodsNo = _goodsNo;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setBuyingPrice(double _buyingPrice) {
        this.buyingPrice = _buyingPrice;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setRetailPrice(double _retailPrice) {
        this.retailPrice = _retailPrice;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setFinalPrice(double _finalPrice) {
        this.finalPrice = _finalPrice;
    }

    public double getFinalPrice() {
        return finalPrice;
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

}
