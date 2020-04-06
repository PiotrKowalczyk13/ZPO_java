import com.sun.deploy.config.JfxRuntime;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class EngTest extends Application {
    static EngTestCreate engTestCreate = new EngTestCreate();
    static Scanner scanner = new Scanner(System.in);
    static Answers[] answers = new Answers[5];

    public static void startTest(String name, String surname){
        double time = System.currentTimeMillis();
        ArrayList<Integer> list = EngTestCreate.createList();
        double pts = 0;
        int j = 0;
        TextInputDialog dialog = new TextInputDialog("");
        String userAnswer = "";
        for (int index : list) {
            dialog.setTitle("\nPytanie "+(j+1));
            String question = EngTestCreate.translations[index].getOriginal();
            dialog.setHeaderText(question);
            dialog.setContentText("Odpowiedź: ");

            String[] answer = EngTestCreate.translations[index].getAnswer();
            Optional<String> userAnswerDialog = dialog.showAndWait();
            if(userAnswerDialog.isPresent()) {
                userAnswer = userAnswerDialog.get();
                pts += Translation.compareAnswers(userAnswer, answer);
            }

            answers[j] = new Answers(question, userAnswer);
            j++;
        }
        double time_total = System.currentTimeMillis() - time;
        System.out.println("Punkty: " + pts);
        System.out.println("Czas: " + EngTestCreate.round(time_total) + "s");
        EngTestCreate.writeFile(name, surname, answers);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    }
}
