package sim;


public class Point {
	public int x, y;
	
	public Point(int a, int b) {
		x = a;
		y = b;
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	public boolean equals(Point p2) {
		return (p2.x==x && p2.y==y ? true : false);
	}
	
	public Point clone() {
		return new Point(x, y);
	}
}