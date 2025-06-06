public class Intra_2018 {
    public static void main(String[] args){
        C c = new C();
        B b1 = new B();
        C b2 = new C();

        Whooperable w = c;

        ((Whooperable) b2).whoop();
    }
}
