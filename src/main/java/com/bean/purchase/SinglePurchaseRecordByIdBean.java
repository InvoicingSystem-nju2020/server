package com.bean.purchase;

public class SinglePurchaseRecordByIdBean {
    private String id;
    private String purchaseTime;
    private String goodsNumber;
    private String brand;
    private String goodsName;
    private String model;
    private String goodsNo;
    private String material;
    private String unit;
    private double retailPrice;
    private int numbers;
    private double discount;
    private double unitPrice;
    private double totalAmount;
    private int taxIncluded;
    private String precautionForPreservation;
    private String supplier;
    private String remarks;
    private String createTime;

    public SinglePurchaseRecordByIdBean(){

    }

    public SinglePurchaseRecordByIdBean(String _id, String _purchaseTime, String _goodsNumber,
                                        String _brand, String _goodsName, String _model, String _goodsNo, String _material,
                                        String _unit, double _retailPrice, int _numbers, double _discount, double _unitPrice,
                                        double _totalAmount, int _taxIncluded, String _precautionForPreservation,
                                        String _supplier, String _remarks, String _createTime){
        this.id = _id;
        this.purchaseTime = _purchaseTime;
        this.goodsNumber = _goodsNumber;
        this.brand = _brand;
        this.goodsName = _goodsName;
        this.model = _model;
        this.goodsNo = _goodsNo;
        this.material = _material;
        this.unit = _unit;
        this.retailPrice = _retailPrice;
        this.numbers = _numbers;
        this.discount = _discount;
        this.unitPrice = _unitPrice;
        this.totalAmount = _totalAmount;
        this.taxIncluded = _taxIncluded;
        this.precautionForPreservation = _precautionForPreservation;
        this.supplier = _supplier;
        this.remarks = _remarks;
        this.createTime = _createTime;
    }

    public void setId(String _id){
        this.id = _id;
    }

    public String getId(){
        return id;
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

    public void setBrand(String _brand){
        this.brand = _brand;
    }

    public String getBrand(){
        return brand;
    }

    public void setGoodsName(String _goodsName){
        this.goodsName = _goodsName;
    }

    public String getGoodsName(){
        return goodsName;
    }

    public void setModel(String _model){
        this.model = _model;
    }

    public String getModel(){
        return model;
    }

    public void setGoodsNo(String _goodsNo){
        this.goodsNo = _goodsNo;
    }

    public String getGoodsNo(){
        return goodsNo;
    }

    public void setMaterial(String _material){
        this.material = _material;
    }

    public String getMaterial(){
        return material;
    }

    public void setUnit(String _unit){
        this.unit = _unit;
    }

    public String getUnit(){
        return unit;
    }

    public void setRetailPrice(double _retailPrice){
        this.retailPrice = _retailPrice;
    }

    public double getRetailPrice(){
        return retailPrice;
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
        this.totalAmount = _totalAmount;
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

    public void setPrecautionForPreservation(String _precautionForPreservation){
        this.precautionForPreservation = _precautionForPreservation;
    }

    public String getPrecautionForPreservation(){
        return precautionForPreservation;
    }

    public void setSupplier(String _supplier){
        this.supplier = _supplier;
    }

    public String getSupplier(){
        return supplier;
    }

    public void setRemarks(String _remarks){
        this.remarks = _remarks;
    }

    public String getRemarks(){
        return remarks;
    }

    public void setCreateTime(String _createTime){
        this.createTime = _createTime;
    }

    public String getCreateTime(){
        return createTime;
    }
}
