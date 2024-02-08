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
        User user = new User(name, location);

        // Ask user for appliance information
        System.out.println("Enter information for each appliance you use:");
        int numAppliances = 3; // Change this to the desired number of appliances
        for (int i = 0; i < numAppliances; i++) {
            System.out.println("Appliance " + (i+1) + ":");
            System.out.print("Name: ");
            String applianceName = scanner.nextLine();
            System.out.print("Power consumption per hour (in watts): ");
            double powerConsumption = scanner.nextDouble();
            System.out.print("Usage per hour (in hours): ");
            double usagePerHour = scanner.nextDouble();
            user.addAppliance(applianceName, powerConsumption, usagePerHour);
            scanner.nextLine(); // Consume newline
        }

        // Calculate energy consumption and cost
        double totalKilowatts = user.calculateTotalKilowatts();
        double totalCost = totalKilowatts * user.getElectricityRate();
        System.out.println("Total energy consumption: " + totalKilowatts + " kWh");
        System.out.println("Total cost: $" + totalCost);

        // Open GUI for further calculations or visualization
        GUI gui = new GUI(user);
        gui.display();
    }
}
