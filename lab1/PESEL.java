import java.util.Scanner;
import java.lang.String;

public class PESEL {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj PESEL: ");
        String pesel_val = scan.nextLine();

        int check = Data.validate(pesel_val);
        if(check == 1){
            System.out.println("Incorrect length");
            System.exit(1);
        }
        else if (check == 2){
            System.out.println("Incorrect characters");
            System.exit(2);
        }
        else if (check == 3){
            System.out.println("Control sum error");
            System.exit(3);
        }

        if(Data.date(pesel_val).equals("-1")){
            System.out.println("Incorrect date");
            System.exit(4);
        }
        else{
            System.out.println("Data urodzenia: "+Data.date(pesel_val));
        }

        System.out.println("Płeć: "+Data.sex(pesel_val));
    }
}

class Data{

    static boolean isNumeric(String strNum){
        if (strNum == null) {
            return false;
        }
        try{
            double check = Double.parseDouble(strNum);
        }
        catch (NumberFormatException nfe){
            return false;
        }
        return true;
    }

    static int control_val(String str){
        if(str == null){
            return -1;
        }
                    int sum = 9*(str.charAt(0) - '0') + 7*(str.charAt(1) - '0') + 3*(str.charAt(2) - '0') + 1*(str.charAt(3) - '0')
                            + 9*(str.charAt(4) - '0') + 7*(str.charAt(5) - '0') + 3*(str.charAt(6) - '0') + 1*(str.charAt(7) - '0')
                            + 9*(str.charAt(8) - '0') + 7*(str.charAt(9) - '0');

        sum = sum % 10;

        return sum;
    }

    static int validate(String pesel_val) {
        if (pesel_val.length() != 11) {
            return (1);
        }

        if (isNumeric(pesel_val) == false) {
            return (2);
        }

        if (control_val(pesel_val) != (pesel_val.charAt(10) - '0')) {
            return (3);
        }
        return 0;
    }

    static String date(String pesel_val){

        String str;
        int year;

        if((pesel_val.charAt(2)-'0') == 2 || (pesel_val.charAt(2)-'0') == 3){
            year = 2000 + (pesel_val.charAt(0)-'0')*10 + (pesel_val.charAt(1)-'0');
            //System.out.println(year);
        }
        else if((pesel_val.charAt(2)-'0') == 4 || (pesel_val.charAt(2)-'0') == 5){
            year = 2100 + (pesel_val.charAt(0)-'0')*10 + (pesel_val.charAt(1)-'0');
            //System.out.println(year);
        }
        else if((pesel_val.charAt(2)-'0') == 6 || (pesel_val.charAt(2)-'0') == 7){
            year = 2200 + (pesel_val.charAt(0)-'0')*10 + (pesel_val.charAt(1)-'0');
            //System.out.println(year);
        }
        else if((pesel_val.charAt(2)-'0') == 8 || (pesel_val.charAt(2)-'0') == 9){
            year = 1800 + (pesel_val.charAt(0)-'0')*10 + (pesel_val.charAt(1)-'0');
            //System.out.println(year);
        }
        else {
            year = 1900 + (pesel_val.charAt(0) - '0') * 10 + (pesel_val.charAt(1) - '0');
            //System.out.println(year);
        }

        int month;

        if(year >= 1800 && year <= 1899) {
            month = (pesel_val.charAt(2) - '0' - 8) * 10 + (pesel_val.charAt(3) - '0');
        }
        else if ((year >= 2000 && year <= 2099)){
            month = (pesel_val.charAt(2) - '0' - 2) * 10 + (pesel_val.charAt(3) - '0');
        }
        else if ((year >= 2100 && year <= 2199)){
            month = (pesel_val.charAt(2) - '0' - 4) * 10 + (pesel_val.charAt(3) - '0');
        }
        else if ((year >= 2200 && year <= 2299)){
            month = (pesel_val.charAt(2) - '0' - 6) * 10 + (pesel_val.charAt(3) - '0');
        }
        else {
            month = (pesel_val.charAt(2) - '0') * 10 + (pesel_val.charAt(3) - '0');
        }

        int day = (pesel_val.charAt(4) - '0') * 10 + (pesel_val.charAt(5) - '0');

        if(day > 31 || (day > 30 && (month == 4 || month == 6 || month == 9 || month == 11)) ||
                (month == 2 && (((year % 4) != 0 && day > 28) || ((year % 4) == 0 && day > 29))) ||
                day < 1 || month < 1 || month > 12){
            str = String.format("-1");
            return str;
        }

        if(month<10){
            str = String.format("%d.0%d.%d", day, month, year);
        }
        else{
            str = String.format("%d.%d.%d", day, month, year);
        }
        return str;
    }

    static String sex(String pesel_val){
        if((pesel_val.charAt(9)-'0') % 2 == 1){
            return "Mężczyzna";
        }
        else{
            return "Kobieta";
        }
    }
}