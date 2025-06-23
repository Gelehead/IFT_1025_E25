public class Matrice{

    public double[][] matrix;

    public Matrice(int lignes, int cols){ //Constructeur pour une matrice de taille Nlignes x Mcolonnes, remplie de zéros
        this.matrix = new double[lignes][cols];
    }

    public void additionnerScalaire(double n){ //Additionne la valeur n dans toutes les cellules de la matrice
        for (int i = 0; i < this.matrix.length; i++) {             // rows
            for (int j = 0; j < this.matrix[i].length; j++) {      // columns
                this.matrix[i][j] += n;
            }
        }
    }

    public void multiplierScalaire(double n){ //Multiplie toutes les cellules par un scalaire (modifie la matrice actuelle)
        for (int i = 0; i < this.matrix.length; i++) {             // rows
            for (int j = 0; j < this.matrix[i].length; j++) {      // columns
                this.matrix[i][j] *= n;
            }
        }
    }

    /**
     * Fait le produit matriciel entre deux matrices (crée une *nouvelle matrice*
     * de la bonne taille, ne modifie pas les deux matrices originales)
     * */
    public Matrice dotProduct(Matrice m){
        Matrice res = new Matrice(this.matrix.length, m.matrix[0].length);
        double sum;
        //Pour faire un produit scalaire, deux vecteur doivent avoir le meme nb d'éléments
        if (this.matrix[0].length == m.matrix.length) {
            for (int i = 0; i < this.matrix.length; i++) {            // matrice A
                for (int j = 0; j < m.matrix[0].length; j++) {           // matrice B
                    sum = 0;
                    for (int k = 0; k < this.matrix[i].length; k++) {
                        sum += this.matrix[i][k] * m.matrix[k][j];
                    }
                    res.matrix[i][j] = sum;
                }
            }
        } else {
            System.err.println("Erreur dans les dimensions des matrices");
            res = null;
        }
        return res;
    }

    public double getCell(int ligne, int col){ //Accesseur pour la cellule à une ligne/colonne donnée
        return this.matrix[ligne][col];
    }

    public void setCell(int ligne, int col, double valeur){ //Mutateur pour la cellule à une ligne/colonne donnée
        this.matrix[ligne][col] = valeur;
    }

    public Vecteur getLine(int ligne){ //Retourne un nouveau vecteur contenant la Nième ligne
        return new Vecteur(this.matrix[ligne]);
    }

    public Vecteur getCol(int col){ //Retourne un nouveau vecteur contenant la Nième colonne
        double[] colTab = new double[this.matrix.length];
        Vecteur vector = new Vecteur(colTab);

        for (int i = 0; i < this.matrix.length; i++) {
            vector.setElement(i, this.matrix[i][col]);
        }
        return vector;
    }

    public void afficher(){ //Affiche la matrice sur la console, chaque ligne entre crochets [ ]
        String ligne;

        for (int i = 0; i < this.matrix.length; i++) {             // rows
            ligne = "[ ";
            for (int j = 0; j < this.matrix[i].length; j++) {      // columns
                ligne = ligne.concat(String.valueOf(this.matrix[i][j])).concat(" ");
            }
            ligne = ligne.concat("]");
            System.out.println(ligne);
        }
    }

    public Matrice transpose(){ //Retourne une version transposée de la matrice (sans modifier la matrice actuelle)
        Matrice t = new Matrice(this.matrix[0].length, this.matrix.length);

        for (int i = 0; i < this.matrix.length; i++) {             // rows
            for (int j = 0; j < this.matrix[i].length; j++) {      // columns
                t.matrix[j][i] = this.matrix[i][j];
            }
        }
        return t;
    }

    public static Matrice identite(int n){ //Retourne une instance de la matrice identité N x N
        Matrice id = new Matrice(n,n);

        for (int i = 0; i < n; i++) {
           id.matrix[i][i] = 1;
        }
        return id;
    }

    public int getLignes(){ //Retourne le nombre de lignes
        return this.matrix.length;
    }

    public int getColonnes(){ //Retourne le nombe de colonnes
        return this.matrix[0].length;
    }
}