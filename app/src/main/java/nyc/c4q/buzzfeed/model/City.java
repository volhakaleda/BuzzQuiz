package nyc.c4q.buzzfeed.model;

import android.support.annotation.DrawableRes;

public class City {

    private String question;
    @DrawableRes
    private int option1;
    @DrawableRes
    private int option2;

    public City(String question, @DrawableRes int option1, @DrawableRes int option2) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
    }

    public String getQuestion() {
        return question;
    }
    @DrawableRes
    public int getOption1() {
        return option1;
    }
    @DrawableRes
    public int getOption2() {
        return option2;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOption1(int option1) {
        this.option1 = option1;
    }

    public void setOption2(int option2) {
        this.option2 = option2;
    }
}
