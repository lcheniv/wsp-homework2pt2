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
        - Next to the radio button
            - "Guess" button [CHECK]
        - Beneath the radio button --> Read Only Text-Line [CHECK]
        - Keep track of correct and incorrect guesses
        - Cheat a little : random number w/ Math.random() in Java
            - IF randomNumber < 0.25, THEN correct!
        - Keep the "Guess" button and the score tracking text-line along right edge of control, and the grid
        of four radio-buttons lined up against the left. The widget is expanded, the excess space in the center should
        be left blank (as when empty, always-growing cell is placed there)

*/

import com.sun.javafx.text.TextLine;
import javafx.scene.layout.GridPane;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;

public class GuessingGameWidget extends GridPane{

    public GuessingGameWidget() {

        // TOGGLE GROUPS FOR RADIO BUTTONS
        ToggleGroup tg1 = new ToggleGroup();
        ToggleGroup tg2 = new ToggleGroup();

        // RADIO BUTTONS

        // 1-2 (COLUMN 1)
        RadioButton rb1 = new RadioButton("1");
        add(rb1, 0, 0);
        rb1.setToggleGroup(tg1);
        rb1.setSelected(true);

        RadioButton rb2 = new RadioButton("2");
        add(rb2, 0, 1);
        rb2.setToggleGroup(tg1);


        // 2-4 (COLUMN 2)
        RadioButton rb3 = new RadioButton("3");
        add(rb3, 1, 0);
        rb3.setToggleGroup(tg1);

        RadioButton rb4 = new RadioButton("4");
        add(rb4, 1, 1);
        rb4.setToggleGroup(tg1);

        // INITIALIZED CORRECT & INCORRECT COUNTERS
        int correctCounter = 0;
        int incorrectCounter = 0;

        // GUESS BUTTON
        Button guess = new Button("Guess");
        add(guess, 2, 0);
        guess.setOnAction(

                event -> {

                    // RANDOM NUMBER GENERATOR
                    double randomWin = (double)(Math.random() * 1.0);

                    if(randomWin < .25){
                        //correctCounter = correctCounter + 1;
                        System.out.println("CORRECT!");
                    } else {
                        //incorrectCounter++;
                        System.out.println("INCORRECT!");
                    }

                }
        );

        // CORRECT & INCORRECT COUNTER TEXT DISPLAY BELOW GUESS BUTTON
        //TextLine test = new TextLine();
        TextField scoreBoard = new TextField();
        add(scoreBoard, 2, 1);
        scoreBoard.setDisable(true);
        scoreBoard.setText("TESTING");
        scoreBoard.setPrefColumnCount(6);


    }


}
