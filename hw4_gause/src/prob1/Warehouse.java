package prob1;

import java.util.ArrayList;

public class Warehouse {

    protected ArrayList<Item> items = new ArrayList<Item>();
    private int numItems = 0;

    public Warehouse() {}

    public boolean addItem(Item item) {
        if (items.contains(item)) {
            return false;
        }

        items.add(item);
        numItems++;
        return true;
    }

    public Item getItem(int i) {
        if (i < 0 || i >= numItems) {
            return null;
        }
        
        return items.get(i);
    }

    public Item getItem(String name) {
        Item dummyItem = new Item(name, 0);
        int index = items.indexOf(dummyItem);

        if (index != -1) {
            return items.get(index);
        }
        return null;
    }

    public int getNumItems() {
        return numItems;
    }

    public double getAverageTemp() {
        double total = 0.00;
        double totalTemp = 0.00;
        for (Item item : items) {
            if (item instanceof RefrigeratedItem) {
                totalTemp += ((RefrigeratedItem) item).getTemperature();
                total++;
            }
        }
        return total == 0 ? 0 : totalTemp / total;
    }

    public ArrayList<RefrigeratedItem> getRefrigeratedItems() {
        ArrayList<RefrigeratedItem> refrigeratedItems = new ArrayList<RefrigeratedItem>();

        for (Item i : items) {
            if (i instanceof RefrigeratedItem) {
                refrigeratedItems.add((RefrigeratedItem) i);
            }
        }

        return refrigeratedItems;
    }

    public double getTotalCost() {
        double totalCost = 0.00;

        for (Item item : items) {
            if (item == null) {
                break;
            }
            totalCost += item.cost();
        }
        return totalCost;
    }

    public double getTotalCostRefrigerated() {
        double totalCostRefrigerated = 0.00;

        for (Item item : items) {
            if (item != null && item instanceof RefrigeratedItem) {
                totalCostRefrigerated += item.cost();
            }
        }
        return totalCostRefrigerated;
    }

    public Item removeItem(int i) {
        if (i < 0 || i >= numItems) {
            return null;
        }
        
        Item removedItem = items.get(i);
        items.remove(i);
        numItems--;
        
        return removedItem;
    }

    public Item removeItem(String name) {
        Item dummyItem = new Item(name, 0);

        if (items.contains(dummyItem)) {
            int index = items.indexOf(dummyItem);
            Item removedItem = items.get(index);
            items.remove(index);
            numItems--;
            return removedItem;
        }

        return null;
    }

    public ArrayList<Item> getItemsWithName(String partialName) {
        ArrayList<Item> matchingItems = new ArrayList<>();

        for (Item i : items) {
            if (i.getName().startsWith(partialName)) {
                matchingItems.add(i);
            }
        }

        return matchingItems;
    }

    public boolean hasItem(String name) {
        Item dummyItem = new Item(name, 0);
        return items.contains(dummyItem);
    }

    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();
        
        for (Item item : items) {
            if (item == null) {
                continue;
            }
            msg.append("\n" + item.toString());
        }
        return msg.toString();
    }

    public static void main(String[] args) {

        Item i1 = new Item("marble", 1.00);
        Item i2 = new Item("xbox", 4.00);
        Item i3 = new Item("football", 2.00);

        RefrigeratedItem r1 = new RefrigeratedItem("ice cream", 2.00, 10.00);
        RefrigeratedItem r2 = new RefrigeratedItem("milk", 5.00, 15.00);
        
        Warehouse w = new Warehouse();
        w.addItem(i1);
        w.addItem(i2);
        w.addItem(i3);
        w.addItem(r1);
        w.addItem(r2);

        System.out.println(w.getAverageTemp());
        for (RefrigeratedItem r : w.getRefrigeratedItems()) {
            System.out.println(r);
        }
        
        System.out.println(w.getTotalCost());
        System.out.println(w.getTotalCostRefrigerated());
        System.out.println(w.removeItem(2));

        System.out.println(w.toString());

    }
}
