// Derin Akay 20234040
public class Main {

    public static void main(String[] args) {

        double[] elements = new double[]{1, 2, 3};
        Vecteur v1 = new Vecteur(elements);
        Vecteur v2 = new Vecteur(elements);
        v2.setElement(0, 10);

        System.out.println("--- Vecteurs ---");
        v1.afficher();
        v2.afficher();
        System.out.println("Produit scalaire : " + v1.dotProduct(v2));

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
        if (m3 != null) m3.afficher();

        System.out.println("--- Transposée ---");
        Matrice trans = m1.transpose();
        trans.afficher();

        System.out.println("--- Ligne et Colonne de m1 ---");
        Vecteur line0 = m1.getLine(0);
        Vecteur col0 = m1.getCol(0);
        line0.afficher();
        col0.afficher();
    }
}
