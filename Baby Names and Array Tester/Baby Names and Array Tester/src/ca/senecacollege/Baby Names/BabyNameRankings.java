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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class BabyNameRankings extends Application {

    final int NUMFIELDS = 5;
    final int NUMRECORDS = 1000;

    public static void main(String[] args) {
        launch(args);
    }

    public ArrayList < String > addToArray(ArrayList < String > source, String filename) {
        Scanner scan = null;

        try {
            scan = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
            e.printStackTrace();
        }

        for (int i = 0; scan.hasNextLine(); i++) {
            source.add(scan.nextLine());
            source.set(i, removeWhitespace(source.get(i)));
        }
        return source;
    }


    public String removeWhitespace(String source) {

        String[] split = source.split("\\s+");
        String result = "";
        for (int i = 0; i < NUMFIELDS; i++) {
            result += split[i];
            if (i < NUMFIELDS - 1)
                result += " ";
        }
        return result;
    }

    public String splitString(String source, int index) {
        String[] split = source.split("\\s+");
        return split[index];

    }

    public int searchArray(ArrayList < String > source, String gen, String name) {
        int rank = 0;
        for (int i = 0; i < NUMRECORDS; i++) {

            Baby baby = new Baby(splitString(source.get(i), 0), splitString(source.get(i), 1), splitString(source.get(i), 3));
            if (gen.equals("male") || gen.equals("Male") || gen.equals("MALE") || gen.equals("m") || gen.equals("M")) {
                if (baby.getBoyName().equals(name)) {
                    rank = Integer.parseInt(baby.getRank());
                    break;
                }
            } else if (gen.equals("female") || gen.equals("Female") || gen.equals("FEMALE") || gen.equals("f") || gen.equals("F")) {
                if (baby.getGirlName().equals(name)) {
                    rank = Integer.parseInt(baby.getRank());
                    break;
                }
            } else if (!gen.equals("male") || gen.equals("Male") || gen.equals("MALE") || gen.equals("m") || gen.equals("M") || gen.equals("female") || gen.equals("Female") || gen.equals("FEMALE") || gen.equals("f") || gen.equals("F"))
                rank = -1;
        }

        return rank;

    }


    @Override
    public void start(Stage ps) throws Exception {

        ArrayList < String > bb09 = new ArrayList < > (), bb10 = new ArrayList < > (), bb11 = new ArrayList < > (), bb12 = new ArrayList < > (), bb13 = new ArrayList < > (), bb14 = new ArrayList < > (), bb15 = new ArrayList < > (), bb16 = new ArrayList < > (), bb17 = new ArrayList < > (), bb18 = new ArrayList < > ();
        addToArray(bb09, "babynamesranking2009.txt");
        addToArray(bb10, "babynamesranking2010.txt");
        addToArray(bb11, "babynamesranking2011.txt");
        addToArray(bb12, "babynamesranking2012.txt");
        addToArray(bb13, "babynamesranking2013.txt");
        addToArray(bb14, "babynamesranking2014.txt");
        addToArray(bb15, "babynamesranking2015.txt");
        addToArray(bb16, "babynamesranking2016.txt");
        addToArray(bb17, "babynamesranking2017.txt");
        addToArray(bb18, "babynamesranking2018.txt");

        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);

        gp.setHgap(5);
        gp.setVgap(5);
        Button submit = new Button("SUBMIT QUERY");
        Button quit = new Button("EXIT");
        Button restart = new Button("YES");
        Label yearLabel = new Label("Enter the Year: ");
        Label genderLabel = new Label("Enter the Gender: ");
        Label nameLabel = new Label("Enter the Name: ");

        gp.add(yearLabel, 0, 0);
        TextField year = new TextField();
        gp.add(year, 1, 0);

        gp.add(genderLabel, 0, 1);
        TextField gender = new TextField();
        gp.add(gender, 1, 1);

        gp.add(nameLabel, 0, 2);
        TextField name = new TextField();
        gp.add(name, 1, 2);

        gp.add(submit, 0, 4);
        gp.add(quit, 1, 4);

        submit.setOnAction(e-> {
            int theRank = 0;
            int theYear = 0;
            String theGender = "";
            String theName = "";
            boolean flag = false;
            try {
                theYear = Integer.parseInt(year.getText());
                theGender = gender.getText();
                theName = name.getText();
            } catch (Exception ex) {
                flag = true;
                ex.printStackTrace();
            }

            switch (theYear) {
                case 2009:
                    theRank = searchArray(bb09, theGender, theName);
                    break;
                case 2010:
                    theRank = searchArray(bb10, theGender, theName);
                    break;
                case 2011:
                    theRank = searchArray(bb11, theGender, theName);
                    break;
                case 2012:
                    theRank = searchArray(bb12, theGender, theName);
                    break;
                case 2013:
                    theRank = searchArray(bb13, theGender, theName);
                    break;
                case 2014:
                    theRank = searchArray(bb14, theGender, theName);
                    break;
                case 2015:
                    theRank = searchArray(bb15, theGender, theName);
                    break;
                case 2016:
                    theRank = searchArray(bb16, theGender, theName);
                    break;
                case 2017:
                    theRank = searchArray(bb17, theGender, theName);
                    break;
                case 2018:
                    theRank = searchArray(bb18, theGender, theName);
                    break;
                default:
                    flag = true;
                    break;

            }
            if (!flag) {
                gp.getChildren().clear();
                if (theRank > 0)
                    gp.add(new Label(theGender + " name " + theName + " is ranked #" + theRank + " in the year " + theYear), 0, 0);
                else if (theRank == 0)
                    gp.add(new Label("The name " + theName + " does not appear in the " + theYear + " list of baby names"), 0, 0);
                else {
                    gp.getChildren().clear();
                    gp.add(new Label("Invalid Gender Entry! Please enter \"Male\" or \"Female\""), 0, 0);
                    gp.add(new Label("Do you want to search for another name?"), 0, 3);
                    gp.add(restart, 0, 5);
                    gp.add(quit, 1, 5);
                    quit.setText("NO");
                }
                gp.add(new Label("Do you want to search for another name?"), 0, 3);
                gp.add(restart, 0, 5);
                gp.add(quit, 1, 5);
                quit.setText("NO");
            } else {
                gp.getChildren().clear();
                gp.add(new Label("Invalid Year Entry! Please enter a year between 2009-2018"), 0, 0);
                gp.add(new Label("Do you want to search for another name?"), 0, 3);
                gp.add(restart, 0, 5);
                gp.add(quit, 1, 5);
                quit.setText("NO");
                flag = false;
            }
        });

        restart.setOnAction(r-> {
            gp.getChildren().clear();
            gp.add(yearLabel, 0, 0);
            gp.add(year, 1, 0);
            gp.add(genderLabel, 0, 1);
            gp.add(gender, 1, 1);
            gp.add(nameLabel, 0, 2);
            gp.add(name, 1, 2);
            year.clear();
            gender.clear();
            name.clear();
            gp.add(submit, 0, 4);
            gp.add(quit, 1, 4);

        });

        quit.setOnAction(q-> {
            gp.getChildren().clear();
            Label end = new Label("Thank you for using my app!");
            gp.add(end, 0, 0);

        });

        Scene sc = new Scene(gp, 400, 400);
        ps.setTitle("Search Name Ranking Application");
        ps.setScene(sc);
        ps.show();

    }

}