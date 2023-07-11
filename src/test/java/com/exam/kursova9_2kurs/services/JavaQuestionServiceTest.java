package com.exam.kursova9_2kurs.services;

import com.exam.kursova9_2kurs.dto.Question;
import com.exam.kursova9_2kurs.exceptions.QuestionAlreadyAddedException;
import com.exam.kursova9_2kurs.exceptions.QuestionNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {

    private JavaQuestionService javaQuestionService;

    @BeforeEach
    public void setUp() {
        javaQuestionService = new JavaQuestionService();
        javaQuestionService.add("When?", "Than.");
        javaQuestionService.add("What?", "That.");
    }

    @Test
    public void addingNewQuestionWorksCorrect() {
        javaQuestionService.add("Where?", "There.");
        javaQuestionService.add("Who?");
        Question question = new Question("Where?", "There.");
        Question question1 = new Question("Who?");

        assertTrue(javaQuestionService.getAll().contains(question));
        assertTrue(javaQuestionService.getAll().contains(question1));
        assertThrows(QuestionAlreadyAddedException.class, () -> javaQuestionService.add("Where?", "There."));
        assertThrows(QuestionAlreadyAddedException.class, () -> javaQuestionService.add("Who?"));
    }

    @Test
    public void removingQuestionWorksCorrect(){
        Question question1 = new Question("When?", "Than.");
        Question question2 = new Question("What?", "That.");
        Question question3 = new Question("Where?", "There.");
        javaQuestionService.remove(question1);

        assertFalse(javaQuestionService.getAll().contains(question1));
        assertTrue(javaQuestionService.getAll().contains(question2));
        assertThrows(QuestionNotFoundException.class, () -> javaQuestionService.remove(question3));
    }

    @Test
    public void findingQuestionWorksCorrect() {
        Question expected = new Question("When?", "Than.");

        assertEquals(expected, javaQuestionService.find("When?"));
        assertThrows(QuestionNotFoundException.class, () -> javaQuestionService.find("Where?"));
    }

    @Test
    public void getRandomQuestionWorksCorrect() {
        assertEquals(Question.class, javaQuestionService.getRandomQuestion().getClass());
        assertTrue(javaQuestionService.getAll().contains(javaQuestionService.getRandomQuestion()));
    }
}
