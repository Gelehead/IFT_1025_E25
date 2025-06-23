public class Vecteur {
    private double[] elements;

    /*Procédure qui génère un vecteur de n elements */
    public Vecteur(double[] elements) {
        this.elements = new double[elements.length];
        for(int i = 0; i < elements.length; i++) {
            this.elements[i] = elements[i];
        }
    }
    /*Procédure qui change la valeur d'un élément d'un vecteur */
    public void setElement(int index, double valeur) {
        elements[index] = valeur;
    }
    /*Fonction qui retourne la valeur d'un élément à une certaine position dans un vecteur */
    public double getElement(int index) {
        return elements[index];
    }

    /*Fonction qui effectue le produit scalaire avec un autre vecteur */
    public double dotProduct(Vecteur v) {

        /*S'assure que les dimension des deux vecteur sont les mêmes
         * pour que le produit scalaire soit défini.
        */
        if (this.elements.length != v.elements.length) {
            System.err.println("Erreur dans les dimensions des vecteurs");
            return Double.NaN;
        }

        /*Boucle qui multiplie chaque élément à la même position 
         * respectivement et qui additione les produits résultants
         * (combinaison linéaire)
         */
        double produitScalaire = 0;
        for (int i = 0; i < elements.length; i++) {
            produitScalaire += this.elements[i] * v.getElement(i);
        }
        return produitScalaire;
    }

   @Override
    public String toString() {
    String convString = "{";

    /* Boucle qui converti un vecteur en une châine de charactères de la forme:
     * {1.0, 2.0, 3.0, 4.0, 5.0}
      */
    for (int i = 0; i < elements.length; i++) {
        convString += elements[i];
        if (i < elements.length - 1) {
            convString += ", ";
        }
    }
    convString += "}";
    return convString;
}

    /*Procédure qui affiche un vecteur */
    public void afficher() {
        System.out.println(this.toString());
    }
}
