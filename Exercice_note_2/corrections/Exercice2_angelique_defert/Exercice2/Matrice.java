/* Matrice.java
 Defert Angélique, 20146677 ; 30/05/2025
 Exercices noté 2, ift 1025 */

public class Matrice{
    private double [][] data;
    
    public Matrice(int lignes, int cols){
        // On crée la matrice selon le nombre de lignes et de colonnes données
        data = new double[lignes][cols];
    }

    public void additionnerScalaire(double n){
        // On ajoute un sclaire aux éléments
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] += n;
            }
        }
    }

    public void multiplierScalaire(double n){
        // On multiplie les éléments par un scalaire
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] *= n;
            }
        }
    }

    public Matrice dotProduct(Matrice m){ 
        // On fait un produit matriciel entre this et m
        if (this.data[0].length != m.data.length) {
            System.err.println("Erreur dans les dimensions des matrices");
            return null;
        }

        Matrice result = new Matrice(this.data.length, m.data[0].length);
        for (int i = 0; i< this.data.length; i++) {
            for (int j = 0; j < m.data[0].length; j++) {
                for (int k = 0; k < this.data[0].length; k++) {
                    result.data[i][j] += this.data[i][k] * m.data[k][j];
                }
            }
        }
        return result;
    }

    public double getCell(int ligne, int col){
        // On retourne la valeur à la position donné
        return data[ligne][col];
    }

    public void setCell(int ligne, int col, double valeur){
        // On modifie la valeur 
        data[ligne][col] = valeur;
    }

    public Vecteur getLine(int ligne){
        // On récupère une ligne sous forme de vecteur
        return new Vecteur(data[ligne]);
    }

    public Vecteur getCol(int col){
        // On récupère une colonne sous forme de vecteur
        double[] colData = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            colData[i] = data[i][col];
        }
        return new Vecteur(colData);
    }

    public void afficher(){
        // On affiche la matrice ligne par ligne
        for (double[] row : data) {
            System.out.print("[ ");
            for (double val : row) {
                System.out.print(val + " ");
            }
            System.out.println("]");
        }
    }

    public Matrice transpose(){
        // On retourne la matrice transposée
        Matrice transposed = new Matrice(data[0].length, data.length);
        for (int i = 0; i < data.length; i ++) {
            for (int j = 0; j < data[0].length; j ++) {
                transposed.data[j][i] = data[i][j];
            }
        }
        return transposed;
    }

    public static Matrice identite(int n){
        // On crée une matrice identité de taille n
        Matrice id = new Matrice(n, n);
        for (int i = 0; i < n; i++) {
            id.data[i][i] = 1.0;
        }
        return id;
    }

    public int getLignes(){
        // Retourne le nombre de lignes
        return data.length;
    }

    public int getColonnes(){
        // Retourne le nombre de colonnes
        return data[0].length;
    }

}