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

public class HourlyEmployee extends Employee {
    private double wage;
    private double hours;
    public HourlyEmployee() {
        try {
            setWage(0.0);
            setHours(0.0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public HourlyEmployee(double w, double h, String fname, String lname, String ssn) {
        super(fname, lname, ssn);
        try {
            setWage(w);
            setHours(h);
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

        return getWage() * getHours();
    }
    private double getWage() {
        return wage;
    }
    private void setWage(double wage) {
        if (wage <= 0.0)
            throw new IllegalArgumentException("Wage amount must be greater than 0.0.");
        else
            this.wage = wage;
    }
    private double getHours() {
        return hours;
    }
    private void setHours(double hours) {
        if (hours < 0.0 || hours > 168.00)
            throw new IllegalArgumentException("Hours must be between 0.0 and 168.00");
        else
            this.hours = hours;
    }
    public String toString() {
        return super.toString() + "\nHourly employee wage: " + getWage() + "\nHourly employee hours: " + getHours();
    }

}