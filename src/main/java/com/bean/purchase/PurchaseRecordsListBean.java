package com.bean.purchase;

public class PurchaseRecordsListBean {
    private String id;
    private String purchaseTime;
    private String createTime;
    private String goodsNumber;
    private String brand;
    private String goodsName;
    private double unitPrice;
    private int numbers;
    private double totalAmount;
    private String supplier;

    public PurchaseRecordsListBean(){

    }

    public PurchaseRecordsListBean(String _id, String _purchaseTime, String _createTime,
                                   String _goodsNumber, String _brand, String _goodsName, double _unitPrice,
                                   int _numbers, double _totalAmount, String _supplier){
        this.id = _id;
        this.purchaseTime = _purchaseTime;
        this.createTime = _createTime;
        this.goodsNumber = _goodsNumber;
        this.brand = _brand;
        this.goodsName = _goodsName;
        this.unitPrice = _unitPrice;
        this.numbers = _numbers;
        this.totalAmount = _totalAmount;
        this.supplier = _supplier;
    }

    public void  setId(String _id){
        this.id = _id;
    }

    public String getId(){
        return id;
    }

    public void  setPurchaseTime(String _purchaseTime){
        this.purchaseTime = _purchaseTime;
    }

    public String getPurchaseTime(){
        return purchaseTime;
    }

    public void  setCreateTime(String _createTime){
        this.createTime = _createTime;
    }

    public String getCreateTime(){
        return createTime;
    }

    public void  setGoodsNumber(String _goodsNumber){
        this.goodsNumber = _goodsNumber;
    }

    public String getGoodsNumber(){
        return goodsNumber;
    }

    public void  setBrand(String _brand){
        this.brand = _brand;
    }

    public String getBrand(){
        return brand;
    }

    public void  setGoodsName(String _goodsName){
        this.goodsName = _goodsName;
    }

    public String getGoodsName(){
        return goodsName;
    }

    public void  setUnitPrice(double _unitPrice){
        this.unitPrice = _unitPrice;
    }

    public double getUnitPrice(){
        return unitPrice;
    }

    public void  setNumbers(int _numbers){
        this.numbers = _numbers;
    }

    public int getNumbers(){
        return numbers;
    }

    public void  setTotalAmount(double _totalAmount){
        this.totalAmount = _totalAmount;
    }

    public double getTotalAmount(){
        return totalAmount;
    }

    public void  setSupplier(String _supplier){
        this.supplier = _supplier;
    }

    public String getSupplier(){
        return supplier;
    }

}
