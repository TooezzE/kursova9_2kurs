package com.exam.kursova9_2kurs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class MoreRequestedThanAvaliableException extends RuntimeException {
    public MoreRequestedThanAvaliableException() {
    }

    public MoreRequestedThanAvaliableException(String message) {
        super(message);
    }
}
