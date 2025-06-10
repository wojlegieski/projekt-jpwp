import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Zadanie2{
    public static void processAndSum(String inputFile) throws IOException {
        // 1) Odczytaj wszystkie linie z pliku
        List<String> lines = Files.readAllLines(Paths.get(inputFile));

        // 2) Zadeklaruj zmienną sum, inicjalizując ją na 0
        int sum = 0;
        String faultyLine = null;

        try {
            // 3a) Sprawdź, czy lista jest pusta
            if (lines.isEmpty()) {
                throw new IllegalStateException("No data to process");
            }
            // 3b) Parsuj każdą linię i sumuj
            for (String line : lines) {
                faultyLine = line;
                int value = Integer.parseInt(line.trim());
                sum += value;
            }
        } catch (NumberFormatException e) {
            // 4) Rzuć IllegalArgumentException z opisem błędnej linii
            throw new IllegalArgumentException("Invalid number at line: " + faultyLine, e);
        } finally {
            // 5) Wyświetl dotychczasową sumę
            System.out.println("Current sum: " + sum);
        }
    }

    public static void main(String[] args) {
        try {
            processAndSum("Zadania/src/zadanie2in.txt");
        } catch (IOException e) {
            System.err.println("File I/O error: " + e.getMessage());
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.err.println("Processing error: " + e.getMessage());
        }
    }
}
