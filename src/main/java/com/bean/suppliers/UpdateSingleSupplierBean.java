package com.bean.suppliers;

public class UpdateSingleSupplierBean {
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

    public UpdateSingleSupplierBean(){

    }

    public UpdateSingleSupplierBean(String _supplierNumber, String _supplierName, String _contactInformation,
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

    public void setSupplierNumber(String _supplierNumber) {
        this.supplierNumber = _supplierNumber;
    }

    public String getSupplierNumber() {
        return supplierNumber;
    }

    public void setSupplierName(String _supplierName) {
        this.supplierName = _supplierName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setContactInformation(String _contactInformation) {
        this.contactInformation = _contactInformation;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setRemarks(String _remarks) {
        this.remarks = _remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setProductionCategory(String _productionCategory) {
        this.productionCategory = _productionCategory;
    }

    public String getProductionCategory() {
        return productionCategory;
    }

    public void setPurchasingCategories(String _purchasingCategories) {
        this.purchasingCategories = _purchasingCategories;
    }

    public String getPurchasingCategories() {
        return purchasingCategories;
    }

    public void setLegalPerson(String _legalPerson) {
        this.legalPerson = _legalPerson;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setContact(String _contact) {
        this.contact = _contact;
    }

    public String getContact() {
        return contact;
    }

    public void setSex(String _sex) {
        this.sex = _sex;
    }

    public String getSex() {
        return sex;
    }

    public void setPost(String _post) {
        this.post = _post;
    }

    public String getPost() {
        return post;
    }

    public void setMail(String _mail) {
        this.mail = _mail;
    }

    public String getMail() {
        return mail;
    }

}
