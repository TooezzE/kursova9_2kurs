package com.exam.kursova9_2kurs.interfaces;

import com.exam.kursova9_2kurs.dto.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer);

    Question add(String question);

    Question remove(Question question);
    Question find(String question);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
