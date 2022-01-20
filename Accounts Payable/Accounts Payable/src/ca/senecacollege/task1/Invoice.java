/**********************************************
Workshop #4 
Course:JAC444 - Semester 4
Last Name: Buccione
First Name: Tyrone
ID: 029743051
Section: NFF
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature: Tyrone Buccione
Date: October 13, 2021
**********************************************/

package ca.senecacollege.task1;

public class Invoice implements Payable {
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    public Invoice() {
        setPartNum(null);
        setPartDesc(null);
        setQuantity(0);
        setPricePerItem(0);
    }
   
    public Invoice(String partNum, String partDesc, int quan, double price) {
        setPartNum(partNum);
        setPartDesc(partDesc);
        setQuantity(quan);
        setPricePerItem(price);
    }
    private String getPartNum() {
        return partNumber;
    }
    private void setPartNum(String source) {
        partNumber = source;
    }
    private String getPartDesc() {
        return partDescription;
    }
    private void setPartDesc(String source) {
        partDescription = source;
    }
    private int getQuantity() {
        return quantity;
    }
    private void setQuantity(int source) {
        quantity = source;
    }
    private double getPricePerItem() {
        return pricePerItem;
    }
    private void setPricePerItem(double source) {
        pricePerItem = source;
    }
    public String toString() {
        return "Invoice part number: " + getPartNum() + "\nInvoice part description: " + getPartDesc() + "\nInvoice quantity: " + getQuantity() + "\nInvoice price per item: " + getPricePerItem();
    }
    @Override
    public double getPaymentAmount() {
        return getPricePerItem() * getQuantity();
    }

}