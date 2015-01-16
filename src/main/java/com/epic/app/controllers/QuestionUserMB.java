package com.epic.app.controllers;

import com.epic.app.model.Answer;
import com.epic.app.model.Question;
import com.epic.app.model.User;
import com.epic.app.model.UserAnswer;
import com.epic.app.service.QuestionService;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;


/**
 * Created by Pas8sion on 02.01.2015.
 */

@Named
@Scope("session")
public class QuestionUserMB implements Serializable {

    private static final long serialVersionUID = 34L;
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";
    //TODO replace by correct user
    private static final User DEFAULT_TEST_USER = new User();

    @Inject
    private QuestionService questionService;

    //TODO think about compare Questions
    private NavigableMap<Question,List<UserAnswer>> userAnswers = new TreeMap<Question, List<UserAnswer>>(new Comparator<Question>() {
        @Override
        public int compare(Question o1, Question o2) {
            return o1.getNumber().compareTo(o2.getNumber());
        }
    });
    private Map.Entry<Question,List<UserAnswer>> currentEntry;



    @PostConstruct
    public void init() {
        //TODO change to real list
        for (Question question : questionService.getAllQuestions()) {
            List<UserAnswer> list = new ArrayList<UserAnswer>();
            for (Answer answer : question.getAnswers()) {
                UserAnswer userAnswer = new UserAnswer();
                userAnswer.setQuestion(question);
                userAnswer.setAnswer(answer);
                userAnswer.setUser(DEFAULT_TEST_USER);
                list.add(userAnswer);
            }
            userAnswers.put(question, list);
        }
        currentEntry = userAnswers.firstEntry();
    }

    public QuestionUserMB() {
    }

    public void getNextQuestion() {

        if (currentEntry != null){
            Map.Entry entry = userAnswers.higherEntry(currentEntry.getKey());
            if (entry!= null){
                currentEntry = entry;
            }
        }
    }

    public void getPreviousQuestion() {

        if (currentEntry != null){
            Map.Entry entry = userAnswers.lowerEntry(currentEntry.getKey());
            if (entry!= null){
                currentEntry = entry;
            }
        }
    }


    public NavigableMap<Question, List<UserAnswer>> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(NavigableMap<Question, List<UserAnswer>> userAnswers) {
        this.userAnswers = userAnswers;
    }

    public Map.Entry<Question, List<UserAnswer>> getCurrentEntry() {
        return currentEntry;
    }

    public void setCurrentEntry(Map.Entry<Question, List<UserAnswer>> currentEntry) {
        this.currentEntry = currentEntry;
    }
}
