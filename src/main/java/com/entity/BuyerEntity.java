package com.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "buyer", schema = "invoicingsystem")
public class BuyerEntity implements Serializable{
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "buyerNumber")
    private String buyerNumber;

    @Basic
    @Column(name = "buyerName")
    private String buyerName;

    @Basic
    @Column(name = "contactInformation")
    private String contactInformation;

    @Basic
    @Column(name = "productionCategory")
    private String productionCategory;

    @Basic
    @Column(name = "purchasingCategories")
    private String purchasingCategories;

    @Basic
    @Column(name = "legalPerson")
    private String legalPerson;

    @Basic
    @Column(name = "contact")
    private String contact;

    @Basic
    @Column(name = "sex")
    private String sex;

    @Basic
    @Column(name = "post")
    private String post;

    @Basic
    @Column(name = "mail")
    private String mail;

    @Basic
    @Column(name = "remarks")
    private String remarks;

    public BuyerEntity(){

    }

    public BuyerEntity(int _id, String _buyerNumber, String _buyerName, String _contactInformation,
                       String _productionCategory, String _purchasingCategories, String _legalPerson, String _contact,
                       String _sex, String _post, String _mail, String _remarks){
        this.id = _id;
        this.buyerNumber = _buyerNumber;
        this.buyerName = _buyerName;
        this.contactInformation = _contactInformation;
        this.productionCategory = _productionCategory;
        this.purchasingCategories = _purchasingCategories;
        this.legalPerson = _legalPerson;
        this.contact = _contact;
        this.sex = _sex;
        this.post = _post;
        this.mail = _mail;
        this.remarks = _remarks;
    }

    public void setId(int _id){
        this.id = _id;
    }

    public int getId() {
        return id;
    }

    public void setBuyerNumber(String _buyerNumber){
        this.buyerNumber = _buyerNumber;
    }

    public String getBuyerNumber() {
        return buyerNumber;
    }

    public void setBuyerName(String _buyerName){
        this.buyerName = _buyerName;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setContactInformation(String _contactInformation){
        this.contactInformation = _contactInformation;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setProductionCategory(String _productionCategory){
        this.productionCategory = _productionCategory;
    }

    public String getProductionCategory() {
        return productionCategory;
    }

    public void setPurchasingCategories(String _purchasingCategories){
        this.purchasingCategories = _purchasingCategories;
    }

    public String getPurchasingCategories() {
        return purchasingCategories;
    }

    public void setLegalPerson(String _legalPerson){
        this.legalPerson = _legalPerson;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setContact(String _contact){
        this.contact = _contact;
    }

    public String getContact() {
        return contact;
    }

    public void setSex(String _sex){
        this.sex = _sex;
    }

    public String getSex() {
        return sex;
    }

    public void setPost(String _post){
        this.post = _post;
    }

    public String getPost() {
        return post;
    }

    public void setMail(String _mail){
        this.mail = _mail;
    }

    public String getMail() {
        return mail;
    }

    public void setRemarks(String _remarks){
        this.remarks = _remarks;
    }

    public String getRemarks() {
        return remarks;
    }

}
