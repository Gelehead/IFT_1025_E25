
public class Matrice {
    private double[][] data;

    public Matrice(int lignes, int cols) {
        data = new double[lignes][cols];
    }

    public void additionnerScalaire(double n) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] += n;
            }
        }
    }

    public void multiplierScalaire(double n) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] *= n;
            }
        }
    }

    public Matrice dotProduct(Matrice m) {
        int rows = this.data.length;
        int cols = m.data[0].length;
        int shared = this.data[0].length;
        Matrice result = new Matrice(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                double somme = 0;
                for (int k = 0; k < shared; k++) {
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
        return new Vecteur(data[ligne]);
    }

    public Vecteur getCol(int col) {
        double[] colonne = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            colonne[i] = data[i][col];
        }
        return new Vecteur(colonne);
    }

    public void afficher() {
        for (int i = 0; i < data.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println("]");
        }
    }

    public Matrice transpose() {
        int rows = data.length;
        int cols = data[0].length;
        Matrice t = new Matrice(cols, rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                t.setCell(j, i, data[i][j]);
            }
        }
        return t;
    }

    public static Matrice identite(int n) {
        Matrice id = new Matrice(n, n);
        for (int i = 0; i < n; i++) {
            id.setCell(i, i, 1.0);
        }
        return id;
    }
}
