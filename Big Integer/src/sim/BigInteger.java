/**
 * Represents an integer that can be greater than the integer limit.
 * This class allows the user to add BigIntegers together and find the modulus of a BigInteger.
 *
 * <p>Note: The class does not allow negative BigIntegers.</p>
 *
 * @author Sim Sim
 * @version 1.0
 * @since 2023-09-28
 */

package sim;

public class BigInteger {
	private String value;
	
	/**
	 * Constructor for BigInteger
	 * @param value to assign to this.value
	 */
	public BigInteger(String value) {
		if (isPositiveInt(value)) {
			this.value = value;
		} else {
			this.value = null;
		}
	}
	
	
	/**
	 * Adds two BigIntegers together
	 * @param y the BigInteger to add to this BigInteger
	 * @return the resulting BigInteger from adding the two BigIntegers
	 * @throws IllegalArgumentException since either this or y is an invalid BigInteger
	 */
	public BigInteger add(BigInteger y) {
		if((!isPositiveInt(value)) || !isPositiveInt(y.toString())) {
			throw new IllegalArgumentException("One of the provided BigIntegers is an invalid BigInteger");
		}
		
        // Assign larger and smaller number vars
        String bigNum, smallNum;
        if (y.value.length() > value.length()) {
            bigNum = y.value;
            smallNum = value;
        } else {
            bigNum = value;
            smallNum = y.value;
        }

        // Pad smaller number w/ leading zeros
        smallNum = padWithZeros(smallNum, bigNum.length());

        // Result and carry initialization
        String z = "";
        int carry = 0;

        // Loop through the numbers from right to left
        for (int i = bigNum.length() - 1; i >= 0; i--) {
            int bigDigit = bigNum.charAt(i) - '0';  // Convert char to int
            int smallDigit = smallNum.charAt(i) - '0';
            
            int cumulativeVal = bigDigit + smallDigit + carry;
            carry = cumulativeVal / 10;
            cumulativeVal = cumulativeVal % 10;
            
            z = cumulativeVal + z;  // Append the result digit
        }

        // Append remaining carry
        if (carry > 0) {
            z = carry + z;
        }
        
        return new BigInteger(z);
    }
	
	/**
	 * Calculates the BigInteger's value mod m
	 * @param m the integer to apply to value in a modulus
	 * @return mod m of this BigInteger's value
	 * @throws IllegalArgumentException if either the BigInteger or Index are invalid (non-null, non-positive values)
	 */
    public int mod(int m) {
    	if (value == null) {
			throw new IllegalArgumentException("BigInteger must be a valid, non-negative BigInteger.");
		}
    	if (!isPositiveInt(""+m)) {
    		throw new IllegalArgumentException("Provided index must be non-negative");
    	}
    	
        int result = 0;

        for (int i = 0; i < value.length(); i++) {
            int currentDigit = Character.getNumericValue(value.charAt(i));
            result = (result * 10 + currentDigit) % m;
        }
        return result;
    }
    
    /**
     * Returns the BigInteger's value
     * @throws NullPointerException since if value is null, there is no proper String to send back
     */
    public String toString() {
    	if (value == null) {
    		throw new NullPointerException();
    	}
    	return value;
    }
    
    /**
     * Allows the assigning/reassigning of the BigInteger's value
     * @param value the String to set the value to
     * @throws IllegalArgumentException if value is any String that will not become a positive integer
     */
	public void setValue(String value) {
		if (!isPositiveInt(value)) {
			throw new IllegalArgumentException("BigInteger must be assigned as a non-negative integer");
		}
		this.value = value;	
	}
	
	/**
	 * Deems whether the sent String is devoid of non-digit character
	 * @param s String to be inspected
	 * @return true if s is representative of a positive int and false otherwise
	 */
	private boolean isPositiveInt(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
	
	/**
     * Pads a smaller number with zeroes to reach the target length
     * @param num The number as a string that you want to pad with zeroes
     * @param targetLength The length you want the result to be
     * @return
     */
    private String padWithZeros(String num, int targetLength) {
        while (num.length() < targetLength) {
            num = "0" + num;
        }
        return num;
    }
    
	
}

