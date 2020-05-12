package com.bean.orders;

public class UpdateSingleOrderBean {
    private String orderNumber;
    private String state;
    private String salesPerson;
    private String clientNumber;
    private String writeAnInvoice;
    private String goodsNumber;
    private double finalPrice;
    private int numbers;
    private double totalAmount;
    private String typeOfPayment;
    private String typeOfShipping;

    public UpdateSingleOrderBean(){

    }

    public UpdateSingleOrderBean(String _orderNumber, String _state, String _salesPerson, String _clientNumber,
                                 String _writeAnInvoice, String _goodsNumber, double _finalPrice, int _numbers,
                                 double _totalAmount, String _typeOfPayment, String _typeOfShipping){
        this.orderNumber = _orderNumber;
        this.state = _state;
        this.salesPerson = _salesPerson;
        this.clientNumber = _clientNumber;
        this.writeAnInvoice = _writeAnInvoice;
        this.goodsNumber = _goodsNumber;
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

    public void setClientNumber(String _clientNumber) {
        this.clientNumber = _clientNumber;
    }

    public String getClientNumber() {
        return clientNumber;
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
