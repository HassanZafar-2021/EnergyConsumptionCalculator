import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Energy Consumption Calculator!");

        // Get user information
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your location (city, state): ");
        String location = scanner.nextLine();
        System.out.print("Enter your electricity rate ($/kWh): ");
        double electricityRate = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character
        User user = new User(name, location, electricityRate);

        // Ask user for number of appliances
        int numAppliances = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Number of appliances: ");
                String input = scanner.nextLine();
                numAppliances = Integer.parseInt(input.trim());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        // Gather information for each appliance
        for (int i = 0; i < numAppliances; i++) {
            System.out.println("Appliance " + (i + 1) + ":");
            System.out.print("Name: ");
            String applianceName = scanner.nextLine();
            System.out.print("Power consumption per hour (in watts): ");
            double powerConsumption = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character after reading a double
            System.out.print("Usage per hour (in hours): ");
            double usagePerHour = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character after reading a double
            user.addAppliance(applianceName, powerConsumption, usagePerHour);
        }

        // Calculate energy consumption and cost
        double totalKilowatts = user.calculateTotalKilowatts();
        double totalCost = totalKilowatts * user.getElectricityRate();
        System.out.println("Total energy consumption: " + totalKilowatts + " kWh");
        System.out.println("Total cost: $" + totalCost);

        // Open GUI for further calculations or visualization
        GUI gui = new GUI(user);
        gui.display();

        // Close the scanner
        scanner.close();
    }
}
