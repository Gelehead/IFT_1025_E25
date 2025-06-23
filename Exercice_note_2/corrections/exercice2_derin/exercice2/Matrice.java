// Derin Akay 20234040
public class Matrice{
    private double[][] data;
    private int lignes;
    private int cols;

    public Matrice(int lignes, int cols) {
        this.lignes = lignes;
        this.cols = cols;
        this.data = new double[lignes][cols];
    }

    public void additionnerScalaire(double n) {
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] += n;
            }
        }
    }

    public void multiplierScalaire(double n) {
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] *= n;
            }
        }
    }

    public Matrice dotProduct(Matrice m) {
        if (this.cols != m.lignes) {
            System.err.println("Erreur dans les dimensions des matrices");
            return null;
        }
        Matrice result = new Matrice(this.lignes, m.cols);
        for (int i = 0; i < this.lignes; i++) {
            for (int j = 0; j < m.cols; j++) {
                double sum = 0;
                for (int k = 0; k < this.cols; k++) {
                    sum += this.data[i][k] * m.data[k][j];
                }
                result.data[i][j] = sum;
            }
        }
        return result;
    }

    public double getCell(int ligne, int col) {
        return data[ligne][col];
    }

    public void setCell(int ligne, int col, double valeur) {
        data[ligne][col] = valeur;
    }

    public Vecteur getLine(int ligne) {
        return new Vecteur(data[ligne]);
    }

    public Vecteur getCol(int col) {
        double[] column = new double[lignes];
        for (int i = 0; i < lignes; i++) {
            column[i] = data[i][col];
        }
        return new Vecteur(column);
    }

    public void afficher() {
        for (int i = 0; i < lignes; i++) {
            System.out.print("[ ");
            for (int j = 0; j < cols; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println("]");
        }
    }

    public Matrice transpose() {
        Matrice trans = new Matrice(this.cols, this.lignes);
        for (int i = 0; i < this.lignes; i++) {
            for (int j = 0; j < this.cols; j++) {
                trans.data[j][i] = this.data[i][j];
            }
        }
        return trans;
    }

    public static Matrice identite(int n) {
        Matrice id = new Matrice(n, n);
        for (int i = 0; i < n; i++) {
            id.data[i][i] = 1.0;
        }
        return id;
    }

    public int getLignes(){
        return lignes;
    }

    public int getColonnes(){
        return cols;
    }

}