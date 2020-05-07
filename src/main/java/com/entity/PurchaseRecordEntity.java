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
    private String numbers;

    @Basic
    @Column(name = "discount")
    private String discount;

    @Basic
    @Column(name = "unitPrice")
    private String unitPrice;

    @Basic
    @Column(name = "balance")
    private String balance;

    @Basic
    @Column(name = "taxIncluded")
    private String taxIncluded;

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
                                String _numbers, String _discount, String _unitPrice, String _balance, String _taxIncluded,
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

    public void setNumbers(String _numbers){
        this.numbers = _numbers;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setDiscount(String _discount){
        this.discount = _discount;
    }

    public String getDiscount() {
        return discount;
    }

    public void setUnitPrice(String _unitPrice){
        this.unitPrice = _unitPrice;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setBalance(String _balance){
        this.balance = _balance;
    }

    public String getBalance() {
        return balance;
    }

    public void setTaxIncluded(String _taxIncluded){
        this.taxIncluded = _taxIncluded;
    }

    public String getTaxIncluded() {
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
