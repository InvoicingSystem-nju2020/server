package com.bean.suppliers;

public class SingleSupplierBean {
    private String supplierNumber;
    private String supplierName;
    private String contactInformation;
    private String remarks;
    private String productionCategory;
    private String purchasingCategories;
    private String legalPerson;
    private String contact;
    private String sex;
    private String post;
    private String mail;

    public SingleSupplierBean(){

    }

    public SingleSupplierBean(String _supplierNumber, String _supplierName, String _contactInformation,
                              String _remarks, String _productionCategory, String _purchasingCategories, String _legalPerson,
                              String _contact, String _sex, String _post, String _mail){
        this.supplierNumber = _supplierNumber;
        this.supplierName = _supplierName;
        this.contactInformation = _contactInformation;
        this.remarks = _remarks;
        this.productionCategory = _productionCategory;
        this.purchasingCategories = _purchasingCategories;
        this.legalPerson = _legalPerson;
        this.contact = _contact;
        this.sex = _sex;
        this.post = _post;
        this.mail = _mail;
    }

    public void setSupplierNumber(String supplierNumber) {
        this.supplierNumber = supplierNumber;
    }

    public String getSupplierNumber() {
        return supplierNumber;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPost() {
        return post;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public void setProductionCategory(String productionCategory) {
        this.productionCategory = productionCategory;
    }

    public String getProductionCategory() {
        return productionCategory;
    }

    public void setPurchasingCategories(String purchasingCategories) {
        this.purchasingCategories = purchasingCategories;
    }

    public String getPurchasingCategories() {
        return purchasingCategories;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContact() {
        return contact;
    }

}
