package prob2;

import java.util.ArrayList;

public class BinarySearchTester {
	
	/**
	 * WRITE THIS METHOD. YOU MUST ALSO WRITE A RECURSIVE HELPER METHOD.
	 */
	public static int binarySearch( ArrayList<Blob> blobs, Blob bKey1, Blob bKey2 ) {
		int combinedCoolnessFactor = bKey1.getCoolnessFactor() + bKey2.getCoolnessFactor();
		return binarySearchHelper(blobs, combinedCoolnessFactor, 0, blobs.size() - 1);
	}

	public static int binarySearchHelper( ArrayList<Blob> blobs, int key, int low, int high ) {

		if ( low > high )
			return -(low + 1);

		int mid = ( low + high ) / 2;

		if (mid % 2 != 0)
			mid--;

		int combinedCoolnessFactor = blobs.get(mid).getCoolnessFactor() + blobs.get(mid + 1).getCoolnessFactor();

		if ( key < combinedCoolnessFactor )
			return binarySearchHelper(blobs, key, low, mid - 2);
		else if ( key > combinedCoolnessFactor )
			return binarySearchHelper(blobs, key, mid + 2, high);
		else
			return mid;

	}

	//-----------------------------------------------------------------
	// Code below is used for testing. Should not change, but can 
	// comment out some tests when needed.
	//-----------------------------------------------------------------

	/**
	 * Excecutes tests.
	 */
	public static void main( String[] args ) {
		// Build initial blob list
		ArrayList<Blob> blobs = buildBlobList(5);
		// Print blob list (for reference)
		printBlobList(blobs);
		
		// Run tests
		
		// Searches blobs for the twin pair: B(1) & B(4)
		testBlobSearch(blobs,1,4); // not found
		// Searches blobs for the twin pair: B(1) & B(5)
		testBlobSearch(blobs,1,5);
		// Searches blobs for the twin pair: B(2) & B(5)
		testBlobSearch(blobs,2,5); // not found
		testBlobSearch(blobs,2,6);
		testBlobSearch(blobs,3,6); // not found
		testBlobSearch(blobs,3,7);
		testBlobSearch(blobs,4,7); // not found
		testBlobSearch(blobs,4,8);
		testBlobSearch(blobs,5,8); // not found
		testBlobSearch(blobs,5,9);
		testBlobSearch(blobs,6,9); // not found
	}

	/**
	 * Helper method that actually does the testing and reporting.
	 */
	private static void testBlobSearch(ArrayList<Blob> blobs, int cNess1, int cNess2) {
		Blob b1 = new Blob(cNess1);
		Blob b2 = new Blob(cNess2);
		int index = binarySearch(blobs, b1, b2);
		String searchFor = buildTwinString(b1,b2);
		String msg;
		if(index>=0) {
			String found = buildTwinString(blobs.get(index),blobs.get(index+1));
			msg = String.format("Searched for:%s, Found:%s at index=%d", searchFor, found, index);
		}
		else {
			int indexClosest = -1*index - 1;
			if(indexClosest<blobs.size()) {
				String closest = buildTwinString(blobs.get(indexClosest),blobs.get(indexClosest+1));
				msg = String.format("Search for:%s, Not Found, belongs at:%s at index %d", searchFor, closest, indexClosest);
			}
			else {
				indexClosest-=2;
				String closest = buildTwinString(blobs.get(indexClosest),blobs.get(indexClosest+1));
				msg = String.format("Search for:%s, Not Found, belongs after:%s at index %d", searchFor, closest, indexClosest);
			}
		}
		System.out.println(msg);
	}

	private static void printBlobList(ArrayList<Blob> blobs) {
		StringBuilder sb = new StringBuilder("Sorted Blob list:\n");
		for(int i=0; i<blobs.size(); i+=2) {
			int cNess1 = blobs.get(i).getCoolnessFactor();
			int cNess2 = blobs.get(i+1).getCoolnessFactor();
			int twinPower = cNess1 + cNess2;
			sb.append(String.format("B(%d)+B(%d)=%d, ", cNess1, cNess2, twinPower));
		}
		sb.delete(sb.length()-2, sb.length());
		System.out.println(sb.toString());
		System.out.println();
	}

	private static String buildTwinString(Blob b1, Blob b2) {
		int cNess1 = b1.getCoolnessFactor();
		int cNess2 = b2.getCoolnessFactor();
		int twinPower = cNess1 + cNess2;
		String msg = String.format("(%d+%d=%d)", cNess1, cNess2, twinPower);
		return msg;
	}

	/**
	 * Builds the list of sorted blob twins that is used for testing
	 * the search method.
	 */
	private static ArrayList<Blob> buildBlobList(int numTwins) {
		ArrayList<Blob> blobs = new ArrayList<>();
		int cNess = 2;
		for(int i=1; i<=numTwins; i++) {
			Blob b1 = new Blob(cNess);
			cNess+=2;
			Blob b2 = new Blob(cNess--);
			blobs.add(b1);
			blobs.add(b2);
		}
		return blobs;
	}
}

