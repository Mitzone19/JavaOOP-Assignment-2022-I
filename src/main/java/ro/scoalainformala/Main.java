package ro.scoalainformala;

import ro.scoalainformala.models.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Car selectedCar = null;

        while (true) {
            System.out.println("==== Car Selection Menu ====");
            System.out.println("1. Select Logan");
            System.out.println("2. Select CKlasse");
            System.out.println("3. Select Model3");
            System.out.println("4. Select SKlasse");
            System.out.println("5. Select VWGolf");
            System.out.println("6. Select VWPassat");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            if (choice >= 1 && choice <= 6) {
                System.out.print("Enter available fuel (in liters): ");
                int availableFuel = scanner.nextInt();
                System.out.print("Enter chassis number: ");
                String chassisNumber = scanner.next();

                selectedCar = createCar(choice, availableFuel, chassisNumber);
                System.out.println(selectedCar.getClass().getSimpleName() + " selected.");
            } else if (choice == 7) {
                System.out.println("Exiting the program.");
                scanner.close();
                System.exit(0);
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

            if (selectedCar != null) {
                // Perform car-related actions
                performCarActions(selectedCar, scanner);
            }
        }
    }

    private static Car createCar(int choice, int availableFuel, String chassisNumber) {
        switch (choice) {
            case 1:
                return new Logan(availableFuel, chassisNumber);
            case 2:
                return new CKlasse(availableFuel, chassisNumber);
            case 3:
                return new Model3(availableFuel, chassisNumber);
            case 4:
                return new SKlasse(availableFuel, chassisNumber);
            case 5:
                return new VWGolf(availableFuel, chassisNumber);
            case 6:
                return new VWPassat(availableFuel, chassisNumber);
            default:
                return null;
        }
    }

    private static void performCarActions(Car car, Scanner scanner) {
        while (true) {
            System.out.println("==== " + car.getClass().getSimpleName() + " Menu ====");
            System.out.println("1. Start the car");
            System.out.println("2. Stop the car");
            System.out.println("3. Shift gear");
            System.out.println("4. Drive");
            System.out.println("5. Check fuel and distance");
            System.out.println("6. Back to car selection");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    car.start();
                    System.out.println(car.getClass().getSimpleName() + " started.");
                    break;
                case 2:
                    car.stop();
                    System.out.println(car.getClass().getSimpleName() + " stopped.");
                    break;
                case 3:
                    System.out.print("Enter gear (1-6): ");
                    int gear = scanner.nextInt();
                    car.shiftGear(gear);
                    System.out.println("Shifted to gear " + gear);
                    break;
                case 4:
                    System.out.print("Enter distance to drive (in km): ");
                    double distance = scanner.nextDouble();
                    car.drive(distance);
                    System.out.println("Driving...");
                    break;
                case 5:
                    System.out.println("Fuel: " + car.getAvailableFuel() + " liters");
                    System.out.println("Distance traveled: " + car.getKmCounter() + " km");
                    System.out.println("Average Fuel Consumption: " + car.getAverageFuelConsumption() + " liters/100km");
                    break;
                case 6:
                    System.out.println("Returning to car selection menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}