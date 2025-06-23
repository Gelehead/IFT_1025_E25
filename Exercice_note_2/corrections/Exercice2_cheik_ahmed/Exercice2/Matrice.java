import java.util.Arrays;
public class Matrice{
    private int lignes,cols;
    private double[][] matrice;

    public Matrice(int lignes, int cols){
        this.lignes = lignes;
        this.cols = cols;
        this.matrice = new double[lignes][cols];


    }

    public void additionnerScalaire(double n){
        for (int i = 0; i < this.matrice.length; i++) {
            for (int j = 0; j < this.matrice[i].length; j++) {
                this.matrice[i][j] += n;
            }
        }
    }

    public void multiplierScalaire(double n) {
        for (int i = 0; i < this.matrice.length; i++) {
            for (int j = 0; j < this.matrice[i].length; j++) {
                this.matrice[i][j] *= n;
            }
        }
    }

    public Matrice dotProduct(Matrice m) {
        int k = 0;
        double sum = 0.0;
        Matrice t = new Matrice(this.lignes,m.cols);
        if (this.matrice[0].length != m.matrice.length) {
            System.err.println("Erreur dans les dimensions des matrices");
            return null;
        }
        for (int i = 0; i < t.lignes; i++) {
            for (int j = 0; j < t.cols; j++) {
                while (k < m.matrice.length) {
                    sum += this.matrice[i][k] * m.matrice[k][j];
                    k++;
                }
                t.matrice[i][j] = sum;
                k = 0;
                sum = 0.0;
            }
        }
    return t ;
    }

    public double getCell(int ligne, int col){

        return this.matrice[ligne][col] ;
    }

    public void setCell(int ligne, int col, double valeur){
          this.matrice[ligne][col] = valeur;
    }

    public Vecteur getLine(int ligne){
        Vecteur v = new Vecteur(this.matrice[ligne-1]);
        return v;
    }

    public Vecteur getCol(int col){

        double[] a = new double[this.lignes];
        for (int i = 0; i < this.lignes; i++) {
            a[i] = this.matrice[i][col-1];
        }
        Vecteur v = new Vecteur(a);

        return v;
    }

    public void afficher(){
        String s = "";
        for(int i = 0; i < this.lignes; i++) {
            for (int j = 0; j < this.cols; j++) {
                s += this.matrice[i][j] + " ";
            }
            System.out.println("[" + s + "]");
            s = "";
        }
    }


    public Matrice transpose(){
        Matrice t = new Matrice(this.cols, this.lignes);
        for (int i = 0; i < t.lignes; i++) {
            for (int j = 0; j < t.cols; j++) {
                t.matrice[i][j] = this.matrice[j][i];
            }
        }
        return t;
    }

    public static Matrice identite(int n){
        Matrice identite = new Matrice(n,n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    identite.matrice[i][j] = 1;
                } else{
                identite.matrice[i][j] = 0;}
            }

        }
        return identite;
    }

    public int getLignes(){
        return this.lignes;
    }

    public int getColonnes(){
        return this.cols;
    }

}