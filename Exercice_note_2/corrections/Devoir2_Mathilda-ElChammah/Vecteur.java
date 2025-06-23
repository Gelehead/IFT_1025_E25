public class Vecteur {
    private final double[] elements;
    

    /** 
     * Constructeur avec en paramètre un tableau d'éléments de type
     * double. 
     */
    public Vecteur(double[] elements){
        this.elements = new double[elements.length];
        for (int i = 0; i < elements.length; i++) {
            this.elements[i] = elements[i];
        }
    }
    

    /**
     * Permet de changer la valeur à l'index donné (commence à 0,
     * comme dans un tableau).
     */
    public void setElement(int index, double valeur){
        elements[index] = valeur;   
    }


    /**
     * Retourne la valeur à l'index demandé.
     */
    public double getElement(int index){
        return elements[index];
    }


    /**
     * Calcule le produit scalaire avec un autre vecteur.
     */
    public double dotProduct(Vecteur v){
        if (this.elements.length != v.elements.length) {
            System.err.println("Erreur dans les dimensions des vecteurs");
            return Double.NaN;
        }

        double somme = 0;
        for (int i = 0; i < elements.length; i++) {
            somme += this.elements[i] * v.elements[i];
        }
        return somme;
    }


    /** 
     * Affiche le contenu du vecteur entres accolades sur la console.
     */
    @Override
    public String toString(){
        String result = "{";
        for (int i = 0; i < elements.length; i++) {
            result += elements[i];
            if (i<elements.length - 1) {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }

    public void afficher(){
        System.out.println(this.toString());
    }
}