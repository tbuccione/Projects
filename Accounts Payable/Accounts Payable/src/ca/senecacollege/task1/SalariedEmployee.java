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

public class SalariedEmployee extends Employee {
    private double weeklySalary;
    public SalariedEmployee() {
        try {
            setSalary(0.0);
        } catch (IllegalArgumentException ex) {
            System.out.println("Incorrect entry!");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Incorrect entry!");
            ex.printStackTrace();
        }
    }
    public SalariedEmployee(double sal, String fname, String lname, String ssn) {
        super(fname, lname, ssn);
        try {
            setSalary(sal);
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
        	System.out.println("Testing finally block");
        }
    }
    @Override
    public double getPaymentAmount() {

        return getWeeklySalary();
    }
    private double getWeeklySalary() {
        return weeklySalary;
    }
    private void setSalary(double weeklySalary) {
        if (weeklySalary <= 0.0)
            throw new IllegalArgumentException("Salary amount must be greater than 0.0.");
        else
            this.weeklySalary = weeklySalary;
    }

    public String toString() {
        return super.toString() + "\nEmployee weekly salary: " + getWeeklySalary();
    }

}