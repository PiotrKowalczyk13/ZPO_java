import java.util.HashMap;
import java.util.Scanner;
import java.util.Arrays;

class countLev{

    static double LevQWERTY(String s1, String s2){
        HashMap<Character, String> neighbour = new HashMap<Character, String>();
        neighbour.put('q', "ww");
        neighbour.put('w', "qe");
        neighbour.put('e', "wr");
        neighbour.put('r', "et");
        neighbour.put('t', "ry");
        neighbour.put('y', "tu");
        neighbour.put('u', "yi");
        neighbour.put('i', "uo");
        neighbour.put('o', "ip");
        neighbour.put('p', "oo");
        neighbour.put('a', "ss");
        neighbour.put('s', "ad");
        neighbour.put('d', "sf");
        neighbour.put('f', "dg");
        neighbour.put('g', "fh");
        neighbour.put('h', "gj");
        neighbour.put('j', "hk");
        neighbour.put('k', "jl");
        neighbour.put('l', "kk");
        neighbour.put('z', "xx");
        neighbour.put('x', "zc");
        neighbour.put('c', "xv");
        neighbour.put('v', "cb");
        neighbour.put('b', "vn");
        neighbour.put('n', "bm");
        neighbour.put('m', "nn");

        int i, j, len1, len2;
        double cost=0;

        len1=s1.length();
        len2=s2.length();

        double array[][] = new double[len1+1][len2+1];

        for(i = 0; i <= len1; i++){
            array[i][0] = i;
        }
        for(j = 0; j <= len2; j++){
            array[0][j] = j;
        }

        for(i = 1; i < (len1 + 1); i++){
            for(j = 1; j < (len2 + 1); j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    cost = 0;
                }
                else{
                    if(s1.charAt(i-1) == neighbour.get(s2.charAt(j-1)).charAt(0) ||
                          s1.charAt(i-1) == neighbour.get(s2.charAt(j-1)).charAt(1)){
                        cost = 0.5;
                     }
                    else{
                        cost = 1;
                    }
                }
                array[i][j] = Math.min(Math.min(array[i-1][j]+1, array[i][j-1]+1), array[i-1][j-1]+cost);
            }
        }

        return array[i-1][j-1];
    }

    static boolean validate(String str){

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) < 'a' || str.charAt(i) > 'z'){
                return false;
            }
        }

        return true;
    }
}

public class Levenshtein {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj pierwszy wyraz: ");
        String s1 = scan.nextLine();
        if(!countLev.validate(s1)){
            System.out.println("Incorrect value for first word");
            System.exit(1);
        }

        System.out.println("Podaj drugi wyraz: ");
        String s2 = scan.nextLine();
        if(!countLev.validate(s2)){
            System.out.println("Incorrect value for second word");
            System.exit(2);
        }
        System.out.println("Długość Levenshteina wynosi "+countLev.LevQWERTY(s1, s2));
    }
}
