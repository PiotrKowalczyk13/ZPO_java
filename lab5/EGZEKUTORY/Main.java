import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class Main {

    static int findViewers(int people) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(people);
        List<Callable<Boolean>> createPeople = new ArrayList<>();
        for(int i = 0; i < people; i++){
            Osoba person = new Osoba();
            createPeople.add(person);
        }
        List<Future<Boolean>> decision = executorService.invokeAll(createPeople);
        executorService.shutdownNow();

        int countViewers = 0;
        for(Future<Boolean> temp : decision){
            if (temp.get()){
                countViewers++;
            }
        }
        return countViewers;
    }

    static int peopleBored(int people) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(people);
        List<Callable<Boolean>> createPeople = new ArrayList<>();
        for(int i = 0; i < people; i++){
            Widz person = new Widz();
            createPeople.add(person);
        }
        List<Future<Boolean>>decision = executorService.invokeAll(createPeople);
        executorService.shutdownNow();

        int countLeavers = 0;
        for(Future<Boolean> temp : decision){
            if (temp.get()){
                countLeavers++;
            }
        }
        return countLeavers;
    }

    static void movieTimer(){
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int people = 100;
        System.out.println("Ludzie zastanawiają się...");
        int countViewers = 0;
        countViewers = findViewers(people);

        System.out.println("Liczba ludzi, która zdecydowała się obejrzeć film: "+countViewers);
        movieTimer();
        if(countViewers < 5) {
            System.out.println("Przepraszamy, filmu nie będzie.");
            System.exit(0);
        }

        System.out.println("Pierwsza połowa filmu w toku");
        movieTimer();
        System.out.println("Koniec pierwszej połowy filmu");

        int leavers = 0;
        leavers = peopleBored(countViewers);


        System.out.println("Liczba ludzi opuszczających seans: "+leavers);
        movieTimer();
        if(countViewers-leavers < 5){
            System.out.println("Koniec seansu frajerzy, zwrótów nie będzie!");
            System.exit(0);
        }
        movieTimer();
        System.out.println("Koniec seansu, dziękujemy za oglądanie.");
    }
}
