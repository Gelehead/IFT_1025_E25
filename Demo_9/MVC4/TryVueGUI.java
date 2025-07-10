import java.util.Scanner;

class TryVueGUI { 

    public static void describe() {
        System.out.println(" Tapez \"START\" pour demarrer l horloge");
        System.out.println(" Tapez \"STOP\" pour arreter l horloge");
        System.out.println(" Tapez \"QUIT\" pour fermer le programme");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        TryClock clock = new TryClock();

        System.out.println("l horloge a ete initialisee ");
        describe();

        while ( true ) {
            input = scanner.nextLine().strip().toUpperCase();
            switch (input) {
                case "START":
                    clock.start();
                    break;

                case "STOP" : 
                    clock.stop();
                    break;

                case "QUIT" : 
                case "EXIT" : 
                    clock.stop();
                    scanner.close();
                    System.out.println("au revoir !!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("cette commande n'est pas conforme");
                    describe();
                    break;
            }
        }
    }
}