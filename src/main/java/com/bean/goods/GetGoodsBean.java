package com.bean.goods;

public class GetGoodsBean {
    private String goodsNumber;
    private String goodsName;
    private String abbreviation;
    private String[] brand;
    private String model;
    private String goodsNo;
    private String material;
    private String colour;
    private String[] type;
    private String[] place;
    private double minRetailPrice;
    private double maxRetailPrice;
    private String sorter;
    private int desc;
    private int startIndex;
    private int num;

    public GetGoodsBean(){

    }

    public GetGoodsBean(String _goodsNumber, String _goodsName,String _abbreviation, String[] _brand, String _model,
                        String _goodsNo, String _material, String _colour,String[] _type,String[] _place,double _minRetailPrice,
                        double _maxRetailPrice,String _sorter, int _desc, int _startIndex, int _num){
        this.goodsNumber = _goodsNumber;
        this.goodsName = _goodsName;
        this.abbreviation = _abbreviation;
        this.brand = _brand;
        this.model = _model;
        this.goodsNo = _goodsNo;
        this.material = _material;
        this.colour = _colour;
        this.type = _type;
        this.place = _place;
        this.minRetailPrice = _minRetailPrice;
        this.maxRetailPrice = _maxRetailPrice;
        this.sorter = _sorter;
        this.desc = _desc;
        this.startIndex = _startIndex;
        this.num = _num;
    }

    public void setGoodsNumber(String _goodsNumber){
        this.goodsNumber = _goodsNumber;
    }

    public String getGoodsNumber(){
        return goodsNumber;
    }

    public void setGoodsName(String _goodsName){
        this.goodsNumber = _goodsName;
    }

    public String getGoodsName(){
        return goodsName;
    }

    public void setAbbreviation (String _abbreviation){
        this.abbreviation = _abbreviation;
    }

    public String getAbbreviation(){
        return abbreviation;
    }

    public void setBrand(String[] _brand){
        this.brand = _brand;
    }

    public String[] getBrand(){
        return brand;
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

    public void setColour (String _colour){
        this.colour = _colour;
    }

    public String getColour(){
        return colour;
    }

    public void setType(String[] _type){
        this.type = _type;
    }

    public String[] getType(){
        return type;
    }

    public void setPlace(String[] _place){
        this.place = _place;
    }

    public String[] getPlace(){
        return place;
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
