import java.util.Random;
import java.util.concurrent.Callable;

import static java.lang.Thread.sleep;

public class Osoba implements Callable {
    private Random random = new Random();

    private boolean decision() throws InterruptedException {
        sleep(random.nextInt(4)*1000);
        if(random.nextDouble() >= 0.05){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public Object call() throws Exception {
        return decision();
    }
}
