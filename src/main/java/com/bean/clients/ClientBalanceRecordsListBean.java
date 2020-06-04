package com.bean.clients;

public class ClientBalanceRecordsListBean {
    private String month;
    private double lastMonthSBalance;
    private String remittanceDate;
    private double remittanceBalance;
    private double purchaseBalance;

    public ClientBalanceRecordsListBean(){

    }

    public ClientBalanceRecordsListBean(String _month, double _lastMonthSBalance, String _remittanceDate,
                           double _remittanceBalance, double _purchaseBalance){
        this.month = _month;
        this.lastMonthSBalance = _lastMonthSBalance;
        this.remittanceDate = _remittanceDate;
        this.remittanceBalance = _remittanceBalance;
        this.purchaseBalance = _purchaseBalance;
    }

    public void setMonth(String _month){
        this.month = _month;
    }

    public String getMonth() {
        return month;
    }

    public void setLastMonthSBalance(double _lastMonthSBalance){
        this.lastMonthSBalance = _lastMonthSBalance;
    }

    public double getLastMonthSBalance() {
        return lastMonthSBalance;
    }

    public void setRemittanceDate(String _remittanceDate){
        this.remittanceDate = _remittanceDate;
    }

    public String getRemittanceDate() {
        return remittanceDate;
    }

    public void setRemittanceBalance(double _remittanceBalance){
        this.remittanceBalance = _remittanceBalance;
    }

    public double getRemittanceBalance() {
        return remittanceBalance;
    }

    public void setPurchaseBalance(double _purchaseBalance){
        this.purchaseBalance = _purchaseBalance;
    }

    public double getPurchaseBalance() {
        return purchaseBalance;
    }

}
