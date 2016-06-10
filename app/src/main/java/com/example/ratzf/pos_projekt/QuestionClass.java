package com.example.ratzf.pos_projekt;

/**
 * Created by preiter on 09.06.2016.
 */
public class QuestionClass {
    String question, wrongAnswer1, wrongAnswer2, wrongAnswer3, rightAnswer;

    public QuestionClass(String question, String wrongAnswer1, String wrongAnswer2, String wrongAnswer3, String rightAnswer) {
        this.question = question;
        this.wrongAnswer1 = wrongAnswer1;
        this.wrongAnswer2 = wrongAnswer2;
        this.wrongAnswer3 = wrongAnswer3;
        this.rightAnswer = rightAnswer;
    }

    public String getWrongAnswer1() {
        return wrongAnswer1;
    }

    public String getWrongAnswer2() {
        return wrongAnswer2;
    }

    public String getWrongAnswer3() {
        return wrongAnswer3;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setWrongAnswer1(String wrongAnswer1) {
        this.wrongAnswer1 = wrongAnswer1;
    }

    public void setWrongAnswer2(String wrongAnswer2) {
        this.wrongAnswer2 = wrongAnswer2;
    }

    public void setWrongAnswer3(String wrongAnswer3) {
        this.wrongAnswer3 = wrongAnswer3;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
