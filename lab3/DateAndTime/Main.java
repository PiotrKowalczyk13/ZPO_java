import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.util.Objects.isNull;

public class Main {
    public static void main(String[] args) {
        LocalDate beginDate = LocalDate.of(1939, 9, 1);
        LocalDate endDate = LocalDate.of(1945, 5, 8);
        System.out.println("Druga Wojna Światowa trwała "+daysBetween(endDate,beginDate)+" dni");
        System.out.println("Dzień/Miesiąc: "+getMonthAndDay(68, 2016));
        LocalTime beginTime = LocalTime.of(11,45);
        LocalTime endTime = LocalTime.of(22,30);
        System.out.println("Ilość razy, kiedy suma cyfr w godzinie była równa 15: "+getSumOfDigits(beginTime, endTime, 15));
        LocalDate birthDate = LocalDate.of(1995, 12, 13);
        System.out.println("Ilość przeżytych 29.02: "+getAmountOfDays(birthDate));

    }

    static long daysBetween(LocalDate initialDate, LocalDate finalDate)  {

        if(isNull(initialDate) | isNull(finalDate)){
            return -1;
        }
        return Math.abs(DAYS.between(initialDate, finalDate)) + 1;
    }

    static String getMonthAndDay(int day, int year){

        LocalDate date =  LocalDate.ofYearDay(year,day);

        int dayGet = date.getDayOfMonth();
        int monthGet = date.getMonthValue();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM");
        return formatter.format(date);
    }

    static int getSumInHour(LocalTime time){
        int hour = time.getHour();
        int min = time.getMinute();

        int sum = hour/10 + hour%10 + min/10 + min%10;

        return sum;
    }

    static int getSumOfDigits(LocalTime beginTime, LocalTime endTime, int value){
        int sum = 0;
        for(LocalTime tempTime = beginTime; !tempTime.isAfter(endTime); tempTime = tempTime.plusMinutes(1)){
            if(getSumInHour(tempTime) == value){
                sum++;
            }
        }
        return sum;
    }

    static int getAmountOfDays(LocalDate birthDate){
        int sum = 0;
        for(LocalDate tempDate = birthDate; !tempDate.isAfter(LocalDate.now()); tempDate = tempDate.plusDays(1)){
            if(tempDate.getMonth() == Month.FEBRUARY && tempDate.getDayOfMonth() == 29){
                sum++;
            }
        }
        return sum;
    }
}
