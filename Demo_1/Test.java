public class Test {
    public static void main(String[] args){
        var result = 3 == 2 + 1 && ( 3 > 3 || true);
        System.out.println();
        System.out.println(result);
        System.out.println(((Object) result).getClass().getName());
    }
}
