package tester;

import sim.Point;
import sim.ColorPoint;

public class PointTester {

	public static void main(String[] args) {
		// Experiment 1: Create a point cp1 and visually verify
		ColorPoint cp1 = new ColorPoint(2, 3, "Yellow");
		System.out.println(cp1.toString() + "\n");
		
		// Experiment 2: Equality of a Point object with a ColorPoint object
		Point pt2 = new Point(cp1.x, cp1.y);
		System.out.println("Does cp1==pt2? " + (cp1.equals(pt2) ? "Yes" : "No") + "\n");
		
		// Experiment 3: Equality of a two independent ColorPoint objects and equality
		ColorPoint cp3 = new ColorPoint(2, 3, "Yellow");
		System.out.println("Does cp1==cp3? " + (cp1.equals(cp3) ? "Yes" : "No") + "\n");
		
		// Experiment 4: Equality with two independent ColorPoint objects and transitivity
		ColorPoint cp4 = cp1.clone();
		ColorPoint cp5 = new ColorPoint(2, 3, "Blue");
		System.out.println("Does cp1==cp4? " + (cp1.equals(cp4) ? "Yes" : "No"));
		System.out.println("Does cp4==cp3? " + (cp4.equals(cp3) ? "Yes" : "No"));
		System.out.println("Does cp4==pt2? " + (cp4.equals(pt2) ? "Yes" : "No"));
	}
}
