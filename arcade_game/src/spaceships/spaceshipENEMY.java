package spaceships;
import gui.GamePlayScreen;
import gui.Hitbox;

import java.awt.Color;
import java.awt.Image;
import java.util.LinkedList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import main.MainClass;
import spaceships_laserguns.Laser;

public class spaceshipENEMY extends spaceship {
	static Random random=new Random();
	public static boolean fire;
	public static Image img;
	static {
		try {
			spaceshipENEMY.img=ImageIO.read(MainClass.class.getResource("/images/ENEMY.png"));
			spaceshipENEMY.img=spaceshipENEMY.img.getScaledInstance(spaceshipWidth,spaceshipheigth,0);
		}
		catch(Exception ex) {System.out.println(ex);}
	}
	
	public static Color enemycolor=Color.white;
	public static int x_cord=cosmosWidth/2 ;//initialize xcord
	public static int y_cord=30; //initialize ycord
	public static int space_speed=15;
	public spaceshipENEMY(){
		super(space_speed,x_cord,y_cord,enemycolor);
		super.SpaceShipImageIcon=new ImageIcon(spaceshipENEMY.img);
		
	}

	
	
	public void printCoords() {
		System.out.println("\n");
		System.out.println("spaceshipENEMY:");
		System.out.println("Xcord:\n"+super.x_cord+"\nYcord\n"+super.y_cord);
	}
	
	
	
	
	public void huntuserspaceship(spaceship userSpaceShip) {
		int mv=random.nextInt(10);
		int res=random.nextInt(6);
		
	if (GamePlayScreen.game_ends==true) {
		return ;
	}
	else {
	if(mv==5) {
		fire=true;
	}
	else fire=false;
	
	if(res==5) {
		if(userSpaceShip.getX()>super.getX()) {spaceshipENEMY.x_cord=this.moveRight(); }
		else if (userSpaceShip.getX()<super.getX()) {spaceshipENEMY.x_cord=this.moveLeft(); }
		else {return;}
	}

	if(res==1) {
		for(int i=0;i<random.nextInt(10);i++) {
		spaceshipENEMY.x_cord=this.moveRight();
	}}
	if(res==3) {
		for(int i=0;i<random.nextInt(10);i++) {
		spaceshipENEMY.x_cord=this.moveLeft();
	}}

	}}}
