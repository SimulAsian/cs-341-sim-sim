package sim;

public class PhoneNumber implements Comparable<PhoneNumber>{
	private short areaCode;
	private short prefix;
	private short lineNumber;
	
	public PhoneNumber(int areaCode, int prefix, int lineNumber) {
		this.areaCode = rangeCheck(areaCode, 999, "area code");
		this.prefix = rangeCheck(prefix, 999, "prefix");
		this.lineNumber = rangeCheck(lineNumber, 9999, "line num");
	}

	public static short rangeCheck(int val, int max, String arg) {
		if(val<0||val>max)
			throw new IllegalArgumentException(arg+": "+val);
		return (short) val;
	}
	
	public String toString() {
		return String.format("%03d-%03d-%04d", areaCode, prefix, lineNumber);
	}
	
	public int compareTo(PhoneNumber other) {
			int result = Short.compare(areaCode, other.areaCode);
			if (result == 0) {
				result = Short.compare(prefix, other.prefix);
			if (result == 0)
				result = Short.compare(lineNumber, other.lineNumber);
		}
		return result;
	}
	

	
}
