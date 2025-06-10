import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Zadanie1 {
    public static void performOperation(String inputFile, String outputFile) throws IOException {
        String data = Files.readString(Paths.get(inputFile));

        // 1) Parsowanie do liczby całkowitej
        int number;


        // 2) Sprawdzenie, czy liczba jest dodatnia


        // 3) Dzielenie 100 przez liczbę (ArithmeticException przy zero)

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
