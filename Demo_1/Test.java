public class Test {
    public static void main(String[] args){
        var result =  1 + Math.pow(2.0, 3) / 2;
        System.out.println(result);
        System.out.println(((Object) result).getClass().getName());
    }
}
