public class Vecteur {

    private double[] elements;

    public Vecteur(double[] elements) {

        this.elements = new double[elements.length];

        for (int i = 0; i < elements.length; i++) {

            this.elements[i] = elements[i];
        }
    }

    public void setElement(int index, double valeur) {

        this.elements[index] = valeur; //change la valeur à la position de l'index
    }

    public double getElement(int index) {

        return this.elements[index];   // valeur à l'index
    }

    public double dotProduct(Vecteur v) {
        //Vérification des dimensions
        if (this.elements.length != v.elements.length) {

            System.err.println("Erreur dans les dimensions des vecteurs");

            return Double.NaN;

        } else {

            double produitScalaire= 0.0;  //produit scalaire des vecteurs

            for (int i = 0; i < this.elements.length; i++) {

                produitScalaire += this.elements[i] * v.elements[i];
            }
            return produitScalaire;
        }
    }

    public void afficher() {

        System.out.print("{");

        for (int i = 0; i < this.elements.length; i++) {

            System.out.print(this.elements[i]);  //ressort chaque valeur

            if (i < this.elements.length - 1) {

                System.out.print(", ");
            }
        }
        System.out.println("}");  //saut de ligne à la fin
    }
}
