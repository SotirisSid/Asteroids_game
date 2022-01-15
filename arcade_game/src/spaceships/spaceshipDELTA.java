package spaceships;

import java.awt.Color;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import main.MainClass;

public class spaceshipDELTA extends spaceship {
	public static Image img;
	static {
		try {
			spaceshipDELTA.img=ImageIO.read(MainClass.class.getResource("/images/DELTA.png"));
		}
		catch(Exception ex) {System.out.println(ex);}
	}
	public static Color deltacolor=Color.yellow;
	public static int x_cord=0; //initialize xcord
	public static int y_cord=cosmosHeight-spaceshipheigth; //initialize ycord
	public static int space_speed=40;
	public spaceshipDELTA(){
		super(space_speed,x_cord,y_cord,deltacolor);
		super.SpaceShipImageIcon=new ImageIcon(spaceshipDELTA.img);
		
	}
	
	public void printCoords() {
		System.out.println("\n");
		System.out.println("spaceshipDELTA:");
		System.out.println("Xcord:\n"+super.x_cord+"\nYcord\n"+super.y_cord);
	}


	}