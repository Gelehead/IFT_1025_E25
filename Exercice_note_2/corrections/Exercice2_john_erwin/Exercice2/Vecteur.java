import java.util.Arrays;

public class Vecteur {
    double[] elements;
    public Vecteur(double[] elements){
        this.elements = elements.clone();
    }

    
    /** 
     * @param index
     * @param valeur
     */
    //ajouter un element a une position
    public void setElement(int index, double valeur) {
        int i = 0;
        if(index >= elements.length || index < 0){
                System.out.println("Invallid index");
        }else{
            while(i < index) {
                i++;
            }
            elements[i] = valeur;
        }
        
        
    }
    
    /** 
     * @param index
     * @return double
     */
    //Retrouver la valeur a une position
    public double getElement(int index) {
        int i = 0;
            while(i < index){
               i++;
            }
        return elements[i];
    }
    
    /** 
     * @param x
     * @return double
     */
    //[a,b] * [c,d] = a * c + b * d
    //[a,b] * [c] = a * c + b * c
    /*   * dotProduct d'un Vecteur avec un autre
      => Si les dimensions des vecteurs multipliés ne sont pas
         cohérentes, exécutez ce code :

            System.err.println("Erreur dans les dimensions des vecteurs");
            return Double.NaN;
            */
    public double dotProduct(Vecteur x) {
        double result = 0;
        if(this.elements.length != x.elements.length) {
            System.err.println("Erreur dans les dimensions des vecteurs");
            return Double.NaN;
        }
        else if(x instanceof Vecteur){
            for(int i = 0; i < elements.length; i++) {
                result += elements[i] * x.getElement(i);
            }
        }
        return result;
    }
    public void afficher() {
        String line = "";
        line += "{";
        for(int i = 0; i < elements.length; i++) {
            line += elements[i];
            if(i < elements.length - 1){
                line += ", ";
            }
        }
        line += "}";

        System.out.print(line);
    }
    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        String line = "";

        line += "{";
        for(int i = 0; i < elements.length; i++) {
            line += elements[i];
            if(i < elements.length - 1){
                line += ", ";
            }
        }
        line += "}";

        return line;
    }
}

