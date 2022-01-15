package spaceships;
import java.awt.Color;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import main.MainClass;

public class spaceshipBETA extends spaceship {
	
	
	public static Image img;
	static {
		try {
			spaceshipBETA.img=ImageIO.read(MainClass.class.getResource("/images/BETA.png"));
		}
		catch(Exception ex) {System.out.println(ex);}
	}
	
	public static Color betacolor=Color.magenta;
	public static int x_cord=0; //initialize xcord
	public static int y_cord=cosmosHeight-spaceshipheigth; //initialize ycord
	public static int space_speed=20;
	public spaceshipBETA(){
		super(space_speed,x_cord,y_cord,betacolor);
		super.SpaceShipImageIcon=new ImageIcon(spaceshipBETA.img);
		
	}
	
	public void printCoords() {
		System.out.println("\n");
		System.out.println("spaceshipBETA:");
		System.out.println("Xcord:\n"+super.x_cord+"\nYcord\n"+super.y_cord);
	}


	}