/**
 * Nom : Ziyue Wang
 * Date : 1 juin 2025
 * Matricule : 22308297
 * Ce programme définit une classe matrice permettant de créer et manipuler des matrices :
 * addition, multiplication, produit matriciel, transposition, etc. 
 */

public class Matrice{

    // Tableau pour stocker les éléments de la matrice
    private double[][] data;
    // nombre de lignes
    private int lignes;
    // nombre de colonnes
    private int colonnes;
    
    // constructeur : initialiser une matrice de dimensions données remplie de zéros
    public Matrice(int lignes, int cols){
        this.lignes = lignes;
        this.colonnes = cols;
        this.data = new double[lignes][cols];
    }

    // ajoute un scalaire à chaque cellule de la matrice
    public void additionnerScalaire(double n){
        for (int i = 0; i < lignes; i++){
            for (int j = 0; j < colonnes; j++){
                data[i][j] += n;
            }
        }
    }

    // multiplie chaque cellule de la matrice par un scalaire
    public void multiplierScalaire(double n){
        for (int i = 0; i < lignes; i++){
            for (int j = 0; j < colonnes; j++){
                data[i][j] *= n;
            }
        }   
    }

    // produit scalaire entre cette matrice et une autre (cela retourne null 
    // si les dimensions sont incompatibles)
    public Matrice dotProduct(Matrice m){ 
        if (this.colonnes != m.getLignes()){ 
        System.err.println("Erreur dans les dimensions des matrices");
        return null;
    }
    Matrice res = new Matrice(this.lignes, m.getColonnes());
    for (int i = 0; i < this.lignes; i++){ 
        for (int j = 0; j < m.getColonnes(); j++){ 
            double somme = 0;
            for (int k = 0; k < this.colonnes; k++){ 
                somme += this.data[i][k] * m.getCell(k,j);
            }
            res.setCell(i, j, somme);
            }
        }
        return res;
    }
   
    // retourne la valeur d'une cellule (ligne, colonne)
    public double getCell(int ligne, int col){ 
         return data [ligne][col];
    }  

    // modifie la valeur d'une cellule (ligne, colonne)
    public void setCell(int ligne, int col, double valeur){
        data[ligne][col] = valeur;
    }

    // retourne une ligne sous forme de vecteur
    public Vecteur getLine(int ligne){
        double[] ligneData = new double[colonnes];
        for (int j = 0; j < colonnes; j++){ 
            ligneData[j] = data[ligne][j];
        }   
        return new Vecteur(ligneData);
    }

    // retourne une colonne sous forme de vecteur
    public Vecteur getCol(int col){
        double[] colData = new double[lignes];
        for (int i = 0; i < lignes; i++){ 
            colData[i] = data[i][col];
        }   
        return new Vecteur(colData);
    }

    // affiche la matrice de la console
    public void afficher(){
        for (int i = 0; i < lignes; i++){
            System.out.print("[ ");
            for (int j = 0; j < colonnes; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println("]");
        }
    }

    // retourne la transposée de la matrice
    public Matrice transpose(){
        Matrice trans = new Matrice(colonnes, lignes);
        for (int i = 0; i < lignes; i++){
            for (int j = 0; j < colonnes; j++) {
                trans.setCell(j, i, data[i][j]);
            }
        }
        return trans;
    }

    // crée une matrice identité de taille nxn
    public static Matrice identite(int n){
        Matrice id = new Matrice(n,n);
        for (int i = 0; i < n; i++) {
            id.setCell(i,i,1.0);
        }
        return id;
    }

    // retourne le nombre de lignes 
    public int getLignes(){
        return lignes;
    }

    // retourne le nombre de colonnes
    public int getColonnes(){
        return colonnes;
    }

}