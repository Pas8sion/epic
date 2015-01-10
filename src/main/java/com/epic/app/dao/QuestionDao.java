package com.epic.app.dao;

import com.epic.app.model.Question;

import java.util.List;

/**
 * Created by Pas8sion on 02.01.2015.
 */
public interface QuestionDao extends BasicCrudDao<Question>{

    public Question getQuestionByNumber(String number);
    public List<Question> getAllQuestions();

    public void addQuestion(Question question);
    public void removeQuestion(Question question);

}
