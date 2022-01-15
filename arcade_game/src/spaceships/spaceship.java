package spaceships;

import java.awt.Color;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import gui.Hitbox;
import spaceships_laserguns.*;


public abstract class spaceship implements Navigation {
	public static int cosmosWidth=800;
	public static int cosmosHeight=600;
	public static int spaceshipWidth=100;
	public static int spaceshipheigth=140;
	public int hp=765;
	int speed;
	public int x_cord;
	public int y_cord;
	public Color lcolor;
	public  Lasergun gun;
	protected ImageIcon SpaceShipImageIcon;
	public LinkedList<Laser> lasershooterl=new LinkedList<Laser>();
	public Hitbox hitbox;
	
	
   spaceship(int speed ,int x_cord, int y_cord,Color lcolor){
   
	   this.speed=speed;
	   this.x_cord=x_cord;
	   this.y_cord=y_cord;
	   this.lcolor=lcolor;
	   gun=new Lasergun(lcolor);
	   hitbox=new Hitbox(this.x_cord+20,this.y_cord,60,100);
}	
  
   public ImageIcon getIcon() {
	  return SpaceShipImageIcon;
   }
   

   public void fire(int x,int y) {
	   
	   lasershooterl.add(lasershooterl.size(),new Laser(x,y));
   }
 
   
	public int getX() {
		return x_cord;
	}
	public int getY() {
		return y_cord;
	}
	
	public int moveUp() {
		y_cord-=speed;
		hitbox.y-=speed;
		
		if(y_cord<0) {
		y_cord=y_cord+speed;
		hitbox.y=hitbox.y+speed;
		}
		return 0;
	}

	
	public int moveDown() {
		y_cord+=speed;
		hitbox.y+=speed;
		if(y_cord+spaceshipheigth>cosmosHeight) {
		y_cord=y_cord-speed;
		hitbox.x=hitbox.y-speed;
		}
		return 0;
	}

	
	public int moveLeft() {
		x_cord-=speed;
		hitbox.x-=speed;
		if(x_cord<0) {
		x_cord=x_cord+speed;
		hitbox.x=hitbox.x+speed;
		}
		return 0;
	}
	public LinkedList<Laser> getlist(){
		return lasershooterl;
	}

	
	public int moveRight() {
		x_cord+=speed;
		hitbox.x+=speed;
		if(x_cord+ spaceshipWidth> cosmosWidth) {
		x_cord=x_cord-speed;
		hitbox.x=hitbox.y-speed;
		}
		return 0;
	}
public abstract void printCoords();

}
