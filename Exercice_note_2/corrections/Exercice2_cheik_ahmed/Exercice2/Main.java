public class Main {
    public static void main(String[] args) {
        double[] elements = new double[]{1, 2, 3};
        Vecteur v1 = new Vecteur(elements);
        Vecteur v2 = new Vecteur(elements);
        v2.setElement(0, 10);

        System.out.println("--- Vecteurs ---");
        v1.afficher();
        v2.afficher();

        double s = v2.dotProduct(v1);
        System.out.println(s);





        System.out.println("--- Matrices ---");
        Matrice m1 = Matrice.identite(2);
        m1.multiplierScalaire(3);
        m1.setCell(0, 1, 5);
        m1.setCell(1, 0, -2);
        System.out.println("Matrice 1 :");
        m1.afficher();

        Matrice m2 = new Matrice(2, 1);
        m2.additionnerScalaire(10);
        System.out.println("Matrice 2 :");
        m2.afficher();

        Matrice m3 = m1.dotProduct(m2);
        System.out.println("Matrice 3 :");
        m3.afficher();

        Matrice m4 = m3.transpose();
        System.out.println("Matrice 4 :");
        m4.afficher();

        int a = m4.getLignes();
        int b = m4.getColonnes();
        System.out.println("La matrice m4 a pour dimension :");
        System.out.println(a + ", " + b);

        Vecteur v3 = m1.getLine(1);
        Vecteur v4 = m1.getCol(1);
        System.out.println("les premiers ligne et colonne de la Matrice m1 sont: ");
        v3.afficher();
        v4.afficher();



    }
}


