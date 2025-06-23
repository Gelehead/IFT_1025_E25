// Auteur : Fatimazahrae El Fakir
// Matricule : 20259530
// Classe représentant un vecteur mathématique
//j'ai développé ce code avec un peu d'utilisation de l'IA pour m'aider à la compréhension et à l'apprentissage pour compléter le code
public class Vecteur {
    private double[] elements;

    public Vecteur(double[] elements) {
        this.elements = new double[elements.length];
        for (int i = 0; i < elements.length; i++) {
            this.elements[i] = elements[i];
        }
    }

    public void setElement(int index, double valeur) {
        elements[index] = valeur;
    }

    public double getElement(int index) {
        return elements[index];
    }

    public double dotProduct(Vecteur v) {
        if (elements.length != v.elements.length) {
            System.err.println("Erreur dimensions des vecteurs");
            return Double.NaN;
        }
        
        double somme = 0;
        for (int i = 0; i < elements.length; i++) {
            somme = somme + elements[i] * v.elements[i];
        }
        return somme;
    }

    public void afficher() {
        System.out.print("{");
        for (int i = 0; i < elements.length; i++) {
            System.out.print(elements[i]);
            if (i < elements.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }
}