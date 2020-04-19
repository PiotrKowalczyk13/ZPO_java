public class MAIN {
    public static void main(String[] args) {
        int n = 10  ;
        for(int i = 0; i < n; i++){
            Threads threads = new Threads(i, n-1);
            threads.start();
        }
    }
}
