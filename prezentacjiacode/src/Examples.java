import java.util.concurrent.*;


public class Examples {
    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            throw new RuntimeException("Błąd w czystym wątku");
        });

        thread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("[Thread] Złapany wyjątek z wątku " + t.getName() + ": " + e.getMessage());
        });

        thread.start();

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<?> future = executor.submit(() -> {
            throw new RuntimeException("Błąd w zadaniu ExecutorService");
        });

        try {
            future.get();
        } catch (ExecutionException ee) {
            System.out.println("[ExecutorService] Złapany wyjątek z zadania: " + ee.getCause().getMessage());
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        executor.shutdown();
    }

}
