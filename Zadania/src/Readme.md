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
```

## Zadanie 3 – StackOverflowError – rekurencja bez końca (wersja rozbudowana)

Masz klasę `RecursiveCalculator`, która symuluje liczenie sumy i średniej liczb od `n` do `1`.  
Kod zawiera błędne wywołanie rekurencji bez warunku zakończenia – powoduje to `StackOverflowError`.

### Twoje zadania:
1. Uruchom kod i zaobserwuj, co się stanie.
2. Zidentyfikuj metodę będącą źródłem błędu.
3. Dodaj brakujący warunek zakończenia rekurencji.
4. Zrozum i popraw zależności między metodami.

Program pokazuje, jak rekurencja może wystąpić pośrednio – jedna metoda wywołuje drugą, tworząc nieskończoną pętlę.

---

## Zadanie 4 – Cykl zależności i NullPointerException (rozbudowane)

Masz dwie klasy: `A` i `B`, które ze sobą współpracują:

- Klasa `A` wywołuje metodę z klasy `B`.
- Klasa `B` może zarejestrować dane w klasie `A` i uzyskać dostęp do jej parametrów.

W kodzie występuje `NullPointerException`.

### Twoje zadania:
1. Znajdź przyczynę błędu i popraw inicjalizację zależności między klasami.
2. Upewnij się, że obie klasy poprawnie współdziałają – jedna może korzystać z zasobów drugiej.
3. Program ma symulować komunikację między komponentami `A` i `B` (np. wzajemne wywołania metod).

 Uważaj na cykl zależności – upewnij się, że obiekty są prawidłowo tworzone i inicjalizowane, zanim zostaną użyte.

d