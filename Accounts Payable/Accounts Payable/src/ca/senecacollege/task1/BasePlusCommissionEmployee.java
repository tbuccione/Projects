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

public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;
    public BasePlusCommissionEmployee() {
        try {
            setBaseSalary(0.0);
        } catch (IllegalArgumentException ex) {
            System.out.println("Incorrect entry!");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Incorrect entry!");
            ex.printStackTrace();
        }
    }
    public BasePlusCommissionEmployee(double base, double sales, double rate, String fname, String lname, String ssn) {
        super(sales, rate, fname, lname, ssn);
        try {
            setBaseSalary(base);
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
        	System.out.println("Testing finally block");
        }
    }
    @Override
    public double getPaymentAmount() {

        return getBaseSalary() + (super.getGrossSales() * super.getCommission());
    }
    public double getBaseSalary() {

        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary <= 0.0)
            throw new IllegalArgumentException("Base salary amount must be greater than 0.0.");
        else
            this.baseSalary = baseSalary;
    }

    public String toString() {
        return super.toString() + "\nBase plus commission employee weekly salary: " + getBaseSalary();
    }
}