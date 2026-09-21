package parkinglot.src;

public class ParkingSpot {
    private final String spotID;
    private Vehicle parkedVehicle;

    public ParkingSpot(String spotID) {
        this.spotID = spotID;
        this.parkedVehicle = null;
    }

    public boolean isAvailable() {
        return parkedVehicle == null;
    }

    @Override
    public String toString() {
        if (!isAvailable()) {
            return "\nLicense Plate: " + this.parkedVehicle.getPlate() +
                    "\nVehicle Type: " + this.parkedVehicle.getType() +
                    "\nParking Spot: " + this.spotID +
                    "\nTime Entered: " + this.parkedVehicle.getTime();
        }
        else {
            return "\nThere is no car parking at this spot." +
                    "\nParking Spot: " + this.spotID;
        }
    }

    public void assignVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
    }

    public void removeVehicle() {
        this.parkedVehicle = null;
    }

    public String getSpotID() {
        return this.spotID;
    }

    public Vehicle getParkedVehicle() {
        return this.parkedVehicle;
    }
}