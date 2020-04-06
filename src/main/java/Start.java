import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) {

        Logger logger = LogManager.getLogger();
        Scanner scan = new Scanner(System.in);


        System.out.println("Ile godzin chcesz parkować?");
        int parkingTimeHours = scan.nextInt();

        System.out.println("Ile minut chcesz parkować?");
        int parkingTimeMinutes = scan.nextInt();

        LocalTime now = LocalTime.now();
        LocalTime calculatedFinishedParkingTime = now.plusHours(parkingTimeHours).plusMinutes(parkingTimeMinutes);

        LocalTime start = LocalTime.parse("08:00");
        LocalTime stop = LocalTime.parse("17:00");


//        LocalTime start = LocalTime.parse("08:00");
//        LocalTime stop = LocalTime.parse("17:00");
//        LocalTime start = now.isBefore(defaultStart) ? defaultStart : now;
//        LocalTime stop = now.isAfter(defaultStop) ? defaultStop : now;
//        long dur = Duration.between(start, stop).toMinutes();
//        double costParkingTime = CostParkingTime.costParkingTime(dur);

        double costParkingTime = 0;
        if (now.isBefore(start) && calculatedFinishedParkingTime.isAfter(start)) {
            long duration = Duration.between(start, calculatedFinishedParkingTime).toMinutes();
            costParkingTime = CostParkingTime.costParkingTime(duration);
        } else if (calculatedFinishedParkingTime.isAfter(stop) && now.isBefore(stop)) {
            long duration = Duration.between(now, stop).toMinutes();
            costParkingTime = CostParkingTime.costParkingTime(duration);
        } else if(calculatedFinishedParkingTime.isBefore(stop) && now.isAfter(start)) {
            long duration = Duration.between(now, calculatedFinishedParkingTime).toMinutes();
            costParkingTime = CostParkingTime.costParkingTime(duration);
        } else {
            costParkingTime=0;
        }

        DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm");

        logger.info("BILECIK:\n" +
                "DO ZAPLATY -> {}\n" +
                "CZAS POSTOJU -> OD {} DO {}\n" +
                "Data i Godzina zakupu biletu -> {}", 
                costParkingTime, 
                tf.format(now), tf.format(calculatedFinishedParkingTime),
                DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm").format(LocalDate.now()));
    }
}