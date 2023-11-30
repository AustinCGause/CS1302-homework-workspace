package prob1;

import java.util.ArrayList;

public class WarehouseTest {

	public static void main(String[] args) {
		testAddItem();
		testAddItem_Duplicate();
		testAddItem_Multiple();
		testAddItem_Multiple_11_Items();
		testGetItem_WithIndex();
		testGetItem_WithIndex_Negative();
		testGetItem_WithName();
		testGetItem_WithName_Unknown();
		testGetItems_WithName();
		testGetAverageTemp();
		testGetAverageTemp_No_Refrigerated_Items();
		testGetRefrigeratedItems();
		testGetRefrigeratedItems_No_Items();
		testGetTotalCost();
		testGetTotalCost_No_Items();
		testGetTotalCostRefrigerated();
		testGetTotalCostRefrigerated_No_Refrigerated_Items();
		testRemoveItem_WithIndex();
		testRemoveItem_WithIndex_Negative();
		testRemoveItem_WithName();
		testRemoveItem_WithName_Unknown();
		testHasItem_Find();
		testHasItem_NoFind();
		testToString();
	}
	
	/**
	 * Add one item and check the number of items to verify.
	 */
	public static void testAddItem() {
		System.out.println("\n-->testAddItem"); 
		
		Item i = new Item("xbox", 5.00);
		Warehouse w = new Warehouse();
		w.addItem(i);

		System.out.println("Expected: 1");
		System.out.println("  Actual: " + w.getNumItems());
	}

	/**
	 * Add one duplicate item and ensure it wasn't added.
	 */
	public static void testAddItem_Duplicate() {
		System.out.println("\n-->testAddItem_Duplicate"); 
		
		Item i1 = new Item("xbox", 5.00);
		Item i2 = new Item("xbox", 11.00);
		Warehouse w = new Warehouse();
		w.addItem(i1);
		w.addItem(i2);

		System.out.println("Expected: 1");
		System.out.println("  Actual: " + w.getNumItems());
	}
	
	/**
	 * Add three items and check the number of items to verify. At least one should be a refrigerated item.
	 */
	public static void testAddItem_Multiple() {
		System.out.println("\n-->testAddItem_Multiple"); 
		
		Item i1 = new Item("xbox", 5.00);
		Item i2 = new Item("cheese", 3.00);
		Item i3 = new Item("ice cream", 1.00);
		Warehouse w = new Warehouse();
		w.addItem(i1);
		w.addItem(i2);
		w.addItem(i3);

		System.out.println("Expected: 3");
		System.out.println("  Actual: " + w.getNumItems());
	}

	public static void testAddItem_Multiple_11_Items() {
		System.out.println("\n-->testAddItem_Multiple_11_Items");

		Item i1 = new Item("xbox", 5.00);
		Item i2 = new Item("cheese", 3.00);
		Item i3 = new Item("ice cream", 1.00);
		Item i4 = new Item("computer", 2.00);
		Item i5 = new Item("soccer ball", 4.00);
		Item i6 = new Item("nintendo", 6.00);
		Item i7 = new Item("playstation", 7.00);
		Item i8 = new Item("pen", 8.00);
		Item i9 = new Item("pencil", 10.00);
		Item i10= new Item("headphones", 9.00);
		Item i11= new Item("pickaxe",11.00);

		Warehouse w = new Warehouse();
		w.addItem(i1);
		w.addItem(i2);
		w.addItem(i3);
		w.addItem(i4);
		w.addItem(i5);
		w.addItem(i6);
		w.addItem(i7);
		w.addItem(i8);
		w.addItem(i9);
		w.addItem(i10);
		w.addItem(i11);
		
		System.out.println("Expected: 11");
		System.out.println("  Actual: " + w.getNumItems());
	}
	
	/**
	 * Add three items and retrieve the one at index 1.
	 */
	public static void testGetItem_WithIndex() {
		System.out.println("\n-->testGetItem_WithIndex"); 
		
		Item i1 = new Item("xbox", 5.00);
		Item i2 = new Item("cheese", 3.00);
		Item i3 = new Item("ice cream", 1.00);
		Warehouse w = new Warehouse();
		w.addItem(i1);
		w.addItem(i2);
		w.addItem(i3);

		System.out.println("Expected: cheese");
		System.out.println("  Actual: " + w.getItem(1).getName());
	}

	public static void testGetItem_WithIndex_Negative() {
		System.out.println("\n-->testGetItem_WithIndex_Negative"); 
		
		Item i1 = new Item("xbox", 5.00);
		Item i2 = new Item("cheese", 3.00);
		Item i3 = new Item("ice cream", 1.00);
		Warehouse w = new Warehouse();
		w.addItem(i1);
		w.addItem(i2);
		w.addItem(i3);

		System.out.println("Expected: null");
		System.out.println("  Actual: " + w.getItem(-1));
	}

