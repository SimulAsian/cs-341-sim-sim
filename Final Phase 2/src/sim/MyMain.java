package sim;

import java.util.ArrayList;
import java.util.List;

public class MyMain {
	public static void main(String[] args) {
		// TASK 1: CREATE A CANVAS FOR ANIMATION
		Canvas canvas = new Canvas();
		canvas.requestFocus();
		List<GameObject> objects = new ArrayList<GameObject>();
		
		//TASK 2:  ADD A USER GAME OBJECT OF TYPE D
		Type_A_GameObject shpA = new Type_A_GameObject(200, 200, false);
		Type_B_GameObject shpB = new Type_B_GameObject(250, 250, false);
		Type_C_GameObject shpC = new Type_C_GameObject(300, 300, false);
		Type_D_GameObject user = new Type_D_GameObject(350, 350, true);
		
		//Note: user must be first since you only want user to accelerate. Otherwise, whatever is in index 0 will speed up wildly.
		objects.add(user);
		objects.add(shpA);
		objects.add(shpB);
		objects.add(shpC);
		
		for(GameObject o: objects) {
			canvas.addKeyListener(o);
			canvas.addGameObject(o);
			o.setVelocity(5);
		}
	}
}