public class Vecteur {

    private double[] elements;

    public Vecteur(double[] elements) {
       
        this.elements = elements.clone();
    }

    public void setElement(int index, double valeur) {
        
        this.elements[index] = valeur;
    }

    public double getElement(int index) {
    
        return this.elements[index];
    }

    public double dotProduct(Vecteur v) {
        
        if (this.elements.length != v.elements.length) {
            System.err.println("Erreur dans les dimensions des vecteurs");
            return Double.NaN;
        }

        double resultat = 0.0;
        for (int i = 0; i < elements.length; i++) {
            resultat += this.elements[i] * v.elements[i];
        }
        return resultat;
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
