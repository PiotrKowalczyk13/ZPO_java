import java.util.Arrays;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import java.lang.String;

class sort_Methods{

    static void sortStrings(Collator collator, String[] words){
        int j;
        for (int i = 1; i < words.length; ++i){
            String key = words[i];
            j = i - 1;
            while (j >= 0 && (collator.compare(words[j], key)) == 1){
                words[j + 1] = words[j];
                j--;
            }
            words[j + 1] = key;
        }
    }

    static void fastSortStrings(Collator collator, String[] words){
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return collator.compare(o1, o2);
            }
        });
    }

    static void fastSortStrings2(Collator collator, String[] words){
        Arrays.sort(words, (a, b) -> collator.compare(a, b));
    }
}

class time_Count{
    static double getTime(int i){
        String[] names = new String[]{"Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka", "Zyta", "Órszula",
                "Świętopełk"};
        Collator collator = Collator.getInstance(new Locale("pl", "PL"));
        double final_Time = 0;

            if(i == 1){
                long start_Time = System.nanoTime();
                for(int j = 0; j < 100000; j++){
                    names = new String[]{"Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka", "Zyta", "Órszula",
                            "Świętopełk"};
                    sort_Methods.sortStrings(collator, names);
                }
                long end_Time = System.nanoTime();
                final_Time = end_Time - start_Time;
            }
            else if(i == 2){
                long start_Time = System.nanoTime();
                for(int j = 0; j < 100000; j++){
                    names = new String[]{"Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka", "Zyta", "Órszula",
                            "Świętopełk"};
                    sort_Methods.fastSortStrings(collator, names);
                }
                long end_Time = System.nanoTime();
                final_Time = end_Time - start_Time;
            }
            else if(i == 3){
                long start_Time = System.nanoTime();
                for(int j = 0; j < 100000; j++){
                    names = new String[]{"Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka", "Zyta", "Órszula",
                            "Świętopełk"};
                    sort_Methods.fastSortStrings(collator, names);
                }
                long end_Time = System.nanoTime();
                final_Time = end_Time - start_Time;
            }
            return (final_Time / 1000000000);
        }
    }

public class sorting {
    public static void main(String[] args) {

        Collator collator = Collator.getInstance(new Locale("pl", "PL"));
        System.out.println("Instertion sort:");
        String[] names = new String[]{"Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka", "Zyta", "Órszula",
                "Świętopełk"};
        sort_Methods.sortStrings(collator, names);
        System.out.println(Arrays.toString(names));

        System.out.println("Fast sort /w anonymous object:");
        names = new String[]{"Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka", "Zyta", "Órszula", "Świętopełk"};
        sort_Methods.fastSortStrings(collator, names);
        System.out.println(Arrays.toString(names));

        System.out.println("Fast sort /w lambda:");
        names = new String[]{"Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka", "Zyta", "Órszula", "Świętopełk"};
        sort_Methods.fastSortStrings2(collator, names);
        System.out.println(Arrays.toString(names));


        System.out.println("\nCzas dla insertion sort: "+time_Count.getTime(1)+"s");
        System.out.println("Czas dla fast sort z obiektem anonimowym: "+time_Count.getTime(2)+"s");
        System.out.println("Czas dla fast sort z lambda: "+time_Count.getTime(3)+"s");
    }
}
