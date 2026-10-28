# Parking Lot Simulation

A Java-based console application simulating a parking lot management system.

## Features

This application allows users to interact with a simulated parking lot using a command-line interface. Features include:
- **Park Vehicle**: Park different types of vehicles (Motorcycles, Cars, Trucks).
  - Motorcycles can park in motorcycle, compact, or large spots.
  - Cars can park in compact or large spots.
  - Trucks can only park in large spots.
- **Remove Vehicle**: Remove a parked vehicle using its license plate, calculating the duration of the stay and the fee based on the vehicle type.
- **Find Vehicle**: Search for a parked vehicle by its license plate to see its details and spot.
- **Display Parking Status**: View the number of occupied spots versus total spots for each category.
- **Display Available Spots**: View the number of available spots in each category.
- **Display Revenue**: Check the total revenue accumulated from removed vehicles and currently parked vehicles.

## Rates

Fees are charged in 15-second blocks for simulation purposes. The rates are as follows:
- Motorcycle: $3.00 / 15 seconds
- Car: $5.00 / 15 seconds
- Truck: $8.00 / 15 seconds

## Project Structure

- `src/ParkingProgram.java`: Main entry point for the application. Contains the CLI loop and menu.
- `src/ParkingLot.java`: Core logic for managing parking spots, assigning vehicles, checking status, and calculating revenue.
- `src/ParkingSpot.java`: Represents an individual parking spot.
- `src/Vehicle.java`: Represents a vehicle with a license plate and type.
- `src/VehicleType.java`: Enum containing vehicle types and their associated charging rates.

## How to Compile and Run

Make sure you have a Java Development Kit (JDK) installed.

### Compilation

To compile the source code, open a terminal in the root directory of the repository and run:

```sh
javac -d . src/*.java
```

This will compile the `.java` files and place the compiled `.class` files into the `parkinglot/src/` directory (matching the package structure).

### Running the Application

After compiling, you can run the application with the following command from the root directory:

```sh
java parkinglot.src.ParkingProgram
```

Follow the on-screen prompts to interact with the parking lot system!
