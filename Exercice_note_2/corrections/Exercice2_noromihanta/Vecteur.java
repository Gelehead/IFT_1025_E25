/*
 * Classe qui représente un vecteur
 * Permet d'effectuer des opérations vectorielles
 * Nom: Noromihanta Raharinivo Raharison
 * Matricule: 20312477
 * Date: 29 mai 2025
 */

public class Vecteur {
    private double[] elements;

    /*
     * Constructeur avec en paramètre un tableau d'éléments de type
     * double
     * Paramètre :
     *   elements - tableau contenant les valeurs du vecteur
     */
    public Vecteur(double[] elements) {
        this.elements = new double[elements.length];
        for (int i = 0; i < elements.length; i++) {
            this.elements[i] = elements[i];
        }
    }

    /*
     * Permet de changer la valeur à l'index donné (commence à 0,
     * comme dans un tableau)
     * Paramètres :
     *   index - position de l'élément à modifier
     *   valeur - nouvelle valeur
     */
    public void setElement(int index, double valeur) {
        elements[index] = valeur;
    }
    
    /*
     * Obtient la valeur à une position demandé
     * Paramètre :
     *   index - position de l'élément à récupérer
     * Retourne la valeur de l'élément
     */

    public double getElement(int index) {
        return elements[index];
    }

    /*
     * Calcule le produit scalaire avec un autre vecteur
     * Paramètre :
     *   v - vecteur avec lequel calculer le produit
     * Retourne le résultat du produit scalaire ou 
     * Double.NaN si ,es dimensions sont incompatibles
     */
    public double dotProduct(Vecteur v) {
        if (this.elements.length != v.elements.length) {
            System.err.println("Erreur dans les dimensions des vecteurs");
            return Double.NaN;
        }
        
        double result = 0;
        for (int i = 0; i < elements.length; i++) {
            result += elements[i] * v.elements[i];
        }
        return result;
    }

    /*
     * Représentation en texte du vecteur
     * Retourne une chaîne représentant le vecteur
     */
    @Override
    public String toString() {
        String result = "{";
        for (int i = 0; i < elements.length; i++) {
            result += elements[i];
            if (i < elements.length - 1) {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }

    /*
     * Affiche le contenu du vecteur entres accolades sur la console
     */
    public void afficher() {
        System.out.println(this.toString());
    }
}