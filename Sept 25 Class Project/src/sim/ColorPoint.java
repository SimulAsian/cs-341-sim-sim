package sim;

public class ColorPoint extends Point {

	private String color;
	
	public ColorPoint(int x, int y, String colour){
		super(x, y);
		color = colour;
	}
	
	public String getColor() {
		return color;
	}
	
	@Override public String toString() {
		return super.toString() + ", " + color;
	}
	
	@Override public boolean equals(Point p2) {
		if (p2 instanceof ColorPoint) {
			// it's like casting but in reverse
			ColorPoint c = (ColorPoint) p2;
			return (super.equals(p2) && c.getColor()==color);
		} else {
			return super.equals(p2);
		}
	}

	@Override public ColorPoint clone() {
		return new ColorPoint(super.x, super.y, color);
	}
	
//	public boolean equals(ColorPoint p2) {
//		return (super.equals(p2) && p2.getColor()==color ? true : false);
//	}
}
