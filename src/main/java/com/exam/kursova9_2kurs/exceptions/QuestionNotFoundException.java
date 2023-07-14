package com.exam.kursova9_2kurs.exceptions;

public class QuestionNotFoundException extends RuntimeException {
    public QuestionNotFoundException() {
    }

    public QuestionNotFoundException(String message) {
        super(message);
    }
}
