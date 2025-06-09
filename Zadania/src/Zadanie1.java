import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Zadanie1 {
    public static void performOperation(String inputFile, String outputFile) throws IOException {
        // 1) Odczyt całego tekstu z pliku
        String data = Files.readString(Paths.get(inputFile));

        // 2) Parsowanie do liczby całkowitej
        int number;
        try {
            number = Integer.parseInt(data.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number: " + data);
        }

        // 3) Sprawdzenie, czy liczba jest dodatnia
        if (number <= 0) {
            throw new IllegalArgumentException("Number must be positive");
        }

        // 4) Dzielenie 100 przez liczbę (ArithmeticException przy zero)
        int result = 100 / number;

        // 5) Zapis wyniku do pliku wyjściowego
        Files.writeString(Paths.get(outputFile), String.valueOf(result));
    }

    public static void main(String[] args) {
        try {
            performOperation("Zadania/src/in.txt", "out.txt");
            System.out.println("Operation completed successfully.");
        } catch (IllegalArgumentException e) {
            System.err.println("Input error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("File I/O error: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.err.println("Math error: " + e.getMessage());
        }
    }
}
