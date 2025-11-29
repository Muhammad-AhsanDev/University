import java.util.Timer;
import java.util.TimerTask;

public class timeing {

    public static void main(String[] args) {
        Timer timer = new Timer();
         
        TimerTask task = new TimerTask() {
int count =0;
            @Override
            public void run() {
                // TODO Auto-generated method stub
               
                System.out.println(count);
                count++;
                if(count==10){
                    timer.cancel();
                }
            }
            
        };
        timer.schedule(task, 0,1000);
    }
}
