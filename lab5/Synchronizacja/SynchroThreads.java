import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;

public class SynchroThreads
{
    public void createThreads()
    {
        String[] strings = new String[]{"aaaa", "bb", "ccccccccccccc", "dddddd"};
        ExecutorService executorService = Executors.newFixedThreadPool(strings.length);
        LockCreate lock = new LockCreate();
        for(int i = 0; i < strings.length; i++)
        {
            Runnable runnable = new SynchroPrint(strings[i], i, lock);
            executorService.submit(runnable);
        }
        executorService.shutdown();
    }
}