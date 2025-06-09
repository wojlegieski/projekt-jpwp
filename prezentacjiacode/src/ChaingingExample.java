public class ChaingingExample {
    public static void main(String[] args) {
        try {
            processData();
        } catch (Exception e) {
            System.out.println("Złapany wyjątek: " + e);
            System.out.println("Pierwotna przyczyna: " + e.getCause());
        }
    }

    static void processData() throws Exception {
        try {
            int result = divide(10, 0);
        } catch (ArithmeticException ae) {
            throw new Exception("Błąd podczas przetwarzania danych", ae);
        }
    }

    static int divide(int a, int b) {
        return a / b;
    }
}
