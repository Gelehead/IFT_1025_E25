package Personnages.Pokemons;

import Personnages.Humains.Humain;
import Personnages.Personnage;

public class Pokemon extends Personnage{
    private int hp, defense, attack;
    String name;

    boolean captured = false;
    public Pokemon(int hp, String name, int defense, int attack) {
        this.defense = defense;
        this.attack = attack;
        this.hp = hp;
        this.name = name;
    }

    public Pokemon(int hp, String name){
        this.name = name;
        this.hp = hp;
        this.defense = 10;
        this.attack = 10;
    }

    public String getName(){
        return this.name;
    }

    public void capture(){
        this.captured = true;
    }

    @Override
    public void attaquer(Personnage personnage) {
        if ( personnage instanceof Humain ){
            System.out.println( this.name + " " + this.name + " !!!");
        }
        if ( personnage instanceof Pokemon ){
            System.out.println( "nuh huh !");
        }
    }



    @Override
    public void afficher() {
        if ( captured ) {
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
        }
        else {
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
}
