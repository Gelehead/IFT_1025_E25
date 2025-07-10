import java.util.Scanner;

/**
 * Pour une application en ligne de commande, on peut mettre le main()
 * dans la classe qu'on veut. Cette classe sert simplement à créer une
 * instance du contrôleur et à l'avertir lorsqu'on entre un nombre sur
 * la ligne de commande.
 */
public class VueGUI {
    public static void main(String[] args) {
        // Définit le contrôleur
        ControleurConsole controleur = new ControleurConsole();

        Scanner s = new Scanner(System.in);

        while(s.hasNext()) {
            String line = s.nextLine();
            controleur.ajouter(line);
        }
    }
}
