package prob1;

public class RecursionExamples {

	// Problem 1a
	public static double sumSeries(int n) {
		if ( n == 1 )
			return 1;
		else {
			if ( n % 2 == 0 )
				return sumSeries( n - 1 ) - 1.0 / n;
			else
				return sumSeries( n - 1 ) + 1.0 / n;
		}
	}

	// Problem 1b
	public static void printReverse2(String s) {
		if ( s.length() <= 3 ) {
			System.out.println(s);
			return;
		}
		System.out.print(s.substring( s.length() -3 ));
		printReverse2(s.substring( 0, s.length() - 3 ));
	}
	
	// Problem 1c
	public static void printReverse(String s, int n) {
		if ( s.length() <= n ) {
			System.out.println(s);
			return;
		}
		System.out.print(s.substring( s.length() - n ));
		printReverse(s.substring( 0, s.length() - n ), n);
	}

	// Problem 1d
	public static int countVowels(String s) {
		String vowels = "aeiou";
		if ( s.length() == 0 ) 
			return 0;

		if ( vowels.indexOf(s.charAt(0)) == -1 )
			return 0 + countVowels(s.substring( 1 ));
		else
			return 1 + countVowels(s.substring( 1 ));
	}
	
	// Problem 1e, requires a helper
	public static int countLength(String[] strs) {
		return countLengthHelper(strs, 0);
	}
	
	private static int countLengthHelper(String[] strs, int index) {
		if ( index == strs.length )
			return 0;
		int currentLength = (strs[index] == null) ? 0 : strs[index].length();
		return currentLength + countLengthHelper(strs, index + 1);
	}

	// Problem 1f, requires a helper
	public static int getMax(int[] vals) {
		return getMaxHelper(vals, vals.length);
	}

	private static int getMaxHelper(int[] vals, int n) {
		if (n == 1)
			return vals[0];
		return Math.max(vals[n-1], getMaxHelper(vals, n - 1));
	}

	// Problem 1g, requires a helper
	public static int countCode(String msg, String code ) {
		return countCodeHelper(msg, code, 0);
	}

	private static int countCodeHelper(String msg, String code, int pos) {
		if ( pos >= ( msg.length() - ( code.length() - 1 ) ))
			return 0;

		if ( msg.substring(pos, ( pos + code.length() )).equals(code) )
			return 1 + countCodeHelper(msg, code, pos + ( code.length() + 1 ));
		else
			return 0 + countCodeHelper(msg, code, pos + 1);
	}

}
