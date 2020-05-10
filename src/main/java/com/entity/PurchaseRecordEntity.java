package com.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "purchaserecord", schema = "invoicingsystem")
public class PurchaseRecordEntity implements Serializable{
    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "createTime")
    private String createTime;

    @Basic
    @Column(name = "purchaseTime")
    private String purchaseTime;

    @Basic
    @Column(name = "goodsNumber")
    private String goodsNumber;

    @Basic
    @Column(name = "numbers")
    private int numbers;

    @Basic
    @Column(name = "discount")
    private double discount;

    @Basic
    @Column(name = "unitPrice")
    private double unitPrice;

    @Basic
    @Column(name = "balance")
    private double balance;

    @Basic
    @Column(name = "taxIncluded")
    private int taxIncluded;

    @Basic
    @Column(name = "precautionsForPreservation")
    private String precautionsForPreservation;

    @Basic
    @Column(name = "buyer")
    private String buyer;

    @Basic
    @Column(name = "remarks")
    private String remarks;

    public PurchaseRecordEntity(){

    }

    public PurchaseRecordEntity(String _id, String _createTime, String _purchaseTime, String _goodsNumber,
                                int _numbers, double _discount, double _unitPrice, double _balance, int _taxIncluded,
                                String _precautionsForPreservation, String _buyer, String _remarks){
        this.id = _id;
        this.createTime = _createTime;
        this.purchaseTime = _purchaseTime;
        this.goodsNumber = _goodsNumber;
        this.numbers = _numbers;
        this.discount = _discount;
        this.unitPrice = _unitPrice;
        this.balance = _balance;
        this.taxIncluded = _taxIncluded;
        this.precautionsForPreservation = _precautionsForPreservation;
        this.buyer = _buyer;
        this.remarks = _remarks;
    }

    public void setId(String _id){
        this.id = _id;
    }

    public String getId() {
        return id;
    }

    public void setCreateTime(String _createTime){
        this.createTime = _createTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setPurchaseTime(String _purchaseTime){
        this.purchaseTime = _purchaseTime;
    }

    public String getPurchaseTime() {
        return purchaseTime;
    }

    public void setGoodsNumber(String _goodsNumber){
        this.goodsNumber = _goodsNumber;
    }

    public String getGoodsNumber() {
        return goodsNumber;
    }

    public void setNumbers(int _numbers){
        this.numbers = _numbers;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setDiscount(double _discount){
        this.discount = _discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setUnitPrice(double _unitPrice){
        this.unitPrice = _unitPrice;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setBalance(double _balance){
        this.balance = _balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setTaxIncluded(int _taxIncluded){
        this.taxIncluded = _taxIncluded;
    }

    public int getTaxIncluded() {
        return taxIncluded;
    }

    public void setPrecautionsForPreservation(String _precautionsForPreservation){
        this.precautionsForPreservation = _precautionsForPreservation;
    }

    public String getPrecautionsForPreservation() {
        return precautionsForPreservation;
    }

    public void setBuyer(String _buyer){
        this.buyer = _buyer;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setRemarks(String _remarks){
        this.remarks = _remarks;
    }

    public String getRemarks() {
        return remarks;
    }

}
