///////////////////////////////////////////////
/// NAME: LAWRENCE CHEN                     ///
/// ASSIGNMENT: HW2, COMBO & TEXT CONTROLS  ///
/// PROFESSOR: DAVID BOLDING                ///
/// DUE DATE: SEPTEMBER 19th                ///
///////////////////////////////////////////////

/*
   OUTLINE: In this assignment, students will create an application that allows them to get information about a number,
   and that allows them to play a trivial guessing-game.

   THERE ARE TWO WIDGETS BEING CREATED! 1) NUMBERINFORMATION WIDGET
                                        2) GUESSINGGAME WIDGET

------GUESSING GAME WIDGET (GGW)------------------------------------------------------------------------------------


        OBJECTIVE : Guess the "right" button, and keep track of how many times the user guesses correctly (counter)

        - The guessing game should have four radio buttons arranged into two columns [CHECK]
        - Radio buttons should be in two button groups (toggle groups) [CHECK]
        - Only one be selected at a time out of the group of radio buttons [CHECK]
        - Next to the radio button [CHECK]
            - "Guess" button [CHECK]
        - Beneath the radio button --> Read Only Text-Line [CHECK]
        - Keep track of correct and incorrect guesses [CHECK]
        - Cheat a little : random number w/ Math.random() in Java
            - IF randomNumber < 0.25, THEN correct! [CHECK]
        - Keep the "Guess" button and the score tracking text-line along right edge of control, and the grid
        of four radio-buttons lined up against the left. The widget is expanded, the excess space in the center should
        be left blank (as when empty, always-growing cell is placed there) [CHECK]

*/

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.util.converter.NumberStringConverter;
import java.io.Console;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.ResourceBundle;


public class GuessingGameWidget extends GridPane{


    // INITIALIZED CORRECT & INCORRECT COUNTERS GLOBALLY
    int correctCounter = 0;
    int incorrectCounter = 0;

    public GuessingGameWidget() {

        Region space = new Region();

        // CREATING REGIONS TO CREATE SPACING AND SEPERATIONS
        add(space, 1, 0);
        setHgrow(space, Priority.ALWAYS);

        // TOGGLE GROUPS FOR RADIO BUTTONS
        ToggleGroup tg1 = new ToggleGroup();

        // RADIO BUTTONS 1-4

        // 1-2 (COLUMN 1)
        RadioButton rb1 = new RadioButton("1");
        add(rb1, 0, 0);
        rb1.setToggleGroup(tg1);
        rb1.setSelected(true);
        rb1.setPadding(new Insets(10));
        RadioButton rb2 = new RadioButton("2");
        add(rb2, 0, 1);
        rb2.setToggleGroup(tg1);
        rb2.setPadding(new Insets(10));

        // 2-4 (COLUMN 2)
        RadioButton rb3 = new RadioButton("3");
        add(rb3, 1, 0);
        rb3.setToggleGroup(tg1);
        rb3.setPadding(new Insets(10));

        RadioButton rb4 = new RadioButton("4");
        add(rb4, 1, 1);
        rb4.setToggleGroup(tg1);
        rb4.setPadding(new Insets(10));


        // CORRECT & INCORRECT COUNTER TEXT DISPLAY BELOW GUESS BUTTON
        //TextLine test = new TextLine();
        TextField scoreBoard = new TextField();
        add(scoreBoard, 2, 1);
        scoreBoard.setEditable(false);
        scoreBoard.setPrefColumnCount(12);
        scoreBoard.setAlignment(Pos.CENTER);

        // GUESS BUTTON
        Button guess = new Button("Guess");
        add(guess, 2, 0);
        guess.setOnAction(

                event -> {

                    // CALLING METHOD
                    updateCounter(scoreBoard, correctCounter, incorrectCounter);

                }

        );
    }

    // INCREMENTS CORRECT COUNTER METHOD HAD TO BE OUTSIDE DUE TO ERROR I WAS GETTING
    public void incrementCorrectCounter() {
        correctCounter++;
    }

    // INCREMENTS INCORRECT COUNTER METHOD HAD TO BE OUTSIDE DUE TO ERROR I WAS GETTING

    public void incrementIncorrectCounter() {
        incorrectCounter++;
    }

    // UPDATE COUNTER METHOD TO KEEP TRACK OF CORRECT AND INCORRECT GUESSES
    public void updateCounter(TextField scoreBoard, int correctCounter, int incorrectCounter) {

        // RANDOM NUMBER GENERATOR
        double randomWin = (double) (Math.random() * 1.0);

        if (randomWin < .25) {
            incrementCorrectCounter();
            System.out.println("CORRECT!");
            scoreBoard.setText("Correct: " + correctCounter + "  Incorrect: " + incorrectCounter);

        } else {
            incrementIncorrectCounter();
            System.out.println("INCORRECT!");
            scoreBoard.setText("Correct: " + correctCounter + "  Incorrect: " + incorrectCounter);
        }

    }




}
