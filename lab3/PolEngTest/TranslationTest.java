import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TranslationTest {

    @Test
    void compareAnswers() {
            String[] answers = new String[3];
            answers[0] = "cry";
            answers[1] = "shout";
            answers[2] = "scream";
            String user_answer = new String();
            user_answer = "sout";
            assertEquals(0.5, Translation.compareAnswers(user_answer, answers));
    }

    @Test
    void compareAnswers2() {
        String[] answers = new String[3];
        answers[0] = "cry";
        answers[1] = "shout";
        answers[2] = "scream";
        String user_answer = new String();
        user_answer = "shout";
        assertEquals(1, Translation.compareAnswers(user_answer, answers));
    }

    @Test
    void compareAnswers3() {
        String[] answers = new String[3];
        answers[0] = "cry";
        answers[1] = "shout";
        answers[2] = "scream";
        String user_answer = new String();
        user_answer = "souter";
        assertEquals(0, Translation.compareAnswers(user_answer, answers));
    }
}