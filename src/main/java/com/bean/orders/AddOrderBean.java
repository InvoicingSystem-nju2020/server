package com.bean.orders;

public class AddOrderBean {
    private String salesPerson;
    private String clientNumber;
    private int writeAnInvoice;
    private String goodsNumbers;
    private double finalPrice;
    private int numbers;
    private double totalAmount;
    private String typeOfPayment;
    private String typeOfShipping;
    private String state;

    public AddOrderBean(){

    }

    public AddOrderBean(String _salesPerson, String _clientNumber, int _writeAnInvoice,
                        String _goodsNumbers, double _finalPrice, int _numbers, double _totalAmount,
                        String _typeOfPayment, String _typeOfShipping, String _state){
        this.salesPerson = _salesPerson;
        this.clientNumber = _clientNumber;
        this.writeAnInvoice = _writeAnInvoice;
        this.goodsNumbers = _goodsNumbers;
        this.finalPrice = _finalPrice;
        this.numbers = _numbers;
        this.totalAmount = _totalAmount;
        this.typeOfPayment = _typeOfPayment;
        this.typeOfShipping = _typeOfShipping;
        this.state = _state;
    }

    public void setSalesPerson(String _salesPerson){
        this.salesPerson = _salesPerson;
    }

    public String getSalesPerson(){
        return salesPerson;
    }

    public void setClientNumber(String _clientNumber){
        this.clientNumber = _clientNumber;
    }

    public String getClientNumber(){
        return clientNumber;
    }

    public void setWriteAnInvoice(int _writeAnInvoice){
        this.writeAnInvoice = _writeAnInvoice;
    }

    public int getWriteAnInvoice(){
        return writeAnInvoice;
    }

    public void setGoodsNumbers(String _goodsNumbers){
        this.goodsNumbers = _goodsNumbers;
    }

    public String getGoodsNumbers(){
        return goodsNumbers;
    }

    public void setFinalPrice(double _finalPrice){
        this.finalPrice = _finalPrice;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setNumbers(int _numbers) {
        this.numbers = _numbers;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setTotalAmount(double _totalAmount) {
        this.totalAmount = _totalAmount;
    }

    public double getTotalAmount(){
        return totalAmount;
    }

    public void setTypeOfPayment(String _typeOfPayment) {
        this.typeOfPayment = _typeOfPayment;
    }

    public String getTypeOfPayment(){
        return typeOfPayment;
    }

    public void setTypeOfShipping(String _typeOfShipping) {
        this.typeOfShipping = _typeOfShipping;
    }

    public String getTypeOfShipping() {
        return typeOfShipping;
    }

    public void setState(String _state) {
        this.state = _state;
    }

    public String getState() {
        return state;
    }

}
