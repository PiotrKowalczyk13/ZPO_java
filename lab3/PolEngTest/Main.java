import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        EngTest engTest = new EngTest();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Imie: ");
        String name = scanner.nextLine();
        System.out.println("Nazwisko: ");
        String surname = scanner.nextLine();
        EngTest.startTest(name, surname);
    }
}
