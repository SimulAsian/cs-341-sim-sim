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
		Type_A_GameObject shpA = new Type_A_GameObject(200, 200);
		Type_B_GameObject shpB = new Type_B_GameObject(250, 250);
		Type_C_GameObject shpC = new Type_C_GameObject(300, 300);
		Type_D_GameObject user = new Type_D_GameObject(350, 350);
		
		objects.add(shpA);
		objects.add(shpB);
		objects.add(shpC);
		objects.add(user);
		
		canvas.addKeyListener(user);
		
		for(GameObject o: objects) {
			canvas.addGameObject(o);
			o.setVelocity(o.getVelocity()+1);
		}
		

	}

}

