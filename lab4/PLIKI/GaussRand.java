import java.io.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;

public class GaussRand {

    private static boolean EOF;

    public static ArrayList getRandomGauss(ArrayList numbers, double average, double dev, int n){

        Random random = new Random();
        for(int i = 0; i < n; i++)
        {
            numbers.add(random.nextGaussian()*dev+average);
        }

        return numbers;
    }

    public static void writeRandNumbers(int n, double average, double dev, String path) throws IOException
    {
        ArrayList<Double> numbers = new ArrayList<>();

        getRandomGauss(numbers, average, dev, n);

        DataOutputStream binWrite = new DataOutputStream(new FileOutputStream(path+".bin"));

        for(int i = 0; i < n; ++i)
        {
            binWrite.writeDouble(numbers.get(i));
        }
        binWrite.close();

        NumberFormat numberFormat = NumberFormat.getNumberInstance();

        DataInputStream binRead = new DataInputStream(new FileInputStream(path+".bin"));
        FileWriter txtWrite = new FileWriter(path+"TXT.txt");
        while(!EOF)
            try
            {
                txtWrite.write(numberFormat.format(binRead.readDouble()) + "\n");
            }
            catch (IOException endOfFile)
            {
                EOF = true;
            }
        binRead.close();
        txtWrite.flush();
    }
}
