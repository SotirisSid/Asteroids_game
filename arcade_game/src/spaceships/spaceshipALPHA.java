
package spaceships;
import java.awt.Color;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import main.MainClass;




public class spaceshipALPHA extends spaceship {
	public static Image img;
	static {
		try {
			spaceshipALPHA.img=ImageIO.read(MainClass.class.getResource("/images/ALPHA.png"));
		}
		catch(Exception ex) {System.out.println(ex);}
	}
	
	public static Color alphacolor=Color.BLUE;
	public static int x_cord=0; //initialize xcord
	public static int y_cord=cosmosHeight-spaceshipheigth; //initialize ycord
	public static int space_speed=10;
	public spaceshipALPHA(){
		super(space_speed,x_cord,y_cord,alphacolor);
		super.SpaceShipImageIcon=new ImageIcon(spaceshipALPHA.img);
		
	}
	
	public void printCoords() {
		System.out.println("\n");
		System.out.println("spaceshipALPHA:");
		System.out.println("Xcord:\n"+super.x_cord+"\nYcord\n"+super.y_cord);
	}




	}