public class Vecteur {
    double[] elements;
    
    // Constructeur avec un tableau d'éléments de type double
    public Vecteur(double[] elements){
        this.elements = elements;
    }

    public int length() {
        return this.elements.length;
    }

    // Permet de changer la valeur à l'index donné (commence à 0)
    public void setElement(int index, double valeur){
        this.elements[index] = valeur;
    }

    // Retourne la valeur à l'index demandé
    public double getElement(int index){
        return this.elements[index];
    }

    // Calcule le produit scalaire avec un autre vecteur
    public double dotProduct(Vecteur v){
        if (this.length() != v.length()) { 
            throw new Error("cannot compute dot product for vectors of different length"); 
        }

        double sum = 0;
        for (int i = 0; i < elements.length; i++) {
            sum += this.getElement(i) * v.getElement(i);
        }

        return sum;
    }

    // Affiche le contenu du vecteur sur la console au format {x.0, y.0, z.0}
    public void afficher(){
        System.out.println(this.toString());
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("{");

        for (int i = 0; i < elements.length; i++) {
            sb.append(elements[i]);

            if (i < elements.length - 1) {
                sb.append(", ");
            }
        }

        sb.append("}");
        return sb.toString();
    }
}