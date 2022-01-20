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

public abstract class Employee implements Payable {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    public String getFirstName() {
        return firstName;
    }
    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    private String getLastName() {
        return lastName;
    }
    private void setLastName(String lastName) {
        this.lastName = lastName;
    }
    private String getSSN() {
        return socialSecurityNumber;
    }
    private void setSSN(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }
    public Employee() {
        setFirstName(null);
        setLastName(null);
        setSSN(null);
    }
    public Employee(String fname, String lname, String ssn) {
        setFirstName(fname);
        setLastName(lname);
        setSSN(ssn);
    }
    public String toString() {
        return "Employee first name: " + getFirstName() + "\nEmployee last name: " + getLastName() + "\nEmployee Social Security Number: " + getSSN();
    }


}