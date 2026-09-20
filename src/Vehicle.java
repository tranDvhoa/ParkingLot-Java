package parkinglot;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Vehicle {

    private final VehicleType type;
    private final String plate;
    private final LocalDateTime unformattedEntryTime;
    private final String entryTime;

    public Vehicle(VehicleType vehicleType, String plateInfo) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        this.unformattedEntryTime = LocalDateTime.now();
        this.type = vehicleType;
        this.plate = plateInfo;
        this.entryTime = unformattedEntryTime.format(formatter);
    }

    @Override
    public String toString() {
        return "\n\nVehicle Type: " + this.type +
                "\nLicense Plate: " + this.plate +
                "\nTime Entered: " + this.entryTime;
    }

    public VehicleType getType() {
        return this.type;
    }

    public String getPlate() {
        return this.plate;
    }

    public String getTime() {
        return this.entryTime;
    }

    public LocalDateTime getUnformattedEntryTime() {
        return this.unformattedEntryTime;
    }

}