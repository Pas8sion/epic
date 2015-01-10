package com.epic.app.controllers;

import com.epic.app.model.Question;
import com.epic.app.service.QuestionService;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.ListIterator;


/**
 * Created by Pas8sion on 02.01.2015.
 */

//@ManagedBean
//@SessionScoped
@Named
@Scope("session")
public class QuestionMB implements Serializable {

    private static final long serialVersionUID = 3L;
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";

    private ListIterator<Question> questionsIterator;
    private Question currentQuestion;

    @Inject
    private QuestionService questionService;

    private String number;
    private String content;

    private List<Question> questionsList;

    @PostConstruct
    public void init() {
        questionsList = questionService.getAllQuestions();
        //TODO change to real list

        questionsIterator = questionsList.listIterator();
        getNextQuestion();
    }



    public QuestionService getQuestionService() {
        return questionService;
    }

    public void addItem() {

        try {
            Question question = new Question();

            question.setNumber(getNumber().trim());
            question.setContent(getContent().trim());
            getQuestionService().addQuestion(question);
            //return SUCCESS;
            addMessage("Question added", FacesMessage.SEVERITY_INFO);
        } catch (DataAccessException e) {
            addMessage(e.getMessage(), FacesMessage.SEVERITY_ERROR);
            e.printStackTrace();
        }
        reset();
        //return ERROR;
    }

    public void addMessage(String summary, FacesMessage.Severity messageType) {
        FacesMessage message = new FacesMessage(messageType, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }


    public void reset() {
        this.setNumber("");
        this.setContent("");
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public List<Question> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List<Question> questionsList) {
        this.questionsList = questionsList;
    }

    public void getNextQuestion() {

        if (questionsIterator.hasNext()) {
            Question q = questionsIterator.next();

            if (q.equals(currentQuestion)) {
                getNextQuestion();
            } else {
                currentQuestion = q;
            }
        }

    }

    public void getPreviousQuestion() {

        if (questionsIterator.hasPrevious()) {
            Question q = questionsIterator.previous();

            if (q.equals(currentQuestion)) {
                getPreviousQuestion();
            } else {
                currentQuestion = q;
            }
        }
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }
}
