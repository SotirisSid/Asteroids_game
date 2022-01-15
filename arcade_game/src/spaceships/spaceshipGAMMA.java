package spaceships;
import java.awt.Color;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import main.MainClass;

public class spaceshipGAMMA extends spaceship {
	public static Image img;
	static {
		try {
			spaceshipGAMMA.img=ImageIO.read(MainClass.class.getResource("/images/GAMA.png"));
		}
		catch(Exception ex) {System.out.println(ex);}
	}
	public static Color gammacolor=Color.orange;
	public static int x_cord=0; //initialize xcord
	public static int y_cord=cosmosHeight-spaceshipheigth; //initialize ycord
	public static int space_speed=30;
	public spaceshipGAMMA(){
		super(space_speed,x_cord,y_cord,gammacolor);
		super.SpaceShipImageIcon=new ImageIcon(spaceshipGAMMA.img);
	}
	
	public void printCoords() {
		System.out.println("\n");
		System.out.println("spaceshipGAMMA:");
		System.out.println("Xcord:\n"+super.x_cord+"\nYcord\n"+super.y_cord);
	}


	}
