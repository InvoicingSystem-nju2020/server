package com.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orders", schema = "invoicingsystem")
public class OrdersEntity implements Serializable{
    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "orderNumber")
    private String orderNumber;

    @Basic
    @Column(name = "salesPerson")
    private String salesPerson;

    @Basic
    @Column(name = "createTime")
    private String createTime;

    @Basic
    @Column(name = "dealTime")
    private String dealTime;

    @Basic
    @Column(name = "client")
    private String client;

    @Basic
    @Column(name = "writeAnInvoice")
    private String writeAnInvoice;

    @Basic
    @Column(name = "goodsNumber")
    private String goodsNumber;

    @Basic
    @Column(name = "finalPrice")
    private double finalPrice;

    @Basic
    @Column(name = "numbers")
    private int numbers;

    @Basic
    @Column(name = "totalAmount")
    private double totalAmount;

    @Basic
    @Column(name = "typeOfPayment")
    private String typeOfPayment;

    @Basic
    @Column(name = "typeOfShipping")
    private String typeOfShipping;

    public OrdersEntity(){

    }

    public OrdersEntity(String _id, String _orderNumber, String _salesPerson, String _createTime, String _dealTime,
                       String _client, String _writeAnInvoice, String _goodsNumber, double _finalPrice, int _numbers,
                       double _totalAmount, String _typeOfPayment, String _typeOfShipping){
        this.id = _id;
        this.orderNumber = _orderNumber;
        this.salesPerson = _salesPerson;
        this.createTime = _createTime;
        this.dealTime = _dealTime;
        this.client = _client;
        this.writeAnInvoice = _writeAnInvoice;
        this.goodsNumber = _goodsNumber;
        this.finalPrice = _finalPrice;
        this.numbers = _numbers;
        this.totalAmount =_totalAmount ;
        this.typeOfPayment = _typeOfPayment;
        this.typeOfShipping = _typeOfShipping;
    }

    public void setId(String _id){
        this.id = _id;
    }

    public String getId() {
        return id;
    }

    public void setOrderNumber(String _orderNumber){
        this.orderNumber = _orderNumber;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setSalesPerson(String _salesPerson){
        this.salesPerson = _salesPerson;
    }

    public String getSalesPerson() {
        return salesPerson;
    }

    public void setCreateTime(String _createTime){
        this.createTime = _createTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setDealTime(String _dealTime){
        this.dealTime = _dealTime;
    }

    public String getDealTime() {
        return dealTime;
    }

    public void setClient(String _client){
        this.client = _client;
    }

    public String getClient() {
        return client;
    }

    public void setWriteAnInvoice(String _writeAnInvoice){
        this.writeAnInvoice = _writeAnInvoice;
    }

    public String getWriteAnInvoice() {
        return writeAnInvoice;
    }

    public void setGoodsNumber(String _goodsNumber){
        this.goodsNumber = _goodsNumber;
    }

    public String getGoodsNumber() {
        return goodsNumber;
    }

    public void setFinalPrice(double _finalPrice){
        this.finalPrice = _finalPrice;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setNumbers(int _numbers){
        this.numbers = _numbers;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setTotalAmount(double _totalAmount){
        this.totalAmount = _totalAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTypeOfPayment(String _typeOfPayment){
        this.typeOfPayment = _typeOfPayment;
    }

    public String getTypeOfPayment() {
        return typeOfPayment;
    }

    public void setTypeOfShipping(String _typeOfShipping){
        this.typeOfPayment = _typeOfShipping;
    }

    public String getTypeOfShipping() {
        return typeOfShipping;
    }

}
