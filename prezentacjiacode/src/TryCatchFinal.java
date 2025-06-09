public class TryCatchFinal {
    public static String example1() {
        try {
            System.out.println("w try");
            return "retrun z try";
        } catch (Exception e) {
            System.out.println("w  catch");
            return "retrun z catch";
        } finally {
            System.out.println("w  finally");
        }
    }

    public static String exampe2() {
        try {
            System.out.println("w block");
            return "retrun z try";
        } finally {
            System.out.println("w  finally");
            return "retrun z finally";
        }
    }

    public static String example3() {
        try {
            System.out.println("w try");
            throw new RuntimeException("Wyjatek w try!!!");
            //   return "return z try";
        } finally {
            System.out.println("w finally");
                throw new RuntimeException("w  finally");
        }
    }

    public static String example4() {
        try {
            System.out.println("w try");
            throw new IllegalStateException("w catch");
        } catch (Exception e) {
            System.out.println("w catch");
            return "retun z catch";
        } finally {
            System.out.println("w  finally");
        }
    }
    public static String example5() {
        try {
            System.out.println("w try");
            throw new IllegalArgumentException("exception w try !!!");
        } catch (Exception e) {
            System.out.println("w catch");
            throw new IllegalStateException("wyjątek w catch !!!", e);
        } finally {
            System.out.println("w finally");
            return "retun z finally";
        }
    }



    public static void main(String[] args) {
        System.out.println("Przykład 1");
        System.out.println(example1());

        System.out.println("\nPrzykład 2");
        System.out.println(exampe2());

        System.out.println("\nPrzykład 3");


        try {
            System.out.println(example3());
        } catch (RuntimeException e) {
            System.out.println(e);
        }

        System.out.println("\nPrzykład 4");
        System.out.println(example4());
        System.out.println("\nPrzykład 5");
        example5();
    }
}
