import Personnages.Humains.Humain;
import Personnages.Personnage;
import Personnages.Pokemons.Pokemon;

public class Main {
    public static void main(String[] args) {
        Personnage[] ennemis = new Personnage[2];
        ennemis[0] = new Humain(10, "jean", "jacques");
        ennemis[1] = new Pokemon("Scissor");

        Pokemon Pikachu = new Pokemon("Pikachu");
        Pikachu.attaquer(ennemis[1]);
        Pikachu.attaquer(ennemis[0]);
    }

}
