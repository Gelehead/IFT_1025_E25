/*
Exercice 2
IFT 1025
Par : Pierre-Luc Sasseville
Matricule : 20297694
Date : 2025-06-01
*/

public class Matrice {
    private int lignes;
    private int colonnes;
    private double[][] donnees;

    public Matrice(int lignes, int colonnes) {
        /* Constructeur pour une matrice de taille Nlignes x Mcolonnes
        remplie de zéros */

        this.lignes = lignes;
        this.colonnes = colonnes;
        this.donnees = new double[lignes][colonnes];
    }
    public void additionnerScalaire(double n) {
        /* Additionne la valeur n dans toutes les cellules de la matrice
        (modifie la matrice actuelle) */

        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                donnees[i][j] += n;
            }
        }
    }
    public void multiplierScalaire(double n) {
        /* Multiplie toutes les cellules par un scalaire
        (modifie la matrice actuelle) */

        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                donnees[i][j] *= n;
            }
        }
    }
    public Matrice dotProduct(Matrice m) {
        /* Fait le produit matriciel entre deux matrices
        (crée une *nouvelle matrice* de la bonne taille, ne modifie
        pas les deux matrices originales) */

        if (this.colonnes != m.lignes) {
            System.err.println("Erreur dans les dimensions des matrices");
            return null;
        }
        Matrice resultat = new Matrice(this.lignes, m.colonnes);
        for (int i = 0; i < this.lignes; i++) {
            for (int j = 0; j < m.colonnes; j++) {
                double somme = 0;
                for (int k = 0; k < this.colonnes; k++) {
                    somme += this.donnees[i][k] * m.donnees[k][j];
                }
                resultat.donnees[i][j] = somme;
            }
        }
        return resultat;
    }
    public double getCell(int ligne, int col) {
        /* Accesseur pour la cellule à une ligne/colonne donnée */

        return donnees[ligne][col];
    }
    public void setCell(int ligne, int col, double valeur) {
        /* Mutateur pour la cellule à une ligne/colonne donnée */

        donnees[ligne][col] = valeur;
    }
    public Vecteur getLine(int ligne) {
        /* Retourne un nouveau vecteur contenant la Nième ligne */

        double[] ligneData = new double[colonnes];
        for (int j = 0; j < colonnes; j++) {
            ligneData[j] = donnees[ligne][j];
        }
        return new Vecteur(ligneData);
    }
    public Vecteur getCol(int col) {
        /* Retourne un nouveau vecteur contenant la Nième colonne */

        double[] colData = new double[lignes];
        for (int i = 0; i < lignes; i++) {
            colData[i] = donnees[i][col];
        }
        return new Vecteur(colData);
    }
    public void afficher() {
        /* Affiche la matrice sur la console, chaque ligne entre crochets [ ] */

        for (int i = 0; i < lignes; i++) {
            System.out.print("[ ");
            for (int j = 0; j < colonnes; j++) {
                System.out.print(donnees[i][j] + " ");
            }
            System.out.println("]");
        }
    }
    public Matrice transpose() {
        /* Retourne une version transposée de la matrice
        (sans modifier la matrice actuelle) */

        Matrice trans = new Matrice(colonnes, lignes);
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                trans.donnees[j][i] = this.donnees[i][j];
            }
        }
        return trans;
    }
    public static Matrice identite(int n) {
        /* Retourne une instance de la matrice identité N x N */

        Matrice id = new Matrice(n, n);
        for (int i = 0; i < n; i++) {
            id.donnees[i][i] = 1.0;
        }
        return id;
    }
    public int getLignes() {
        return lignes;
    }
    public int getColonnes() {
        return colonnes;
    }
}
