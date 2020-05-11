package com.bean.suppliers;

public class GetSuppliersBean {
    private String supplierNumber;
    private String supplierName;
    private String productionCategory;
    private String purchasingCategories;
    private String contact;
    private String contactInformation;
    private String mail;
    private int sex;
    private String sorter;
    private int desc;
    private int startIndex;
    private int num;

    public GetSuppliersBean(){

    }

    public GetSuppliersBean(String _supplierNumber, String _supplierName, String _productionCategory,
                            String _purchasingCategories, String _contact, String _contactInformation,
                            String _mail, int _sex, String _sorter, int _desc, int _startIndex, int _num){
        this.supplierNumber = _supplierNumber;
        this.supplierName = _supplierName;
        this.productionCategory = _productionCategory;
        this.purchasingCategories = _purchasingCategories;
        this.contact = _contact;
        this.contactInformation = _contactInformation;
        this.mail = _mail;
        this.sex = _sex;
        this.sorter = _sorter;
        this.desc = _desc;
        this.startIndex = _startIndex;
        this.num = _num;
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

    public void setContact(String _contact) {
        this.contact = _contact;
    }

    public String getContact() {
        return contact;
    }

    public void setContactInformation(String _contactInformation) {
        this.contactInformation = _contactInformation;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setMail(String _mail) {
        this.mail = _mail;
    }

    public String getMail() {
        return mail;
    }

    public void setSex(int _sex) {
        this.sex = _sex;
    }

    public int getSex() {
        return sex;
    }

    public void setSorter(String _sorter) {
        this.sorter = _sorter;
    }

    public String getSorter() {
        return sorter;
    }

    public void setDesc(int _desc) {
        this.desc = _desc;
    }

    public int getDesc() {
        return desc;
    }

    public void setStartIndex(int _startIndex) {
        this.startIndex = _startIndex;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setNum(int _num) {
        this.num = _num;
    }

    public int getNum() {
        return num;
    }

}
