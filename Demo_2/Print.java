public class Print {

    public void print(int x) {
        System.out.println(x);
    }

    public static void main(String[] args) {
        int n = 13;
        Print printer = new Print();
        printer.print(n);
    }
}