package Personnages.Pokemons;

import Personnages.Humains.Humain;
import Personnages.Personnage;

public class Pokemon extends Personnage {
    Poke_type[] types;
    String nom;
    int health, attack, defense;
    boolean captured = false;
    public Pokemon(Poke_type[] types, String nom, int[] stats) {
        this.types = types;
        this.nom = nom;
        this.health = stats[0];
        this.attack = stats[1];
        this.defense = stats[2];
    }

    public Pokemon(String name) {
        this.nom = name;
        this.types = null;
        this.health = 10;
        this.attack = 10;
        this.defense = 5;
    }

    public void attaquer(Pokemon pokemon) {
        System.out.println(this.nom + ' ' + this.nom + " !!");
    }

    public void attaquer(Humain humain) {
        System.out.println(" rahhhhhhhhhhhhh ");
    }

    public void attaquer(Personnage personnage){
        if ( personnage instanceof Pokemon ) {
            attaquer((Pokemon) personnage);
        }
        if ( personnage instanceof Humain ) {
            attaquer((Humain) personnage);
        }
    }

    @Override
    public void afficher() {
        if ( this.captured ) {
            System.out.println(
                    """
                                -------
                              -/       \\-
                             /           \\
                             +-----O-----+
                             \\.........../
                              -\\......./-
                                -------
                            """
            );
        } else {
            System.out.println(
                    """
                               ___
                              (ô.ô)
                               -v-
                             <(   )>
                              (___)
                               m m
                            """
            );
        }
    }

    @Override
    public String toString() {
        return this.nom + " : " + this.health;
    }
}
