package prob1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CodeComparatorTestComprehensive2 {

	public static void main(String[] args) {
		testSort();
	}
	
	private static void testSort() {
		ArrayList<ArrayList<Product>> prodsLists = createProductsLists();
		doTest(prodsLists, new CodeComparator2());
	}
	
	private static void doTest(ArrayList<ArrayList<Product>> prodsLists, Comparator<Product> comp) {
		for(int testNum=1; testNum<=prodsLists.size(); testNum++) {
			ArrayList<Product> prodsSorted = prodsLists.get(testNum-1);
			ArrayList<Product> prodsOriginal = new ArrayList<>(prodsSorted);
			Collections.sort(prodsSorted, comp);
			printProductList(prodsOriginal, prodsSorted, testNum);
		}
	}

	private static void printProductList(ArrayList<Product> prodsOriginal, ArrayList<Product> prodsSorted, int testNum) {
		System.out.println("Test: " + testNum + "\nOriginal\tSorted");
		System.out.println("--------\t------");
		for(int i=0; i<prodsOriginal.size(); i++) {
			String codeOriginal = prodsOriginal.get(i).getCode();
			String codeSorted = prodsSorted.get(i).getCode();
			System.out.println(codeOriginal + "\t\t" + codeSorted);
		}
		System.out.println();
	}

	private static ArrayList<ArrayList<Product>> createProductsLists() {
		ArrayList<ArrayList<Product>> prodsLists= new ArrayList<ArrayList<Product>>(Arrays.asList(
				new ArrayList<>(Arrays.asList(  // t's!
						new Product("QZ-53"),
						new Product("QZ-99t"),
						new Product("QZ-44")
						)),
				new ArrayList<>(Arrays.asList(  // t's!
						new Product("QZ-53"),
						new Product("QZ-99t"),
						new Product("QZ-22"),
						new Product("QZ-44t")
						)),
				new ArrayList<>(Arrays.asList(
						new Product("DC-333"),
						new Product("DC-111t"),
						new Product("DC-099"),
						new Product("DC-100t")
						)),
				new ArrayList<>(Arrays.asList(
						new Product("ML-883t"),
						new Product("ML-050t"),
						new Product("ML-444"),
						new Product("ML-222")
						)),
				new ArrayList<>(Arrays.asList(
						new Product("DC-333t"),
						new Product("QZ-44"),
						new Product("DC-111"),
						new Product("ML-883"),
						new Product("QZ-89t"),
						new Product("QZ-53t"),
						new Product("ML-050")
						))
				));
		return prodsLists;
	}
}
