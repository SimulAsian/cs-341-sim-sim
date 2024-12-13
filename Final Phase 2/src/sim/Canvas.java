package sim;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Canvas extends JComponent implements ActionListener, KeyListener {
	// DEFAULT SERIAL NUMBER
	private static final long serialVersionUID = 1L;

	//GAME LOOP USES A FRAME AND TIMER
	private JFrame frame;
	private Timer gameLoopTimer;
	
	private List<GameObject> gameObjectList;
	private int highlighted = 0;
	


	public Canvas() {
		// TASK 1: CREATE A LIST OF CHARACTERS THAT WILL APPEAR ON THE CANVAS
		gameObjectList = new LinkedList<GameObject>();

		// TASK 2: CREATE A WINDOW FOR THE APPLICATION
		frame = new JFrame("Animation Canvas");
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);

		// TASK 3: CONSTRUCT A TIMER FOR GAME LOOP
		gameLoopTimer = new Timer(25, this);
		gameLoopTimer.start();
		
		setFocusTraversalKeysEnabled(false);
	    addKeyListener(this);

		// TASK 4: MAKE THE WINDOW VISIBLE
		frame.setVisible(true);
		
	}
	
	/**
	 * Adds GameObjects to the List, which are latter added to the Canvas
	 */
	public synchronized void addGameObject(GameObject sprite) {
		gameObjectList.add(sprite);
	}

	/**
	 * Draws the GameObject graphic onto the Canvas
	 */
	public synchronized void paint(Graphics g) {
		for (int i = 0; i < gameObjectList.size(); i++) {
			GameObject obj = gameObjectList.get(i);
			obj.draw(this, g);
			
			if (i == highlighted) {
	            g.setColor(Color.RED); // Set the color for the outline
	            g.drawRect(obj.getX(), obj.getY(), 
	                       obj.getCurrentImage().getIconWidth(), 
	                       obj.getCurrentImage().getIconHeight());
			}
		}
	}
	
	
	// ****************************************************
	// Canvas must implement the inherited abstract method
	// ActionListener.actionPerformed(ActionEvent)
	public synchronized void actionPerformed(ActionEvent e) {
		for (GameObject gameObject : gameObjectList) {
			gameObject.move(this);
			gameObject.setImage();
		}
		repaint();
	}


	
	
	// ****************************************************
	// Canvas must implement the inherited abstract methods
	// for KeyListener
	
	  public void keyTyped(KeyEvent e) {
	  }

	  public void keyPressed(KeyEvent e) {
	  }

	  public void keyReleased(KeyEvent e) {
		  GameObject s = gameObjectList.get(highlighted);
		  if (e.getKeyCode() == KeyEvent.VK_TAB) {
			  System.out.print(s.getClass());
			  s.setUnderControl(false);
			  highlighted = (highlighted + 1)%gameObjectList.size();
			  s = gameObjectList.get(highlighted);
			  System.out.print(s.getClass());
			  s.setUnderControl(true);
		  }
	  }

}