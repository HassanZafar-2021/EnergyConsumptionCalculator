import java.util.ArrayList;
import java.util.List;

class User {
    private String name;
    private String location;
    private List<Appliance> appliances;
    private double electricityRate;

    public User(String name, String location, double electricityRate) {
        this.name = name;
        this.location = location;
        this.appliances = new ArrayList<>();
        this.electricityRate = electricityRate;
    }

    public void addAppliance(String name, double powerConsumption, double usagePerHour) {
        appliances.add(new Appliance(name, powerConsumption, usagePerHour));
    }

    public double calculateTotalKilowatts() {
        double totalKilowatts = 0;
        for (Appliance appliance : appliances) {
            totalKilowatts += (appliance.getPowerConsumption() * appliance.getUsagePerHour()) / 1000.0;
        }
        return totalKilowatts;
    }

    public double getElectricityRate() {
        return electricityRate;
    }
}

class Appliance {
    private String name;
    private double powerConsumption; // in watts
    private double usagePerHour; // in hours

    public Appliance(String name, double powerConsumption, double usagePerHour) {
        this.name = name;
        this.powerConsumption = powerConsumption;
        this.usagePerHour = usagePerHour;
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public double getUsagePerHour() {
        return usagePerHour;
    }
}
