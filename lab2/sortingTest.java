import org.junit.jupiter.api.Test;
import java.text.Collator;
import java.util.Locale;
import static org.junit.jupiter.api.Assertions.*;

class sortingTest {
    @Test
    void sortStrings(){
        Collator collator = Collator.getInstance(new Locale("pl", "PL"));
        String[] names = new String[]{"Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka", "Zyta", "Órszula",
                "Świętopełk"};
        String[] names_sorted = new String[]{"Agnieszka", "Darek", "Łukasz", "Órszula", "Stefania", "Ścibor",
                "Świętopełk", "Zyta"};
        sort_Methods.sortStrings(collator, names);
        assertArrayEquals(names_sorted, names);
    }

    @Test
    void fastSortStrings() {
        Collator collator = Collator.getInstance(new Locale("pl", "PL"));
        String[] names = new String[]{"Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka", "Zyta", "Órszula",
                "Świętopełk"};
        String[] names_sorted = new String[]{"Agnieszka", "Darek", "Łukasz", "Órszula", "Stefania", "Ścibor",
                "Świętopełk", "Zyta"};
        sort_Methods.fastSortStrings(collator, names);
        assertArrayEquals(names_sorted, names);
    }

    @Test
    void fastSortStrings2() {
        Collator collator = Collator.getInstance(new Locale("pl", "PL"));
        String[] names = new String[]{"Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka", "Zyta", "Órszula",
                "Świętopełk"};
        String[] names_sorted = new String[]{"Agnieszka", "Darek", "Łukasz", "Órszula", "Stefania", "Ścibor",
                "Świętopełk", "Zyta"};
        sort_Methods.fastSortStrings2(collator, names);
        assertArrayEquals(names_sorted, names);
    }
}
