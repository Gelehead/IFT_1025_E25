public class Vecteur {
    private double[] elements;

    /**
     * Constructeur avec en paramètre un tableau d'éléments de type`double`
     * 
     * @param elements    : tableau d'éléments de type`double`
     * @param kamiliaAmir
     */
    public Vecteur(double[] elements) {
        this.elements = elements;
    }

    /**
     * Permet de changer la valeur à l'index donné (commence à 0,
     * comme dans un tableau)
     * 
     * @param index       l'index donné (commence à 0)
     * @param valeur      nouvelle valeur de l'élément
     * @param kamiliaAmir
     */
    public void setElement(int index, double valeur) {
        this.elements[index] = valeur;
    }

    /**
     * Retourne la valeur à l'index demandé
     * 
     * @param index l'index donné (commence à 0)
     * @return retourne la valeur à l'index demandé
     * @param kamiliaAmir
     */
    public double getElement(int index) {
        return this.elements[index];
    }

    /**
     * Calcule le produit scalaire avec un autre vecteur
     * 
     * @param v un vecteur
     * @return retourne le calcul du produit scalaire
     * @param kamiliaAmir
     */
    //
    public double dotProduct(Vecteur v) {
        // On verifie que les dimensiosn des vecteurs sont identiques
        if (this.elements.length != v.elements.length) {
            System.err.println("Erreur dans les dimensions des vecteurs");
            return Double.NaN;
        }

        double product = 0.0;
        for (int i = 0; i < this.elements.length; i++) {
            product = product + this.elements[i] * v.elements[i];
        }
        return product;
    }

    @Override
    public String toString() {
        String chaine = "{";
        for (int i = 0; i < this.elements.length; i++) {
            chaine = chaine + this.elements[i];
            if (i < this.elements.length - 1) {
                chaine = chaine + ", ";
            }
        }
        chaine = chaine + "}"; 
        return chaine;

    }

    /**
     * Affiche le contenu du vecteur entres accolades sur la console.
     * Par exemple, le vecteur qui contient les nombres 1,2 et 3 sera
     * affiché avec : {1.0, 2.0, 3.0}
     * 
     * @param kamiliaAmir
     */
    public void afficher() {
        System.out.print("{");
        for (int i = 0; i < this.elements.length; i++) {
            System.out.print(this.elements[i]);
            if (i < this.elements.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }
}