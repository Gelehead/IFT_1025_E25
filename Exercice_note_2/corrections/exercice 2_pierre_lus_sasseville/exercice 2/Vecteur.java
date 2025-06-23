/*
Exercice 2
IFT 1025
Par : Pierre-Luc Sasseville
Matricule : 20297694
Date : 2025-06-01
*/

public class Vecteur {
    private double[] elements; // attribut privé

    public Vecteur(double[] elements){
        /*  Constructeur avec en paramètre un tableau d'éléments de type
        `double */
            // On affecte l'attribut avec une copie du tableau reçu
            this.elements = elements.clone();
    }
    public void setElement(int index, double valeur){
        /*  Permet de changer la valeur à l'index donné (commence à 0,
        comme dans un tableau)   */

        elements[index] = valeur;
    }
    public double getElement(int index){
        /* Retourne la valeur à l'index demandé */

        return elements[index];
    }
    public double dotProduct(Vecteur v) {
        /* Calcule le produit scalaire avec un autre vecteur */

        if (this.elements.length != v.elements.length) {
            return Double.NaN;
        }
        double somme = 0.0;
        for (int i = 0; i < elements.length; i++) {
            somme += this.elements[i] * v.elements[i];
        }
        return somme;
    }
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

    public void afficher(){
    /* Affiche le contenu du vecteur entres accolades sur la console. */

        System.out.println(this.toString());
    }
}