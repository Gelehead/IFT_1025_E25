import Personnages.Humains.Humain;
import Personnages.Personnage;
import Personnages.Pokemons.Pokemon;

// java main.java arg1 arg2

public class Main {
    public static void main(String[] args) {
        Humain humain = new Humain(10, "jack");
        humain.afficher();

        Pokemon pokemon = new Pokemon(10, "Pikachu");

        Personnage[] ennemis = new Personnage[2];
        ennemis[0] = new Humain(10, "jhon");
        ennemis[1] = new Pokemon(10, "Tortank");

        Pokemon pokemon1 = new Pokemon(10, "Squirtle");

        pokemon1.attaquer(ennemis[0]);
        pokemon1.attaquer(ennemis[1]);
    }
}