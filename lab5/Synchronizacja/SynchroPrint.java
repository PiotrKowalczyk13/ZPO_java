public class SynchroPrint implements Runnable {

    private String text;
    private int index;
    private LockCreate lock;

    public SynchroPrint(String text, int index, LockCreate lock)
    {
        this.text = text;
        this.index = index;
        this.lock  = lock;
    }

    public void run()
    {
            synchronized(lock){
                lock.addToQueue(index);
                lock.notifyAll();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for(int i = 0; i < text.length(); i++)
            {
                synchronized(lock){
                    lock.notifyAll();
                    while (index != lock.getCurrentQueue()) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(text.charAt(i));
                    lock.incrementQueue();
                }
            }

            synchronized(lock){
                lock.notifyAll();
                while (index != lock.getCurrentQueue()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.deleteFromQueue(index);
                lock.notifyAll();
            }
    }
}

