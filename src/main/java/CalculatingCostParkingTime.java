public class CalculatingCostParkingTime {

    static int costParkingHourInPLN = 3;

    public static double costParkingTime(int parkingTimeMinutes) {
        if (parkingTimeMinutes <= 15) {
            return 0;
        }
        double sum = (parkingTimeMinutes * costParkingHourInPLN)/60;
        return sum;
    }
}
