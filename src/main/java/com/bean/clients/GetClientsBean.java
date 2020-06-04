package com.bean.clients;

public class GetClientsBean {
    private String clientsNumber;
    private String clientsName;
    private String[] clientsType;
    private String clientsContact;
    private String contactInformation;
    private String mail;
    private int clientsSex;
    private String sorter;
    private int desc;
    private int startIndex;
    private int num;

    public GetClientsBean(){

    }

    public GetClientsBean(String _clientsNumber, String _clientsName, String[] _clientsType, String _clientsContact,
                          String _contactInformation, String _mail, int _clientsSex, String _sorter, int _desc,
                          int _startIndex, int _num){
        this.clientsNumber = _clientsNumber;
        this.clientsName = _clientsName;
        this.clientsType = _clientsType;
        this.clientsContact = _clientsContact;
        this.contactInformation = _contactInformation;
        this.mail = _mail;
        this.clientsSex = _clientsSex;
        this.sorter = _sorter;
        this.desc = _desc;
        this.startIndex = _startIndex;
        this.num = _num;
    }


    public void setClientsNumber(String _clientsNumber) {
        this.clientsNumber = _clientsNumber;
    }

    public String getClientsNumber() {
        return clientsNumber;
    }

    public void setClientsName(String _clientsName) {
        this.clientsName = _clientsName;
    }

    public String getClientsName() {
        return clientsName;
    }

    public void setClientsType(String[] _clientsType) {
        this.clientsType = _clientsType;
    }

    public String[] getClientsType() {
        return clientsType;
    }

    public void setClientsContact(String _clientsContact) {
        this.clientsContact = _clientsContact;
    }

    public String getClientsContact() {
        return clientsContact;
    }

    public void setContactInformation(String _contactInformation) {
        this.contactInformation = _contactInformation;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setMail(String _mail) {
        this.mail = _mail;
    }

    public String getMail() {
        return mail;
    }

    public void setClientsSex(int _clientsSex) {
        this.clientsSex = _clientsSex;
    }

    public Integer getClientsSex() {
        return clientsSex;
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
