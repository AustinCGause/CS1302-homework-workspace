package prob1;

public class ProductTest {

	/***
	 * YOU SHOULD WRITE THESE TEST METHODS.
	 * 
	 */
	public static void main(String[] args) {
		testProductConstructor_Plant_3chars_Batch_2chars();
		testProductConstructor_Plant_3chars_Batch_1chars();
		testProductConstructor_Plant_2chars_Batch_2chars();
		testProductConstructor_Plant_2chars_Batch_1chars();
		testIsAfter2000Test_True_Year2019();
		testIsAfter2000Test_True_Year2000();
		testIsAfter2000Test_False_Year1994();
		testIsMonthEqual_True();
		testIsMonthEqual_False();
	}
	
	/***
	 * Construct a product where the plant has 3 characters, and the batch has 2.
	 * Should show that code, plant, date, and batch are correct.
	 */
	public static void testProductConstructor_Plant_3chars_Batch_2chars() {
		System.out.println("-->testProductConstructor_Plant_3chars_Batch_2chars()");

		Product p = new Product("abc0901200323");
		System.out.println("Expected: code=abc0901200323, plant=abc, date=09/01/2003, batch=23");
		System.out.println("  Actual: " + p.toString());
	}

	/***
	 * Construct a product where the plant has 3 characters, and the batch has 1.
	 * Should show that code, plant, date, and batch are correct.
	 */
	public static void testProductConstructor_Plant_3chars_Batch_1chars() {
		System.out.println("\n-->testProductConstructor_Plant_3chars_Batch_1chars()");

		
		Product p = new Product("abc090120032");
		System.out.println("Expected: code=abc090120032, plant=abc, date=09/01/2003, batch=2");
		System.out.println("  Actual: " + p.toString());
	}

	/***
	 * Construct a product where the plant has 2 characters, and the batch has 2.
	 * Should show that code, plant, date, and batch are correct.
	 */
	public static void testProductConstructor_Plant_2chars_Batch_2chars() {
		System.out.println("\n-->testProductConstructor_Plant_2chars_Batch_2chars()");

		
		Product p = new Product("ab0901200323");
		System.out.println("Expected: code=ab0901200323, plant=ab, date=09/01/2003, batch=23");
		System.out.println("  Actual: " + p.toString());
	}

	/***
	 * Construct a product where the plant has 2 characters, and the batch has 1.
	 * Should show that code, plant, date, and batch are correct.
	 */
	public static void testProductConstructor_Plant_2chars_Batch_1chars() {
		System.out.println("\n-->testProductConstructor_Plant_2chars_Batch_1chars()");

		Product p = new Product("ab090120032");
		System.out.println("Expected: code=ab090120032, plant=ab, date=09/01/2003, batch=2");
		System.out.println("  Actual: " + p.toString());
	}

	/***
	 * Construct a product where the year is 2019 and then call isAfter2000() which should return true.
	 * Show values to illustrate that return is correct.
	 */
	public static void testIsAfter2000Test_True_Year2019() {
		System.out.println("\n-->testIsAfter2000Test_True_Year2019()");

		Product p = new Product("ab0901201923");
		System.out.println("Expected: true");
		System.out.println("  Actual: " + p.isAfter2000());
	}

	/***
	 * Construct a product where the year is 2000 and then call isAfter2000() which should return true.
	 * Show values to illustrate that return is correct.
	 */
	public static void testIsAfter2000Test_True_Year2000() {
		System.out.println("\n-->testIsAfter2000Test_True_Year2000()");

		Product p = new Product("ab0901200023");
		System.out.println("Expected: true");
		System.out.println("  Actual: " + p.isAfter2000());
	}

	/***
	 * Construct a product where the year is 1994 and then call isAfter2000() which should return false.
	 * Show values to illustrate that return is correct.
	 */
	public static void testIsAfter2000Test_False_Year1994() {
		System.out.println("\n-->testIsAfter2000Test_False_Year1994()");

		Product p = new Product("ab0901199423");
		System.out.println("Expected: false");
		System.out.println("  Actual: " + p.isAfter2000());
	}

	/***
	 * Construct a product where the month is say, Feb, and then call isMonthEqual(2) which should return true.
	 * Show values to illustrate that return is correct.
	 */
	public static void testIsMonthEqual_True() {
		System.out.println("\n-->testIsMonthEqual_True()");

		Product p = new Product("ab0901199423");
		System.out.println("Expected: true");
		System.out.println("  Actual: " + p.isMonthEqual(9));
	}

	/***
	 * Construct a product where the month is say, Feb, and then call isMonthEqual(3) which should return false.
	 * Show values to illustrate that return is correct.
	 */
	public static void testIsMonthEqual_False() {
		System.out.println("\n-->testIsMonthEqual_False()");

		Product p = new Product("ab0901199423");
		System.out.println("Expected: false");
		System.out.println("  Actual: " + p.isMonthEqual(6));
	}

}
