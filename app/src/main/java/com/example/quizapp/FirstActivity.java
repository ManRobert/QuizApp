package com.example.quizapp;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class FirstActivity extends AppCompatActivity {
    public static final String requirement = "requirement";
    public static final String answerOption1 = "answerOption1";
    public static final String answerOption2 = "answerOption2";
    public static final String answerOption3 = "answerOption3";
    public static final String answerOption4 = "answerOption4";
    public static final String resultKey = "result";

    Boolean gameStarted = false;

    List<Question> questions = new ArrayList<>();
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<Boolean> correctAnswers1 = new ArrayList<>();
        List<Boolean> usersAnswers1 = new ArrayList<>();

        List<Boolean> correctAnswers2 = new ArrayList<>();
        List<Boolean> usersAnswers2 = new ArrayList<>();

        List<Boolean> correctAnswers3 = new ArrayList<>();
        List<Boolean> usersAnswers3 = new ArrayList<>();

        List<Boolean> correctAnswers4 = new ArrayList<>();
        List<Boolean> usersAnswers4 = new ArrayList<>();

        correctAnswers1.add(false);
        correctAnswers1.add(false);
        correctAnswers1.add(true);
        correctAnswers1.add(false);

        correctAnswers2.add(true);
        correctAnswers2.add(false);
        correctAnswers2.add(false);
        correctAnswers2.add(false);

        correctAnswers3.add(false);
        correctAnswers3.add(true);
        correctAnswers3.add(false);
        correctAnswers3.add(false);

        correctAnswers4.add(true);
        correctAnswers4.add(true);
        correctAnswers4.add(false);
        correctAnswers4.add(false);

        usersAnswers1.add(false);
        usersAnswers1.add(false);
        usersAnswers1.add(false);
        usersAnswers1.add(false);

        usersAnswers2.add(false);
        usersAnswers2.add(false);
        usersAnswers2.add(false);
        usersAnswers2.add(false);

        usersAnswers3.add(false);
        usersAnswers3.add(false);
        usersAnswers3.add(false);
        usersAnswers3.add(false);

        usersAnswers4.add(false);
        usersAnswers4.add(false);
        usersAnswers4.add(false);
        usersAnswers4.add(false);

        Question question1 = new Question("cat face 1+2", "1", "2", "3", "4", correctAnswers1, usersAnswers1);
        Question question2 = new Question("cat face 2+2", "4", "10", "3", "4", correctAnswers2, usersAnswers2);
        Question question3 = new Question("cat face 10+10", "1", "20", "9", "4", correctAnswers3, usersAnswers3);
        Question question4 = new Question("cat face 10+10", "30-10", "20", "9", "4", correctAnswers4, usersAnswers4);

        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);


        setContentView(R.layout.activity_bundle);
    }

    public void next(View view) {
        if (position == questions.size()) {
            Button button = findViewById(R.id.button1);
            ViewGroup layout = (ViewGroup) button.getParent();
            if (null != layout)
                layout.removeView(button);

            String result = "You answered correctly to ";
            int number = 0;

            for (int i = 0; i < questions.size(); i++) {
                Question questionForResult = questions.get(i);
                List<Boolean> usersAnswersForResultPerQuestion = new ArrayList<>();
                usersAnswersForResultPerQuestion.add(questionForResult.getUsersAnswer1());
                usersAnswersForResultPerQuestion.add(questionForResult.getUsersAnswer2());
                usersAnswersForResultPerQuestion.add(questionForResult.getUsersAnswer3());
                usersAnswersForResultPerQuestion.add(questionForResult.getUsersAnswer4());

                if (usersAnswersForResultPerQuestion.get(0) == questionForResult.getCorrectAnswers().get(0) &&
                        usersAnswersForResultPerQuestion.get(1) == questionForResult.getCorrectAnswers().get(1) &&
                        usersAnswersForResultPerQuestion.get(2) == questionForResult.getCorrectAnswers().get(2) &&
                        usersAnswersForResultPerQuestion.get(3) == questionForResult.getCorrectAnswers().get(3)
                ) {
                    number++;
                }
            }

            result = result + (String.valueOf(number) + " questions from " + String.valueOf(questions.size()));
            Bundle bundle = new Bundle();
            bundle.putString(resultKey, result);
            GameOver gameOver = new GameOver();
            gameOver.setArguments(bundle);
            FragmentHelper.displayFragment(FirstActivity.this, R.id.placeholderFragment, gameOver);

        } else if (!gameStarted) {
            gameStarted = true;
            Bundle bundle = new Bundle();
            bundle.putString(requirement, questions.get(position).getRequirement());
            bundle.putString(answerOption1, questions.get(position).getAnswerOption1());
            bundle.putString(answerOption2, questions.get(position).getAnswerOption2());
            bundle.putString(answerOption3, questions.get(position).getAnswerOption3());
            bundle.putString(answerOption4, questions.get(position).getAnswerOption4());
            BundleFragment bundleFragment = new BundleFragment();
            bundleFragment.setArguments(bundle);
            position++;
            FragmentHelper.displayFragment(FirstActivity.this, R.id.placeholderFragment, bundleFragment);
        } else if (questions.get(position - 1).getUsersAnswer1() ||
                questions.get(position - 1).getUsersAnswer2() ||
                questions.get(position - 1).getUsersAnswer3() ||
                questions.get(position - 1).getUsersAnswer4()) {
            Bundle bundle = new Bundle();
            bundle.putString(requirement, questions.get(position).getRequirement());
            bundle.putString(answerOption1, questions.get(position).getAnswerOption1());
            bundle.putString(answerOption2, questions.get(position).getAnswerOption2());
            bundle.putString(answerOption3, questions.get(position).getAnswerOption3());
            bundle.putString(answerOption4, questions.get(position).getAnswerOption4());
            BundleFragment bundleFragment = new BundleFragment();
            bundleFragment.setArguments(bundle);
            position++;
            FragmentHelper.displayFragment(FirstActivity.this, R.id.placeholderFragment, bundleFragment);

        } else {
            Toast.makeText(FirstActivity.this, "You did not answer this question!", Toast.LENGTH_LONG).show();
        }
    }

    public void setAnswer1(View view) {
        System.out.println(position - 1);
        questions.get(position - 1).setUsersAnswers1(!questions.get(position - 1).getUsersAnswer1());
    }

    public void setAnswer2(View view) {
        questions.get(position - 1).setUsersAnswers2(!questions.get(position - 1).getUsersAnswer2());
    }

    public void setAnswer3(View view) {
        questions.get(position - 1).setUsersAnswers3(!questions.get(position - 1).getUsersAnswer3());
    }

    public void setAnswer4(View view) {
        questions.get(position - 1).setUsersAnswers4(!questions.get(position - 1).getUsersAnswer4());
    }

}