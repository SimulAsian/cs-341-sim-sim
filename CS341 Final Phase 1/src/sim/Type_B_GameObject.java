package sim;

import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_B_GameObject extends GameObject{

  public Type_B_GameObject(int x, int y) {
    super(x, y);
    setDirection(Direction.DOWN);
    setVelocity(5);
    
    imageList = new LinkedList<Icon>();
    imageList.add(new ImageIcon("images/Type_B_Up.png"));
    imageList.add(new ImageIcon("images/Type_B_Down.png"));
    imageList.add(new ImageIcon("images/Type_B_Left.png"));
    imageList.add(new ImageIcon("images/Type_B_Right.png"));
    
  }

  public void move(Canvas c) {
	    Icon icon = getCurrentImage();
	    int iconHeight = icon.getIconHeight();
	    int iconWidth = icon.getIconWidth();
	    int canvasHeight = (int) c.getSize().getHeight();
	    int canvasWidth = (int) c.getSize().getWidth();

	    switch (getDirection()) {
	        case Direction.UP:
	            setY(getY() - getVelocity());
	            if (getY() < 0) {
	                setY(0);
	                setDirection(Direction.RIGHT);
	            }
	            break;
	        case Direction.DOWN:
	            setY(getY() + getVelocity());
	            if (getY() + iconHeight > canvasHeight) {
	                setY(canvasHeight - iconHeight);
	                setDirection(Direction.LEFT);
	            }
	            break;
	        case Direction.LEFT:
	            setX(getX() - getVelocity());
	            if (getX() < 0) {
	                setX(0);
	                setDirection(Direction.UP);
	            }
	            break;
	        case Direction.RIGHT:
	            setX(getX() + getVelocity());
	            if (getX() + iconWidth > canvasWidth) {
	                setX(canvasWidth - iconWidth);
	                setDirection(Direction.DOWN);
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
	      case Direction.LEFT:
		    currentImage = 2;
		    break;
		  case Direction.RIGHT:
		    currentImage = 3;
		    break;
	    }
	 }
}