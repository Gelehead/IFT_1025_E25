

public class Matrice {
    private double[][] elements;
     //  Constructeur pour une matrice de taille Nlignes x Mcolonnes remplie de zéros
    public Matrice(int lignes, int cols){
        elements = new double[lignes][cols];    // creer la nouvelle matrice
    }
      //     Additionne la valeur n dans toutes les cellules de la matrice
      //        (modifie la matrice actuelle)
    public void additionnerScalaire(double n){
        for (int i = 0; i < elements.length; i++){
            for (int j = 0; j < elements[i].length; j++){
                elements[i][j] += n;
            }
        }

    }
    //        Multiplie toutes les cellules par un scalaire
    //        (modifie la matrice actuelle)
    public void multiplierScalaire(double n){
        for (int i = 0; i < elements.length; i++){
            for (int j = 0; j < elements[i].length; j++){
                elements[i][j] *= n;
            }
        }

    }
    // Fait le produit matriciel entre deux matrices
    // (crée une *nouvelle matrice* de la bonne taille, ne modifie pas les deux matrices originales)
    public Matrice dotProduct(Matrice m) {
        int ligne1 = this.elements.length;  //la ligne de la premiere matrice
        int ligne2 = m.elements.length;  // la ligne de la deuxieme matrice
        int rang1 = this.elements[0].length;  //la colonne de la premiere matrice
        int rang2 = m.elements[0].length;   // la colonne de la deuxiemee matrice

        // Si les dimensions des matrices multipliées ne sont pas cohérente
        // la range1 doit egale la ligne 2
        if (rang1 != ligne2){
            System.err.println("Erreur dans les dimensions des matrices");
            return null;
        }
        // creer le resultat
        Matrice matrice = new Matrice(ligne1, rang2);  // creer la nouvelle matrice
        for (int i = 0; i < ligne1; i++){     // la ligne de matrice1
            for (int j = 0; j < rang2; j++){    // la colonne  de matrice2
                double somme = 0;
                for (int k = 0; k < rang1; k++){
                    double produit= this.elements[i][k] * m.elements[k][j];
                    somme += produit;
                }
                matrice.elements[i][j] = somme;
            }
        }
        return matrice;

    }
     //     Accesseur pour la cellule à une ligne/colonne donnée
    public double getCell(int ligne, int col){
        return elements[ligne][col];
    }
      //  Mutateur pour la cellule à une ligne/colonne donnée
    public void setCell(int ligne, int col, double valeur){
        elements[ligne][col] = valeur;

    }
    //  Retourne un nouveau vecteur contenant la Nième ligne
    public Vecteur getLine(int ligne){
        double[] lignevaleur = elements[ligne];
        // cree un  nouveau vecteur
        Vecteur vecteur = new Vecteur(lignevaleur);
        return vecteur;
    }
     // Retourne un nouveau vecteur contenant la Nième colonne
    public Vecteur getCol(int col){
        int lignes = this.elements.length;   // nbre de ligne
        double[] valeur =  new double[lignes];  // creer le nouveau tableau ,met combien de colonne
        for (int i = 0; i < lignes; i++){    // chercher la valeur de colonne de chaque ligne
            valeur[i] = this.elements[i][col];
        }
        Vecteur v = new Vecteur(valeur);
        return v;
    }
     // Affiche la matrice sur la console, chaque ligne entre crochets [ ]
     //
     //        Par exemple, la matrice qui contient les nombres 1 et 2 sur la
     //        première ligne et 13 et 14 sur la deuxième ligne sera affichée
     //        avec :
     //
     //        [ 1.0 2.0 ]
     //        [ 13.0 14.0 ]
    public void afficher(){
        for (int i = 0; i < elements.length; i++) {
            String ligne= "[ ";    // commence pour chaque ligne
            for (int j = 0; j < elements[i].length; j++) {//pour les valeurs de la colonne de chaque ligne
                ligne += elements[i][j] + " ";  // ajouter la valeur
            }
            ligne+= "]";  //finir avec ]
            System.out.println(ligne);
        }

    }
    //        Retourne une version transposée de la matrice
    //        (sans modifier la matrice actuelle)
    public Matrice transpose(){
        int lignes = this.elements.length;
        int cols = this.elements[0].length;

        Matrice matrice = new Matrice(cols,lignes);  //creer le tableau pour la version
                                                     // transposée de la matrice
        for (int i = 0; i < lignes; i++){
            for (int j = 0; j < cols; j++){
                double valeur = this.elements[i][j];    // chercher la valeur
                matrice.setCell(j, i, valeur);    // verser
            }
        }
        return matrice;
    }
     //Retourne une instance de la matrice identité N x N
    public static Matrice identite(int n){
        Matrice matrice = new Matrice(n, n);   //creer le matrice  N x N
        for (int i = 0; i < n; i++){
            matrice.setCell(i, i, 1.0);   // per exemple [ 1 0]
                                                 //             [0  1]
        }
        return matrice;
    }

    public int getLignes(){
        int lignes = this.elements.length;
        return lignes;
    }

    public int getColonnes(){
        int colonnes = this.elements[0].length;
        return colonnes;
    }

}