import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            StreamData.printData("src/dane.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
