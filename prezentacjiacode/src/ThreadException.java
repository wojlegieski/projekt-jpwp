import java.util.Random;

public class ThreadException {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("Wątek rusza...");
            int[] arr = new int[0];
            System.out.println(arr[1]);
        });
        Thread[] threads = new Thread[10];
        Random r= new Random();
        for(int i=0; i<10; i++){
            threads[i] = new Thread(() -> {
                int[] arr = new int[r.nextInt(10)];
                for (int j = 0; j < arr.length; j++) {
                    arr[j] = r.nextInt(100) + 1;
                }
                System.out.println(arr[r.nextInt(10)]);
            });
        }



        t.setUncaughtExceptionHandler((thread, ex) -> {
            System.err.println("Nieobsłużony wyjątek w wątku „"
                    + thread.getName() + "”: "
                    + ex.getClass().getSimpleName()
                    + " – " + ex.getMessage());
        });


        Thread.setDefaultUncaughtExceptionHandler((thread, ex) -> {
            System.err.println(
                    "GLOBAL handler: wyjątek w wątku „"
                            + thread.getName()
            );
        });



        t.start();
        for(int i=0; i<10; i++){
            threads[i].start();
        }
    }
}
