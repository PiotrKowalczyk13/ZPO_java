import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AddRemoveWords {

    private static Random random = new Random();

    public static StringBuilder addWords(ArrayList<String> words, List<String> dictionary){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < 2; i++){
            String wordTemp = dictionary.get(random.nextInt(dictionary.size()));
            words.add(wordTemp);
            dictionary.remove(wordTemp);
            stringBuilder.append(wordTemp);
            stringBuilder.append(" ");
        }
        return stringBuilder;
    }

    public static StringBuilder removeWords(ArrayList<String> words, List<String> dictionary){
        StringBuilder stringBuilder = new StringBuilder();
        int days = 3;
        double probability = 0.5;
        for (int i = 0; i < 2; i++){
            if (random.nextDouble() >= probability){
                String wordTemp = words.get(new Random().nextInt(words.size()-days*2));
                words.remove(wordTemp);
                dictionary.add(wordTemp);
                stringBuilder.append(wordTemp);
                stringBuilder.append(" ");
            }
        }
        if(stringBuilder.length() == 0){
            stringBuilder.append("---");
        }
        return stringBuilder;
    }
}
