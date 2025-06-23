/**
 * Classe représentant un vecteur de nombres réels (double).
 */
public class Vecteur {
    // Tableau contenant les éléments du vecteur
    private double[] elements;

    /**
     * Constructeur qui initialise le vecteur avec une copie des éléments donnés.
     *
     * @param elements tableau de réels à copier dans le vecteur
     */
    public Vecteur(double[] elements) {
        this.elements = new double[elements.length];
        for (int i = 0; i < elements.length; i++) {
            this.elements[i] = elements[i];
        }
    }

    /**
     * Modifie la valeur d'un élément du vecteur à une position donnée.
     *
     * @param index position de l'élément à modifier
     * @param valeur nouvelle valeur à insérer
     */
    public void setElement(int index, double valeur) {
        elements[index] = valeur;
    }

    /**
     * Retourne l'élément du vecteur à la position indiquée.
     *
     * @param index position de l'élément à lire
     * @return valeur à cette position
     */
    public double getElement(int index) {
        return elements[index];
    }

    /**
     * Calcule le produit scalaire avec un autre vecteur.
     * Si les dimensions ne correspondent pas, affiche une erreur et retourne NaN.
     *
     * @param v le vecteur avec lequel effectuer le produit scalaire
     * @return le résultat du produit scalaire ou NaN en cas d'erreur
     */
    public double dotProduct(Vecteur v) {
        if (v.elements.length != this.elements.length) {
            System.err.println("Erreur dans les dimensions des vecteurs");
            return Double.NaN;
        }

        double produit = 0;
        for (int i = 0; i < elements.length; i++) {
            produit += this.elements[i] * v.elements[i];
        }
        return produit;
    }

    /**
     * Retourne une représentation du vecteur sous forme de chaîne, par exemple : {1, 2, 3}
     *
     * @return une chaîne représentant le vecteur
     */
    @Override
    public String toString() {
        String s = "{";
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == (int) elements[i]) {
                s += (int) elements[i];  // Affiche sans .0 si le nombre est entier
            } else {
                s += elements[i];
            }

            if (i != elements.length - 1) {
                s += ", ";
            }
        }
        s += "}";
        return s;
    }

    /**
     * Affiche le vecteur dans la console.
     */
    public void afficher() {
        System.out.println(this.toString());
    }
}
