/*
 * Titre : Bibliothèque de calcul vectoriel et matriciel
 * Auteur : Ruoxuan Hu
 * Matricule : 20304027
 * Date : le 29 Mai, 2025
 * Vecteur : permet de créer et manipuler des vecteurs de dimension quelconque,
 *    avec accès et modification de composantes, calcul de produit scalaire,
 *    et affichage formaté.
 */ 
/* Vecteur.java */
// Classe représentant un vecteur mathématique à n dimensions
public class Vecteur {
    // Tableau privé stockant les composantes du vecteur
    private double[] elements;

    // Constructeur : initialise le vecteur en clonant le tableau fourni
    // pour préserver l'encapsulation et éviter les modifications externes
    public Vecteur(double[] elements) {
        this.elements = elements.clone();
    }

    // Mutateur : modifie la valeur de l'élément situé à l'index donné (base 0)
    public void setElement(int index, double valeur) {
        elements[index] = valeur;
    }

    // Accesseur : renvoie la valeur de l'élément situé à l'index donné (base 0)
    public double getElement(int index) {
        return elements[index];
    }

    // Méthode : calcule le produit scalaire avec un autre vecteur
    // Vérifie d'abord que les dimensions sont compatibles, sinon affiche une erreur
    public double dotProduct(Vecteur v) {
        if (v.elements.length != this.elements.length) {
            System.err.println("Erreur dans les dimensions des vecteurs");
            return Double.NaN;
        }
        double sum = 0;
        for (int i = 0; i < elements.length; i++) {
            sum += this.elements[i] * v.elements[i];
        }
        return sum;
    }

    // Redéfinition de toString : convertit le vecteur en chaîne au format {x, y, z, ...}
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < elements.length; i++) {
            sb.append(elements[i]);
            if (i < elements.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    // Affiche le vecteur dans la console en appelant toString()
    public void afficher() {
        System.out.println(this.toString());
    }
}