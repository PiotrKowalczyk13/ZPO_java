import java.io.IOException;

public class Main {
    public static void main(String[] args)
    {
        assert Double.parseDouble(args[2]) >= 0 : "Odchylenie ujemne";

        try {
            GaussRand.writeRandNumbers(Integer.parseInt(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]),
                        "src/randomGauss");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
