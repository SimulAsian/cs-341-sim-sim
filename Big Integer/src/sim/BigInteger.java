package sim;

public class BigInteger {
	private String value;
	
	public BigInteger(String value) {
		this.value = value;
	}
	
	/**
	 * 
	 * @param y
	 * @return
	 */
	public BigInteger add(BigInteger y) {
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
     * 
     * @param num
     * @param targetLength
     * @return
     */
    private String padWithZeros(String num, int targetLength) {
        while (num.length() < targetLength) {
            num = "0" + num;
        }
        return num;
    }

    
    

    public int mod(int m) {
        int result = 0;

        for (int i = 0; i < value.length(); i++) {
            int currentDigit = Character.getNumericValue(value.charAt(i));
            result = (result * 10 + currentDigit) % m;
        }
        return result;
    }
    
    public String toString() {
    	return value;
    }
    
	public void setValue(String value) {
		this.value = value;
	}
	
	
}

