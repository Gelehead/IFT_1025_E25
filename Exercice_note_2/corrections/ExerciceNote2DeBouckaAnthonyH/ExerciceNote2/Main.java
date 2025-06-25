/*Cour  IFT 1025 SESSION E25  section A
 PROF: Alena TSIKHANOVICH
 DÉMONSTRATEUR:  Oscar LAVOLET
 ETUDIANT:  Anthony Hannael DE BOUCKA (20290983)
  Exercice Noté 2
 */



public class Main {

    public static void main(String[] args) {

        double[] elements = new double[]{1, 2, 3};
        Vecteur v1 = new Vecteur(elements);
        Vecteur v2 = new Vecteur(elements);
        v2.setElement(0, 10);

        System.out.println("--- Vecteurs ---");
        v1.afficher();
        v2.afficher();

        System.out.println("Produit scalaire v1 • v2 : " + v1.dotProduct(v2));

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
        System.out.println("Matrice 3 (m1 × m2) :");
        if (m3 != null) m3.afficher();

        System.out.println("--- getLine / getCol ---");
        Vecteur ligne0 = m1.getLine(0);
        Vecteur col1 = m1.getCol(1);

        System.out.print("Ligne 0 de m1 : ");
        ligne0.afficher();

        System.out.print("Colonne 1 de m1 : ");
        col1.afficher();

        System.out.println("--- Transposée de m1 ---");
        Matrice m1T = m1.transpose();
        m1T.afficher();

        System.out.println("--- Matrice identité 4x4 ---");
        Matrice id4 = Matrice.identite(4);
        id4.afficher();

        System.out.println("--- Produit scalaire incorrect (vecteurs de tailles différentes) ---");
        Vecteur v3 = new Vecteur(new double[]{1, 2});
        double erreur = v1.dotProduct(v3);// va show une erreur
        System.out.println("Résultat : " + erreur);

        System.out.println("--- Produit matriciel incorrect (dimensions incompatibles) ---");
        Matrice erreurMatrice = m2.dotProduct(new Matrice(3, 2)); // va show une erreur
        if (erreurMatrice == null) {
            System.out.println("Produit invalide : null retourné");
        }
    }
}
