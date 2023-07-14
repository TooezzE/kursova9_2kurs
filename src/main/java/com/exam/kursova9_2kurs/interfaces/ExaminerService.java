package com.exam.kursova9_2kurs.interfaces;

import com.exam.kursova9_2kurs.dto.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
