
//Créeons la class matrice

public class Matrice {
    private double[][] elements;

//creons un setteur aka un mutateur 

public void setCell(int ligne , int col, double valeur){
        elements[ligne][col]= valeur;
}

//creons un getteur aka un accesseur

public double getCell(int ligne , int col ){
    return elements[ligne][col];
}


    //Créeons la fonction cosntructrice

    public Matrice(int lignes, int cols){
        elements = new double[lignes][cols];
    }


//Créeons la méthode pour additonner les scal

public void additionnerScalaire(double n){
    for (int i = 0; 1 < elements.length;i++){
        for(int k=0; k<elements[i].length;k++){
            elements[i][k] =elements[i][k]+n;
        }
    }
}



//Créeons la methode pour multiplier les cellules par un scalaires

public void multiplierScalaire(double n){
    for(int i =0;i < elements.length; i++){
        for (int j=0; j < elements[i].length; j++){
            elements[i][j]= elements[i][j]*n;
        }
    }
}


public Matrice dotProduct(Matrice m){

    //declarons les attributs qu'on utilisera

    int lignes1 = this.elements.length;
    int cols1 = this.elements[0].length;
    int cols2 =m.elements[0].length;
    int lignes2 = m.elements.length;

    
    if(cols1 != lignes2){
        System.err.println("erreur dans les dimension des matrices");
        return null;
    }

    Matrice finale = new Matrice(lignes1, cols2);


    for (int i =0;i<lignes1;i++){

        for(int j=0;j<cols2;j++){

            double somme=0;

            for(int p=0;p<cols1;p++){
                somme+=this.getCell(i,p)* m.getCell(p,j); }
                
            finale.setCell(i,j,somme);
        }

    }
    return finale;
}

//Creons la methode getLine

public Vecteur getLine(int ligne){
    int nbCol = elements[0].length;

    //creons un tableau temporaire pour conserver la ligne
    double[] lignePrise = new double[nbCol];

    //remplissons le tableau avec cette ligne

    for (int j = 0; j< nbCol;j++){
        lignePrise[j]= elements[ligne][j]; }

    return new Vecteur(lignePrise); }  


//On fait la methode getCol

public Vecteur getCol(int col){
    int nbLignes = elements.length;

    double[] colonPrise = new double [nbLignes];

    for (int i =0; i< nbLignes;i++){
        colonPrise[i]= elements[i][col];
    }
    return new Vecteur(colonPrise);
                    }



//creons la methode afficher

public void afficher(){
    for(int i =0; i< elements.length;i++){
        System.out.print("[");
        for(int j=0; j<elements[i].length;j++){
            System.out.print(elements[i][j]+"");}
            System.out.println("]");
        }
    }


//Creons la m,ethode transpose

public Matrice transpose(){
    
    int nbLignes = elements.length;
    int nbCol = elements[0].length;

    Matrice transpo = new Matrice (nbCol,nbLignes);

    //on copie en transposant les elements

    for(int i =0; i <nbLignes;i++){
        for( int j=0; j<nbCol;j++){
            transpo.setCell(j,i, elements[i][j]);
        }
    }
    return transpo;
}


//creons la methode matrice identité

 public static Matrice identite(int n){
    Matrice identite = new Matrice (n,n);

    for (int i = 0 ; i<n;i++){
        identite.setCell(i,i,1.0);}
    return identite;     
 }




}



        






