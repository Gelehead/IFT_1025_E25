import java.text.ParseException;
import java.util.ArrayList;

public class AppointmentBook {
    ArrayList<Appointment> book;

    public AppointmentBook() {
        this.book = new ArrayList<Appointment>();
    }

    public void AddAll(ArrayList<Appointment> list){
        this.book.addAll(list);
    }

    public int getNumAppointments() {
        return this.book.size();
    }

    public Appointment getAppointment(int index) {
        return this.book.get(index);
    }

    @Override
    public String toString(){
        if (this.book.isEmpty()) { return "book empty"; }
        String s = "";
        for ( Appointment a : this.book ){
            s += " - " + a.toString() + "\n";
        }
        return s;
    }

    public void add( String sDate, String description ) throws ParseException {
        this.book.add(new Appointment(sDate, description));
    }
    public void add(Appointment a) throws ParseException {
        this.book.add(a);
    }
}
