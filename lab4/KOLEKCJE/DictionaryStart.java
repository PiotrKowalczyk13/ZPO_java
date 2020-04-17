import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class DictionaryStart {

    public void dictionaryStart() {

        List<String> dictionary = null;
        ArrayList<String> words = new ArrayList<>();
        try {
            dictionary = Files.lines(Paths.get("src/1500.txt")).
                    collect(Collectors.toCollection(LinkedList::new));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        int days;

        for (int i = 0; i < 10 ;i++){
            if(i <= 2){
                System.out.println("Day "+(i+1));
                System.out.println("New words:      " + AddRemoveWords.addWords(words, dictionary));
                System.out.println("Forgotten words:        ---");
                System.out.println("["+words+"]");
                System.out.println();
            }
            else{
                System.out.println("Day "+(i+1));
                System.out.println("New words:      " + AddRemoveWords.addWords(words, dictionary));
                System.out.println("Forgotten words:        " + AddRemoveWords.removeWords(words, dictionary));
                System.out.println("["+words+"]");
                System.out.println();
            }


        }
    }
}
