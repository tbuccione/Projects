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

public class CommissionEmployee extends Employee {
    private double grossSales;
    private double commissionRate;
    public CommissionEmployee() {
        try {
            setGrossSales(0.0);
            setCommission(0.0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    public CommissionEmployee(double sales, double rate, String fname, String lname, String ssn) {
        super(fname, lname, ssn);
        try {
            setGrossSales(sales);
            setCommission(rate);
        } catch (IllegalArgumentException ex) {
            System.out.println("Incorrect entry!");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Incorrect entry!");
            ex.printStackTrace();
        }finally {
        	System.out.println("Testing finally block");
        }
    }

    @Override
    public double getPaymentAmount() {

        return getCommission() * getGrossSales();
    }

    public double getGrossSales() {
        return grossSales;
    }
    public void setGrossSales(double grossSales) {
        if (grossSales <= 0.0)
            throw new IllegalArgumentException("Gross sales must be greater than 0.0.");
        else
            this.grossSales = grossSales;
    }
    public double getCommission() {
        return commissionRate;
    }
    public void setCommission(double commissionRate) {
        if (commissionRate < 0.0 || commissionRate > 1.0)
            throw new IllegalArgumentException("Commission rate must be between 0.0 and 1.0");
        else
            this.commissionRate = commissionRate;
    }

    public String toString() {
        return super.toString() + "\nCommission employee gross sales: " + getGrossSales() + "\nCommission employee commission rate: " + getCommission();
    }
}