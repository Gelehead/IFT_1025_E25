import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

class TryClock {
    Timer timer;
    boolean isRunning;

    public void start() {
        if ( this.isRunning == true ) { 
            System.out.println("l horloge est deja en marche");
            return ;
        }

        this.isRunning = true;
        timer = new Timer(true);

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date().toString());
            }
        }, 0, 1000);

        System.out.println("l'horloge a ete demarree");
    }

    public void stop() {
        if ( this.isRunning == false ) {
            System.out.println("l'horloge est deja arretee");
            return;
        }

        this.isRunning = false;

        if ( timer != null ) { 
            timer.cancel();
            timer = null;
        }

        System.out.println("l'horloge est arretee");
    }
}