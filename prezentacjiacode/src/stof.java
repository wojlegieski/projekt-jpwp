public class stof {
    public static void main(String[] args)
    {
        try {
        StackOverflow.test(5);
        }
        catch (StackOverflowError e) {
            System.out.println(e);
        }
    }
}
class StackOverflow {

    public static void test(int i)
    {
        try {
            System.out.println(i);
            test(i + 1);
        }
        catch (StackOverflowError e) {
            System.out.println(e);
            System.out.println(i);
        }
    }
}