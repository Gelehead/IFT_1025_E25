# Démonstration 01, Java

0. S'assurer que tout le monde peut se connecter à StudiUM et aux
ordinateurs du lab

Consulter au besoin :
https://support.iro.umontreal.ca/doku.php?id=compte:motdepasse
1. Installer Java et un IDE (comme IntelliJ IDEA ou Eclipse)
2. Remplir le document 01-expressions.pdf disponible sur StudiUM
2. Écrire une fonction :
public static int[] renverser(int[] tab)
Écrivez une version :
  1) Qui retourne un nouveau tableau de int qui contient les 
mêmes éléments que tab mais en ordre inverse. Le tableau 
original passé en paramètre ne doit pas être modifié.
2) Qui inverse (donc modifie) le contenu du tableau tab "in 
place", sans allouer plus de mémoire
3. Le programme suivant est supposé copier en mémoire un tableau
 de double et modifier la première case du tableau copié :
// Fichier: Copier.java:

public class Copier {
    public static double[] copierTab(double[] tab) {
        double[] copie = tab;
        return copie;
    }
    public static void main(String[] args) {
        double[] t1 = new double[10];

        for(int i=0; i<10; i++) {
            t1[i] = i;
        }
        double[] t2 = copierTab(t1);
        t2[0] = 1000;
        System.out.println(t1[0]); // Devrait afficher 0
        System.out.println(t2[0]); // Devrait afficher 1000
    }
}

Exécuter le programme pour voir ce qui se passe réellement, puis
dessiner la mémoire pour comprendre ce qui ne va pas.
Corriger le bug dans le programme.
4. Prenez 10 minutes en classe pour évaluer le programme suivant
(seulement en regardant le code, sans l'exécuter) :
class Scratch {
    public static void main(String[] args) {
        int[] x = new int[3];
        for(int i=0; i<x.length; i++) {
            x[i] = i;
        }
        int y = 2;
        int[] z = foo(x, x, y);
        System.out.println( y );
        System.out.println(x[0] + "," + x[1] + "," + x[2]);
        System.out.println(z[0] + "," + z[1] + "," + z[2]);
    }

    public static int[] foo(int[] a, int[] b, double c) {
        c++;
        System.out.println(c / 2);
        for(int i=0; i<a.length; i++) {
            a[i] += (int) (c / 2);
            b[i] += (int) (c / 2);
        }
        return b;
    }
}
 
Dites ce que le programme affiche. Dessinez ce qui se passe en
mémoire à chaque étape du programme.
5. Montrer comment installer les outils en ligne de commande 
Java et s'assurer que tout le monde arrive à compiler un Hello 
World avec :

javac Hello.java
java Hello