package sim;

public class Tester {
	public static void main(String args[]) {
		RoundHole hole = new RoundHole(4.0);
		
		CircleBlock circleBlock = new CircleBlock(4.0);
		System.out.print("Circle block fits? ");
		System.out.println(hole.fits(circleBlock));
		
		SquareBlock block = new SquareBlock(2.5);
		
		CircleBlock squareToCircleAdapter = new SquareToCircleAdapter(block);
		System.out.print("Can square block fit into the hole? ");
		System.out.println(hole.fits(squareToCircleAdapter));
	}
}
