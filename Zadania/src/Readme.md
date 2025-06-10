## Zadanie 1 – Walidacja i operacja arytmetyczna z obsługą wyjątków

### Opis:
Zaimplementuj fragment kodu, który wykonuje następujące operacje na pojedynczym ciągu znaków (`data`):

1. **Parsowanie do liczby całkowitej**  
   Spróbuj sparsować wartość `data` do liczby typu `int`.
    - Jeśli nie uda się sparsować (np. `data = "abc"`), rzuć wyjątek:
      ```java
      throw new IllegalArgumentException("Invalid number: " + data);
      ```

2. **Sprawdzenie, czy liczba jest dodatnia**  
   Po poprawnym sparsowaniu, sprawdź, czy liczba jest **większa od zera**.
    - Jeśli nie, rzuć wyjątek:
      ```java
      throw new IllegalArgumentException("Number must be positive");
      ```

3. **Dzielenie 100 przez liczbę**  
   Wykonaj operację `100 / number`.
    - Jeśli liczba wynosi `0`, może wystąpić `ArithmeticException`.




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