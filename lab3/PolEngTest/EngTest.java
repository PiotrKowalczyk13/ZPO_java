import java.util.ArrayList;
import java.util.Scanner;

public class EngTest {
    static EngTestCreate engTestCreate = new EngTestCreate();
    static Scanner scanner = new Scanner(System.in);
    static Answers[] answers = new Answers[5];

    public static void startTest(String name, String surname){
        double time = System.currentTimeMillis();
        String user_answer = "";
        ArrayList<Integer> list = EngTestCreate.createList();
        double pts = 0;
        int j = 0;
        for (int index : list) {
            String question = EngTestCreate.translations[index].getOriginal();
            System.out.println(question);

            String[] answer = EngTestCreate.translations[index].getAnswer();
            user_answer = scanner.nextLine();
            pts += Translation.compareAnswers(user_answer, answer);

            answers[j] = new Answers(question, user_answer);
            j++;
        }
        double time_total = System.currentTimeMillis() - time;
        System.out.println("Punkty: " + pts);
        System.out.println("Czas: " + EngTestCreate.round(time_total) + "s");
        EngTestCreate.writeFile(name, surname, answers);
    }
}
