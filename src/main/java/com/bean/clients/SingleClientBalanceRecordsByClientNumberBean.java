package com.bean.clients;

public class SingleClientBalanceRecordsByClientNumberBean {
    private String startMonth;
    private String endMonth;
    private String startRemittanceDate;
    private String endRemittanceDate;
    private double minRemittanceAmount;
    private double maxRemittanceAmount;
    private double minPurchaseAmount;
    private double maxPurchaseAmount;
    private int startIndex;
    private int num;

    public SingleClientBalanceRecordsByClientNumberBean(){

    }

    public SingleClientBalanceRecordsByClientNumberBean(String _startMonth, String _endMonth, String _startRemittanceDate,
                                                        String _endRemittanceDate, double _minRemittanceAmount,
                                                        double _maxRemittanceAmount, double _minPurchaseAmount,
                                                        double _maxPurchaseAmount, int _startIndex, int _num){
        this.startMonth = _startMonth;
        this.endMonth = _endMonth;
        this.startRemittanceDate = _startRemittanceDate;
        this.endRemittanceDate = _endRemittanceDate;
        this.minRemittanceAmount = _minRemittanceAmount;
        this.maxRemittanceAmount = _maxRemittanceAmount;
        this.minPurchaseAmount = _minPurchaseAmount;
        this.maxPurchaseAmount = _maxPurchaseAmount;
        this.startIndex = _startIndex;
        this.num = _num;
    }

    public void setStartMonth(String _startMonth){
        this.startMonth = _startMonth;
    }

    public String getStartMonth() {
        return startMonth;
    }

    public void setEndMonth(String _endMonth){
        this.endMonth = _endMonth;
    }

    public String getEndMonth() {
        return endMonth;
    }

    public void setStartRemittanceDate(String _startRemittanceDate){
        this.startRemittanceDate = _startRemittanceDate;
    }

    public String getStartRemittanceDate() {
        return startRemittanceDate;
    }

    public void setEndRemittanceDate(String _endRemittanceDate){
        this.endRemittanceDate = _endRemittanceDate;
    }

    public String getEndRemittanceDate() {
        return endRemittanceDate;
    }

    public void setMinRemittanceAmount(double _minRemittanceAmount){
        this.minRemittanceAmount = _minRemittanceAmount;
    }

    public double getMinRemittanceAmount() {
        return minRemittanceAmount;
    }

    public void setMaxRemittanceAmount(double _maxRemittanceAmount){
        this.maxRemittanceAmount = _maxRemittanceAmount;
    }

    public double getMaxRemittanceAmount() {
        return maxRemittanceAmount;
    }

    public void setMinPurchaseAmount(double _minPurchaseAmount){
        this.minPurchaseAmount = _minPurchaseAmount;
    }

    public double getMinPurchaseAmount() {
        return minPurchaseAmount;
    }

    public void setMaxPurchaseAmount(double _maxPurchaseAmount){
        this.maxPurchaseAmount = _maxPurchaseAmount;
    }

    public double getMaxPurchaseAmount() {
        return maxPurchaseAmount;
    }

    public void setStartIndex(int _startIndex){
        this.startIndex = _startIndex;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setNum(int _num){
        this.num = _num;
    }

    public int getNum() {
        return num;
    }
}
