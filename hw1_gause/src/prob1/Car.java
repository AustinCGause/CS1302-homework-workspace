package prob1;

public class Car {
    
    double fuelCapacity;
    double fuelEffeciency;
    double fuelLevel;
    double totalDistance;

    public Car(double fuelCapacity, double fuelEffeciency) {
        this(fuelCapacity, fuelEffeciency, 0);
    }

    public Car(double fuelCapacity, double fuelEffeciency, double fuelLevel) {
        this.fuelCapacity = fuelCapacity;
        this.fuelEffeciency = fuelEffeciency;
        this.fuelLevel = fuelLevel;
        this.totalDistance = 0;
    }

    public void drive(double time, double rate) {
        double potentialDistanceTraveled = time * rate;
        double maxTravelDistance = this.getFuelEffeciency() * this.getFuelLevel();
        double potentialFuelUsed = potentialDistanceTraveled / this.fuelEffeciency;

        if (potentialDistanceTraveled <= maxTravelDistance) {
            this.totalDistance += potentialDistanceTraveled;
            this.fuelLevel -= potentialFuelUsed;
        } else {
            this.totalDistance += maxTravelDistance;
            this.fuelLevel = 0.0;
        }
    }

    public void fillUp(double amount) {
        double potentialFuelLevel = this.getFuelLevel() + amount;
        this.fuelLevel = (potentialFuelLevel > fuelCapacity)? fuelCapacity : potentialFuelLevel;
    }

    public double getFuelCapacity() {
        return this.fuelCapacity;
    }

    public double getFuelEffeciency() {
        return this.fuelEffeciency;
    }

    public double getFuelLevel() {
        return this.fuelLevel;
    }

    public double getTotalDistance() {
        return this.totalDistance;
    }

    public String toString() {
        return String.format("fuelLevel=%.1f, totalDistance=%.1f, fuelCapacity=%.1f, fuelEffeciency=%.1f", this.getFuelLevel(), this.getTotalDistance(), this.getFuelCapacity(), this.getFuelEffeciency());
    }

}
