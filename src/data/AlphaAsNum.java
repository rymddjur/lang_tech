package data;

import java.util.ArrayList;
import java.util.HashMap;

public class AlphaAsNum {
	/**
	 * maybe use these later
	 */
	private static final String LOWER_ALPHA = "lower_alpha";
	private static final String UPPER_ALPHA = "upper_alpha";
	private static final String ALPHA_NUMERIC = "alpha_numeric";

	HashMap<String, Integer> map = new HashMap<String, Integer>();
	PrimeNumbers pn;
	ArrayList<String> alphaArray;

	/**
	 * default, uses lower case alphabet only.
	 * 
	 * @param primesUpTo
	 */
	public AlphaAsNum() {
		
		//gives 26 prime numbers
		pn = new PrimeNumbers(101);
		
		//gives lower case alphabet
		alphaArray = initAlphaArray(97, 26);
		linkPrimesAndAlphas();
	}

	public HashMap<String, Integer> getMap() {
		return map;
	}

	/**
	 * links the prime numbers and characters to a map retrievable with
	 * this.getMap()
	 */
	private void linkPrimesAndAlphas() {
		ArrayList<Integer> primes = pn.getArray();
		ArrayList<String> chars = alphaArray;
		if (primes.size() < chars.size()) {
			System.err.println("not enough primes. please retry with more.");
			System.exit(0);
		} else {
			for (int i = 0; i < chars.size(); i++) {
				map.put(chars.get(i), primes.get(i));
			}
		}

	}

	/**
	 * initializes an array of characters from utf-8
	 * 
	 * 32 = SPACE, first non empty
	 * 
	 * string 48 = 0
	 * 
	 * 65 = A
	 * 
	 * 97 = a
	 * 
	 * 127 - 160 = empty strings (automatically omitted)
	 * 
	 * 192 - 255 = accented and other lang specific
	 * 
	 * @param offset,
	 *            start of search
	 * @param totalIncrease,
	 *            amount to be searched
	 */
	private ArrayList<String> initAlphaArray(int offset, int totalIncrease) {
		ArrayList<String> array = new ArrayList<String>();
		for (int i = offset; i < (offset + totalIncrease); i++) {
			if (i < 127 || i > 161) {
				// String hex = Integer.toHexString(i);
				// System.out.println(i + " = " + (char) i);
				array.add(Character.toString((char) i));

			}
		}
		return array;
	}
}
