package sim;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.Icon;


//GENERAL GAME OBJECT
public abstract class GameObject implements KeyListener{
	//EACH GAME OBJECT HAS AN X,Y LOCATION, VELOCITY, AND A DIRECTION
	private int x;
	private int y;
	private int velocity;
	private int direction;

	//EACH GAME OBJECT CAN HAVE A COLLECTION OF IMAGES AND CONTROL STATUS
	protected boolean underControl;
	protected List<Icon> imageList;
	protected int currentImage; 
	protected int lastDirection;
	protected int lastImage;

	public GameObject(int x, int y, boolean underControl) {
		this.x = x;
		this.y = y;
		this.underControl = underControl;
		velocity = 0;
		currentImage = 0;
	}

	public void draw(Component c, Graphics g) {
		imageList.get(currentImage).paintIcon(c, g, x, y);
	}

	// SETTERS AND GETTERS
	public int getX() { return x; }

	public void setX(int x) { this.x = x; }

	public int getY() { return y; }

	public void setY(int y) { this.y = y; }

	public void setVelocity(int velocity) { this.velocity = velocity; }

	public int getVelocity() { return velocity; }

	public int getDirection() { return direction; }

	public void setDirection(int direction) {
		if(!underControl && direction != Direction.NONE) {
			lastDirection = this.direction;
			lastImage = this.currentImage;
		}
		this.direction = direction;
	}

	public Icon getCurrentImage() { return imageList.get(currentImage); }
	
	public void setUnderControl(boolean underControl) {
		if(underControl) {
			System.out.println("Switching INTO control mode. LastDirection and LastImage set." );
			lastDirection = direction;
			lastImage = currentImage;
			setDirection(Direction.NONE);
		}else {
			System.out.println("Switching OUT of control mode. LastDirection" + lastDirection + "and LastImage" + lastImage + " restored.\n" );
			setDirection(lastDirection);
			currentImage = lastImage;
		}
		this.underControl = underControl;
	}
	
	public boolean getUnderControl() { return underControl;}
	
	public void keyReleased(KeyEvent e) {
		if (underControl) {
			if(e.getKeyCode() != KeyEvent.VK_TAB) {
				setDirection(Direction.NONE);
			}
		}
	}
	
	//ABSTRACT METHODS
	public abstract void move(Canvas c);
	public abstract void setImage();
	public abstract void keyTyped(KeyEvent e);
	public abstract void keyPressed(KeyEvent e);
}