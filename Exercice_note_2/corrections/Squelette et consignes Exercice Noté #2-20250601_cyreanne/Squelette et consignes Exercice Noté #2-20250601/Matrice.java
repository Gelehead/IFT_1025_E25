//Cyreanne Andrianefa, 20236570

public class Matrice{
    private double[][] elements;
    private int lignes;
    private int cols;
    
    public Matrice(int lignes, int cols){
        this.lignes = lignes;
        this.cols = cols;
        this.elements = new double[lignes][cols];

    }

    public void additionnerScalaire(double n){
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < cols; j++) {
                elements[i][j] += n;
            }
        }
    }

    public void multiplierScalaire(double n){
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < cols; j++) {
                elements[i][j] *= n;
            }
        }
    }

    public Matrice dotProduct(Matrice m){ 
        if (this.cols != m.lignes) {
            System.err.println("Erreur dans les dimensions");
            return null;
        }
        Matrice result = new Matrice(this.lignes, m.cols);
        for (int i = 0; i < this.lignes; i++) {
            for (int j = 0; j < m.cols; j++) {
                for (int k = 0; k < this.cols; k++) {
                    result.elements[i][j] += this.elements[i][k] * m.elements[k][j];
                }
            }
        }
        return result;
    }

    public double getCell(int ligne, int col){
        return elements[ligne][col];
    }

    public void setCell(int ligne, int col, double valeur){
        elements[ligne][col] = valeur;
    }

    public Vecteur getLine(int ligne){
        return new Vecteur(elements[ligne]);
    }

    public Vecteur getCol(int col){
        double[] colElements = new double[lignes];
        for (int i = 0; i < lignes; i++) {
            colElements[i] = elements[i][col];
        }
        return new Vecteur(colElements);
    }

    public void afficher(){
        for (int i = 0; i < lignes; i++) {
            System.out.print("[ ");
            for (int j = 0; j < cols; j++) {
                System.out.print(elements[i][j] + " ");
            }
            System.out.println("]");
        }
    }

    public Matrice transpose(){
        Matrice transposee = new Matrice(this.cols, this.lignes);
        for (int i = 0; i < this.lignes; i++) {
            for (int j = 0; j < this.cols; j++) {
                transposee.elements[j][i] = this.elements[i][j];
            }
        }
        return transposee;
    }

    public static Matrice identite(int n){
        Matrice identite = new Matrice(n, n);
        for (int i = 0; i < n; i++) {
            identite.elements[i][i] = 1.0;
        }
        return identite;
    }

    public int getLignes(){
        return lignes;
    }

    public int getColonnes(){
        return cols;
    }

}