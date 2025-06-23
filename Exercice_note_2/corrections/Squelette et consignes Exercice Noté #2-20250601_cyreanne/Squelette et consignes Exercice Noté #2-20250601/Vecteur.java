//Cyreanne Andrianefa, 20236570

public class Vecteur {
    private double[] elements;
    
    public Vecteur(double[] elements){
        this.elements = elements.clone();
    }

    public void setElement(int index, double valeur){
        elements[index] = valeur;
    }

    public double getElement(int index){
        return elements[index];
    }

    public double dotProduct(Vecteur v){
        if (this.elements.length != v.elements.length) {
            System.err.println("Erreur dans les dimensions");
            return Double.NaN;
        }
        double produit = 0;
        for (int i = 0; i < elements.length; i++) {
            produit += this.elements[i] * v.elements[i];
        }
        return produit;
    }


    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (int i = 0; i < elements.length; i++) {
            stringBuilder.append(elements[i]);
            if (i < elements.length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void afficher(){
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