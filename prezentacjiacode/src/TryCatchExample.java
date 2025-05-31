import java.nio.file.Files;
import java.nio.file.Paths;

public class TryCatchExample {
    public static void main(String[] args) {
        try {
            String content = Files.readString(Paths.get("prezentacjiacode/src/plik.txt"));
            int value = Integer.parseInt(content.trim());
            System.out.println("Wczytana liczba: " + value);
        } catch (java.io.IOException ioe) {
            System.err.println("Błąd odczytu pliku: " + ioe.getMessage());
        } catch (NumberFormatException nfe) {
            System.err.println("Nieprawidłowy format liczby: " + nfe.getMessage());
        } catch (Exception e) {
            System.err.println("Wystąpił nieoczekiwany błąd: " +
                    e.getClass().getSimpleName() + " – " + e.getMessage());
        } finally {
            System.out.println("Koniec próby odczytu pliku.");
        }
    }
}
