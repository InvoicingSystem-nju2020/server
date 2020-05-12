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
    @Column(name = "state")
    private String state;

    @Basic
    @Column(name = "client")
    private String clientNumber;

    @Basic
    @Column(name = "writeAnInvoice")
    private int writeAnInvoice;

    @Basic
    @Column(name = "goodsNumber")
    private String goodsNumber;

    @Basic
    @Column(name = "goodsName")
    private String goodsName;

    @Basic
    @Column(name = "goodsNo")
    private String goodsNo;

    @Basic
    @Column(name = "brand")
    private String brand;

    @Basic
    @Column(name = "buyingPrice")
    private double buyingPrice;

    @Basic
    @Column(name = "retailPrice")
    private double retailPrice;

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
                       String _state, String _clientNumber, int _writeAnInvoice, String _goodsNumber, String _goodsName, String _goodsNo,
                        String _brand, double _buyingPrice, double _retailPrice, double _finalPrice, int _numbers,
                       double _totalAmount, String _typeOfPayment, String _typeOfShipping){
        this.id = _id;
        this.orderNumber = _orderNumber;
        this.salesPerson = _salesPerson;
        this.createTime = _createTime;
        this.dealTime = _dealTime;
        this.state = _state;
        this.clientNumber = _clientNumber;
        this.writeAnInvoice = _writeAnInvoice;
        this.goodsNumber = _goodsNumber;
        this.goodsName = _goodsName;
        this.goodsNo = _goodsNo;
        this.brand = _brand;
        this.buyingPrice =_buyingPrice;
        this.retailPrice = _retailPrice;
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

    public void setState(String _state) {
        this.state = _state;
    }

    public String getState() {
        return state;
    }

    public void setClientNumber(String _clientNumber){
        this.clientNumber = _clientNumber;
    }

    public String getClientNumber() {
        return clientNumber;
    }

    public void setWriteAnInvoice(int _writeAnInvoice){
        this.writeAnInvoice = _writeAnInvoice;
    }

    public int getWriteAnInvoice() {
        return writeAnInvoice;
    }

    public void setGoodsNumber(String _goodsNumber){
        this.goodsNumber = _goodsNumber;
    }

    public String getGoodsNumber() {
        return goodsNumber;
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

    public void setBrand(String _brand) {
        this.brand = _brand;
    }

    public String getBrand() {
        return brand;
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
