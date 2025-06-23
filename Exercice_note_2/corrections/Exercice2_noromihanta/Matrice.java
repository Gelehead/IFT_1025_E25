/*
 * Classe qui représente une matrice
 * Permet d'effectuer des opérations vectorielles
 * Nom: Noromihanta Raharinivo Raharison
 * Matricule: 20312477
 * Date: 29 mai 2025
 */

public class Matrice {
    private double[][] grille;
    private int lignes;
    private int colonnes;

    /*
     * Constructeur pour une matrice de taille Nlignes x Mcolonnes
     *remplie de zéros
     * Paramètres :
     *   lignes - nombre de lignes de la matrice
     *   cols   - nombre de colonnes de la matrice
     */
    public Matrice(int lignes, int cols) {
        this.lignes = lignes;
        this.colonnes = cols;
        this.grille = new double[lignes][cols];
    }

    /*
     * Ajoute un nombre à tous les éléments de la matrice
     * Modifie la matrice actuelle
     * Paramètre :
     *   n - valeur à ajouter à chaque élément
     */
    public void additionnerScalaire(double n) {
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                grille[i][j] += n;
            }
        }
    }

    /*
     * Multiplie tous les éléments par un nombre
     * Modifie la matrice actuelle
     * Paramètre :
     *   n - valeur multiplicative
     */
    public void multiplierScalaire(double n) {
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                grille[i][j] *= n;
            }
        }
    }

    /*
     * Fait le produit matriciel entre deux matrices
     * crée une nouvelle matrice de la bonne taille,
     * Ne modifie pas les deux matrices originales
     * Paramètre :
     *   m - matrice à multiplier
     * Retourne une nouvelle matrice résultat 
     * ou null si les dimensions sont incompatibles
     */

    public Matrice dotProduct(Matrice m) {
        if (this.colonnes != m.lignes) {
            System.err.println("Erreur dans les dimensions des matrices");
            return null;
        }

        Matrice result = new Matrice(this.lignes, m.colonnes);
        for (int i = 0; i < this.lignes; i++) {
            for (int j = 0; j < m.colonnes; j++) {
                double sommeProduits  = 0;
                for (int k = 0; k < this.colonnes; k++) {
                    sommeProduits  += this.grille[i][k] * m.grille[k][j];
                }
                result.grille[i][j] = sommeProduits ;
            }
        }
        return result;
    }

    /*
     * Accesseur pour la cellule à une ligne/colonne donnée
     * Paramètres :
     *   ligne - index de ligne
     *   col   - index de colonne
     * Retourne la valeur de la cellule
     */
    public double getCell(int ligne, int col) {
        return grille[ligne][col];
    }

    /*
     * Mutateur pour la cellule à une ligne/colonne donnée
     * Paramètres :
     *   ligne  - index de ligne (0-based)
     *   col    - index de colonne (0-based)
     *   valeur - nouvelle valeur
     */
    public void setCell(int ligne, int col, double valeur) {
        grille[ligne][col] = valeur;
    }

    /*
     * Extrait une ligne sous forme de vecteur
     * Paramètre :
     *   ligne - index de la ligne
     * Retourne un nouveau vecteur contenant la ligne
     */
    public Vecteur getLine(int ligne) {
        double[] lineGrille = new double[colonnes];
        for (int i = 0; i < colonnes; i++) {
            lineGrille[i] = grille[ligne][i];
        }
        return new Vecteur(lineGrille);
    }

    /*
     * Extrait une colonne sous forme de vecteur
     * Paramètre :
     *   col - index de la colonne
     * Retourne le nouveau vecteur contenant la colonne
     */
    public Vecteur getCol(int col) {
        double[] colGrille = new double[lignes];
        for (int i = 0; i < lignes; i++) {
            colGrille[i] = grille[i][col];
        }
        return new Vecteur(colGrille);
    }

    /*
     * Affiche la matrice sur la console, chaque ligne entre crochets [ ]
     */
    public void afficher() {
        for (int i = 0; i < lignes; i++) {
            System.out.print("[ ");
            for (int j = 0; j < colonnes; j++) {
                System.out.print(grille[i][j] + " ");
            }
            System.out.println("]");
        }
    }

    /*
     * Retourne une version transposée de la matrice,
     * sans modifier la matrice actuelle
     */
    public Matrice transpose() {
        Matrice result = new Matrice(colonnes, lignes);
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                result.grille[j][i] = grille[i][j];
            }
        }
        return result;
    }

    /*
     * Créer une matrice identité
     * Paramètre :
     *   n - taille de la matrice (n x n)
     * Retourne une nouvelle matrice identité
     */
    public static Matrice identite(int n) {
        Matrice result = new Matrice(n, n);
        for (int i = 0; i < n; i++) {
            result.grille[i][i] = 1;
        }
        return result;
    }

    /*
     * Retourne le nombre de lignes de la matrice
     */
    public int getLignes() {
        return lignes;
    }

    /*
     * Retourne le nombre de colonnes de la matrice
     * 
     */
    public int getColonnes() {
        return colonnes;
    }
}