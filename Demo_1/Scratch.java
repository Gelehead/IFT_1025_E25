public class Scratch {
    public static void main(String[] args) {
        int[] x = new int[3];
        for(int i=0; i<x.length; i++) {
            x[i] = i;
            System.out.println(i);
        }
        System.out.println(x[0] + "," + x[1] + "," + x[2]);
        int y = 2;
        int[] z = foo(x, x, y);
        System.out.println( y );
        System.out.println(x[0] + "," + x[1] + "," + x[2]);
        System.out.println(z[0] + "," + z[1] + "," + z[2]);
    }

    public static int[] foo(int[] a, int[] b, double c) {
        c++;
        System.out.println(c / 2);
        var result = (int) (c / 2);
        System.out.println("result" +result);
        for(int i=0; i<a.length; i++) {
            System.out.println(a[i]);
            
            a[i] += (int) (c / 2);
            b[i] += (int) (c / 2);
        }
        return b;
    }
}
