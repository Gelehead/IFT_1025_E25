public class Main {

    public static void main(String[] args) {

        double[] elements = new double[]{1, 2, 3};
        Vecteur v1 = new Vecteur(elements);
        Vecteur v2 = new Vecteur(elements);
        v2.setElement(0, 10);

        System.out.println("--- Vecteurs ---");
        v1.afficher();
        v2.afficher();

        double produitScalaire = v1.dotProduct(v2);
        System.out.println("Produit scalaire v1.v2 = " + produitScalaire);

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
        System.out.println("Matrice 3 (produit m1 x m2) :");
        if (m3 != null) {
            m3.afficher();
        }

        System.out.println("--- Tests supplémentaires ---");
        Matrice m4 = m1.transpose();
        System.out.println("Matrice 1 transposée :");
        m4.afficher();

        Vecteur ligne0 = m1.getLine(0);
        System.out.println("Première ligne de Matrice 1 :");
        ligne0.afficher();

        Vecteur colonne1 = m1.getCol(1);
        System.out.println("Deuxième colonne de Matrice 1 :");
        colonne1.afficher();

        // Tests d'erreur (pour vérifier les messages d'erreur)
        System.out.println("--- Tests d'erreur ---");
        Vecteur vErreur = new Vecteur(new double[]{1, 2});
        double erreurVecteur = v1.dotProduct(vErreur); // Affiche erreur dimensions vecteur
        System.out.println("Résultat produit scalaire erroné: " + erreurVecteur);

        Matrice mErreur = new Matrice(3, 3);
        Matrice erreurMatrice = m1.dotProduct(mErreur); // Affiche erreur dimensions matrice
        if (erreurMatrice == null) {
            System.out.println("Produit matriciel impossible dû aux dimensions.");
        }

        // Test accès cellule
        System.out.println("--- Accès cellule Matrice 1 (0,1) ---");
        System.out.println("Valeur à (0,1): " + m1.getCell(0, 1));
    }
}
