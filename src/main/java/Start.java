import java.time.LocalDateTime;
import java.time.LocalTime ;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Start {
    public static void main(String[] args) {

        Logger logger = LogManager.getLogger();

        Scanner scan = new Scanner(System.in);
        System.out.println("Ile godzin chcesz parkować?");
        int parkingTimeHours = scan.nextInt();

        System.out.println("Ile minut chcesz parkować?");
        int parkingTimeMinutes = scan.nextInt();

        float costParkingTime = CalculatingCostParkingTime.costParkingTime(parkingTimeHours, parkingTimeMinutes);
        String calculatingParkingTime = CalculatingHourFinishedParking.updatedTime(parkingTimeHours, parkingTimeMinutes);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm");

        logger.info("BILECIK:\n" +
                "DO ZAPLATY -> {}\n" +
                "CZAS POSTOJU -> OD {} DO {}\n" +
                "Data i Godzina zakupu biletu -> {}", costParkingTime, tf.format(now), calculatingParkingTime, dtf.format(now));

    }
}
