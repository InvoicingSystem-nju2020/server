package com.bean.purchase;

public class AddPurchaseRecordBean {
    private String purchaseTime;
    private String goodsNumber;
    private int numbers;
    private double discount;
    private double unitPrice;
    private double totalAmount;
    private int taxIncluded;
    private String precautionsForPreservation;
    private String supplierNumber;
    private String remarks;

    public AddPurchaseRecordBean(){

    }

    public AddPurchaseRecordBean(String _purchaseTime, String _goodsNumber, int _numbers, double _discount,
                                 double _unitPrice, double _totalAmount, int _taxIncluded, String _precautionsForPreservation,
                                 String _supplierNumber, String _remarks){
        this.purchaseTime = _purchaseTime;
        this.goodsNumber = _goodsNumber;
        this.numbers = _numbers;
        this.discount = _discount;
        this.unitPrice = _unitPrice;
        this.totalAmount = _totalAmount;
        this.taxIncluded = _taxIncluded;
        this.precautionsForPreservation = _precautionsForPreservation;
        this.supplierNumber = _supplierNumber;
        this.remarks = _remarks;
    }

    public void setPurchaseTime(String _purchaseTime){
        this.purchaseTime = _purchaseTime;
    }

    public String getPurchaseTime(){
        return purchaseTime;
    }

    public void setGoodsNumber(String _goodsNumber){
        this.goodsNumber = _goodsNumber;
    }

    public String getGoodsNumber(){
        return goodsNumber;
    }

    public void setNumbers(int _numbers){
        this.numbers = _numbers;
    }

    public int getNumbers(){
        return numbers;
    }

    public void setDiscount(double _discount){
        this.discount = _discount;
    }

    public double getDiscount(){
        return discount;
    }

    public void setUnitPrice(double _unitPrice){
        this.unitPrice = _unitPrice;
    }

    public double getUnitPrice(){
        return unitPrice;
    }

    public void setTotalAmount(double _totalAmount){
        this.totalAmount= _totalAmount;
    }

    public double getTotalAmount(){
        return totalAmount;
    }

    public void setTaxIncluded(int _taxIncluded){
        this.taxIncluded = _taxIncluded;
    }

    public int getTaxIncluded(){
        return taxIncluded;
    }
    public void setPrecautionsForPreservation(String _precautionsForPreservation){
        this.precautionsForPreservation = _precautionsForPreservation;
    }

    public String getPrecautionsForPreservation(){
        return precautionsForPreservation;
    }

    public void setSupplierNumber(String _supplierNumber){
        this.supplierNumber = _supplierNumber;
    }

    public String getSupplierNumber(){
        return supplierNumber;
    }

    public void setRemarks(String _remarks){
        this.remarks = _remarks;
    }

    public String getRemarks(){
        return remarks;
    }

}
