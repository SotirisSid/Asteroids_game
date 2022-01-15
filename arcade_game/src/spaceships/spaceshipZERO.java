package spaceships;
import java.awt.Color;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import main.MainClass;

public class spaceshipZERO extends spaceship {
	public static Image img;
	static {
		try {
			spaceshipZERO.img=ImageIO.read(MainClass.class.getResource("/images/ZERO.png"));
		}
		catch(Exception ex) {System.out.println(ex);}
	}
	public static Color zerocolor=Color.red;
	public static int x_cord=0; //initialize xcord
	public static int y_cord=cosmosHeight-spaceshipheigth; //initialize ycord
	public static int space_speed=5;
	public spaceshipZERO(){
		super(space_speed,x_cord,y_cord,zerocolor);
		super.SpaceShipImageIcon=new ImageIcon(spaceshipZERO.img);
	}
	
	public void printCoords() {
		System.out.println("\n");
		System.out.println("spaceshipZERO:");
		System.out.println("Xcord:\n"+super.x_cord+"\nYcord\n"+super.y_cord);
	}


	}
