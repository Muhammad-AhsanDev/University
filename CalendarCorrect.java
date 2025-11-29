import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CalendarCorrect {
    public static void main(String[] args) {

        // Week header
        System.out.println("MON TUE WED THU FRI SAT SUN");

        int year = 2025;
        int month = 10;

        LocalDate first = LocalDate.of(year, month, 1);
        DayOfWeek firstDay = first.getDayOfWeek();

        // Monday = 1 ... Sunday = 7
        int startPos = firstDay.getValue();  

        // Print empty slots before the 1st
        for (int i = 1; i < startPos; i++) {
            System.out.print("    ");
        }

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd");

        // Print all dates
        for (int d = 1; d <= first.lengthOfMonth(); d++) {
            LocalDate date = LocalDate.of(year, month, d);

            System.out.printf("%3s ", fmt.format(date));

            if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                System.out.println();  // new line at end of week
            }
        }
    }
}
