/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import alexevan.annotations.MapToColumn;
import alexevan.annotations.MapToTable;
import alexevan.annotations.PrimaryKey;
import java.io.Serializable;

/**
 *
 * @author Alex Christian
 */
@MapToTable("FAQ")
public class FAQ implements Serializable{
    @PrimaryKey("question_id")
    @MapToColumn("question_id")
    private String questionId;
    @MapToColumn("question")
    private String question;
    @MapToColumn("answer")
    private String answer;
    @MapToColumn("search_frequency")
    private int searchFrequency;

    public FAQ() {
    }
    
    public FAQ(String questionId, String question, String answer, int searchFrequency) {
        this.questionId = questionId;
        this.question = question;
        this.answer = answer;
        this.searchFrequency = searchFrequency;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getSearchFrequency() {
        return searchFrequency;
    }

    public void setSearchFrequency(int searchFrequency) {
        this.searchFrequency = searchFrequency;
    }

    @Override
    public String toString() {
        return "FAQ{" + "questionId=" + questionId + 
                ", question=" + question + 
                ", answer=" + answer + 
                ", searchFrequency=" + searchFrequency + '}';
    }
    
}
