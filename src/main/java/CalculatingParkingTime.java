public class CalculatingParkingTime {

    float parkingTimeHours = 0;
    float parkingTimeMinutes = 0;
    int costParkingHourInPLN = 3;

    public float costParkingTime(float parkingTimeHours, float parkingTimeMinutes) {
        float sum = (parkingTimeHours + (parkingTimeMinutes / 60)) * costParkingHourInPLN;
        return sum;
    }
}
