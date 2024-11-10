package sim;
//Adapter
public class SquareToCircleAdapter extends CircleBlock{
	private SquareBlock block;
	
	public SquareToCircleAdapter(SquareBlock block) {
		this.block = block;
	}
	
	public void computeRadius() {
		double w = block.getWidth();
		this.setRadius(Math.sqrt(2)*w);
	}
}
