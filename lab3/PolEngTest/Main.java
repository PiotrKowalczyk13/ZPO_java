import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

import java.util.Scanner;

public class Main {
    static JFXPanel jfxPanel = new JFXPanel();

    public static void main(String[] args) {
        EngTest engTest = new EngTest();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Imie: ");
        String name = scanner.nextLine();
        System.out.print("Nazwisko: ");
        String surname = scanner.nextLine();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                EngTest.startTest(name, surname);
                Platform.exit();
            }
        });

    }
}
