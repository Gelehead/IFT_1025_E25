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
        double val = elements[index];
        return val;
    }

    public double dotProduct(Vecteur v) {
        if (elements.length != v.elements.length) {
            System.err.println("Erreur dans les dimensions des vecteurs");
            return Double.NaN;
        }
        double produit = 0.0;
        for (int i = 0; i < this.elements.length; i++) {
            produit += this.elements[i] * v.elements[i];
        }
        return produit;
    }

    @Override
    public String toString() {
        String s = "{";
        for (int i = 0; i < elements.length; i++) {
            s += elements[i];
            if (i < elements.length - 1) {
                s += ", ";
            }
        }
        s += "}";
        return s;
    }

    public void afficher() {
        System.out.println(this.toString());
    }
}
