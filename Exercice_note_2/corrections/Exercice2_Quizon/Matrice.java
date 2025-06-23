public class Matrice {
    private double[][] data;
    private int lignes;
    private int cols;

    public Matrice(int lignes, int cols) {
        this.lignes = lignes;
        this.cols = cols;
        data = new double[lignes][cols];
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
                double somme = 0;
                for (int k = 0; k < this.cols; k++) {
                    somme += this.data[i][k] * m.data[k][j];
                }
                result.setCell(i, j, somme);
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
        double[] ligneData = new double[cols];
        for (int i = 0; i < cols; i++) {
            ligneData[i] = data[ligne][i];
        }
        return new Vecteur(ligneData);
    }

    public Vecteur getCol(int col) {
        double[] colData = new double[lignes];
        for (int i = 0; i < lignes; i++) {
            colData[i] = data[i][col];
        }
        return new Vecteur(colData);
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
        Matrice trans = new Matrice(cols, lignes);
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < cols; j++) {
                trans.setCell(j, i, data[i][j]);
            }
        }
        return trans;
    }

    public static Matrice identite(int n) {
        Matrice identite = new Matrice(n, n);
        for (int i = 0; i < n; i++) {
            identite.setCell(i, i, 1.0);
        }
        return identite;
    }
}
