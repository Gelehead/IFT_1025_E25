//Auteur : Fatimazahrae El Fakir
// Matricule : 20259530
// Classe représentant une matrice mathématique
public class Matrice {
    private double[][] elements;
    private int lignes;
    private int cols;

    public Matrice(int lignes, int cols) {
        this.lignes = lignes;
        this.cols = cols;
        this.elements = new double[lignes][cols];
    }

    public void additionnerScalaire(double n) {
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < cols; j++) {
                elements[i][j] = elements[i][j] + n;
            }
        }
    }

    public void multiplierScalaire(double n) {
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < cols; j++) {
                elements[i][j] = elements[i][j] * n;
            }
        }
    }

    public Matrice dotProduct(Matrice m) {
        if (cols != m.lignes) {
            System.err.println("Erreur dans les dimensions des matrices");
            return null;
        }

        Matrice resultat = new Matrice(lignes, m.cols);
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < m.cols; j++) {
                double somme = 0;
                for (int k = 0; k < cols; k++) {
                    somme = somme + elements[i][k] * m.elements[k][j];
                }
                resultat.elements[i][j] = somme;
            }
        }
        return resultat;
    }

    public double getCell(int ligne, int col) {
        return elements[ligne][col];
    }

    public void setCell(int ligne, int col, double valeur) {
        elements[ligne][col] = valeur;
    }

    public Vecteur getLine(int ligne) {
        double[] ligneElements = new double[cols];
        for (int i = 0; i < cols; i++) {
            ligneElements[i] = elements[ligne][i];
        }
        return new Vecteur(ligneElements);
    }

    public Vecteur getCol(int col) {
        double[] colElements = new double[lignes];
        for (int i = 0; i < lignes; i++) {
            colElements[i] = elements[i][col];
        }
        return new Vecteur(colElements);
    }

    public void afficher() {
        for (int i = 0; i < lignes; i++) {
            System.out.print("[ ");
            for (int j = 0; j < cols; j++) {
                System.out.print(elements[i][j]);
                if (j < cols - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println(" ]");
        }
    }

    public Matrice transpose() {
        Matrice resultat = new Matrice(cols, lignes);
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < cols; j++) {
                resultat.elements[j][i] = elements[i][j];
            }
        }
        return resultat;
    }

    public static Matrice identite(int n) {
        Matrice resultat = new Matrice(n, n);
        for (int i = 0; i < n; i++) {
            resultat.elements[i][i] = 1;
        }
        return resultat;
    }
}
