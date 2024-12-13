package sim;

import java.awt.event.KeyEvent;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_C_GameObject extends GameObject{
	public Type_C_GameObject(int x, int y, boolean underControl) {
		super(x, y, underControl);
	    setDirection(Direction.RIGHT);
	    lastDirection = this.getDirection();
	    
	    imageList = new LinkedList<Icon>();
	    imageList.add(new ImageIcon("images/Type_C_Left.png"));
	    imageList.add(new ImageIcon("images/Type_C_Right.png"));
	}

  public void move(Canvas c) {
	    Icon icon = getCurrentImage();
	    int iconWidth = icon.getIconWidth();
	    int canvasWidth = (int) c.getSize().getWidth();

	    switch (getDirection()) {
	        case Direction.LEFT:
	            setX(getX() - getVelocity());
	            if (getX() < 0) {
	                setX(0);
	                setDirection(Direction.RIGHT);
	            }
	            break;
	        case Direction.RIGHT:
	            setX(getX() + getVelocity());
	            if (getX() + iconWidth > canvasWidth) {
	                setX(canvasWidth - iconWidth);
	                setDirection(Direction.LEFT);
	            }
	            break;
	        default:
	            break;
	    }

	    setImage();
	}


  //SPECIFY THE IMAGE TO DISPLAY
  //   USED FOR ANIMATION
  public void setImage() {
	    switch (getDirection()) {
	      case Direction.LEFT:
	    	  currentImage = 0;
	    	  break;
	      case Direction.RIGHT:
	    	  currentImage = 1;
	    	  break;
		default:
			break;
	    }
	 }
  
	public void keyTyped(KeyEvent e) {}
	
	public void keyPressed(KeyEvent e) {
	    if(underControl) {
	    	if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
	 	       	setDirection(Direction.RIGHT);
	 	    }
	 	    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
	 	    	setDirection(Direction.LEFT);
	 	    }
	    }
	}
}