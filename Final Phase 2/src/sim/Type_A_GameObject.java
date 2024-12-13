package sim;

import java.awt.event.KeyEvent;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_A_GameObject extends GameObject{
	public Type_A_GameObject(int x, int y, boolean underControl) {
		super(x, y, underControl);
		setDirection(Direction.DOWN);
		lastDirection = this.getDirection();
    
		imageList = new LinkedList<Icon>();
	    imageList.add(new ImageIcon("images/Type_A_Up.png"));
	    imageList.add(new ImageIcon("images/Type_A_Down.png"));
  }

  public void move(Canvas c) {
	  Icon icon = getCurrentImage();
	  int iconHeight = icon.getIconHeight();
	  int canvasHeight = (int) c.getSize().getHeight();
	  switch (getDirection()) {
	      case Direction.UP:
	          setY(getY() - getVelocity());
	          if (getY() < 0) {
	              setY(0);
	              setDirection(Direction.DOWN);
	          }
	          break;
	      case Direction.DOWN:
	          setY(getY() + getVelocity());
	          if (getY() + iconHeight > canvasHeight) {
	              setY(canvasHeight - iconHeight);
	              setDirection(Direction.UP);
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
	      case Direction.UP:
	    	  currentImage = 0;
	    	  break;
	      case Direction.DOWN:
	    	  currentImage = 1;
	    	  break;
	      default:
	    	  break;
	    }
	 }
  
	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {
		if(underControl) {
	    	if (e.getKeyCode() == KeyEvent.VK_UP) {
	 	       setDirection(Direction.UP);
	 	    }
	 	    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
	 	       setDirection(Direction.DOWN);
	 	    }
	     }
	}
}

