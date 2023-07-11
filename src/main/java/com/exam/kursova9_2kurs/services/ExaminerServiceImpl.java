package com.exam.kursova9_2kurs.services;

import com.exam.kursova9_2kurs.exceptions.MoreRequestedThanAvaliableException;
import com.exam.kursova9_2kurs.dto.Question;
import com.exam.kursova9_2kurs.interfaces.ExaminerService;
import com.exam.kursova9_2kurs.interfaces.QuestionService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
@SessionScope
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if(amount > questionService.getAll().size()){
            throw new MoreRequestedThanAvaliableException();
        }
        Set<Question> examQuestions = new HashSet<>();
        while (examQuestions.size() < amount){
            examQuestions.add(questionService.getRandomQuestion());
        }
        return Collections.unmodifiableCollection(examQuestions);
    }

}
