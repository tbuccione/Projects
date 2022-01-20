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

package ca.senecacollege.task2;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ArrayOps extends Application {
    public static final ArrayProcessor maxVal = (arr) -> {
        Arrays.sort(arr);
        return arr[arr.length - 1];
    };

    public static final ArrayProcessor minVal = (arr) -> {
        Arrays.sort(arr);
        return arr[0];
    };

    public static final ArrayProcessor arrSum = (arr) -> {
        double sum = 0.0;
        for (double a: arr)
            sum += a;
        return sum;
    };

    public static final ArrayProcessor arrAvg = (arr) -> {
        double sum = 0.0;
        for (double a: arr)
            sum += a;
        return sum / arr.length;
    };

    public static ArrayProcessor counter(double value) {
        return (arr) -> {
            double counter = 0.0;
            for (double a: arr) {
                if (a == value)
                    counter++;
            }
            return counter;
        };
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage ps) throws Exception {

        ArrayList < Double > arr = new ArrayList < > ();

        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);

        gp.setHgap(5);
        gp.setVgap(5);
        Label prompt = new Label("Please enter an array number (double)");
        Label showArray = new Label("");
        Label enterForCount = new Label("Count occurances of this number in your array: ");
        Button submit = new Button("SUBMIT");
        Button quit = new Button("QUIT APP");
        Button restart = new Button("START OVER");
        Button finished = new Button("I'M FINISHED ENTERING NUMBERS");
        Button max = new Button("FIND MAX VAL IN ARRAY");
        Button min = new Button("FIND MIN VAL IN ARRAY");
        Button sum = new Button("CALCULATE ARRAY SUM");
        Button avg = new Button("CALCULATE ARRAY AVERAGE");
        Button count = new Button("COUNT");
        TextField num = new TextField();

        gp.add(prompt, 0, 0);
        gp.add(num, 0, 1);

        gp.add(submit, 0, 4);
        gp.add(quit, 0, 6);

        submit.setOnAction(e -> {

            String numbers = "";
            prompt.setText("Please enter an array number (double)");
            try {
                arr.add(Double.parseDouble(num.getText()));
            } catch (Exception ex) {
                prompt.setText("Invalid Entry! Please only enter a number: ");
                ex.printStackTrace();
            }
            for (int i = 0; i < arr.size(); i++)
                numbers += arr.get(i).toString() + ", ";
            showArray.setText("Numbers in your array: " + numbers);
            submit.setText("ADD THIS NUMBER");
            num.clear();
            gp.getChildren().clear();
            gp.add(prompt, 0, 0);
            gp.add(showArray, 0, 1);
            gp.add(num, 0, 2);
            gp.add(submit, 0, 4);
            gp.add(finished, 0, 6);
            gp.add(quit, 0, 8);
        });

        finished.setOnAction(e -> {
            gp.getChildren().clear();
            gp.add(showArray, 0, 1);
            gp.add(max, 0, 4);
            gp.add(min, 0, 6);
            gp.add(sum, 0, 8);
            gp.add(avg, 0, 10);
            gp.add(enterForCount, 0, 12);
            gp.add(num, 0, 13);
            gp.add(count, 1, 13);
            gp.add(restart, 0, 14);
            gp.add(quit, 0, 16);

        });

        quit.setOnAction(q -> {
            gp.getChildren().clear();
            Label end = new Label("Thank you for using my app!");
            gp.add(end, 0, 0);

        });

        max.setOnAction(e -> {
            Double maximum = 0.0;
            double[] dblArr = new double[arr.size()];
            for (int i = 0; i < arr.size(); i++)
                dblArr[i] = arr.get(i);
            maximum = maxVal.operations(dblArr);
            gp.add(new Label(maximum.toString()), 1, 4);
        });

        min.setOnAction(e -> {
            Double minimum = 0.0;
            double[] dblArr = new double[arr.size()];
            for (int i = 0; i < arr.size(); i++)
                dblArr[i] = arr.get(i);
            minimum = minVal.operations(dblArr);
            gp.add(new Label(minimum.toString()), 1, 6);
        });

        sum.setOnAction(e -> {
            Double arraySum = 0.0;
            double[] dblArr = new double[arr.size()];
            for (int i = 0; i < arr.size(); i++)
                dblArr[i] = arr.get(i);
            arraySum = (double) Math.round(arrSum.operations(dblArr));
            gp.add(new Label(arraySum.toString()), 1, 8);
        });

        avg.setOnAction(e -> {
            Double arrayAverage = 0.0;
            double[] dblArr = new double[arr.size()];
            for (int i = 0; i < arr.size(); i++)
                dblArr[i] = arr.get(i);
            arrayAverage = (double) Math.round(arrAvg.operations(dblArr));
            gp.add(new Label(arrayAverage.toString()), 1, 10);
        });

        count.setOnAction(e -> {
            enterForCount.setText("Count occurances of this number in your array: ");
            double[] dblArr = new double[arr.size()];
            for (int i = 0; i < arr.size(); i++)
                dblArr[i] = arr.get(i);
            try {
                enterForCount.setText("The number " + num.getText() + " appears " + String.valueOf((int) counter(Double.parseDouble(num.getText())).operations(dblArr)) + " time(s) in your array. \nCount occurances of this number in your array: ");
                num.clear();
            } catch (Exception ex) {
            	num.clear();
                enterForCount.setText("Invalid entry! Please enter a number only: \nCount occurances of this number in your array: ");
                ex.printStackTrace();
            }
        });

        restart.setOnAction(e -> {
            gp.getChildren().clear();
            arr.clear();
            gp.add(prompt, 0, 0);
            gp.add(num, 0, 1);
            gp.add(submit, 0, 4);
            gp.add(quit, 0, 6);
        });

        Scene sc = new Scene(gp, 650, 400);
        ps.setTitle("Array Processor Application");
        ps.setScene(sc);
        ps.show();

    }


}