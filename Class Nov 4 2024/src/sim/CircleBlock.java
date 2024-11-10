package sim;

public class CircleBlock implements Shape{
	private double radius;
	
	public CircleBlock(double radius) {
		this.radius = radius;
	}
	
	public CircleBlock() {
		radius = 1;
	}
	
	public double getRadius () {
		return radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	@Override
	public double getWidth() {
		return radius*2;
	}

}
