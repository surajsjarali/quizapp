package com.example.bruno.quizapp;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    int scoreCounter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This Method is called when the Submit button is clicked.
     */
    public void checkQuiz(View view){
        scoreCounter = 0;
        boolean firstAnswer = false;
        boolean secondAnswer;
        boolean thirdAnswer = false;
        boolean forthAnswer = false;
        boolean fifthAnswer = false;
        /*
          Acquires the user's name for later use.
         */
        EditText nameInput =(EditText) findViewById(R.id.name_input);
        Editable userName =nameInput.getText();
        String name = userName.toString();
        /* Stores the value of the first question and checks the answer.
          **/
        EditText firstPresident = (EditText) findViewById(R.id.first_president);
        Editable firstQuestion = firstPresident.getText();
        String first = firstQuestion.toString().trim();
        if(first.equalsIgnoreCase("George Washington")){
            firstAnswer = true;
            scoreCounter += 1;
        }
        secondAnswer = secondQuestionCheck();
        /*
            Reads the Editable for the third question and sets thirdAnswer to True or False based on whether or not it's correct.
         */
        EditText howManyColonies = (EditText) findViewById(R.id.third_question);
        Editable thirdQuestion = howManyColonies.getText();
        String third = thirdQuestion.toString();
        if(third.equals("13")){
            scoreCounter += 1;
            thirdAnswer = true;
        }
        /*
            Reads the Editable for the forth question and sets forthAnswer to True or False based on whether or not it's correct.
         */
        EditText howManySenators = (EditText) findViewById(R.id.forth_question);
        Editable forthQuestion = howManySenators.getText();
        String forth = forthQuestion.toString();
        if(forth.equals("100")){
            scoreCounter += 1;
            forthAnswer = true;
        }
        RadioButton forthRadio =(RadioButton) findViewById(R.id.forth_radio);
        boolean forthRadioButton = forthRadio.isChecked();
        if(forthRadioButton){
            scoreCounter += 1;
            fifthAnswer = true;
        }
        /*
          Calculate score and stores a string of the results of the quiz.
         */
        int score = 20 * scoreCounter;
        String message = calculateScore(name, firstAnswer, secondAnswer, thirdAnswer, forthAnswer, fifthAnswer, score);
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
        TextView scoreTopRight = (TextView) findViewById(R.id.display_score);
        scoreTopRight.setText(String.valueOf(score));
    }
    public String calculateScore(String name, Boolean firstAnswer, Boolean secondAnswer, Boolean thirdAnswer, Boolean forthAnswer, Boolean fifthAnswer, int score){
        String scoreMessage =name;
        if(firstAnswer && secondAnswer && thirdAnswer && forthAnswer && fifthAnswer){
            scoreMessage = ("Amazing! " + name +", you got everything correct!" + "\n\nYou got a score of " + score  + "%!!");
            return scoreMessage;
        }
        if(firstAnswer != true){
            scoreMessage += ("\nIt seems your answer to the first question is wrong, please make sure you have correctly spelled the President's name. ");
        }
        if(secondAnswer != true){
            scoreMessage +=("\n\nIt seems your answer to the second question is wrong, you need to check the boxes for only the 3 Branches. ");
        }
        if(thirdAnswer != true){
            scoreMessage +=("\n\nYour answer to the third question is wrong, please revisit it. ");
        }if(forthAnswer != true){
            scoreMessage +=("\n\nYour answer to the forth question is wrong, please revisit it. ");
        }
        if(fifthAnswer != true){
            scoreMessage +=("\n\nYour answer to the fifth question is wrong, please revisit it. ");
        }
        scoreMessage += ("\n\nYou got a score of " + score + "%");
        return scoreMessage;
    }
    /**
     * Checks the checkboxes for the second question to find the answer.
     */
    public boolean secondQuestionCheck(){
        CheckBox firstBox = (CheckBox) findViewById(R.id.first_box);
        boolean firstCheckBox = firstBox.isChecked();
        CheckBox secondBox = (CheckBox) findViewById(R.id.second_box);
        boolean secondCheckBox = secondBox.isChecked();
        CheckBox thirdBox = (CheckBox) findViewById(R.id.third_box);
        boolean thirdCheckBox = thirdBox.isChecked();
        CheckBox forthBox = (CheckBox) findViewById(R.id.forth_box);
        boolean forthCheckBox = forthBox.isChecked();
        boolean answerToSecondQuestion;
        if (firstCheckBox){
            answerToSecondQuestion = false;
            return answerToSecondQuestion;
        } else{
            answerToSecondQuestion = true;
        }
        if(secondCheckBox){
            answerToSecondQuestion = true;
        } else{
            answerToSecondQuestion = false;
            return answerToSecondQuestion;
        }
        if(thirdCheckBox){
            answerToSecondQuestion = true;
        } else{
            answerToSecondQuestion = false;
            return answerToSecondQuestion;
        }
        if(forthCheckBox){
            scoreCounter += 1;
            answerToSecondQuestion = true;
        } else{
            answerToSecondQuestion = false;
            return answerToSecondQuestion;
        }
        return answerToSecondQuestion;
    }
}
