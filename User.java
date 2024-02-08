import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String location;
    private double electricityRate; // Cost per kWh
    private List<Appliance> appliances;

    public User(String name, String location) {
        this.name = name;
        this.location = location;
        this.electricityRate = 0.12; // Default electricity rate
        this.appliances = new ArrayList<>();
    }

    public void addAppliance(String name, double powerConsumption, double usagePerHour) {
        appliances.add(new Appliance(name, powerConsumption, usagePerHour));
    }

    public double calculateTotalKilowatts() {
        double totalKilowatts = 0;
        for (Appliance appliance : appliances) {
            totalKilowatts += appliance.calculateKilowatts();
        }
        return totalKilowatts;
    }

    public double getElectricityRate() {
        return electricityRate;
    }

    // Inner class Appliance
    public class Appliance {
        private String name;
        private double powerConsumption; // in watts
        private double usagePerHour; // in hours

        public Appliance(String name, double powerConsumption, double usagePerHour) {
            this.name = name;
            this.powerConsumption = powerConsumption;
            this.usagePerHour = usagePerHour;
        }

        public double calculateKilowatts() {
            return powerConsumption * usagePerHour / 1000; // Convert watts to kilowatts
        }
    }
}
