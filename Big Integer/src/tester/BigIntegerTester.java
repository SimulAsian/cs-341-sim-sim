package tester;

import sim.BigInteger;

public class BigIntegerTester {
	public static void main(String args[]) {
		// Test 1: Construct and verify toString
		BigInteger bigInt = new BigInteger("1462592351843729"); // mod should be 13
		System.out.println("BigInteger: " + bigInt);
		
		// Test 2: Get the remainder given another integer
		int mod = 23;
		System.out.println("mod " + mod + " of " + bigInt + " is " + bigInt.mod(mod));
		
	}
	
}
