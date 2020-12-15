
package com.haidar.mulchoqu.model.soal;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class SoalResult {

    @SerializedName("category")
    private String mCategory;
    @SerializedName("correct_answer")
    private String mCorrectAnswer;
    @SerializedName("difficulty")
    private String mDifficulty;
    @SerializedName("incorrect_answers")
    private List<String> mIncorrectAnswers;
    @SerializedName("question")
    private String mQuestion;
    @SerializedName("type")
    private String mType;

    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String category) {
        mCategory = category;
    }

    public String getCorrectAnswer() {
        return mCorrectAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        mCorrectAnswer = correctAnswer;
    }

    public String getDifficulty() {
        return mDifficulty;
    }

    public void setDifficulty(String difficulty) {
        mDifficulty = difficulty;
    }

    public List<String> getIncorrectAnswers() {
        return mIncorrectAnswers;
    }

    public void setIncorrectAnswers(List<String> incorrectAnswers) {
        mIncorrectAnswers = incorrectAnswers;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public void setQuestion(String question) {
        mQuestion = question;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

}
