package com.exam.kursova9_2kurs.services;

import com.exam.kursova9_2kurs.dto.Question;
import com.exam.kursova9_2kurs.exceptions.MoreRequestedThanAvaliableException;
import com.exam.kursova9_2kurs.interfaces.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {

    @Mock
    QuestionService questionService;

    @InjectMocks
    ExaminerServiceImpl examinerService;

    List<Question> questions = Arrays.asList(
            new Question("Where?", "There."),
            new Question("What?", "That."),
            new Question("When?", "Than."),
            new Question("Who?")
    );

    @BeforeEach
    public void setUp() {
        Mockito.when(questionService.getAll()).thenReturn(questions);
    }

    @Test
    public void getQuestionsWorksCorrect() {
        int amountExpected = 2;

        assertTrue(questions.containsAll(examinerService.getQuestions(2)));
        assertEquals(amountExpected, examinerService.getQuestions(2).size());
        assertThrows(MoreRequestedThanAvaliableException.class, () -> examinerService.getQuestions(10));
    }
}
