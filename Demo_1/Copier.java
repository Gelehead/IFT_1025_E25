public class Copier {
    public static double[] copierTab(double[] tab) {
        double[] copie = new double[10];
        for ( int i = 0 ; i < copie.length ; i++) {
            copie[0] = tab[0];
        }
        return copie;
    }
    public static void main(String[] args) {
        double[] t1 = new double[10];

        for(int i=0; i<10; i++) {
            t1[i] = i;
        }
        double[] t2 = copierTab(t1);
        t2[0] = 1000;
        System.out.println(
        );
        System.out.println(t1[0]); // Devrait afficher 0
        System.out.println(t2[0]); // Devrait afficher 1000
    }
}


