package prob1;

public class Item {

    private String name;
    private double weight;

    public Item(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double cost() {
        return weight * 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this.name.equals(((Item) o).getName())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("name=%s, cost=$%.2f, weight=%.2f", name, cost(), weight);
    }

}
