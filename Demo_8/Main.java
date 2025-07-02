import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println(" please write your file name");
            String filename = scanner.nextLine();
            
            AppointmentBook book = AppointmentReader.fileReader(filename);
            System.out.println(book);
            scanner.close();
        } 
        catch ( ParseException pe) { System.out.println(" parse exception ");}
        catch ( FileNotFoundException e) { System.out.println( " file not found ");}
        catch (IOException ioe) { System.out.println(" IO Exception ");}
    }
}
