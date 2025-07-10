import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Simple Clock class for console display
 */
class ClockConsole {
    private Timer timer;
    private boolean isRunning = false;
    
    public void start() {
        if (isRunning) {
            System.out.println("L'horloge est déjà en marche!");
            return;
        }
        
        isRunning = true;
        timer = new Timer(true); // daemon thread
        
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date());
            }
        }, 0, 1000); // Start immediately, repeat every 1000ms
        
        System.out.println("Horloge démarrée!");
    }
    
    public void stop() {
        if (!isRunning) {
            System.out.println("L'horloge est déjà arrêtée!");
            return;
        }
        
        isRunning = false;
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        
        System.out.println("Horloge arrêtée!");
    }
}