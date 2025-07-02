import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class Appointment {
    private Date date;
    private String description;

    public Appointment(String sDate, String description) throws ParseException {
        this.description = description;
        this.date = DateFormat.getInstance().parse(sDate);
    }

    @Override
    public String toString(){
        return DateFormat.getInstance().format(date) + " - " + description;
    }

}
