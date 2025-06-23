// Yousra Bennaceur
// Matricule 20218188
// Date: 1 juin 2025

public class Vecteur {

    // Déclaration de l'attribut elements en private pour respecter l'encapsulation
    private double[] elements;
    // Constructeur du vecteur
    public Vecteur(double[] elements){
        // Copie du vecteur(tableau)
        this.elements = elements.clone();
    }

    // Changer une valeur à un index donné
    public void setElement(int index, double valeur){
        this.elements[index] = valeur;
    }
    // Retourne la valeur de l'index donné
    public double getElement(int index) {
        return this.elements[index];
    }
    // Calcule le produit scalaire avec un autre vecteur
    public double dotProduct(Vecteur v){
        // Vérifier que this.elements et v ont la même taille
        if (this.elements.length == v.elements.length) {
            // Faire le produit scalaire (somme des produits de chaque index des tableaux)
            double produitScalaire = 0;
            for (int i = 0; i < this.elements.length; i++) {
                produitScalaire += this.getElement(i) * v.getElement(i);
            }
            return produitScalaire;
            }
        else {
            System.err.println("Erreur dans les dimensions des vecteurs");
            return Double.NaN;

        }

    }


    @Override
    // Mettre le contenu du vecteur entre accolades et séparer les éléments par des virgules
    public String toString() {
        // Mettre l'accolade d'ouverture dans la variable contenu
        String contenu = "{";
        // Boucle qui parcours le tableau et ajoute chaque élément suivi d'une virgule dans contenu
        // (sauf pour le dernier élément)
        for (int i = 0; i < this.elements.length; i++) {
            contenu += this.elements[i];
            if (i < this.elements.length - 1) {
                contenu += ", ";
            }
        }
        // Ajout de l'accolade de fermeture
        contenu += "}";
        return contenu;
    }

        // Affiche le contenu du vecteur sur la console (entre accolades)
    public void afficher(){
        System.out.println(this.elements.toString());
    }
}