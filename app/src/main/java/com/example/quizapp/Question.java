package com.example.quizapp;

import java.util.List;

public class Question {
    private String requirement;
    private String answerOption1;
    private String answerOption2;
    private String answerOption3;
    private String answerOption4;
    private List<Boolean> correctAnswers;
    private List<Boolean> usersAnswers;


    public Question(String requirement, String answerOption1, String answerOption2, String answerOption3, String answerOption4, List<Boolean> correctAnswers, List<Boolean> usersAnswers) {
        this.requirement = requirement;
        this.answerOption1 = answerOption1;
        this.answerOption2 = answerOption2;
        this.answerOption3 = answerOption3;
        this.answerOption4 = answerOption4;
        this.correctAnswers = correctAnswers;
        this.usersAnswers = usersAnswers;
    }

    public String getRequirement() {
        return requirement;
    }

    public String getAnswerOption1() {
        return answerOption1;
    }

    public String getAnswerOption2() {
        return answerOption2;
    }

    public String getAnswerOption3() {
        return answerOption3;
    }

    public String getAnswerOption4() {
        return answerOption4;
    }

    public List<Boolean> getCorrectAnswers() {
        return correctAnswers;
    }

    public void setUsersAnswers1(Boolean value) { this.usersAnswers.set(0, value); }

    public void setUsersAnswers2(Boolean value) {
        this.usersAnswers.set(1, value);
    }

    public void setUsersAnswers3(Boolean value) {
        this.usersAnswers.set(2, value);
    }

    public void setUsersAnswers4(Boolean value) {
        this.usersAnswers.set(3, value);
    }

    public Boolean getUsersAnswer1() {
        return this.usersAnswers.get(0);
    }

    public Boolean getUsersAnswer2() {
        return this.usersAnswers.get(1);
    }

    public Boolean getUsersAnswer3() {
        return this.usersAnswers.get(2);
    }

    public Boolean getUsersAnswer4() {
        return this.usersAnswers.get(3);
    }
}