	/**
	 * Add three items and try to find one with a name that exists.
	 */
	public static void testGetItem_WithName() {
		System.out.println("\n-->testGetItem_WithName"); 
		
		Item i1 = new Item("xbox", 5.00);
		Item i2 = new Item("cheese", 3.00);
		Item i3 = new Item("ice cream", 1.00);
		Warehouse w = new Warehouse();
		w.addItem(i1);
		w.addItem(i2);
		w.addItem(i3);

		System.out.println("Expected: xbox");
		System.out.println("  Actual: " + w.getItem("xbox").getName());
	}

	public static void testGetItem_WithName_Unknown() {
		System.out.println("\n-->testGetItem_WithName_Unknown"); 
		
		Item i1 = new Item("xbox", 5.00);
		Item i2 = new Item("cheese", 3.00);
		Item i3 = new Item("ice cream", 1.00);
		Warehouse w = new Warehouse();
		w.addItem(i1);
		w.addItem(i2);
		w.addItem(i3);

		System.out.println("Expected: null");
		System.out.println("  Actual: " + w.getItem("unknown"));
	}

	/**
	 * Add three items and return all with matching partial names;
	 */
	public static void testGetItems_WithName() {
		System.out.println("\n-->testGetItems_WithName"); 
		
		Item i1 = new Item("xbox", 5.00);
		Item i2 = new Item("cheese", 3.00);
		Item i3 = new Item("ice cream", 1.00);
		Item i4 = new Item("xbox 360", 1.00);
		Item i5 = new Item("xbox one", 1.00);
		Warehouse w = new Warehouse();
		w.addItem(i1);
		w.addItem(i2);
		w.addItem(i3);
		w.addItem(i4);
		w.addItem(i5);

		ArrayList<Item> matchingItems = new ArrayList<Item>(w.getItemsWithName("xbox"));

		System.out.println("Expected: xbox\nExpected: xbox 360\nExpected: xbox one\n");
		for (Item i : matchingItems) {
			System.out.println("  Actual: " + i.getName());
		}
	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Verify the average temperature.
	 */
	public static void testGetAverageTemp() {
		System.out.println("\n-->testGetAverageTemp"); 
		
		Item i1 = new Item("xbox", 5.00);
		Item i2 = new Item("playstation", 3.00);
		RefrigeratedItem r1 = new RefrigeratedItem("ice cream", 2.00, 10.00);
		RefrigeratedItem r2 = new RefrigeratedItem("pizza", 6.00, 15.00);
		RefrigeratedItem r3 = new RefrigeratedItem("cheese", 4.00, 20.00);

		Warehouse w = new Warehouse();
		w.addItem(i1);
		w.addItem(i2);
		w.addItem(r1);
		w.addItem(r2);
		w.addItem(r3);
		
		System.out.println("Expected: 15.0");
		System.out.println("  Actual: " + w.getAverageTemp());
	}

	public static void testGetAverageTemp_No_Refrigerated_Items() {
		System.out.println("\n-->testGetAverageTemp_No_Refrigered_Items"); 
		
		Item i1 = new Item("xbox", 5.00);
		Item i2 = new Item("playstation", 3.00);

		Warehouse w = new Warehouse();
		w.addItem(i1);
		w.addItem(i2);
		
		System.out.println("Expected: 0.0");
		System.out.println("  Actual: " + w.getAverageTemp());
	}
	
	/**
	 * Add 5 items, 3 of which are refrigerated. Verify that the 3 are returned in array.
	 */
	public static void testGetRefrigeratedItems() {
		System.out.println("\n-->testGetRefrigeratedItems"); 
		
		Item i1 = new Item("xbox", 5.00);
		Item i2 = new Item("playstation", 3.00);
		RefrigeratedItem r1 = new RefrigeratedItem("ice cream", 2.00, 10.00);
		RefrigeratedItem r2 = new RefrigeratedItem("pizza", 6.00, 15.00);
		RefrigeratedItem r3 = new RefrigeratedItem("cheese", 4.00, 20.00);

		Warehouse w = new Warehouse();
		w.addItem(i1);
		w.addItem(i2);
		w.addItem(r1);
		w.addItem(r2);
		w.addItem(r3);
		
		System.out.println("Expected: ice cream\nExpected: pizza\nExpected: cheese\n");

		for (Item item : w.getRefrigeratedItems()) {
			System.out.println("  Actual: " + item.getName());
		}
	}

	public static void testGetRefrigeratedItems_No_Items() {
		System.out.println("\n-->testGetRefrigeratedItems_No_Items"); 
		
		Warehouse w = new Warehouse();
		
		System.out.println("Expected:");

		System.out.println("  Actual:");

		for (Item item : w.getRefrigeratedItems()) {
			System.out.println(item);
		}
	}
	
	/**
	 * Add 5 items, 3 of which are refrigerated. Verify the total cost.
	 */
	public static void testGetTotalCost() {
		System.out.println("\n-->testGetTotalCost"); 
		
		Item i1 = new Item("xbox", 5.00);
		Item i2 = new Item("playstation", 3.00);
		RefrigeratedItem r1 = new RefrigeratedItem("ice cream", 2.00, 10.00);
		RefrigeratedItem r2 = new RefrigeratedItem("pizza", 6.00, 15.00);
		RefrigeratedItem r3 = new RefrigeratedItem("cheese", 4.00, 20.00);

		Warehouse w = new Warehouse();
		w.addItem(i1);
		w.addItem(i2);
		w.addItem(r1);
		w.addItem(r2);
		w.addItem(r3);
		
		System.out.println("Expected: 65.5");
		System.out.println("  Actual: " + w.getTotalCost());
	}

	public static void testGetTotalCost_No_Items() {
		System.out.println("\n-->testGetTotalCost_No_Items"); 
		
		Warehouse w = new Warehouse();
		
		System.out.println("Expected: 0.0");
		System.out.println("  Actual: " + w.getTotalCost());
	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Verify the total cost of the 3 refrigerated items
	 */
	public static void testGetTotalCostRefrigerated() {
		System.out.println("\n-->testGetTotalCostRefrigerated"); 
		
		Item i1 = new Item("xbox", 5.00);
		Item i2 = new Item("playstation", 3.00);
		RefrigeratedItem r1 = new RefrigeratedItem("ice cream", 2.00, 10.00);
		RefrigeratedItem r2 = new RefrigeratedItem("pizza", 6.00, 15.00);
		RefrigeratedItem r3 = new RefrigeratedItem("cheese", 4.00, 20.00);

		Warehouse w = new Warehouse();
		w.addItem(i1);
		w.addItem(i2);
		w.addItem(r1);
		w.addItem(r2);
		w.addItem(r3);
		
		System.out.println("Expected: 49.5");
		System.out.println("  Actual: " + w.getTotalCostRefrigerated());
	}

	
	public static void testGetTotalCostRefrigerated_No_Refrigerated_Items() {
		System.out.println("\n-->testGetTotalCostRefrigerated_No_Refrigerated_Items"); 
		
		Item i1 = new Item("xbox", 5.00);
		Item i2 = new Item("playstation", 3.00);

		Warehouse w = new Warehouse();
		w.addItem(i1);
		w.addItem(i2);
		
		System.out.println("Expected: 0.0");
		System.out.println("  Actual: " + w.getTotalCostRefrigerated());
	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Remove the one at position 2 and 
	 * verify: the item is returned, and the number of items is decremented.
	 */
	public static void testRemoveItem_WithIndex() {
		System.out.println("\n-->testRemoveItem_WithIndex"); 
		
		Item i1 = new Item("xbox", 5.00);
		Item i2 = new Item("playstation", 3.00);
		RefrigeratedItem r1 = new RefrigeratedItem("ice cream", 2.00, 10.00);
		RefrigeratedItem r2 = new RefrigeratedItem("pizza", 6.00, 15.00);
		RefrigeratedItem r3 = new RefrigeratedItem("cheese", 4.00, 20.00);

		Warehouse w = new Warehouse();
		w.addItem(i1);
		w.addItem(i2);
		w.addItem(r1);
		w.addItem(r2);
		w.addItem(r3);
		
		System.out.println("Num items before removal: 5");
		Item removedItem = w.removeItem(2);
		System.out.println("Num items after  removal: " + w.getNumItems());

		System.out.println("Expected item removed: ice cream");
		System.out.println("  Actual item removed: " + removedItem.getName());
	}

	public static void testRemoveItem_WithIndex_Negative() {
		System.out.println("\n-->testRemoveItem_WithIndex_Negative"); 
		
		Item i1 = new Item("xbox", 5.00);
		Item i2 = new Item("playstation", 3.00);
		RefrigeratedItem r1 = new RefrigeratedItem("ice cream", 2.00, 10.00);
		RefrigeratedItem r2 = new RefrigeratedItem("pizza", 6.00, 15.00);
		RefrigeratedItem r3 = new RefrigeratedItem("cheese", 4.00, 20.00);

		Warehouse w = new Warehouse();
		w.addItem(i1);
		w.addItem(i2);
		w.addItem(r1);
		w.addItem(r2);
		w.addItem(r3);
		
		System.out.println("Num items before removal: 5");
		Item removedItem = w.removeItem(-1);
		System.out.println("Num items after  removal: " + w.getNumItems());

		System.out.println("Expected item removed: null");
		System.out.println("  Actual item removed: " + removedItem);
	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Remove one with a name that exists and 
	 * verify: the item is returned, and the number of items is decremented.
	 */
	public static void testRemoveItem_WithName() {
		System.out.println("\n-->testRemoveItem_WithName"); 

		Item i1 = new Item("xbox", 5.00);
		Item i2 = new Item("playstation", 3.00);
		RefrigeratedItem r1 = new RefrigeratedItem("ice cream", 2.00, 10.00);
		RefrigeratedItem r2 = new RefrigeratedItem("pizza", 6.00, 15.00);
		RefrigeratedItem r3 = new RefrigeratedItem("cheese", 4.00, 20.00);

		Warehouse w = new Warehouse();
		w.addItem(i1);
		w.addItem(i2);
		w.addItem(r1);
		w.addItem(r2);
		w.addItem(r3);
		
		System.out.println("Num items before removal: 5");
		Item removedItem = w.removeItem("ice cream");
		System.out.println("Num items after  removal: " + w.getNumItems());

		System.out.println("Expected item removed: ice cream");
		System.out.println("  Actual item removed: " + removedItem.getName());
	}

	public static void testRemoveItem_WithName_Unknown() {
		System.out.println("\n-->testRemoveItem_WithName_Unknown"); 

		Item i1 = new Item("xbox", 5.00);
		Item i2 = new Item("playstation", 3.00);
		RefrigeratedItem r1 = new RefrigeratedItem("ice cream", 2.00, 10.00);
		RefrigeratedItem r2 = new RefrigeratedItem("pizza", 6.00, 15.00);
		RefrigeratedItem r3 = new RefrigeratedItem("cheese", 4.00, 20.00);

		Warehouse w = new Warehouse();
		w.addItem(i1);
		w.addItem(i2);
		w.addItem(r1);
		w.addItem(r2);
		w.addItem(r3);
		
		System.out.println("Num items before removal: 5");
		Item removedItem = w.removeItem("unknown");
		System.out.println("Num items after  removal: " + w.getNumItems());

		System.out.println("Expected item removed: null");
		System.out.println("  Actual item removed: " + removedItem);
	}

	public static void testHasItem_Find() {
		System.out.println("\n-->testHasItem_Find"); 
		
		Item i1 = new Item("xbox", 5.00);
		Item i2 = new Item("cheese", 3.00);
		Item i3 = new Item("ice cream", 1.00);
		Warehouse w = new Warehouse();
		w.addItem(i1);
		w.addItem(i2);
		w.addItem(i3);

		System.out.println("Expected: true");
		System.out.println("  Actual: " + w.hasItem("xbox"));
	}

	public static void testHasItem_NoFind() {
		System.out.println("\n-->testHasItem_Find"); 
		
		Item i1 = new Item("xbox", 5.00);
		Item i2 = new Item("cheese", 3.00);
		Item i3 = new Item("ice cream", 1.00);
		Warehouse w = new Warehouse();
		w.addItem(i1);
		w.addItem(i2);
		w.addItem(i3);

		System.out.println("Expected: false");
		System.out.println("  Actual: " + w.hasItem("playstation"));
	}

	/**
	 * Verify that the toString method produces a string exactly
	 * as specified in the assignment document. 
	 */
	public static void testToString() {
		System.out.println("\n-->testToString"); 

		Item i1 = new Item("xbox", 5.00);
		Item i2 = new Item("playstation", 3.00);
		RefrigeratedItem r1 = new RefrigeratedItem("ice cream", 2.00, 10.00);
		RefrigeratedItem r2 = new RefrigeratedItem("pizza", 6.00, 15.00);
		RefrigeratedItem r3 = new RefrigeratedItem("cheese", 4.00, 20.00);

		Warehouse w = new Warehouse();
		w.addItem(i1);
		w.addItem(i2);
		w.addItem(r1);
		w.addItem(r2);
		w.addItem(r3);

		System.out.println("""
Expected:
name=xbox, cost=$10.00, weight=5.00
name=playstation, cost=$6.00, weight=3.00
name=ice cream, cost=$13.00, weight=2.00, temp=10.00 degrees
name=pizza, cost=$20.50, weight=6.00, temp=15.00 degrees
name=cheese, cost=$16.00, weight=4.00, temp=20.00 degrees
				""");
		
		System.out.print("Actual:");
		System.out.println(w.toString());
	}

}
