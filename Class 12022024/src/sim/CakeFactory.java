package sim;

public class CakeFactory {
	
	public Cake orderCake(String type) {
		switch(type) {
			case "vanilla":
				return new VanillaCake();
			case "chocolate":
				return new ChocolateCake();
			default:
				return new LemonCake();
		}
	}
}
