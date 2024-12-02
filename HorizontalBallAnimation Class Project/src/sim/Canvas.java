package sim;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Canvas extends JComponent implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private Timer gameLoopTimer;
	private List<GameObject> gameObjectList;
	
	public Canvas() {
		gameObjectList = new LinkedList<GameObject>();
		
		frame = new JFrame("Animation Canvas");
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		
		gameLoopTimer = new Timer(25, this);
		gameLoopTimer.start();
		
		frame.setVisible(true);
	}
	
	public synchronized void addGameObject(GameObject sprite) {
		gameObjectList.add(sprite);
	}
	
	public synchronized void paint(Graphics g) {
		for(GameObject s: gameObjectList) {
			s.draw(this, g);
		}
	}

	public synchronized void actionPerformed(ActionEvent e) {
		for(GameObject gameObject : gameObjectList) {
			gameObject.move(this);
		}
		repaint();
	}
}
