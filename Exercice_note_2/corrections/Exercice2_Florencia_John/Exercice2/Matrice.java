// Florencia Jhon Locht, date:25-05-2025 , File: Matrice.java
// Ce programme est la classe Matrice et toutes ses fonctionnalités.
public class Matrice{
    // Variables :
    private int lignes;
    private int cols;
    private double[][] matrix;

    /**
     * Constructeur pour une matrice de taille Nlignes x Mcolonnes
     * remplie de zéros
    */
    public Matrice(int lignes, int cols){
        // Variables :
        this.lignes = lignes;
        this.cols = cols;
        this.matrix = new double[lignes][cols];
        // Mettre la valeur de zéro pour toutes les cases de la matrice :
        for(int i=0; i<lignes; i++){
            for(int j=0; j<cols; j++){
                this.matrix[i][j] = 0;
            } 
        }
    }

    /**
     * Additionne la valeur n dans toutes les cellules de la matrice
     * (modifie la matrice actuelle)
    */
    public void additionnerScalaire(double n){
        for(int i=0; i<lignes; i++){
            for(int j=0; j<cols; j++){
                this.matrix[i][j] += n;
            } 
        }
    }

    // Multiplie toutes les cellules par un scalaire (modifie la matrice actuelle)
    public void multiplierScalaire(double n){
        for(int i=0; i<lignes; i++){
            for(int j=0; j<cols; j++){
                this.matrix[i][j] *= n;
            } 
        }
    }

    /**
     * Fait le produit matriciel entre deux matrices
     * (crée une *nouvelle matrice* de la bonne taille, ne modifie
     * pas les deux matrices originales)
    */
    public Matrice dotProduct(Matrice m){ 
        if(cols != m.getLignes()){
            System.err.println("Erreur dans les dimensions des matrices");
            return null;
        }
        else{
            int col = m.getColonnes();
            Matrice produit = new Matrice(lignes,col); 
            for(int i=0; i<lignes; i++){
                for(int j=0; j<col; j++){
                    double valeur = 0;
                    for(int k=0; k<cols; k++){
                        valeur += this.getCell(i, k)*m.getCell(k, j);
                    }
                    produit.setCell(i, j, valeur);
                }
            }
        return produit;
        }
    }

    // Accesseur pour la cellule à une ligne/colonne donnée
    public double getCell(int ligne, int col){
        double cell = this.matrix[ligne][col];
        return cell;
    }

    // Accesseur pour la cellule à une ligne/colonne donnée
    public void setCell(int ligne, int col, double valeur){
        this.matrix[ligne][col] = valeur;
    }

    // Retourne un nouveau vecteur contenant la Nième ligne
    public Vecteur getLine(int ligne){
        double[] l = new double[cols];
        for(int i=0;i<cols;i++){
            l[i] = getCell(ligne, i);
        }
        Vecteur vec = new Vecteur(l);
        return vec;
    }
 
    // Retourne un nouveau vecteur contenant la Nième colonne
    public Vecteur getCol(int col){
        double[] c = new double[lignes];
        for(int i=0;i<lignes;i++){
            c[i] = getCell(i, col);
        }
        Vecteur vec = new Vecteur(c);
        return vec;
    }

    /**
     * Affiche la matrice sur la console, chaque ligne entre crochets [ ]
     * Par exemple, la matrice qui contient les nombres 1 et 2 sur la
     * première ligne et 13 et 14 sur la deuxième ligne sera affichée
     * avec :
     * [ 1.0 2.0 ]
     * [ 13.0 14.0 ]
    */
    public void afficher(){
        double valeur;
        for(int i=0; i<lignes; i++){
            String interieur = "";
            for(int j=0; j<cols; j++){
                valeur = this.getCell(i, j);
                interieur += Double.toString(valeur);
                if(j<cols-1){
                    interieur += " ";
                }
            }
            System.out.println("["+ interieur +"]");
        }
    }

    /**
     * Retourne une version transposée de la matrice 
     * (sans modifier la matrice actuelle)
    */
    public Matrice transpose(){
        Matrice t = new Matrice(cols,lignes);
        for(int i=0; i<cols; i++){
            for(int j=0; j<lignes; j++){
                double valeur = this.getCell(j, i);
                t.setCell(i, j, valeur);
            }
        }
        return t;
    }

    // Retourne une instance de la matrice identité N x N
    public static Matrice identite(int n){
        Matrice id = new Matrice(n,n);
        for(int i=0; i<n; i++){
            id.setCell(i, i, 1);
        }
        return id;
    }

    // Retourne le nombre de lignes.
    public int getLignes(){
        return lignes;
    }

    // Retourne le nombre de colonnes.
    public int getColonnes(){
        return cols;
    }

}