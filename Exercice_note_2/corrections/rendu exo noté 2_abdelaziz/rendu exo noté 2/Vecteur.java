public class Vecteur {
    private final int dimension; // Dimension du vecteur
    private final double[] elements; // Tableau des éléments du vecteur
    
    /**
     * @param elements le tableau des éléments du vecteur
     * constructeur du vecteur
     */
    public Vecteur(double[] elements){
        this.dimension = elements.length;
        this.elements = elements.clone(); // Copie des éléments pour éviter les modifications externes
    }
    /**
     * Constructeur pour créer un vecteur nul de la dimension spécifiée.
     * @param dimension la dimension du vecteur
     */
    public Vecteur(int dimension){
        this.dimension = dimension;
        this.elements = new double[dimension]; // Initialisation du tableau avec des zéros
    }
    /**
     * @param index l'indice de l'élément à modifier
     * @param valeur la nouvelle valeur à attribuer
     */
    public void setElement(int index, double valeur){
        
        elements[index] = valeur; // Modification de l'élément à l'index spécifié
    }

    /**
     * @param index
     * @return l'élément du vecteur à l'index spécifié
     */
    public double getElement(int index){
        return elements[index]; // Retourne l'élément à l'index spécifié
    }

    /**
     * @param v le vecteur avec lequel on veut calculer le produit scalaire
     * @return le produit scalaire de ce vecteur avec le vecteur v
     */
    public double dotProduct(Vecteur v){
        if (this.dimension != v.dimension) {
            System.err.println("Erreur dans les dimensions des vecteurs");
            return Double.NaN;
        }
        double result = 0.0;
        for (int i = 0; i < this.dimension; i++) {
            result += this.elements[i] * v.getElement(i); // Calcul du produit scalaire
        }
        return result; // Retourne le résultat du produit scalaire
        
    }


    @Override
    public String toString(){
    // exemple de format {1.0, 2.0, 3.0}
        String retour = "{";
        for (int i = 0; i < this.dimension; i++) {
            retour += this.elements[i]; // Convertit chaque élément en chaîne de caractères
            if (i < this.dimension - 1) {
                retour += ", "; // Ajoute une virgule entre les éléments
            }
        }
        retour += "}";
        return retour;
    }

    /**
     * afficher les éléments du vecteur dans l'invité de commande
     */
    public void afficher(){
        System.out.println(this.toString());
    }
}