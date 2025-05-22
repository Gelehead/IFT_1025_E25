package Personnages.Humains;

import Personnages.Personnage;
import Personnages.Pokemons.Pokemon;

public class Humain extends Personnage {
    int hp;
    String name;
    public Humain(int hp, String name){
        this.hp = hp;
        this.name = name;
    }

    @Override
    public void afficher() {
        System.out.println(
                """
                        :)
                        """
        );
    }

    public void attaquer(Humain humain) {
        System.out.println(humain.name + " sucumbed in battle to : " + this.name);
    }

    public void attaquer(Pokemon pokemon) {
        System.out.println(this.name + " caught " + pokemon.getName());
        pokemon.capture();
    }
}
