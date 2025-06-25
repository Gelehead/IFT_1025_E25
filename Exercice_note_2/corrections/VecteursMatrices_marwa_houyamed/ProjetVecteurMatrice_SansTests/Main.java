/**
 * Ce travail a été partiellement réalisé avec l’aide de ChatGPT pour m’aider à structurer les classes et
 * comprendre les consignes demandées.
 * J’ai pris soin de relire et comprendre l’ensemble du code fourni ainsi que d'adapter et modifier ce qui était
 * nécessaire pour assurer la bonne exécution du code.
 * Nom : Marwa Houmayed
 * Matricule : 20263058
 * Date : 1er juin 2025
 * * Classe Main
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
    }
}
