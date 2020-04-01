import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import sun.security.util.Length;

import java.util.HashMap;
import java.lang.*;
import java.util.Scanner;

class change{

    static boolean isNumeric(String strNum){
        if (strNum == null) {
            return false;
        }
        try{
            double d = Double.parseDouble(strNum);
        }
        catch (NumberFormatException nfe){
            return false;
        }
        return true;
    }

    static StringBuffer to_Words(String val){

        HashMap<Character, String> numbers = new HashMap<Character, String>();
        numbers.put('0', "zero");
        numbers.put('1', "jeden");
        numbers.put('2', "dwa");
        numbers.put('3', "trzy");
        numbers.put('4', "cztery");
        numbers.put('5', "pięć");
        numbers.put('6', "sześć");
        numbers.put('7', "siedem");
        numbers.put('8', "osiem");
        numbers.put('9', "dziewięć");
        numbers.put('-', "minus");

        StringBuffer str = new StringBuffer();

        if((val.length() > 3 && val.charAt(0) != '-') || val.length()>4){
            throw new ValueException("Value too long");
        }

        if(!isNumeric(val)){
            throw new NumberFormatException("Incorrect format");
        }

        int len=val.length();

        for(int i=0; i<len; i++){
            str.append(numbers.get(val.charAt(i)));
            str.append(' ');
        }

        return str;
    }
}

public class dictionary {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj trzycyfrową liczbę: ");
        String val = scan.nextLine();

        if(change.to_Words(val)==null){
            System.out.println("Incorrect input");
            System.exit(-1);
        }
        System.out.print(val+" -> ");

        System.out.println(change.to_Words(val));
    }
}