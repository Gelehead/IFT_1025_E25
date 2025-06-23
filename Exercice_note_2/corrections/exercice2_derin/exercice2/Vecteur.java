// Derin Akay 20234040
public class Vecteur {
    private double[] elements;

    public Vecteur(double[] elements){
        this.elements = new double[elements.length];
        for (int i = 0; i < elements.length; i++) {
            this.elements[i] = elements[i];
        }
    }

    public void setElement(int index, double valeur){
        elements[index] = valeur;
    }

    public double getElement(int index){
        return elements[index];
    }

    public double dotProduct(Vecteur v){
        if (this.elements.length != v.elements.length) {
            System.err.println("Erreur dans les dimensions des vecteurs");
            return Double.NaN;
        }
        double sum = 0;
        for (int i = 0; i < elements.length; i++) {
            sum += this.elements[i] * v.elements[i];
        }
        return sum;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < elements.length; i++) {
            sb.append(elements[i]);
            if (i < elements.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }


    public void afficher() {
        System.out.println(this.toString());
    }
}