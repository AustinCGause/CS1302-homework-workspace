package prob1;

public class ItemTest {

	public static void main(String[] args) {
		testConstructor();
		testItemCost();
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
