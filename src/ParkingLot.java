package parkinglot.src;

import java.time.Duration;
import java.time.LocalDateTime;

public class ParkingLot {
    private final int motorLotSize = 20;
    private final int compactLotSize = 30;
    private final int largeLotSize = 10;
    private double cashier = 0;
    private double totalRevenue = 0;

    private ParkingSpot[] motorcycleSpots = new ParkingSpot[motorLotSize];
    private ParkingSpot[] compactSpots = new ParkingSpot[compactLotSize];
    private ParkingSpot[] largeSpots = new ParkingSpot[largeLotSize];

    public ParkingLot() {
        for (int i = 0; i < motorcycleSpots.length; i++) {
            motorcycleSpots[i] = new ParkingSpot("M-" + (i + 1));
        }

        for (int i = 0; i < compactSpots.length; i++) {
            compactSpots[i] = new ParkingSpot("C-" + (i + 1));
        }

        for (int i = 0; i < largeSpots.length; i++) {
            largeSpots[i] = new ParkingSpot("L-" + (i + 1));
        }
    }

    public int getMotorLotSize() {
        return motorLotSize;
    }

    public int getCompactLotSize() {
        return compactLotSize;
    }

    public int getLargeLotSize() {
        return largeLotSize;
    }

    public String parkVehicle(Vehicle vehicle, VehicleType vehicleType) {
        if (vehicleType == VehicleType.MOTORCYCLE) {
            for (ParkingSpot spot : motorcycleSpots) {
                if (spot.isAvailable()) {
                    spot.assignVehicle(vehicle);
                    return spot.getSpotID();
                }
            }
        }

        if (vehicleType == VehicleType.MOTORCYCLE || vehicleType == VehicleType.CAR) {
            for (ParkingSpot spot : compactSpots) {
                if (spot.isAvailable()) {
                    spot.assignVehicle(vehicle);
                    return spot.getSpotID();
                }
            }
        }

        if (vehicleType == VehicleType.MOTORCYCLE || vehicleType == VehicleType.CAR || vehicleType == VehicleType.TRUCK) {
            for (ParkingSpot spot : largeSpots) {
                if (spot.isAvailable()) {
                    spot.assignVehicle(vehicle);
                    return spot.getSpotID();
                }
            }
        }
        return null;
    }

    public Number[] unparkVehicle(ParkingSpot vehicleSpot) {
        long duration = parkingDuration(vehicleSpot);
        double moneyCharge = vehicleCharge(vehicleSpot, duration);
        cashier += moneyCharge;
        vehicleSpot.removeVehicle();
        return new Number[] {duration, moneyCharge};
    }

    public int[] parkingStatus() {
        int motorSpotsOccupied = 0;
        for (ParkingSpot spot : motorcycleSpots) {
            if (!spot.isAvailable()) {
                motorSpotsOccupied++;
            }
        }

        int compactSpotsOccupied = 0;
        for (ParkingSpot spot: compactSpots) {
            if (!spot.isAvailable()) {
                compactSpotsOccupied++;
            }
        }

        int largeSpotsOccupied = 0;
        for (ParkingSpot spot: largeSpots) {
            if (!spot.isAvailable()) {
                largeSpotsOccupied++;
            }
        }
        return new int[] {motorSpotsOccupied, compactSpotsOccupied, largeSpotsOccupied};
    }

    public ParkingSpot findVehicle(String licensePlate) {
        for (ParkingSpot spot : motorcycleSpots) {
            if (spot.getParkedVehicle() != null && spot.getParkedVehicle().getPlate().equals(licensePlate)) {
                return spot;
            }
        }

        for (ParkingSpot spot : compactSpots) {
            if (spot.getParkedVehicle() != null && spot.getParkedVehicle().getPlate().equals(licensePlate)) {
                return spot;
            }
        }

        for (ParkingSpot spot : largeSpots) {
            if (spot.getParkedVehicle() != null && spot.getParkedVehicle().getPlate().equals(licensePlate)) {
                return spot;
            }
        }
        return null;
    }

    public long parkingDuration(ParkingSpot vehicleSpot) {
        LocalDateTime exitTime = LocalDateTime.now();
        Duration duration  = Duration.between(vehicleSpot.getParkedVehicle().getUnformattedEntryTime(), exitTime);
        long durationInSec = duration.toSeconds();

        return durationInSec;
    }

    public double vehicleCharge(ParkingSpot vehicleSpot, long durationInSec) {
        int fifteenSecBlocks = (int) (durationInSec + 15 - 1) / 15;
        double dollarPerFifteenSec = vehicleSpot.getParkedVehicle().getType().getFifteenSecondsRate();
        double moneyCharge = dollarPerFifteenSec * fifteenSecBlocks;

        return moneyCharge;
    }


    public double getTotalRevenue() {
        double motorSpotRevenue = 0;
        double compactSpotRevenue = 0;
        double largeSpotRevenue = 0;

        for (ParkingSpot spot : motorcycleSpots) {
            if (!spot.isAvailable()) {
                long duration = parkingDuration(spot);
                motorSpotRevenue = vehicleCharge(spot, duration);
            }
        }

        for (ParkingSpot spot : compactSpots) {
            if (!spot.isAvailable()) {
                long duration = parkingDuration(spot);
                compactSpotRevenue = vehicleCharge(spot, duration);
            }
        }

        for (ParkingSpot spot : largeSpots) {
            if (!spot.isAvailable()) {
                long duration = parkingDuration(spot);
                largeSpotRevenue = vehicleCharge(spot, duration);
            }
        }

        totalRevenue = (motorSpotRevenue + compactSpotRevenue + largeSpotRevenue) + cashier;

        return totalRevenue;
    }

}
