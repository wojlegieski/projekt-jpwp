import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

public class Zadanie2 {
    public static void processFileAndArray(String inputFile) throws IOException {
        // 1) Odczytaj wszystkie linie z pliku
        List<String> lines = Files.readAllLines(Paths.get(inputFile));

        // 2) Sprawdź, czy lines != null
        if (lines == null) {
            throw new NullPointerException("No data read");
        }

        // 3) Parsuj każdą linię do listy liczb, pomijając błędne
        List<Integer> numbers = new ArrayList<>();
        for (String line : lines) {
            try {
                numbers.add(Integer.parseInt(line.trim()));
            } catch (NumberFormatException e) {
            }
        }

        // 4) Jeśli lista jest pusta, rzuc IllegalStateException
        if (numbers.isEmpty()) {
            throw new IllegalStateException("No valid numbers");
        }

        // 5) Oblicz sumę i wypisz na konsolę
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        System.out.println("Sum: " + sum);
    }

    public static void main(String[] args) {
        try {
            processFileAndArray("Zadania/src/zadanie2in.txt");

        }catch (IOException e) {}
    }
}
