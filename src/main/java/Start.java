import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) {

        Logger logger = LogManager.getLogger();
        Scanner scan = new Scanner(System.in);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime date = LocalDateTime.now();

        System.out.println("Ile godzin chcesz parkować?");
        int parkingTimeHours = scan.nextInt();

        System.out.println("Ile minut chcesz parkować?");
        int parkingTimeMinutes = scan.nextInt();

        LocalTime now = LocalTime.now();
        LocalTime calculatingFinishedParkingTime = now.plusHours(parkingTimeHours).plusMinutes(parkingTimeMinutes);

        LocalTime eightOclock = LocalTime.parse("08:00");
        LocalTime seventeenOclock = LocalTime.parse("17:00");
        double costParkingTime = 0;

        if (now.isBefore(eightOclock) && calculatingFinishedParkingTime.isAfter(eightOclock)) {
            long duration = Duration.between(eightOclock, calculatingFinishedParkingTime).toMinutes();
            costParkingTime = CalculatingCostParkingTime.costParkingTime((double) duration);
        } else if (calculatingFinishedParkingTime.isAfter(seventeenOclock) && now.isBefore(seventeenOclock)) {
            long duration = Duration.between(now, seventeenOclock).toMinutes();
            costParkingTime = CalculatingCostParkingTime.costParkingTime((double) duration);
        } else if((now.isBefore(eightOclock) && calculatingFinishedParkingTime.isBefore(eightOclock)) || (now.isAfter(seventeenOclock) && calculatingFinishedParkingTime.isAfter(seventeenOclock)) || now.equals(seventeenOclock)){
            costParkingTime=0;
        }
        else {
            long duration = Duration.between(now, calculatingFinishedParkingTime).toMinutes();
            costParkingTime = CalculatingCostParkingTime.costParkingTime((double) duration);
        }

        logger.info("BILECIK:\n" +
                "DO ZAPLATY -> {}\n" +
                "CZAS POSTOJU -> OD {} DO {}\n" +
                "Data i Godzina zakupu biletu -> {}", costParkingTime, tf.format(date), tf.format(calculatingFinishedParkingTime), dtf.format(date));
    }
}