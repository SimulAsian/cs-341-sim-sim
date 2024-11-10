package sim;
// Client
public class SquareBlock implements Shape{
	private double width;
	
	public SquareBlock() {
		width = 1;
	}
	
	public SquareBlock(double width) {
		this.width = width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getWidth() {
		return width;
	}
}
