/*
    Zadanie 3 – StackOverflowError – rekurencja bez końca (wersja rozbudowana)

    Masz klasę `RecursiveCalculator`, która symuluje liczenie sumy i średniej liczb od n do 1.
    Kod zawiera błędne wywołanie rekurencji bez warunku zakończenia – powoduje to StackOverflowError.

    Uruchom kod i zobacz, co się stanie.
    Zidentyfikuj, która metoda jest źródłem błędu.
    Dodaj brakujący warunek zakończenia.
    Zrozum i popraw zależności między metodami.

    Program pokazuje, jak rekurencja może wystąpić pośrednio (jedna metoda wywołuje drugą).
*/

public class Zadanie3 {

    static class RecursiveCalculator {

        public int stepCounter = 0;

        // Pierwsza metoda, która inicjuje sumowanie i wywołuje drugą
        public int calculateSum(int n) {
            System.out.println("Start liczenia sumy od: " + n);
            return sumFrom(n, 0);
        }

        // Druga metoda – wykonuje właściwe zliczanie
        public int sumFrom(int current, int total) {
            stepCounter++;

            System.out.println("Krok " + stepCounter + ": current = " + current + ", total = " + total);

            // Brak warunku zakończenia powoduje nieskończoną rekurencję!
            return callBack(current - 1, total + current);
        }

        // Pośrednie wywołanie rekurencyjne (mutual recursion)
        private int callBack(int next, int accumulated) {
            return sumFrom(next, accumulated); // <- cykl między metodami
        }
    }

    public static void main(String[] args) {
        RecursiveCalculator calculator = new RecursiveCalculator();

        int input = 5;
        int result = 0;

        try {
            System.out.println("== Rekurencyjne liczenie sumy od " + input + " ==");
            result = calculator.calculateSum(input);
            System.out.println("\nWynik sumowania: " + result);
            System.out.println("Liczba kroków: " + calculator.stepCounter);

        } catch (StackOverflowError e) {
            System.err.println("\n Błąd: StackOverflowError – rekurencja bez zakończenia!");
            System.err.println("Prawdopodobnie brakuje warunku zakończenia rekurencji.");
        }
    }
}
