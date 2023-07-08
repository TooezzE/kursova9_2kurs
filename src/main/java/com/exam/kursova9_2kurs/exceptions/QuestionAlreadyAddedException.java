package com.exam.kursova9_2kurs.exceptions;

public class QuestionAlreadyAddedException extends RuntimeException {
    public QuestionAlreadyAddedException() {
    }

    public QuestionAlreadyAddedException(String message) {
        super(message);
    }
}
