package gui;


public class Hitbox {
	public int x,y,height,width;
	int laser_x_user;
	int laser_y_user;
	int laser_x_enem;
	int laser_y_enem;
	boolean hit_var;
	int index=-1;
	
	public Hitbox(int x,int y ,int height,int width){
		this.x=x;
		this.y=y;
		this.height=height;
		this.width=width;
	}
	
	public void hit(int choice) {
		if(choice==0) {
	    
	    
		GamePlayScreen.userSpaceShip.lasershooterl.forEach((tmp) ->{
			if(inrect(tmp.x,tmp.y)) {
				GamePlayScreen.enemySpaceShip.hp=GamePlayScreen.enemySpaceShip.hp-35;
				index=GamePlayScreen.userSpaceShip.lasershooterl.indexOf(tmp);
				}
			
			
			
		});
		}
		if (choice==1) {
		GamePlayScreen.enemySpaceShip.lasershooterl.forEach((tmp) ->{
			if(inrect(tmp.x,tmp.y)) {
				GamePlayScreen.userSpaceShip.hp=GamePlayScreen.userSpaceShip.hp-35;
				index=GamePlayScreen.enemySpaceShip.lasershooterl.indexOf(tmp);
				
				}
			
		});
		}
	}
	
	public boolean inrect(int x_in,int y_in) {
		boolean in_box=false;
		if((x_in<x) || (x_in>x+width)) {in_box=false;}
		else if((y_in<y) || (y_in>y+height)) {in_box=false;}
		else {in_box=true;}
		
		
		return in_box;
		
		
	}
	public void delete_laser(int choice) {
		if(choice==0) {
		if(index!=-1) {
		GamePlayScreen.userSpaceShip.lasershooterl.remove(index);
		index=-1;
		}}
		else {
			if(index!=-1) {
				GamePlayScreen.enemySpaceShip.lasershooterl.remove(index);
				index=-1;}
			
		}
		
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	

}
