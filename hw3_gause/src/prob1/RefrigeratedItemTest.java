package prob1;

public class RefrigeratedItemTest {

	public static void main(String[] args) {
		testConstructorMain();
		testConstructorAcceptsItem();
		testItemCost();
		testToString();
	}
	
	/**
	 * Verify that the name, weight, & temp are initialized with the main constructor.
	 */
	public static void testConstructorMain() {
		System.out.println("\n-->testConstructorMain"); 

		RefrigeratedItem r = new RefrigeratedItem("Ice Cream", 3.00, 10.00);

		System.out.println("Expected: name=Ice Cream, weight=3.00, temperature=10.00");
		System.out.printf("  Actual: name=%s, weight=%.2f, temperature=%.2f%n", r.getName(), r.getWeight(), r.getTemperature());
	}

	/**
	 * Verify that the name, weight, & temp are initialized with the second constructor.
	 */
	public static void testConstructorAcceptsItem() {
		System.out.println("\n-->testConstructorAcceptsItem"); 

		Item i = new Item("Milk", 5.00);
		RefrigeratedItem r = new RefrigeratedItem(i, 5.00);
		
		System.out.println("Expected: name=Milk, weight=5.00, temperature=5.00");
		System.out.printf("  Actual: name=%s, weight=%.2f, temperature=%.2f%n", r.getName(), r.getWeight(), r.getTemperature());
	}

	/**
	 * Verify that the cost method works correctly.
	 */
	public static void testItemCost() {
		System.out.println("\n-->testItemCost"); 
		RefrigeratedItem r = new RefrigeratedItem("Ice Cream", 3.00, 10.00);

		System.out.println("Expected: $15.00");
		System.out.printf("  Actual: $%.2f%n", r.cost());
	}

	/**
	 * Verify that the toString method produces a string exactly
	 * as specified in the assignment document. 
	 */
	public static void testToString() {
		System.out.println("\n-->testToString"); 

		RefrigeratedItem r = new RefrigeratedItem("Ice Cream", 3.00, 10.00);
		
		System.out.println("Expected: name=Ice Cream, cost=$15.00, weight=3.00, temp=10.00 degrees");
		System.out.println("  Actual: " +r.toString() + "\n");
	}

}
