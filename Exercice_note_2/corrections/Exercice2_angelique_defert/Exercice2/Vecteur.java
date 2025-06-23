/* Vecteur.java
 Defert Angélique, 20146677 ; 30/05/2025
 Exercices noté 2, ift 1025 */

public class Vecteur {
    private double[] elements;

    public Vecteur(double[] elements){
        this.elements = new double[elements.length];
        System.arraycopy(elements, 0, this.elements, 0, elements.length);
    }

    public void setElement(int index, double valeur){
        // On modifie la valeur à l'index donné
        this.elements[index] = valeur;
    }

    public double getElement(int index){
        // On retourne la valeur 
        return this.elements[index];
    }

    public double dotProduct(Vecteur v){
        // On fait un produit scalaire des deux vecteurs 
        if (this.elements.length != v.elements.length) {
            System.err.println("Erreur dans les dimensions des vecteurs");
            return Double.NaN;
        }

        double result = 0;
        for (int i = 0; i < this.elements.length; i++){
            result += this.elements[i] * v.elements[i];
        }
        return result;
    }

    @Override
    public String toString(){
        // On retourne une représentation du vecteur {a, b, c}
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < elements.length; i++) {
            sb.append(elements[i]);
            if (i != elements.length - 1) sb.append(", ");
        }
        sb.append("}");

        return sb.toString();
    }

    public void afficher(){
        // On affiche le vecteur avec la méthode toString
        System.out.println(this.toString());
    }
}