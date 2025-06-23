 /*
 * Titre : Bibliothèque de calcul matriciel
 * Auteur : Ruoxuan Hu
 * Matricule : 20304027
 * Date : le 29 Mai, 2025
 * Matrice : permet de créer et manipuler des matrices de taille définie,
 *    avec opérations scalaires (addition et multiplication), produit matriciel,
 *    accès et modification de cases, extraction de lignes/colonnes,
 *    transposition et génération de matrices identité.
 */ 

/* Matrice.java */
// Classe représentant une matrice de dimensions (lignes x colonnes)
public class Matrice {
    // Tableau privé stockant les valeurs de chaque cellule
    private double[][] cells;
    // Nombre de lignes de la matrice
    private int rows;
    // Nombre de colonnes de la matrice
    private int cols;

    // Constructeur : initialise une matrice de zéros de taille spécifiée
    public Matrice(int lignes, int cols) {
        this.rows = lignes;
        this.cols = cols;
        this.cells = new double[lignes][cols];
    }

    // Méthode additionnerScalaire : ajoute un scalaire à chaque cellule
    public void additionnerScalaire(double n) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] += n;
            }
        }
    }

    // Méthode multiplierScalaire : multiplie chaque cellule par un scalaire
    public void multiplierScalaire(double n) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] *= n;
            }
        }
    }

    // Méthode dotProduct : produit matriciel entre deux matrices
    // Affiche une erreur et renvoie null si dimensions incompatibles
    public Matrice dotProduct(Matrice m) {
        if (this.cols != m.rows) {
            System.err.println("Erreur dans les dimensions des matrices");
            return null;
        }
        Matrice result = new Matrice(this.rows, m.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < m.cols; j++) {
                double sum = 0;
                for (int k = 0; k < this.cols; k++) {
                    sum += this.cells[i][k] * m.cells[k][j];
                }
                result.cells[i][j] = sum;
            }
        }
        return result;
    }

    // Accesseur getCell : retourne la valeur d'une cellule spécifique
    public double getCell(int ligne, int col) {
        return cells[ligne][col];
    }

    // Mutateur setCell : modifie la valeur d'une cellule spécifique
    public void setCell(int ligne, int col, double valeur) {
        cells[ligne][col] = valeur;
    }

    // Méthode getLine : extrait la Nième ligne et la renvoie sous forme de vecteur
    public Vecteur getLine(int ligne) {
        double[] row = new double[cols];
        System.arraycopy(cells[ligne], 0, row, 0, cols);
        return new Vecteur(row);
    }

    // Méthode getCol : extrait la Nième colonne et la renvoie sous forme de vecteur
    public Vecteur getCol(int col) {
        double[] column = new double[rows];
        for (int i = 0; i < rows; i++) {
            column[i] = cells[i][col];
        }
        return new Vecteur(column);
    }

    // Méthode afficher : affiche la matrice ligne par ligne entre crochets
    public void afficher() {
        for (int i = 0; i < rows; i++) {
            System.out.print("[ ");
            for (int j = 0; j < cols; j++) {
                System.out.print(cells[i][j]);
                if (j < cols - 1) System.out.print(" ");
            }
            System.out.println(" ]");
        }
    }

    // Méthode transpose : renvoie une nouvelle matrice transposée
    public Matrice transpose() {
        Matrice t = new Matrice(cols, rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                t.cells[j][i] = this.cells[i][j];
            }
        }
        return t;
    }

    // Méthode identite : génère et renvoie la matrice identité n x n
    public static Matrice identite(int n) {
        Matrice id = new Matrice(n, n);
        for (int i = 0; i < n; i++) {
            id.cells[i][i] = 1.0;
        }
        return id;
    }

    // Accesseur getLignes : retourne le nombre de lignes de la matrice
    public int getLignes() {
        return rows;
    }

    // Accesseur getColonnes : retourne le nombre de colonnes de la matrice
    public int getColonnes() {
        return cols;
    }
}