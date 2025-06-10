import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Zadanie2{
    public static void processAndSum(String inputFile) throws IOException {
        // TODO 1: Odczytaj wszystkie linie z pliku
        List<String> lines = /* TODO */ null;

        // TODO 2: Zadeklaruj zmienną sum, inicjalizując ją na 0
        // int sum = /* TODO */;

        // TODO 3: Utwórz blok try { ... }
        //   - Wewnątrz: jeśli lista linii jest pusta, rzuć IllegalStateException("No data to process")
        //   - Iteruj po liniach, parsuj każdą do int i dodaj do zmiennej sum

        // TODO 4: Dodaj blok catch dla NumberFormatException
        //   - Wewnątrz: rzuć IllegalArgumentException z wiadomością zawierającą wartość błędnej linii

        // TODO 5: Dodaj blok finally
        //   - Wewnątrz: wyświetl dotychczasową sumę
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
