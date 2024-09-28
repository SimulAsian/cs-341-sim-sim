package tester;

import sim.Point;

public class MyMain {

	public static void main(String[] args) {
		// Visual verification (Experiment 1)
		Point p1 = new Point(3, 4);
		System.out.println(p1);
		
		// Test equal to self (Experiment 2)
		System.out.println("Does p1==p1? " + (p1.equals(p1)  ? "Yes" : "No"));
		
		// Test equals when data values do match (Experiment 3)
		Point p2 = new Point(3, 4);
		System.out.println("Does p1==p2? " + (p1.equals(p2)  ? "Yes" : "No"));
		
		// Test equals when data values do NOT match (Experiment 4)
		Point p3 = new Point(2, 3);
		System.out.println("Does p1==p3? " + (p1.equals(p3) ? "Yes" : "No"));
		
		// Test transitivity
		Point p4 = p1.clone();
		System.out.println("Does p1==p3? " + (p1.equals(p3) ? "Yes" : "No"));
		System.out.println("Does p1==p3? " + (p1.equals(p3) ? "Yes" : "No"));
		
	}

}
