package com.bean.orders;

public class GetOrdersBean {
    private String startTime;
    private String endTime;
    private String clientName;
    private String salesPerson;
    private String goodsName;
    private String goodsNumber;
    private String[] brand;
    private double minTotalAmount;
    private double maxTotalAmount;
    private String[] state;
    private int writeAnInvoice;
    private String sorter;
    private int desc;
    private int startIndex;
    private int num;

    public GetOrdersBean(){

    }

    public GetOrdersBean(String _startTime, String _endTime, String _clientName, String _salesPerson,
                         String _goodsName, String _goodsNumber, String[] _brand, double _minTotalAmount,
                         double _maxTotalAmount, String[] _state, int _writeAnInvoice, String _sorter, int _desc,
                         int _startIndex, int _num){
        this.startTime = _startTime;
        this.endTime = _endTime;
        this.clientName = _clientName;
        this.salesPerson = _salesPerson;
        this.goodsName = _goodsName;
        this.goodsNumber = _goodsNumber;
        this.brand = _brand;
        this.minTotalAmount = _minTotalAmount;
        this.maxTotalAmount = _maxTotalAmount;
        this.state = _state;
        this.writeAnInvoice = _writeAnInvoice;
        this.sorter = _sorter;
        this.desc = _desc;
        this.startIndex = _startIndex;
        this.num = _num;
    }

    public void setStartTime(String _startTime){
        this.startTime = _startTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setEndTime(String _endTime) {
        this.endTime = _endTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setClientName(String _clientName) {
        this.clientName = _clientName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setSalesPerson(String _salesPerson) {
        this.salesPerson = _salesPerson;
    }

    public String getSalesPerson() {
        return salesPerson;
    }

    public void setGoodsName(String _goodsName) {
        this.goodsName = _goodsName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsNumber(String _goodsNumber) {
        this.goodsNumber = _goodsNumber;
    }

    public String getGoodsNumber() {
        return goodsNumber;
    }

    public void setBrand(String[] _brand) {
        this.brand = _brand;
    }

    public String[] getBrand() {
        return brand;
    }

    public void setMinTotalAmount(double _minTotalAmount) {
        this.minTotalAmount = _minTotalAmount;
    }

    public double getMinTotalAmount() {
        return minTotalAmount;
    }

    public void setMaxTotalAmount(double _maxTotalAmount) {
        this.maxTotalAmount = _maxTotalAmount;
    }

    public double getMaxTotalAmount() {
        return maxTotalAmount;
    }

    public void setState(String[] _state) {
        this.state = _state;
    }

    public String[] getState() {
        return state;
    }

    public void setWriteAnInvoice(int _writeAnInvoice) {
        this.writeAnInvoice = _writeAnInvoice;
    }

    public int getWriteAnInvoice() {
        return writeAnInvoice;
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
