package com.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "clientbalancerecord", schema = "invoicingsystem")
public class ClientBalanceRecordEntity implements Serializable{
    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "clientsNumber")
    private String clientsNumber;

    @Basic
    @Column(name = "month")
    private String month;

    @Basic
    @Column(name = "lastMonthSBalance")
    private double lastMonthSBalance;

    @Basic
    @Column(name = "remittanceDate")
    private String remittanceDate;

    @Basic
    @Column(name = "remittanceBalance")
    private double remittanceBalance;

    @Basic
    @Column(name = "purchaseBalance")
    private double purchaseBalance;

    public ClientBalanceRecordEntity(){

    }

    public ClientBalanceRecordEntity(String _id, String _clientsNumber, String _month, double _lastMonthSBalance,
                       String _remittanceDate, double _remittanceBalance, double _purchaseBalance){
        this.id = _id;
        this.clientsNumber = _clientsNumber;
        this.month = _month;
        this.lastMonthSBalance = _lastMonthSBalance;
        this.remittanceDate = _remittanceDate;
        this.remittanceBalance = _remittanceBalance;
        this.purchaseBalance = _purchaseBalance;
    }

    public void setId(String _id){
        this.id = _id;
    }

    public String getId() {
        return id;
    }

    public void setClientsNumber(String _clientsNumber){
        this.clientsNumber = _clientsNumber;
    }

    public String getClientsNumber() {
        return clientsNumber;
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
