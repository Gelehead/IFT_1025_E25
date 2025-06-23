public class Matrice{
    private final int lignes;
    private final int colonnes;
    private final double[][] data;

    // Constructeur : Crée une matrice vide de lignes x colonnes
    public Matrice(int lignes, int cols){
        this.lignes = lignes;
        this.colonnes = cols;
        this.data = new double[lignes][colonnes];
    }

    // Ajouter le scalaire n à tous les éléments de la matrice
    // (Modifier la matrice d'origine)
    public void additionnerScalaire(double n){
        for(int i = 0; i < lignes; i++){
            for(int j = 0; j < colonnes; j++){
                data[i][j] += n;
            }
        }
    }

    // Multiplier tous les éléments de la matrice par le scalaire n
    // (Modifier la matrice d'origine)
    public void multiplierScalaire(double n){
        for(int i = 0; i < lignes; i++){
            for(int j = 0; j < colonnes; j++){
                data[i][j] *= n;
            }
        }
    }

    // Multiplication matricielle  A.dotProduct (B)
    // Si A.colonnes != B.lignes, afficher une erreur et renvoyer null
    public Matrice dotProduct(Matrice m){ 
        if (this.colonnes != m.lignes){
            System.err.println("Erreur dans les dimensions des matrices");
            return null;
        }
        Matrice result = new Matrice(this.lignes, m.colonnes);
        for(int i = 0; i < this.lignes; i++){
            for(int j = 0; j < m.colonnes; j++){
                double sum = 0;
                for(int k = 0; k < this.colonnes; k++){
                    sum += this.data[i][k] * m.data[k][j];
                }
                result.data[i][j] = sum;
            }
        }
        return result;
    }

    // Obtenir la valeur d'une cellule spécifiée
    // Une exception est levée par Java en cas de dépassement des limites
    public double getCell(int ligne, int col){
        return data[ligne][col];
    }

    // Définir la valeur d'une cellule spécifique
    // Une exception est levée par Java en cas de dépassement des limites
    public void setCell(int ligne, int col, double valeur){
        data[ligne][col] = valeur;
    }

    // Retourner la ligne "ligne" sous forme d'un nouveau vecteur
    public Vecteur getLine(int ligne){
        return new Vecteur(data[ligne].clone());
    }

    // Retourner la colonne "col" sous forme d'un nouveau vecteur
    public Vecteur getCol(int col){
        double[] column = new double[lignes];
        for(int i = 0; i < lignes; i++){
            column[i] = data[i][col];
        }
        return new Vecteur(column);
    }

    // Imprimer la matrice sur la console
    // Chaque ligne au format [a b c]
    public void afficher(){
        for(int i = 0; i < lignes; i++){
            System.out.print("[ ");
            for(int j = 0; j < colonnes; j++){
                System.out.print(data[i][j]);
                if (j < colonnes - 1){
                    System.out.print(" ");
                }
            }
        }
        System.out.println(" ]");
    }

    // Renvoyer la matrice transposée sans modifier la matrice actuelle
    public Matrice transpose(){
        Matrice t = new Matrice(colonnes, lignes);
        for(int i = 0; i < lignes; i++){
            for(int j = 0; j < colonnes; j++){
                t.data[j][i] = this.data[i][j];
            }
        }
        return t;
    }

    // Créer et renvoyer une matrice unitaire nxn
    public static Matrice identite(int n){
        Matrice I  = new Matrice (n, n);
        for(int i = 0; i < n; i++){
            I.data[i][i] = 1.0;
        }
        return I;
    }

    // Renvoyer le nombre de lignes de la matrice
    public int getLignes(){
        return this.lignes;
    }

    // Renvoyer le nombre de colonnes de la matrice
    public int getColonnes(){
        return this.colonnes;
    }

}