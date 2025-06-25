// Auteur : Fatimazahrae El Fakir
// Matricule : 20259530
// Programme principal testant les classes Vecteur et Matrice

public class Main {
    public static void main(String[] args) {
        // Test des vecteurs
        double[] elements = {1, 2, 3};
        Vecteur v1 = new Vecteur(elements);
        Vecteur v2 = new Vecteur(elements);
        v2.setElement(0, 10);

        System.out.println("--- Vecteurs ---");
        System.out.println("Vecteur 1 :");
        v1.afficher();
        System.out.println("Vecteur 2 :");
        v2.afficher();
        System.out.println("Produit scalaire = " + v1.dotProduct(v2));

        // Test des matrices
        System.out.println("\n--- Matrices ---");
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
        System.out.println("Produit matriciel :");
        m3.afficher();
    }
}
