package com.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "clientbalancerecord", schema = "invoicingsystem")
public class ClientBalanceRecordEntity implements Serializable{
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "clientsNumber")
    private String clientsNumber;

    @Basic
    @Column(name = "month")
    private String month;

    @Basic
    @Column(name = "lastMonthSBalance")
    private String lastMonthSBalance;

    @Basic
    @Column(name = "remittanceDate")
    private String remittanceDate;

    @Basic
    @Column(name = "remittanceBalance")
    private String remittanceBalance;

    @Basic
    @Column(name = "purchaseBalance")
    private String purchaseBalance;

    public ClientBalanceRecordEntity(){

    }

    public ClientBalanceRecordEntity(int _id, String _clientsNumber, String _month, String _lastMonthSBalance,
                       String _remittanceDate, String _remittanceBalance, String _purchaseBalance){
        this.id = _id;
        this.clientsNumber = _clientsNumber;
        this.month = _month;
        this.lastMonthSBalance = _lastMonthSBalance;
        this.remittanceDate = _remittanceDate;
        this.remittanceBalance = _remittanceBalance;
        this.purchaseBalance = _purchaseBalance;
    }

    public void setId(int _id){
        this.id = _id;
    }

    public int getId() {
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

    public void setLastMonthSBalance(String _lastMonthSBalance){
        this.lastMonthSBalance = _lastMonthSBalance;
    }

    public String getLastMonthSBalance() {
        return lastMonthSBalance;
    }

    public void setRemittanceDate(String _remittanceDate){
        this.remittanceDate = _remittanceDate;
    }

    public String getRemittanceDate() {
        return remittanceDate;
    }

    public void setRemittanceBalance(String _remittanceBalance){
        this.remittanceBalance = _remittanceBalance;
    }

    public String getRemittanceBalance() {
        return remittanceBalance;
    }

    public void setPurchaseBalance(String _purchaseBalance){
        this.purchaseBalance = _purchaseBalance;
    }

    public String getPurchaseBalance() {
        return purchaseBalance;
    }

}
