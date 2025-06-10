/*
    Zadanie 4 – Cykl zależności i NullPointerException (rozbudowane)
    Masz dwie klasy (A i B), które ze sobą współpracują.
    - A wywołuje metodę B
    - B może zarejestrować dane w A i uzyskać dostęp do jej parametrów
    W kodzie występuje NullPointerException – znajdź i popraw inicjalizację zależności.
    Uwaga: kod powinien symulować komunikację między komponentami A i B.
*/

public class Zadanie4 {

    static class A {
        B b;
        private int eventCounter = 0;

        public void callB() {
            System.out.println("A: Wywołuję B...");
            b.doSomething();
            System.out.println("A: zakończono operację z B.");
        }

        public void registerEvent(String eventName) {
            eventCounter++;
            System.out.println("A: Zarejestrowano zdarzenie #" + eventCounter + ": " + eventName);
        }

        public int getEventCount() {
            return eventCounter;
        }
    }

    static class B {
        A a;

        public void doSomething() {
            System.out.println("B: Start operacji...");
            for (int i = 1; i <= 3; i++) {
                String event = "Operacja_B_" + i;
                System.out.println("B: Generuję zdarzenie: " + event);
                a.registerEvent(event); // ← NullPointerException jeśli `a` nie ustawione
            }
            System.out.println("B: Operacja zakończona.");
        }
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        // Brakuje pełnej inicjalizacji – prowadzi do NullPointerException
        // a.b = b;
        // b.a = a;

        a.callB(); // ← tu leci wyjątek
    }
}
