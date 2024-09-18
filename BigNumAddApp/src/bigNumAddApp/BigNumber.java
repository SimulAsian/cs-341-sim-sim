package bigNumAddApp;//

public class BigNumber {
    private String value;

    public BigNumber(String s) {
        value = s;
    }

    public BigNumber add(BigNumber y) {
        // Assign larger and smaller number vars
        String bigNum, smallNum;
        if (y.value.length() > value.length()) {
            bigNum = y.value;
            smallNum = value;
        } else {
            bigNum = value;
            smallNum = y.value;
        }

        // Check that inputs are positive ints
        if (!isPositiveInt(bigNum) || !isPositiveInt(smallNum)) {
            return new BigNumber("input error");
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
        
        return new BigNumber(z);
    }

    // Pads the shorter string with leading zeros
    private String padWithZeros(String num, int targetLength) {
        while (num.length() < targetLength) {
            num = "0" + num;
        }
        return num;
    }

    // Determines if the string is a positive integer
    public boolean isPositiveInt(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
    
    public String getValue() {
    	return value;
    }
    
}

