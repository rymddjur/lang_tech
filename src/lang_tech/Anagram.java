package lang_tech;

import java.util.HashMap;

import data.AlphaAsNum;

/**
 * 3.8 Write a program that takes a word and, using an on-line dictionary,
 * computes possible anagrams of the word, each of which is a legal word.
 * 
 * @author jakobjoelsson
 *
 */
public class Anagram {

	String[] dictionary = "aa ab aab baa bba aaa aaba".split(" ");
	AlphaAsNum aan = new AlphaAsNum();
	HashMap<String, Integer> map = new HashMap<String, Integer>();

	public Anagram() {
		map = aan.getMap();
		anagram("aba");
	}

	public void anagram(String input) {

		for (String s : dictionary) {
			if (primeAnagram(input) == primeAnagram(s)) {
				System.out.println(s + " is an anagram of " + input);
			} else {
				System.out.println(s + " is not an anagram of " + input);

			}
		}

	}

	/**
	 * uses characters assigned to prime numbers
	 */
	public int primeAnagram(String word) {
		String[] split = word.split("");
		int result = 1;
		for (String s : split) {
			result *= map.get(s);
		}
		return result;
	}

	public void sortAnagram() {
		
	}
}
