import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import static org.junit.jupiter.api.Assertions.*;

class EngTestTest {

    @Test
    void StartTest() {
        double pts = 0;
        Reader reader = null;
        try {
            reader = new FileReader("src/PolEngTest.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        Translation[] translations = gson.fromJson(reader, Translation[].class);
        for(int i = 0; i < 5; i++){
            String[] question = translations[i].getAnswer();
            String answer = new String();
            if(i == 0){
                answer = "shout";
            }
            else if(i == 1){
                answer = "phon";
            }
            else if(i == 2){
                answer = "residence";
            }
            else if(i == 3){
                answer = "man";
            }
            else if(i == 4){
                answer = "key";
            }
            pts += Translation.compareAnswers(answer, question);
        }
        System.out.println(pts);

        assertEquals(3.5,pts);
    }
}