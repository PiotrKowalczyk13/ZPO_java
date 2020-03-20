import org.junit.jupiter.api.DynamicTest;

import static org.junit.jupiter.api.Assertions.*;

class LevenshteinTest {
    @org.junit.jupiter.api.Test
    void LevQwerty(){
        assertEquals(1.5, countLev.LevQWERTY("kot", "kita"));
        assertEquals(2.0, countLev.LevQWERTY("drab", "dal"));
        assertEquals(1.0, countLev.LevQWERTY("kij", "pij"));
    }
}