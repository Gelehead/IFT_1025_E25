// Nom : Yu Tong Zhu
// Matricule : 20310738
// Date : 28 mai 2025


public class Matrice{

    // Tableau à deux dimensions pour la grille de la matrice
    private double[][] grille;
    
    // Constructeur initialise une matrice de lignes fois colonnes et les autres sont zéros
    public Matrice(int lignes, int cols){
        this.grille = new double[lignes][cols];
    }

    // Ajoute une valeur scalaire à chaque case de la matrice
    public void additionnerScalaire(double n){

        // Chaque ligne de la matrice
        for (int i = 0; i < grille.length; i++) {

            // Chaque colonne de la matrice
            for (int j = 0; j < grille[0].length; j++) {

                // Ajoute la valeur du scalaire à la case actuelle
                grille[i][j] += n;
            }
        }
    }

    // Multiplie chaque case de la matrice avec un scalaire
    public void multiplierScalaire(double n){

        // Chaque ligne de la matrice
        for (int i = 0; i < grille.length; i++) {

            // Chaque colonne de la matrice
            for (int j = 0; j < grille[0].length; j++) {

                 // Multiplie la case actuelle par le scalaire
                grille[i][j] *= n;
            }
        }
    }

    // On fait le produit matriciel entre deux matrices
    public Matrice dotProduct(Matrice m){ 

        // Vérifie si les dimensions peuvent faire une multiplication matricielle
        if (this.getColonnes() != m.getLignes()) {
            System.err.println("Erreur dans les dimensions des matrices");
            return null;
        }

        // Crée une nouvelle matrice pour garder le résultat
        Matrice resultat = new Matrice(this.getLignes(), m.getColonnes());

        // Chaque ligne de la matrice
        for (int i = 0; i < this.getLignes(); i++) {

             // Chaque colonne de la matrice m
            for (int j = 0; j < m.getColonnes(); j++) {
                double somme = 0;

                // Calcule le produit scalaire entre la ligne i de this et la colonne j de m
                for (int k = 0; k < this.getColonnes(); k++) {
                    somme += this.grille[i][k] * m.grille[k][j];
                }

                // Garde la valeur calculée de i et j du résultat
                resultat.setCell(i, j, somme);
            }
        }

        // Retourne la nouvelle matrice résultante
        return resultat;
    }

    // Retourne la valeur dans la case à la ligne et colonne
    public double getCell(int ligne, int col){
        return grille[ligne][col];
    }

    // Modifie la valeur dans la case à la ligne et colonne
    public void setCell(int ligne, int col, double valeur){
        grille[ligne][col] = valeur;
    }

    // Retourne le vecteur qui a tous les éléments de la ligne 
    public Vecteur getLine(int ligne){
        return new Vecteur(grille[ligne]);
    }

    // Retourne le vecteur qui a tous les éléments de la colonne
    public Vecteur getCol(int col){

        // Crée un tableau pour garder les éléments de la colonne
        double[] colonne = new double[grille.length];

        // Remplit le tableau avec les valeurs de la colonne
        for (int i = 0; i < grille.length; i++) {
            colonne[i] = grille[i][col];
        }

         // Crée un vecteur avec ce colonne et le retourne
        return new Vecteur(colonne);
    }

    public void afficher(){

        // Chaque ligne de la matrice
        for (int i = 0; i < grille.length; i++) {
            System.out.print("[ ");

            // Chaque valeur de la ligne
            for (int j = 0; j < grille[0].length; j++) {
                System.out.print(grille[i][j] + " ");
            }

            // Aller à la ligne après avoir affiché une ligne complète
            System.out.println("]");
        }
    }

    public Matrice transpose() {

        // Crée nouvelle matrice avec lignes/colonnes inversées
        Matrice t = new Matrice(this.getColonnes(), this.getLignes());
    
        // Copie les éléments de l’ancienne matrice en inversant ligne/colonne
        for (int i = 0; i < this.getLignes(); i++) {

            // Chaque colonne de la ligne
            for (int j = 0; j < this.getColonnes(); j++) {

                // Prend la valeur à i et j
                double valeur = this.getCell(i, j);

                // Place cette valeur à i et j dans la nouvelle matrice
                t.setCell(j, i, valeur);
            }
        }
    
        // Retourne nouvelle matrice transposée
        return t;
    }
    

    public static Matrice identite(int n) {

        // Crée  matrice carrée de n x n
        Matrice id = new Matrice(n, n);
    
        // Met des 1 sur la diagonale
        for (int i = 0; i < n; i++) {
            id.setCell(i, i, 1);
        }
    
        // Retourne matrice identité
        return id;
    }
    
    // Retourne le nombre de lignes dans la matrice
    public int getLignes(){
        return grille.length;
    }

    // Retourne le nombre de colonnes dans la matrice
    public int getColonnes(){
        return grille[0].length;
    }

}