/**********************************************
Workshop #7 
Course:JAC444 - Semester 4
Last Name: Buccione
First Name: Tyrone
ID: 029743051
Section: NFF
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature: Tyrone Buccione
Date: November 14, 2021
**********************************************/

package ca.senecacollege.task1;

public class Baby {
    private String rank;
    private String boyName;
    private String girlName;

    public String getRank() {
        return rank;
    }
    public String getBoyName() {
        return boyName;
    }

    public String getGirlName() {
        return girlName;
    }

    public Baby(String rank, String boyName, String girlName) {
        this.rank = rank;
        this.boyName = boyName;
        this.girlName = girlName;

    }

}