/**
 * Nom : Ziyue Wang
 * Date : 1 juin 2025
 * Matricule : 22308297
 * Ce programme définit une classe vecteur qui permet de représenter un vecteur 
 * de réels et d'effectuer des opérations de base comme l'accès aux éléments, la 
 * modification, le produit scalaire et l'affichage formaté.
 */

public class Vecteur {
    // tableau contenant les éléments du vecteur
    private double[] elements;

    // copie les éléments du tableau fourni
    public Vecteur(double[] elements){
        this.elements = new double[elements.length];
        for (int i = 0; i < elements.length; i++){
            this.elements[i] = elements[i];
        }
    }  

    // modifie l'élément à l'index donné
    public void setElement(int index, double valeur){
        elements[index] = valeur;
        
    }

    // retourne l'élément à l'index donné
    public double getElement(int index){
        return elements[index];
    }

    // calcule le produit scalaire avec un autre vecteur
    public double dotProduct(Vecteur v){
        if (this.elements.length != v.elements.length){
            System.err.println("Erreur dans les dimensions des vecteurs");
        return Double.NaN;
    }
    double produit = 0;
    for (int i = 0; i < elements.length; i++) {
        produit += this.elements[i] * v.elements[i];
    }  
    return produit;
    }

    // représentation textuelle du vecteur (ex : {1.0, 2.0, 3.0})
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < elements.length; i++) {
            sb.append(elements[i]);
            if (i < elements.length - 1){
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    // affiche le vecteur dans la console
    public void afficher(){
        System.out.println(this.toString());
    }
}