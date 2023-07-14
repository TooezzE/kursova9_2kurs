package com.exam.kursova9_2kurs.controllers;

import com.exam.kursova9_2kurs.dto.Question;
import com.exam.kursova9_2kurs.exceptions.QuestionAlreadyAddedException;
import com.exam.kursova9_2kurs.exceptions.QuestionNotFoundException;
import com.exam.kursova9_2kurs.services.JavaQuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/add")
    public String add(@RequestParam("question") String question,
                      @RequestParam("answer") String answer){
        try{
            if(answer == null){
                return "Added " + javaQuestionService.add(question).toString();
            }
            return "Added " + javaQuestionService.add(question, answer).toString();
        } catch (QuestionAlreadyAddedException e){
            return "Question already added :^)";
        }
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("question") String question,
                         @RequestParam("answer") String answer){
        try{
            if(answer == null){
                return "Removed " + javaQuestionService.remove(new Question(question)).toString();
            }
            return "Removed " + javaQuestionService.remove(new Question(question, answer)).toString();
        } catch (QuestionNotFoundException e){
            return "Question not found in exam list :^(";
        }
    }

    @GetMapping("/find")
    public String find(@RequestParam("question") String question){
        try{
            return javaQuestionService.find(question).toString();
        } catch (QuestionNotFoundException e){
            return "Question not found in exam list :^(";
        }
    }

    @GetMapping
    public String getAll(){
        return javaQuestionService.getAll().toString();
    }
}
