package prob1;

public class Warehouse {

    protected Item[] items = new Item[10];
    private int numItems = 0;

    public Warehouse() {}

    public void addItem(Item item) {
        if (numItems < items.length) {
            items[numItems++] = item;
        }
    }

    public Item getItem(int i) {
        if (i < 0 || i >= numItems) {
            return null;
        }
        return items[i];
    }

    public Item getItem(String name) {
        for (Item item : items) {
            if (item == null) {
                continue;
            }

            if (item.getName().equals(name)){
                return item;
            }
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

    public RefrigeratedItem[] getRefrigeratedItems() {
        int numRefrigeratedItems = 0;
        for (Item item : items) {
            if (item instanceof RefrigeratedItem) {
                numRefrigeratedItems++;
            }
        }

        RefrigeratedItem[] refrigeratedItems = new RefrigeratedItem[numRefrigeratedItems];

        int index = 0;
        for (Item item : items) {
            if (item instanceof RefrigeratedItem) {
                refrigeratedItems[index++] = ((RefrigeratedItem) item);
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
        if (i < 0 || i >= numItems || items[i] == null) {
            return null;
        }
        Item removedItem = items[i];
        
        for (int j = i; j < numItems - 1; j++) {
            items[j] = items[j + 1];
        }
        
        items[numItems - 1] = null; 
        numItems--;

        return removedItem;
    }

    public Item removeItem(String name) {
        for (int i = 0; i < numItems; i++) {
            if (items[i].getName().equals(name)) {
                return removeItem(i);
            }
        }
        return null;
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
