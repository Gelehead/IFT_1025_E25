package demo;

import java.util.Random;

public class Dice_demo {
    int nb_faces;
    public Dice_demo(int nb_faces) {
        this.nb_faces = nb_faces;
    }

    public int roll_dice(){
        Random random = new Random();
        int resultat = random.nextInt(this.nb_faces);

        return resultat;
    }
}
