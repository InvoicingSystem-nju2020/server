package com.bean.clients;

public class SingleClientByClientsNumberBean {
    private String clientsNumber;
    private String clientsName;
    private String clientsType;
    private double balance;
    private String clientsContact;
    private String clientsSex;
    private String clientsPost;
    private String contactInformation;
    private String mail;
    private String remarks;
    private String other;

    public SingleClientByClientsNumberBean(){

    }

    public SingleClientByClientsNumberBean(String _clientsNumber, String _clientsName, String _clientsType,
                         double _balance, String _clientsContact, String _clientsSex, String _clientsPost,
                         String _contactInformation, String _mail, String _remarks, String _other){
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

    public void setBalance(double _balance){
        this.balance = _balance;
    }

    public double getBalance() {
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
