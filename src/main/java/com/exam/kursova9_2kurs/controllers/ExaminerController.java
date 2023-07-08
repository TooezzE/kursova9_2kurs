package com.exam.kursova9_2kurs.controllers;

import com.exam.kursova9_2kurs.exceptions.MoreRequestedThanAvaliableException;
import com.exam.kursova9_2kurs.interfaces.ExaminerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exam")
public class ExaminerController {
    private final ExaminerService examinerService;

    public ExaminerController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @RequestMapping(value = "/get/{amount}", method = RequestMethod.GET)
    public String getQuestions(@PathVariable String amount){
        try{
            return examinerService.getQuestions(Integer.parseInt(amount)).toString();
        } catch (MoreRequestedThanAvaliableException e){
            return "Something went wrong :^)";
        }
    }
}
