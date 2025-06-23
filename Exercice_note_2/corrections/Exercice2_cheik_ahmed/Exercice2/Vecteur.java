public class Vecteur {
    private double[] elements;
    public Vecteur(double[] elements){
        this.elements = elements;
    }

    public void setElement(int index, double valeur){
        this.elements[index] = valeur;
    }

    public double getElement(int index){

        return this.elements[index] ;
    }

    public double dotProduct(Vecteur v){
        double sum = 0.0;
        if (v.elements != this.elements){
            System.err.println("Erreur dans les dimensions des vecteurs");
            return Double.NaN;
        }
        for(int i = 0; i < this.elements.length; i++){
            sum += this.elements[i] * v.elements[i];
        }
        return sum;
    }


    @Override
    public String toString(){
        String s = "";
        for(int i = 0; i < this.elements.length-1; i++){
            s += this.elements[i] + ",";
        }
        s += this.elements[this.elements.length-1];
        return "{" + s + "}";
    }

    public void afficher(){

        System.out.println(this.toString());
    }

}