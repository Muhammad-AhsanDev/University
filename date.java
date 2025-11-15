import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.text.DateFormatter;

public class date {
    public static void main(String[] args) {
        int counter =0;
        for(int i=1;i<=30;i++){
            
 LocalDateTime date = LocalDateTime.of(2025,2, i, 2, 3);
            
 DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd");
 String updated = formatter.format(date);
 System.out.print(updated+" ");
            counter+=1;
            if(counter%5==0){
                System.out.println();
            }
            
        

        }
    }
}
