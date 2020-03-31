import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import sun.security.util.Length;
import java.util.Scanner;

public class ruler {

        public static void lineDraw(int lineLength, int maxtotalLength) {
            lineDraw(lineLength, -1, maxtotalLength);
        }

        public static void lineDraw(int lineLength, int label, int maxtotalLength) {
            for (int i = 0; i < lineLength; i++){
                int x = (maxtotalLength-lineLength);
                if(i < x){
                    System.out.print(" ");
                }
                else{
                    System.out.print("-");
                }
            }
            if (label >= 0) System.out.print(" " + label);
            System.out.print("\n");
        }
        public static void lines(int lineLength, int maxtotalLength) {
            if (lineLength > 0.5*maxtotalLength) {
                lines(lineLength - 1, maxtotalLength);
                lineDraw(lineLength, maxtotalLength);
                lines(lineLength - 1, maxtotalLength);
            }
        }
        public static void drawRuler(int totalLength, int maxtotalLength) {
            maxtotalLength = maxtotalLength * 2;
            lineDraw(maxtotalLength, 0, maxtotalLength);
            for (int i = 1; i <= totalLength; i++) {
                lines(maxtotalLength - 1, maxtotalLength);
                lineDraw(maxtotalLength, i, maxtotalLength);
            }
        }

    public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int x=0, y=0;
            System.out.println("Podaj długość linijki: ");
            try{
                x = scan.nextInt();
            }
            catch (ValueException e){
                System.out.println("Niepoprawna długość, podaj liczbę całkowitą");
                System.out.println(e);

            }
            System.out.println("Podaj szerokość (połowy) linijki: ");
            try{
                y = scan.nextInt();
            }
            catch (ValueException e){
                System.out.println("Niepoprawna szerokość, podaj liczbę całkowitą");
                System.out.println(e);
                System.exit(1);
            }

            if(x < 1 || y < 1){
                System.out.println("Niepoprawne dane, wartości muszą być większe od 0");
                System.exit(2);
            }
//
            drawRuler(x, y);
    }
}
