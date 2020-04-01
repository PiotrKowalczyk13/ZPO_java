import java.util.Scanner;

public class convert {
    static void szesnastkowy(int liczba){
        try{
            System.out.print(Integer.toString(liczba,16));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    static void dziesietny(int liczba){
        try{
            System.out.print(Integer.toString(liczba,10));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    static void trojkowy(int liczba){
        try{
            System.out.print(Integer.toString(liczba,3));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args){
        int liczba = 0b1101_1000;

        System.out.println(liczba);
        System.out.print("Wybierz rodzaj konwersji, wpisując: szesnastkowy, dziesiętny lub trójkowy\n");

        Scanner scan = new Scanner(System.in);
        String conv_val = scan.nextLine();

        if(conv_val.equals("szesnastkowy")){
            szesnastkowy(liczba);
        }
        else if (conv_val.equals("dziesiętny")){
            dziesietny(liczba);
        }
        else if (conv_val.equals("trójkowy")){
            trojkowy(liczba);
        }
        else{
            System.out.print("Niewłaściwe dane");
        }
    }
}
