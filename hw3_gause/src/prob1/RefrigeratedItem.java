package prob1;

public class RefrigeratedItem extends Item{

    private double temperature;

    public RefrigeratedItem(String name, double weight, double temperature) {
        super(name, weight);
        this.temperature = temperature;
    }

    public RefrigeratedItem(Item i, double temperature) {
        this(i.getName(), i.getWeight(), temperature);
    }

    public double getTemperature() {
        return temperature;
    }

    @Override
    public double cost() {
        return ((2 * this.getWeight()) + ((100 - temperature) * 0.1));
    }

    @Override
    public String toString() {
        return String.format("name=%s, cost=$%.2f, weight=%.2f, temp=%.2f degrees", this.getName(), cost(), this.getWeight(), temperature);
    }

    public static void main(String[] args) {
        Item i = new Item("xbox", 3.0);
        RefrigeratedItem r = new RefrigeratedItem(i, 10);

        System.out.println(r);
    }

}
