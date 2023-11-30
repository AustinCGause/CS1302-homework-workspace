package prob1;

public class ItemTest {

	public static void main(String[] args) {
		testConstructor();
		testItemCost();
		testEquals_Same_Name();
		testEquals_Different_Name();
		testToString();
	}

	/**
	 * Verify that the name & weight are initialized with the constructor.
	 */
	public static void testConstructor() {
		System.out.println("\n-->testConstructor");

		Item i = new Item("xbox", 2);

		System.out.println("Expected: name=xbox, weight=2.00");
		System.out.printf("  Actual: name=%s, weight=%.2f%n", i.getName(), i.getWeight());
	}

	/**
	 * Verify that the cost method works correctly.
	 */
	public static void testItemCost() {
		System.out.println("\n-->testItemCost");

		Item i = new Item("xbox", 2);

		System.out.println("Expected: $4.00");
		System.out.printf("  Actual: $%.2f%n", i.cost());
	}

	/*
	 * Verify that the equals method correctly compares the items
	 */
	public static void testEquals_Same_Name() {
		System.out.println("\n-->testEquals_Same_Name");

		Item i1 = new Item("xbox", 2);
		Item i2 = new Item("xbox", 5);

		System.out.println("Expected: true");
		System.out.println("  Actual: " + i1.equals(i2));

	}

	/*
	 * Verify that the equals method does falsely compares the items
	 */
	public static void testEquals_Different_Name() {
		System.out.println("\n-->testEquals_Different_Name");

		Item i1 = new Item("xbox", 2);
		Item i2 = new Item("playstation", 5);

		System.out.println("Expected: false");
		System.out.println("  Actual: " + i1.equals(i2));

	}

	/**
	 * Verify that the toString method produces a string exactly
	 * as specified in the assignment document.
	 */
	public static void testToString() {
		System.out.println("\n-->testToString");

		Item i = new Item("xbox", 2);

		System.out.println("Expected: name=xbox, cost=$4.00, weight=2.00");
		System.out.printf("  Actual: %s%n", i.toString());

		System.out.println("");
	}

}
