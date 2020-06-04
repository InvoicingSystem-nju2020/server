package com.bean.goods;

public class AddGoodBean {
    private String goodsName;
    private String abbreviation;
    private String brand;
    private String model;
    private String goodsNo;
    private String material;
    private String colour;
    private String type;
    private String specifications;
    private String unit;
    private String weight;
    private int stock;
    private double buyingPrice;
    private double retailPrice;
    private String placeOfProduction;
    private String qualityGuaranteePeriod;
    private String remarks;

    public AddGoodBean(){

    }

    public AddGoodBean( String _goodsName, String _abbreviation,
                       String _brand, String _model, String _goodsNo, String _material, String _colour, String _type,
                       String _specifications, String _unit, String _weight, int _stock,double _buyingPrice,double _retailPrice,
                       String _placeOfProduction, String _qualityGuaranteePeriod, String _remarks){
        this.goodsName = _goodsName;
        this.abbreviation = _abbreviation;
        this.brand = _brand;
        this.model = _model;
        this.goodsNo = _goodsNo;
        this.material = _material;
        this.colour = _colour;
        this.type = _type;
        this.specifications = _specifications;
        this.unit = _unit;
        this.weight = _weight;
        this.stock = _stock;
        this.buyingPrice = _buyingPrice;
        this.retailPrice = _retailPrice;
        this.placeOfProduction = _placeOfProduction;
        this.qualityGuaranteePeriod = _qualityGuaranteePeriod;
        this.remarks = _remarks;
    }

    public void setGoodsName(String _goodsName){
        this.goodsName = _goodsName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setAbbreviation(String _abbreviation){
        this.abbreviation = _abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setBrand(String _brand){
        this.brand = _brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setModel(String _model){
        this.model = _model;
    }

    public String getModel() {
        return model;
    }

    public void setGoodsNo(String _goodsNo){
        this.goodsNo = _goodsNo;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setMaterial(String _material){
        this.material = _material;
    }

    public String getMaterial() {
        return material;
    }

    public void setColour(String _colour){
        this.colour = _colour;
    }

    public String getColour() {
        return colour;
    }

    public void setType(String _type){
        this.type = _type;
    }

    public String getType() {
        return type;
    }

    public void setSpecifications(String _specifications){
        this.specifications = _specifications;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setUnit(String _unit){
        this.unit = _unit;
    }

    public String getUnit() {
        return unit;
    }

    public void setWeight(String _weight){
        this.weight = _weight;
    }

    public String getWeight() {
        return weight;
    }

    public void setStock(int _stock){
        this.stock = _stock;
    }

    public int getStock() {
        return stock;
    }

    public void setBuyingPrice(double _buyingPrice){
        this.buyingPrice = _buyingPrice;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setRetailPrice(double _retailPrice){
        this.retailPrice = _retailPrice;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setPlaceOfProduction(String _placeOfProduction){
        this.placeOfProduction = _placeOfProduction;
    }

    public String getPlaceOfProduction() {
        return placeOfProduction;
    }

    public void setQualityGuaranteePeriod(String _qualityGuaranteePeriod){
        this.qualityGuaranteePeriod = _qualityGuaranteePeriod;
    }

    public String getQualityGuaranteePeriod() {
        return qualityGuaranteePeriod;
    }

    public void setRemarks(String _remarks){
        this.remarks= _remarks;
    }

    public String getRemarks() {
        return remarks;
    }

}
