package tester;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sim.BigInteger;

public class BigIntTester {
	/**
	 * @Test Adding two BigIntegers together
	 */
	public void testBigIntegerAddition() {
	    BigInteger num1 = new BigInteger("12345678901234567890");
	    BigInteger num2 = new BigInteger("98765432109876543210");
	    BigInteger expectedResult = new BigInteger("111111111011111111100");
	    assertEquals(expectedResult, num1.add(num2));
	}
	
	/**
	 * @Test Running mod on a BigInteger
	 */
	public void testBigIntegerMod() {
		BigInteger num1 = new BigInteger("91823787456814981273");
		int forMod = 25;
		int expectedResult = 23;
		assertEquals(expectedResult, num1.mod(forMod));
	}
	
	
	/**
	 * @Test Test sending invalid value to BigInteger's
	 */
	public void testBigIntegerInvalidCreation() {
		BigInteger num1 = new BigInteger("-4325623423543523");
		
		assertThrows(NullPointerException.class, () -> {
		    num1.toString(); 
		});
	}
	
	/**
	 * @Test Test sending invalid value to BigInteger's
	 */
	public void testBigIntegerInvalidAdd() {
		BigInteger num1 = new BigInteger("-4325623423543523");
		BigInteger num2 = new BigInteger("98765432109876543210");
	    
		assertThrows(IllegalArgumentException.class, () -> {
		    num1.add(num2); 
		});
	}
	
	/**
	 * @Test Test sending invalid value to BigInteger's
	 */
	public void testBigIntegerInvalidMod() {
		BigInteger num1 = new BigInteger("98765432109876543210");
	    
		assertThrows(IllegalArgumentException.class, () -> {
		    num1.mod(-5); 
		});
	}
	
	
}
