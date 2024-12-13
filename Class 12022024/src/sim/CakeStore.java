package sim;

public class CakeStore {
	
	private CakeFactory factory;
	
	public CakeStore(CakeFactory factory) {
		this.factory = factory;
	}
	
	public Cake onlineOrder(String type) {
		Cake cake = factory.orderCake(type);
		
		cake.prepare();
		cake.bake();
		cake.box();
		
		return cake;
	}
}
