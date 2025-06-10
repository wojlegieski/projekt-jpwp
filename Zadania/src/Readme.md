## Zadanie 2 – Wersja z użyciem `try-catch-finally`

### Opis:
Zaimplementuj metodę `processAndSum`, która wykonuje następujące operacje:

1. **Odczyt danych**  
   Wczytuje wszystkie linie z pliku wejściowego (`inputFile`).

2. **Przetwarzanie danych**  
   Parsuje każdą linię do typu `int` i sumuje wartości.

3. **Obsługa błędów**
    - Jeśli lista linii jest **pusta**, metoda powinna rzucić wyjątek:
      ```java
      throw new IllegalStateException("No data to process");
      ```
    - Jeśli którakolwiek linia ma **niepoprawny format** (nie można jej sparsować do `int`), należy rzucić wyjątek:
      ```java
      throw new IllegalArgumentException("Invalid line format: " + <zawartość linii>);
      ```

4. **Blok `finally`**  
   Niezależnie od wyniku działania metody, w bloku `finally` należy wyświetlić dotychczasową sumę.

### Sygnatura metody:
```java
public void processAndSum(Path inputFile) throws IOException