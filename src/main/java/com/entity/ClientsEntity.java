package com.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "clients", schema = "invoicingsystem")
public class ClientsEntity implements Serializable{
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "clientsNumber")
    private String clientsNumber;

    @Basic
    @Column(name = "clientsName")
    private String clientsName;

    @Basic
    @Column(name = "clientsType")
    private String clientsType;

    @Basic
    @Column(name = "balance")
    private String balance;

    @Basic
    @Column(name = "clientsContact")
    private String clientsContact;

    @Basic
    @Column(name = "clientsSex")
    private String clientsSex;

    @Basic
    @Column(name = "clientsPost")
    private String clientsPost;

    @Basic
    @Column(name = "contactInformation")
    private String contactInformation;

    @Basic
    @Column(name = "mail")
    private String mail;

    @Basic
    @Column(name = "remarks")
    private String remarks;

    @Basic
    @Column(name = "other")
    private String other;

    public ClientsEntity(){

    }

    public ClientsEntity(int _id, String _clientsNumber, String _clientsName, String _clientsType,
                                     String _balance, String _clientsContact, String _clientsSex, String _clientsPost,
                         String _contactInformation, String _mail, String _remarks, String _other){
        this.id = _id;
        this.clientsNumber = _clientsNumber;
        this.clientsName = _clientsName;
        this.clientsType = _clientsType;
        this.balance = _balance;
        this.clientsContact = _clientsContact;
        this.clientsSex = _clientsSex;
        this.clientsPost = _clientsPost;
        this.contactInformation = _contactInformation;
        this.mail = _mail;
        this.remarks = _remarks;
        this.other = _other;
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

    public void setClientsName(String _clientsName){
        this.clientsName = _clientsName;
    }

    public String getClientsName() {
        return clientsName;
    }

    public void setClientsType(String _clientsType){
        this.clientsType = _clientsType;
    }

    public String getClientsType() {
        return clientsType;
    }

    public void setBalance(String _balance){
        this.balance = _balance;
    }

    public String getBalance() {
        return balance;
    }

    public void setClientsContact(String _clientsContact){
        this.clientsContact = _clientsContact;
    }

    public String getClientsContact() {
        return clientsContact;
    }

    public void setClientsSex(String _clientsSex){
        this.clientsSex = _clientsSex;
    }

    public String getClientsSex() {
        return clientsSex;
    }

    public void setClientsPost(String _clientsPost){
        this.clientsSex = _clientsPost;
    }

    public String getClientsPost() {
        return clientsPost;
    }

    public void setContactInformation(String _contactInformation){
        this.contactInformation = _contactInformation;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setMail(String _mail){
        this.mail = _mail;
    }

    public String getMail() {
        return mail;
    }

    public void setRemarks(String _remarks){
        this.remarks = _remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setOther(String _other){
        this.other = _other;
    }

    public String getOther() {
        return other;
    }
}
