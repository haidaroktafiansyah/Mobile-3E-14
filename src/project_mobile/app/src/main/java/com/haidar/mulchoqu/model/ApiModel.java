package com.haidar.mulchoqu.model;

import java.util.List;

public class ApiModel {

    private List<data_pertanyaan> data_pertanyaan;

    public List<ApiModel.data_pertanyaan> getData_pertanyaan() {
        return data_pertanyaan;
    }

    public void setData_pertanyaan(List<ApiModel.data_pertanyaan> data_pertanyaan) {
        this.data_pertanyaan = data_pertanyaan;
    }

    public class data_pertanyaan{
        private String question;
        private String correct_answer;
        private String incorrect_answer;

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public String getCorrect_answer() {
            return correct_answer;
        }

        public void setCorrect_answer(String correct_answer) {
            this.correct_answer = correct_answer;
        }

        public String getIncorrect_answer() {
            return incorrect_answer;
        }

        public void setIncorrect_answer(String incorrect_answer) {
            this.incorrect_answer = incorrect_answer;
        }
    }
}
