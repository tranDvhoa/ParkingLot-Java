package parkinglot;

import java.util.Scanner;

public class ParkingProgram {
    public static void main() {
        Scanner scnr = new Scanner(System.in);
        new ParkingLot();

        while (true) {
            System.out.print("\n\n==========");
            System.out.print(" Parking Lot ");
            System.out.println("==========");
            System.out.println("\n1. Park Vehicle");
            System.out.println("2. Remove Vehicle");
            System.out.println("3. Find Vehicle");
            System.out.println("4. Display Parking Status");
            System.out.println("5. Display Available Spots");
            System.out.println("6. Display Revenue");
            System.out.println("7. Exit\n");
            System.out.print("Choose: ");

            int choice = scnr.nextInt();
            scnr.nextLine();

            //park vehicle
            if (choice == 1) {
                System.out.println("\n1. Motorcycle");
                System.out.println("2. Car");
                System.out.println("3. Truck");
                System.out.print("\nVehicle Type: ");
                int typeDigit = scnr.nextInt();
                VehicleType type = null;

                if (typeDigit == 1) {
                    type = VehicleType.MOTORCYCLE;
                } else if (typeDigit == 2) {
                    type = VehicleType.CAR;
                } else if (typeDigit == 3) {
                    type = VehicleType.TRUCK;
                }

                System.out.print("License Plate: ");
                scnr.nextLine();
                String licensePlate = scnr.nextLine();

                Vehicle vehicle = new Vehicle(type, licensePlate);
                String parkingStatus = ParkingLot.parkVehicle(vehicle, vehicle.getType());

                if (parkingStatus != null) {
                    System.out.println("\nVehicle parked successfully.");
                    System.out.println("Spot: " + parkingStatus);
                } else {
                    System.out.println("No available parking spot.");
                }
            }
            else if (choice == 2) {
                System.out.print("\n\nLicense Plate: ");
                String licensePlate = scnr.nextLine();
                ParkingSpot vehicleSpot = ParkingLot.findVehicle(licensePlate);

                if (vehicleSpot != null) {
                    Number[] parkingInfo = ParkingLot.unparkVehicle(vehicleSpot);
                    long duration = (long) parkingInfo[0];
                    double moneyCharge = (double) parkingInfo[1];
                    System.out.println("\nVehicle removed.");
                    System.out.println("Parking Time: " + duration + " seconds");
                    System.out.printf("Fee: $%.2f", moneyCharge);
                }
                else {
                    System.out.println("\nVehicle not found.");
                }

            }
            else if (choice == 3) {
                System.out.print("\n\nLicense Plate: ");
                String licensePlate = scnr.nextLine();

                ParkingSpot vehicleSpot = ParkingLot.findVehicle(licensePlate);
                if (vehicleSpot != null) {
                    System.out.println(vehicleSpot);
                }
                else {
                    System.out.println("\nVehicle not found.");
                }
            }
            else if (choice == 4) {
                int[] parkingStatus = ParkingLot.parkingStatus();

                System.out.println("\nMotorcycle Spots");
                System.out.println("Occupied: " + parkingStatus[0] + " / " + ParkingLot.getMotorLotSize());

                System.out.println("\nCompact Spots");
                System.out.println("Occupied: " + parkingStatus[1] + " / " + ParkingLot.getCompactLotSize());

                System.out.println("\nLarge Spots");
                System.out.println("Occupied: " + parkingStatus[2] + " / " + ParkingLot.getLargeLotSize());
            }
            else if (choice == 5) {
                int[] parkingStatus = ParkingLot.parkingStatus();

                System.out.println("\nMotorcycle: " + (ParkingLot.getMotorLotSize() - parkingStatus[0]));
                System.out.println("\nCompact: " + (ParkingLot.getCompactLotSize() - parkingStatus[1]));
                System.out.println("\nLarge: " + (ParkingLot.getLargeLotSize() - parkingStatus[2]));
            }
            else if (choice == 6) {
                double totalRevenue = ParkingLot.getTotalRevenue();
                System.out.printf("\n\nTotal Revenue: $%.0f", totalRevenue);
            }
            else if (choice == 7) {
                System.out.println("\nExited.");
                break;
            }
        }
    }
}
