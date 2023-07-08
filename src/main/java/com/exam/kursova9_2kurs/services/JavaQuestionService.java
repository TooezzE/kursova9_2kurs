package com.exam.kursova9_2kurs.services;

import com.exam.kursova9_2kurs.dto.Question;
import com.exam.kursova9_2kurs.exceptions.QuestionAlreadyAddedException;
import com.exam.kursova9_2kurs.exceptions.QuestionNotFoundException;
import com.exam.kursova9_2kurs.interfaces.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private List<Question> questions = new ArrayList<>();

    @Override
    public Question add(String question, String answer){
        Question newQuestion = new Question(question, answer);
        if(questions.contains(newQuestion)){
            throw new QuestionAlreadyAddedException();
        }
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(String question){
        Question newQuestion = new Question(question);
        if(questions.contains(newQuestion)){
            throw new QuestionAlreadyAddedException();
        }
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question remove(Question question){
        if(questions.contains(question)){
            questions.remove(question);
        } else {
            throw new QuestionNotFoundException();
        }
        return question;
    }

    @Override
    public Question find(String question){
        for (Question value : questions) {
            if (value.getQuestion().equals(question)) {
                return value;
            }
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public List<Question> getAll(){
        return Collections.unmodifiableList(questions);
    }

    @Override
    public Question getRandomQuestion(){
        Random randomNum = new Random();
        return getAll().get(randomNum.nextInt(questions.size() - 1));
    }
}
