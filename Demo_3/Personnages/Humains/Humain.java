package Personnages.Humains;

import Personnages.Personnage;

public class Humain extends Personnage {
    String nom, prenom;
    int hp;
    public Humain(int hp, String nom, String prenom) {
        this.hp = hp;
        this.prenom = prenom;
        this.nom = nom;
    }

    @Override
    public void afficher() {
        super.afficher();
    }
}

