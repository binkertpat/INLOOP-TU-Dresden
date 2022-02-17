import java.util.Random;

public class VehicleGenerator {
    private Random randomGenerator;

    public VehicleGenerator(){
        randomGenerator = new Random();
    }

    public Vehicle createVehicle(){
        return switch (randomGenerator.nextInt(3)) {
            case 1 -> new Bus();
            case 2 -> new Car();
            default -> new Bicycle();
        };
    }
}
