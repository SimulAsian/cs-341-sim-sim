package sim;
// Adaptee
public class RoundHole {
	private double radius;
	
	public RoundHole(double radius) {
		this.radius = radius;
	}
	
	public boolean fits(CircleBlock block) {
		return block.getRadius() < radius;
	}
}
