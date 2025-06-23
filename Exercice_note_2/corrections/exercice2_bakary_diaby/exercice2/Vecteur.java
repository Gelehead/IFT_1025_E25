public class Vecteur {
    // Attribut pour stocker les éléments du vecteur
    private double[] elements;

    // Constructeur : initialise le vecteur avec un tableau de doubles
    public Vecteur(double[] elements){
        this.elements = elements; // on assigne le tableau fourni à l'attribut
    }

    // Méthode pour modifier un élément du vecteur à un index donné
    public void setElement(int index, double valeur){
        elements[index] = valeur;
    }

    // Méthode pour récupérer un élément du vecteur à un index donné
    public double getElement(int index){
        return elements[index];
    }

    // Méthode pour calculer le produit scalaire avec un autre vecteur
    public double dotProduct(Vecteur v){
        if (this.elements.length != v.elements.length) {
            return Double.NaN; // dimensions incompatibles
        }
        double somme = 0;
        for (int i = 0; i < elements.length; i++) {
            somme += this.elements[i] * v.elements[i];
        }
        return somme;
    }

    // Redéfinition de la méthode toString pour afficher un vecteur proprement
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < elements.length; i++) {
            sb.append(elements[i]);
            if (i < elements.length - 1) sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }

    // Méthode pour afficher le vecteur dans la console
    public void afficher(){
        System.out.println(this.toString());
    }
}
