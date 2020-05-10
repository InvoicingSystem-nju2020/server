package com.bean.purchase;

public class GetPurchaseRecordsBean {
    private String startPurchaseTime;
    private String endPurchaseTime;
    private String startCreateTime;
    private String endCreateTime;
    private String goodsName;
    private String goodsNumber;
    private String brand;
    private String supplier;
    private int minNumbers;
    private int maxNumbers;
    private double minRetailPrice;
    private double maxRetailPrice;
    private double minDiscount;
    private double maxDiscount;
    private double minUnitPrice;
    private double maxUnitPrice;
    private double minTotalAmount;
    private double maxTotalAmount;
    private int taxIncluded;
    private String sorter;
    private int desc;
    private int startIndex;
    private int num;

    public GetPurchaseRecordsBean(){

    }

    public GetPurchaseRecordsBean(String _startPurchaseTime, String _endPurchaseTime, String _startCreateTime, String _endCreateTime,
                                String _goodsName,  String _goodsNumber, String _brand, String _supplier, int _minNumbers, int _maxNumbers,
                                  double _minRetailPrice, double _maxRetailPrice, double _minDiscount, double _maxDiscount,
                                  double _minUnitPrice, double _maxUnitPrice, double _minTotalAmount, double _maxTotalAmount, int _taxIncluded,
                                  String _sorter, int _desc, int _startIndex, int _num){
       this.startPurchaseTime = _startPurchaseTime;
       this.endPurchaseTime = _endPurchaseTime;
       this.startCreateTime = _startCreateTime;
       this.endCreateTime = _endCreateTime;
        this.goodsName = _goodsName;
        this.goodsNumber = _goodsNumber;
        this.brand = _brand;
        this.supplier = _supplier;
        this.minNumbers = _minNumbers;
        this.maxNumbers = _maxNumbers;
        this.minRetailPrice = _minRetailPrice;
        this.maxRetailPrice = _maxRetailPrice;
        this.minDiscount = _minDiscount;
        this.maxDiscount = _maxDiscount;
        this.minUnitPrice = _minUnitPrice;
        this.maxUnitPrice = _maxUnitPrice;
        this.minTotalAmount = _minTotalAmount;
        this.maxTotalAmount = _maxTotalAmount;
        this.taxIncluded = _taxIncluded;
        this.sorter = _sorter;
        this.desc = _desc;
        this.startIndex = _startIndex;
        this.num = _num;
    }

    public void setStartPurchaseTime(String _startPurchaseTime){
        this.startPurchaseTime = _startPurchaseTime;
    }

    public String getStartPurchaseTime(){
        return startPurchaseTime;
    }

    public void setEndPurchaseTime(String _endPurchaseTime){
        this.endPurchaseTime = _endPurchaseTime;
    }

    public String getEndPurchaseTime(){
        return endPurchaseTime;
    }

    public void setStartCreateTime(String _startCreateTime){
        this.startCreateTime = _startCreateTime;
    }

    public String getStartCreateTime(){
        return startCreateTime;
    }

    public void setEndCreateTime(String _endCreateTime){
        this.endCreateTime = _endCreateTime;
    }

    public String getEndCreateTime(){
        return endCreateTime;
    }

    public void setGoodsName(String _goodsName){
        this.goodsNumber = _goodsName;
    }

    public String getGoodsName(){
        return goodsName;
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

    public void setSupplier(String _supplier){
        this.supplier = _supplier;
    }

    public String getSupplier(){
        return supplier;
    }

    public void setMinNumbers(int _minNumbers){
        this.minNumbers = _minNumbers;
    }

    public int getMinNumbers(){
        return minNumbers;
    }

    public void setMaxNumbers(int _maxNumbers){
        this.maxNumbers = _maxNumbers;
    }

    public int getMaxNumbers(){
        return maxNumbers;
    }

    public void setMinRetailPrice(double _minRetailPrice){
        this.minRetailPrice = _minRetailPrice;
    }

    public double getMinRetailPrice(){
        return minRetailPrice;
    }

    public void setMaxRetailPrice(double _maxRetailPrice){
        this.maxRetailPrice = _maxRetailPrice;
    }

    public double getMaxRetailPrice(){
        return maxRetailPrice;
    }

    public void setMinDiscount(double _minDiscount){
        this.minDiscount = _minDiscount;
    }

    public double getMinDiscount(){
        return minDiscount;
    }

    public void setMaxDiscount(double _maxDiscount){
        this.maxDiscount = _maxDiscount;
    }

    public double getMaxDiscount(){
        return maxDiscount;
    }

    public void setMinUnitPrice(double _minUnitPrice){
        this.minUnitPrice = _minUnitPrice;
    }

    public double getMinUnitPrice(){
        return minUnitPrice;
    }

    public void setMaxUnitPrice(double _maxUnitPrice){
        this.maxUnitPrice = _maxUnitPrice;
    }

    public double getMaxUnitPrice(){
        return maxUnitPrice;
    }

    public void setMinTotalAmount(double _minTotalAmount){
        this.minTotalAmount = _minTotalAmount;
    }

    public double getMinTotalAmount(){
        return minTotalAmount;
    }

    public void setMaxTotalAmount(double _maxTotalAmount){
        this.maxTotalAmount = _maxTotalAmount;
    }

    public double getMaxTotalAmount(){
        return maxTotalAmount;
    }

    public void setTaxIncluded(int _taxIncluded){
        this.taxIncluded = _taxIncluded;
    }

    public int getTaxIncluded(){
        return taxIncluded;
    }

    public void setSorter(String _sorter){
        this.sorter = _sorter;
    }

    public String getSorter(){
        return sorter;
    }

    public void setDesc(int _desc){
        this.desc = _desc;
    }

    public int getDesc(){
        return desc;
    }

    public void setStartIndex(int _startIndex){
        this.startIndex = _startIndex;
    }

    public int getStartIndex(){
        return startIndex;
    }

    public void setNum(int _num){
        this.num = _num;
    }

    public int getNum(){
        return num;
    }

}
