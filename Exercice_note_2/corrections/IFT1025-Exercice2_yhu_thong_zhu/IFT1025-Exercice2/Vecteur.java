// Nom : Yu Tong Zhu
// Matricule : 20310738
// Date : 28 mai 2025

public class Vecteur {

    // Tableau qui contient les valeurs du vecteur
    private double[] elements;

    // Constructeur crée un nouveau vecteur avec les mêmes valeurs que le tableau
    public Vecteur(double[] elements){

        // Crée un nouveau tableau de la même taille
        this.elements = new double[elements.length];
        for (int i = 0; i < elements.length; i++) {

            // Copie chaque valeur une par une
            this.elements[i] = elements[i];
        }
    }

    // Change la valeur à une position spécifique dans le vecteur
    public void setElement(int index, double valeur){
        elements[index] = valeur;
    }

    // Retourne la valeur à une position spécifique dans le vecteur
    public double getElement(int index){
        return elements[index];
    }

    // Calcule le produit scalaire entre deux vecteurs
    public double dotProduct(Vecteur v){

        // Vérifie si les deux vecteurs ont la même taille
        if (this.elements.length != v.elements.length) {
            System.err.println("Erreur dans les dimensions des vecteurs");
            return Double.NaN;

        }
        double somme = 0;
        for (int i = 0; i < elements.length; i++) {

            // Multiplie la valeur de ce vecteur avec l'autre à la même position et on l'ajoute à la somme
            somme += this.elements[i] * v.elements[i];
        }

        // Retourne la somme qui est le produit scalaire
        return somme;
    }
    

    // Change le vecteur en texte 
    @Override
    public String toString(){
        String s = "{";
        for (int i = 0; i < elements.length; i++) {

            // Ajoute chaque valeur
            s += elements[i];

            // Ajoute une virgule sauf pour le dernier
            if (i < elements.length - 1) s += ", ";
        }
        s += "}";
        return s;
    }

    // Affiche le vecteur dans le terminal
    public void afficher(){
        System.out.println(this.toString());
    }
}

