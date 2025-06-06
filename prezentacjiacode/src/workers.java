import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class workers {
    private static final ConcurrentLinkedQueue<Throwable> errorQueue = new ConcurrentLinkedQueue<>();
    public static void main(String[] args) {
        List<Thread> workers = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            int threadIndex = i;
            Thread t = new Thread(() -> {
                try {
                    runTask(threadIndex);
                } catch (Throwable e) {
                    errorQueue.add(e);
                }
            }, "Worker-" + i);
            workers.add(t);
            t.start();
        }

        while (true) {
            Throwable e;
            while ((e = errorQueue.poll()) != null) {
                System.err.println("Odebrano wyjątek z wątku: "
                        + e.getClass().getSimpleName()
                        + " – " + e.getMessage());
            }

            boolean allDone = true;
            for (Thread t : workers) {
                if (t.isAlive()) {
                    allDone = false;
                    break;
                }
            }
            if (allDone) break;

            try {
                Thread.sleep(200);
            } catch (InterruptedException ignored) { }
        }

        System.out.println("Wszystkie wątki zakończyły pracę. Główny wątek kończy działanie.");
    }

    private static void runTask(int index) {
        System.out.println("Wątek " + index + " zaczyna pracę.");
        if (index == 2) {
            throw new RuntimeException("Błąd w wątku numer " + index);
        }
        System.out.println("Wątek " + index + " zakończył pracę.");
    }
}
