// Nom      : Gharbi Hedi
// Matricule: 20327566
// Date     : 2025-06-01

public class Vecteur {
    // Attribut privé qui contient les valeurs du vecteur
    private double[] elements;

    // Constructeur : copie le tableau passé en paramètre
    public Vecteur(double[] elements) {
        this.elements = new double[elements.length];
        for (int i = 0; i < elements.length; i++) {
            this.elements[i] = elements[i];
        }
    }

    // Modifie la valeur à un certain index
    public void setElement(int index, double valeur) {
        elements[index] = valeur;
    }

    // Retourne la valeur à un certain index
    public double getElement(int index) {
        return elements[index];
    }

    // Calcule le produit scalaire avec un autre vecteur
    public double dotProduct(Vecteur v) {
        if (this.elements.length != v.elements.length) {
            System.err.println("Erreur dans les dimensions des vecteurs");
            return Double.NaN;
        }
        double result = 0;
        for (int i = 0; i < elements.length; i++) {
            result += this.elements[i] * v.elements[i];
        }
        return result;
    }

    // Affiche le contenu du vecteur entre accolades
    public void afficher() {
        System.out.print("{");
        for (int i = 0; i < elements.length; i++) {
            System.out.print(elements[i]);
            if (i != elements.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }
}
