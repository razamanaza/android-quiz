package gorda5.bti.famouspaintingsquest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionTest {
    public Question question;

    @Before
    public void setUp() throws Exception {
        question = new Question("mao", "Andy Warhol", "Some clever text");
    }

    @Test
    public void getQuestionTest() {
        assertEquals("mao", question.getQuestion());
    }

    @Test
    public void getAnswer1Test() {
        question.setAnswer1("Andy Warhol");
        assertEquals("Andy Warhol", question.getAnswer1());
    }

    @Test
    public void getAnswer2Test() {
        question.setAnswer2("Andy Warhol");
        assertEquals("Andy Warhol", question.getAnswer2());
    }

    @Test
    public void getAnswer3() {
        question.setAnswer3("Andy Warhol");
        assertEquals("Andy Warhol", question.getAnswer3());
    }

    @Test
    public void getAnswer4() {
        question.setAnswer4("Andy Warhol");
        assertEquals("Andy Warhol", question.getAnswer4());
    }

    @Test
    public void getCorrectIdTest() {
        question.setCorrectId(1);
        assertEquals("answer2", question.getCorrectId());
    }

    @Test
    public void getCorrectTextTest() {
        assertEquals("Some clever text", question.getCorrectText());
    }

    @Test
    public void setQuestionTest() {
        question.setQuestion("bla-bla");
        assertEquals("bla-bla", question.getQuestion());
    }

    @Test
    public void setAnswer1Test() {
        question.setAnswer1("Andy Warhol");
        assertEquals("Andy Warhol", question.getAnswer1());
    }

    @Test
    public void setAnswer2Test() {
        question.setAnswer2("Andy Warhol");
        assertEquals("Andy Warhol", question.getAnswer2());
    }

    @Test
    public void setAnswer3Test() {
        question.setAnswer3("Andy Warhol");
        assertEquals("Andy Warhol", question.getAnswer3());
    }

    @Test
    public void setAnswer4Test() {
        question.setAnswer4("Andy Warhol");
        assertEquals("Andy Warhol", question.getAnswer4());
    }

    @Test
    public void setCorrectIdTest() {
        question.setCorrectId(1);
        assertEquals("answer2", question.getCorrectId());
    }

    @Test
    public void setCorrectTextTest() {
        question.setCorrectText("Some other text");
        assertEquals("Some other text", question.getCorrectText());
    }

    @Test
    public void toString1Test() {
        question.setAnswer1("Andy Warhol");
        question.setAnswer2("Giuseppe Arcimboldo");
        question.setAnswer3("Kazimir Malevich");
        question.setAnswer4("Bill Hammond");
        question.setCorrectId(0);
        assertEquals("Question{question='mao', answer1='Andy Warhol', answer2='Giuseppe Arcimboldo', answer3='Kazimir Malevich', answer4='Bill Hammond', correctId=0, correctText='Some clever text'}", question.toString());
    }

    @Test
    public void getAnswer() {
    }
}