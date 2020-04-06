import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class EngTestCreate {

    static String path = "src/PolEngTest.json";
    static Gson gson = new Gson();
    private static Random random = new Random();
    static Translation[] translations = gson.fromJson(readFile(), Translation[].class);

    public static double round(double val) {
        val = val / 1000;
        val = Math.round(val * 100.0) / 100.0;
        return val;
    }

    public static ArrayList<Integer> createList(){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; ) {
            int checkExisting = random.nextInt(10);
            if (!list.contains(checkExisting)) {
                list.add(checkExisting);
                i++;
            }
        }
        return list;
    }

    public static Reader readFile(){
        Reader reader = null;
        try {
            reader = new FileReader(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reader;
    }

    public static void writeFile(String name, String surname, Answers[] answers){
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(
                    new FileWriter(name.toLowerCase() + "_" + surname.toLowerCase() + ".json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String toWrite = gson.toJson(answers);
        try {
            writer.write(toWrite);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
