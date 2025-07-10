import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class AppointmentReader {
    public static AppointmentBook manualReader(){
        AppointmentBook b = new AppointmentBook();
        try {
            System.out.println("Expected format: " + "25/6/25, 12:45");

            Scanner scanner = new Scanner(System.in);
            boolean done = false;
            while (!done) {
                System.out.println("next date (or -1 if done)");
                String input1 = scanner.nextLine();
                if (input1.equals("-1")){ done = true; }
                else {
                    System.out.println("description : ");
                    String input2 = scanner.nextLine();
                    b.add(input1, input2);
                }
            }
        } catch (ParseException e) {
            System.out.println( "error reading line : " + e.getMessage());
        }
        
        return b;
    }
    
    public static AppointmentBook fileReader(String filename) throws IOException, ParseException {
        AppointmentBook book = new AppointmentBook();
        FileReader fr = new FileReader(filename);
        Scanner scanner = new Scanner(fr);
        try {
            while ( scanner.hasNextLine()){
                String date = scanner.nextLine();
                String description = scanner.nextLine();
                book.add(date, description);
            }
            fr.close();
        } catch ( IOException e) {
            System.out.println(e.getMessage());
        } 
        catch (ParseException e ) { System.out.println(e.getMessage());}
        finally {
            scanner.close();
        }
        return book;
    }
}
