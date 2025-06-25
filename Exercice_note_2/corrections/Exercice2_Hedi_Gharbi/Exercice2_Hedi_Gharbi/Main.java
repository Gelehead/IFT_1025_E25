// Nom      : Gharbi Hedi
// Matricule: 20327566
// Date     : 2025-06-01

public class Main {
    public static void main(String[] args) {
        // Création de deux vecteurs pour test
        double[] elements = new double[]{1, 2, 3};
        Vecteur v1 = new Vecteur(elements);
        Vecteur v2 = new Vecteur(elements);
        v2.setElement(0, 10); // modification d'un élément

        System.out.println("--- Vecteurs ---");
        v1.afficher();
        v2.afficher();
        System.out.println("Produit scalaire : " + v1.dotProduct(v2));

        // Création de matrices pour test
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
        System.out.println("Matrice 3 (produit) :");
        if (m3 != null) {
            m3.afficher();
        }

        // Test de transpose et accès à une ligne/colonne
        System.out.println("Transpose de m1 :");
        Matrice m1T = m1.transpose();
        m1T.afficher();

        System.out.println("Colonne 0 de m1 :");
        m1.getCol(0).afficher();

        System.out.println("Ligne 1 de m1 :");
        m1.getLine(1).afficher();
    }
}
