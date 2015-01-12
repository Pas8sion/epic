package com.epic.app.controllers;

import com.epic.app.model.Answer;
import com.epic.app.model.Question;
import com.epic.app.service.AnswerService;
import com.epic.app.service.QuestionService;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
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

    @Inject
    private AnswerService answerService;

    private String number;
    private String content;

    private List<Question> questionsList;
    private Boolean openQuestion;

    private List<Answer> answersList = new ArrayList<Answer>();
    private String answerNumber;
    private String answerContent;
    private Boolean answerCorrect;

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

    public void addQuestion() {

        try {
            Question question = new Question();

            question.setNumber(getNumber().trim());
            question.setContent(getContent().trim());
            question.setOpenQuestion(getOpenQuestion());

            for (Answer answer : answersList) {
                answer.setQuestionOwner(question);
            }
            question.setAnswers(answersList);
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
        this.setOpenQuestion(false);
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

    public Boolean getOpenQuestion() {
        return openQuestion;
    }

    public void setOpenQuestion(Boolean openQuestion) {
        this.openQuestion = openQuestion;
    }

    public List<Answer> getAnswersList() {
        return answersList;
    }

    public void setAnswersList(List<Answer> answersList) {
        this.answersList = answersList;
    }

    public String deleteRowAnswer(Answer answer) {

        answersList.remove(answer);
        return null;
    }

    public Boolean getAnswerCorrect() {
        return answerCorrect;
    }

    public void setAnswerCorrect(Boolean answerCorrect) {
        this.answerCorrect = answerCorrect;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public String getAnswerNumber() {
        return answerNumber;
    }

    public void setAnswerNumber(String answerNumber) {
        this.answerNumber = answerNumber;
    }

    public String addAnswer() {

        Answer answer = new Answer();
        answer.setNumber(this.getAnswerNumber());
        answer.setContent(this.getAnswerContent());
        answer.setCorrectAnswer(this.getAnswerCorrect());

        answersList.add(answer);
        return null;
    }

}
