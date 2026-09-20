package parkinglot;

public enum VehicleType {
    MOTORCYCLE(3.00),
    CAR(5.00),
    TRUCK(8.00);

    private final double fifteenSecondsRate;

    VehicleType(double fifteenSecondsRate) {
        this.fifteenSecondsRate = fifteenSecondsRate;
    }

    public double getFifteenSecondsRate() {
        return this.fifteenSecondsRate;
    }
}