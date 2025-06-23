
public class Vecteur {
    private double[] elements;

    public Vecteur(double[] elements) {
        this.elements = new double[elements.length];
        for (int i = 0; i < elements.length; i++) {
            this.elements[i] = elements[i];
        }
    }

    public void setElement(int index, double valeur) {
        this.elements[index] = valeur;
    }

    public double getElement(int index) {
        return this.elements[index];
    }

    public double dotProduct(Vecteur v) {
        double somme = 0;
        for (int i = 0; i < this.elements.length; i++) {
            somme += this.elements[i] * v.elements[i];
        }
        return somme;
    }

    public void afficher() {
        System.out.print("{");
        for (int i = 0; i < elements.length; i++) {
            System.out.print(elements[i]);
            if (i < elements.length - 1) System.out.print(", ");
        }
        System.out.println("}");
    }
}
