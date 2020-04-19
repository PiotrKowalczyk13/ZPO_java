import java.util.Random;
import java.util.concurrent.Callable;

public class Widz implements Callable {
    private Random random = new Random();

    private boolean decision(){
        if(random.nextDouble() >= 0.3){
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
