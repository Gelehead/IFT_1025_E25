// Nom      : Gharbi Hedi
// Matricule: 20327566
// Date     : 2025-06-01

public class Matrice {
    // Tableau 2D qui contient les valeurs de la matrice
    private double[][] data;

    // Constructeur : crée une matrice de zéros
    public Matrice(int lignes, int cols) {
        data = new double[lignes][cols];
    }

    // Ajoute n à chaque cellule de la matrice
    public void additionnerScalaire(double n) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] += n;
            }
        }
    }

    // Multiplie chaque cellule par n
    public void multiplierScalaire(double n) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] *= n;
            }
        }
    }

    // Calcule le produit matriciel avec une autre matrice
    public Matrice dotProduct(Matrice m) {
        if (this.data[0].length != m.data.length) {
            System.err.println("Erreur dans les dimensions des matrices");
            return null;
        }

        Matrice resultat = new Matrice(this.data.length, m.data[0].length);

        for (int i = 0; i < resultat.data.length; i++) {
            for (int j = 0; j < resultat.data[0].length; j++) {
                double somme = 0;
                for (int k = 0; k < this.data[0].length; k++) {
                    somme += this.data[i][k] * m.data[k][j];
                }
                resultat.data[i][j] = somme;
            }
        }

        return resultat;
    }

    // Accède à une cellule spécifique
    public double getCell(int ligne, int col) {
        return data[ligne][col];
    }

    // Modifie une cellule spécifique
    public void setCell(int ligne, int col, double valeur) {
        data[ligne][col] = valeur;
    }

    // Retourne une ligne sous forme de vecteur
    public Vecteur getLine(int ligne) {
        double[] ligneVecteur = new double[data[0].length];
        for (int j = 0; j < data[0].length; j++) {
            ligneVecteur[j] = data[ligne][j];
        }
        return new Vecteur(ligneVecteur);
    }

    // Retourne une colonne sous forme de vecteur
    public Vecteur getCol(int col) {
        double[] colVecteur = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            colVecteur[i] = data[i][col];
        }
        return new Vecteur(colVecteur);
    }

    // Affiche la matrice avec une ligne par rangée
    public void afficher() {
        for (int i = 0; i < data.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < data[0].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println("]");
        }
    }

    // Retourne la transposée de la matrice
    public Matrice transpose() {
        Matrice trans = new Matrice(data[0].length, data.length);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                trans.data[j][i] = data[i][j];
            }
        }
        return trans;
    }

    // Retourne une matrice identité de taille n x n
    public static Matrice identite(int n) {
        Matrice identite = new Matrice(n, n);
        for (int i = 0; i < n; i++) {
            identite.data[i][i] = 1.0;
        }
        return identite;
    }
}