public class Matrice {
    private double matrice[][];

    public Matrice(int lignes, int cols) {

        this.matrice = new double[lignes][cols];
    }

    public void additionnerScalaire(double n) {

        for (int i = 0; i < matrice.length; i++) {

            for (int j = 0; j < matrice[0].length; j++) {

                this.matrice[i][j] += n;
            }
        }
    }

    public void multiplierScalaire(double n) {

        for (int i = 0; i < matrice.length; i++) {

            for (int j = 0; j < matrice[0].length; j++) {

                this.matrice[i][j] *= n;
            }
        }
    }

    public Matrice dotProduct(Matrice m) {
        //je considère que l'on fait le produit de la première matrice avec
        //celle fournit dans la fonction donc this.matrice X m
        //Vérification des dimensions
        Matrice mat = new Matrice(this.matrice.length,m.matrice[0].length);

        if (this.matrice[0].length != m.matrice.length) {

            System.err.println("Erreur dans les dimensions des matrices");

            return null;

        } else {

            for (int i = 0; i < mat.matrice.length; i++) {

                for (int j = 0; j < m.matrice[0].length; j++) {

                    for (int k = 0; k < mat.matrice[0].length; k++) {

                        mat.matrice[i][j] += this.matrice[i][k] * m.matrice[k][j]; //je prends les lignes de la première
                    }               //matrice et je fais le produit scalaire avec les colonnes de la deuxième matrice.
                }
            }
        }
        return mat;
    }

    public double getCell(int ligne, int col) {

        return this.matrice[ligne][col];  //retourne la valeur de la case
    }

    public void setCell(int ligne, int col, double valeur) {

        this.matrice[ligne][col] = valeur;   // change la valeur d'une case
    }

    public Vecteur getLine(int ligne) {

        double[] lign = new double[this.matrice[0].length];

        for (int i = 0; i < lign.length; i++) {      //J'ajoute les composantes d'une ligne dans un tableau pour ensuite
                                                    //donner ces valeurs dans un vecteur
            lign[i] = this.matrice[ligne][i];
        }
        return new Vecteur(lign) ;
    }

    public Vecteur getCol(int col) {

        double[] colonne= new double[this.matrice.length];

        for (int i = 0; i < this.matrice.length; i++) {  //Même principe

            colonne[i] = this.matrice[i][col];
        }
        return new Vecteur(colonne);
    }

    public void afficher() {

        for (int i = 0; i < matrice.length; i++) {

            System.out.print("[ ");

            for (int j = 0; j < matrice[0].length; j++) {

                System.out.print(this.matrice[i][j] + " ");
            }
            System.out.println("]");   //saut de ligne
        }
    }

    public Matrice transpose() {

        int lignes = matrice.length;
        int colonnes = matrice[0].length;
        Matrice trans = new Matrice(colonnes, lignes);

        for (int i = 0; i < lignes; i++) {

            for (int j = 0; j < colonnes; j++) {

                trans.matrice[j][i] = matrice[i][j];
            }
        }
        return trans;
    }

    public static Matrice identite(int n) {

        Matrice id = new Matrice(n,n);

        for (int i = 0; i < n; i++) {

            id.matrice[i][i]=1.0;
        }
        return id;
    }
}
