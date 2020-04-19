public class Threads extends Thread {

    private int threadNumber;
    private int sleepTime;

    Threads(int i, int max){
        threadNumber = i;
        sleepTime = i-(max-2*(max-i));
    }

    public void run() {
        try {
            sleep(sleepTime);
            System.out.println("Hello from task " + threadNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
