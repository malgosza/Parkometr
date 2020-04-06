public class CostParkingTime {

    static int costParkingHourInPLN = 3;

    public static double costParkingTime(long parkingTimeMinutes) {
        if (parkingTimeMinutes <= 15) {
            return 0;
        }
        double sum = ((double) parkingTimeMinutes * costParkingHourInPLN)/60;
        return sum;
    }
}
