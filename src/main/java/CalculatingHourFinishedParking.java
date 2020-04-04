import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CalculatingHourFinishedParking {

    public static String updatedTime(int hours, int minutes) {
        LocalTime now  = java.time.LocalTime.now();
        LocalTime calculatingTime = now.plusHours(hours).plusMinutes(minutes);
        return calculatingTime.format(DateTimeFormatter.ofPattern("HH:mm"));
    }
}