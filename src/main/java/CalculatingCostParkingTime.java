public class CalculatingCostParkingTime {

    static int costParkingHourInPLN = 3;

    public static float costParkingTime(int parkingTimeHours, int parkingTimeMinutes) {
        float sum = (parkingTimeHours + (parkingTimeMinutes / 60)) * costParkingHourInPLN;
        return sum;
    }
}
