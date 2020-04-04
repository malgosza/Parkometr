import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Start {
    public static void main(String[] args){

        Logger logger = LogManager.getLogger();

        Scanner scan = new Scanner(System.in);
        System.out.println("Ile godzin chcesz parkować?");
        float parkingTimeHours=scan.nextInt();

        System.out.println("Ile minut chcesz parkować?");
        float parkingTimeMinutes=scan.nextInt();

        CalculatingParkingTime calculatingParkingTime=new CalculatingParkingTime();
        float costParkingTime=calculatingParkingTime.costParkingTime(parkingTimeHours,parkingTimeMinutes);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        logger.info("BILECIK:\n " +
                "DO ZAPLATY -> {}\n" +
                "CZAS POSTOJU -> OD 9:00 DO 12:00\n" +
                "DATA -> 03.04.2020\n" +
                "Data i Godzina zakupu biletu -> {}", costParkingTime, dtf.format(now));

    }
}
