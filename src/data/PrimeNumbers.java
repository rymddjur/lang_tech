package data;

import java.util.ArrayList;

public class PrimeNumbers {

	private ArrayList<Integer> array = new ArrayList<Integer>();

	
	public PrimeNumbers(int maxNumber) {
		for (int i = 2; i <= maxNumber; ++i) {
			if (isPrime(i)) {
				array.add(i);
			}
		}
	}

	/**
	 * Checks is a positive integer is a prime number
	 */
	public boolean isPrime(int number) {
		for (int check = 2; check < number; ++check) {
			if (number % check == 0) {
				return false;
			}
		}
		return true;
	}
	
	public ArrayList<Integer> getArray(){
		return array;
	}

}
