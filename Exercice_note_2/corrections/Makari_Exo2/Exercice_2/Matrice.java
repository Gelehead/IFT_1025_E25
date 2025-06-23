/** Parsa Makari
 *  Matricule 20121030
 *  01/06/25
 */
public class Matrice {
    private int lignes; 
    private int cols;
    private double[][] matrice; 

    public Matrice(int lignes, int cols){
        this.lignes = lignes;
        this.cols = cols;
        this.matrice = new double[lignes][cols]; // tableau 2D
    }

    //Addition une valeur double. doesnt return.
    public void additionnerScalaire(double n){
        for(int i = 0; i< this.matrice.length; i++){
            for(int j = 0; j<this.matrice[0].length; j++){
                this.matrice[i][j] += n; 
            }
        }
    }


    // Multiplication scalaire. doesnt return.
    public void multiplierScalaire(double n){
        for(int i = 0; i< this.matrice.length; i++){
            for(int j = 0; j<this.matrice[0].length; j++){
                this.matrice[i][j] *= n; 
            }
        }
    }

    //produit matriciel. returns new matrix.
    public Matrice dotProduct(Matrice m){
        if (this.cols != m.lignes){
            System.out.println("Erreur dans la dimension des matrices");
            return null; //retourne erreur si mauvais taille.
        }
        else{ 
            Matrice result = new Matrice(this.lignes, m.cols);
            for(int i =0; i < this.lignes; i ++){
                for(int j = 0; j < m.cols; j++){
                    double sum = 0.0;
                    for (int x = 0; x <this.cols; x++){
                        sum += this.matrice[i][x] * m.matrice[x][j];
                    }
                result.matrice[i][j] = sum;
                }
            }   
            return result;
        }
    }

    //retourne la valeur d'une case. returns a double.
    public double getCell(int ligne, int col){
        return this.matrice[ligne][col];
    }

    //change la valeur d'une case. doesnt return.,
    public void setCell(int ligne, int col, double valeur){
        this.matrice[ligne][col] = valeur; 
    }

    //retourne une ligne de la matrice. returns a Vecteur.
    public Vecteur getLine(int ligne){
        double[] tab = new double[this.cols];
        for(int i = 0; i<tab.length; i++){
            tab[i] = this.matrice[ligne][i];
        }
        Vecteur result = new Vecteur(tab); 
        return result; 
    }

    //retourne une colonne de la matrice. returns a Vecteur.
    public Vecteur getCol(int col){ 
        double[] tab = new double[this.lignes];
        for(int i = 0; i<tab.length; i++){
            tab[i] = this.matrice[i][col];
        }
        Vecteur result = new Vecteur(tab); 
        return result; 
    }

    // reecriture de la methode toString(), pour afficher matrice. returns String
    @Override
    public String toString(){
        String result ="";
        for(int i = 0; i < this.lignes; i++){
            result += "[";
            Boolean control = false;
                for(int j = 0; j< this.cols; j++){
                    if(control){
                        result +=", ";
                    }
                    result += String.valueOf(this.matrice[i][j]);
                    control = true;
                }
            result += "]\n";

        }
    return result;


    }

    //affiche matrice a l'ecran. doesnt return.
    public void afficher(){
        System.out.println(this.toString());
    }

    public Matrice transpose(){
        Matrice result = new Matrice(this.cols, this.lignes);
        for(int i = 0; i< this.lignes; i ++){
            for(int j = 0; j< this.cols; j ++){
                result.matrice[j][i] = this.matrice[i][j];
            }
        }
        return result;

    }

    //method static. returns une matrice identite de taille n x n.
    public static Matrice identite(int n){
        Matrice identity = new Matrice(n, n);
        for(int i = 0; i < n ; i++){
            for(int j= 0; j< n; j++){
                if(i == j){
                    identity.matrice[i][j] = 1.0;
                }
                else{
                    identity.matrice[i][j] = 0.0;
                }
            }
        }
        return identity;
    }

    // retrun nb de lignes dans la matrice en int.
    public int getLignes() {
        return this.lignes;
    }

    // retrun nb de colonnes dans la matrice en int.
    public int getColonnes() {
        return this.cols;
    }

}
