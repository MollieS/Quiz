package com.mollie.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private final String QUESTION_ONE_ANSWER = "Canada";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpSubmitButton();
    }

    private void setUpSubmitButton() {
        final Button submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int score = submitAnswers();
                String scoreMessage = "you got " + score + " correct!";
                Toast.makeText(getApplicationContext(), scoreMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private int submitAnswers() {
        int score = 0;

        if (answerOneIsCorrect()) {
            score++;
        }

        if (answerTwoIsCorrect()) {
            score++;
        }

        if (answerThreeIsCorrect()) {
            score++;
        }

        if (answerFourIsCorrect()) {
            score++;
        }

        return score;
    }

    private boolean answerFourIsCorrect() {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.question_four_answer);
        int answerId = radioGroup.getCheckedRadioButtonId();
        return answerId == R.id.angel_catbird;
    }

    private boolean answerThreeIsCorrect() {
        CheckBox correctAnswerOne = (CheckBox) findViewById(R.id.maddaddam);
        CheckBox correctAnswerTwo = (CheckBox) findViewById(R.id.oryx_and_crake);
        CheckBox correctAnswerThree = (CheckBox) findViewById(R.id.year_of_the_flood);
        CheckBox incorrectAnswer = (CheckBox) findViewById(R.id.incorrect);

        if (incorrectAnswer.isChecked()) {
            return false;
        } else if (correctAnswerOne.isChecked() && correctAnswerTwo.isChecked() && correctAnswerThree.isChecked()) {
            return true;
        }
        return false;
    }

    private boolean answerTwoIsCorrect() {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.question_two_answer);
        int answerId = radioGroup.getCheckedRadioButtonId();
        return answerId == R.id.swing_time;
    }

    private boolean answerOneIsCorrect() {
        EditText editText = (EditText) findViewById(R.id.question_one_answer);
        String givenAnswer = editText.getText().toString();
        return Objects.equals(QUESTION_ONE_ANSWER, givenAnswer);
    }

}
