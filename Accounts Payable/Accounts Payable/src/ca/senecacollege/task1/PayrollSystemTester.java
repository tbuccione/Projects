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

public class PayrollSystemTester {
    public static void main(String[] args) {

        Payable testArray[] = {
            new Invoice("700 X 23C", "Inner Tube", 4, 12.95),
            new Invoice("444", "Stem", 10, 30.99),
            new SalariedEmployee(3000.00, "James", "Kirk", "170-11-7011"),
            new HourlyEmployee(20.00, 140.00, "Jean-Luc", "Picard", "001-00-1001"),
            new CommissionEmployee(17011.70, .15, "Benjamin", "Sisko", "999-99-9999"),
            new BasePlusCommissionEmployee(85000.00, 2000.00, 0.20, "Katherine", "Janeway", "746-56-7465")
        };

        System.out.println("TESTING toString() METHODS:\n");

        for (int i = 0; i < testArray.length; i++) {
            System.out.println(testArray[i].toString());
            System.out.println();
        }

        System.out.println("TESTING BASE COMMISSION + 10% FOR BasePlusCommissionEmployee:\n");
        double baseIncrease = 0.0;
        for (int i = 0; i < testArray.length; i++) {
            if (testArray[i] instanceof BasePlusCommissionEmployee) {
                System.out.println("Base salary before 10% increase: " + ((BasePlusCommissionEmployee) testArray[i]).getBaseSalary());
                baseIncrease = ((BasePlusCommissionEmployee) testArray[i]).getBaseSalary() * .10;
                ((BasePlusCommissionEmployee) testArray[i]).setBaseSalary(baseIncrease + ((BasePlusCommissionEmployee) testArray[i]).getBaseSalary());
                System.out.println("Base salary after 10% increase: " + ((BasePlusCommissionEmployee) testArray[i]).getBaseSalary());
            }
            System.out.println(testArray[i].toString());
            System.out.println();
        }

        System.out.println("TESTING getPaymentAmount() METHODS:\n");

        for (int i = 0; i < testArray.length; i++) {
            if (testArray[i] instanceof BasePlusCommissionEmployee) {
                System.out.println("Base salary before 10% increase: " + ((BasePlusCommissionEmployee) testArray[i]).getBaseSalary());
                baseIncrease = ((BasePlusCommissionEmployee) testArray[i]).getBaseSalary() * .10;
                ((BasePlusCommissionEmployee) testArray[i]).setBaseSalary(baseIncrease + ((BasePlusCommissionEmployee) testArray[i]).getBaseSalary());
                System.out.println("Base salary after 10% increase: " + ((BasePlusCommissionEmployee) testArray[i]).getBaseSalary());
            }
            System.out.println(testArray[i].toString());
            System.out.println("Payment amount is: " + testArray[i].getPaymentAmount());
            System.out.println();
        }



    }




}