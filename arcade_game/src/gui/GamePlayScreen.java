package gui;
import spaceships.*;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.Clip;
import javax.swing.JPanel;

import main.MainClass;


@SuppressWarnings("serial")
public class GamePlayScreen extends JPanel implements KeyListener{
public static spaceship userSpaceShip;
public static spaceshipENEMY enemySpaceShip;
public static Clip clip_f;
public static boolean game_ends=false;




 	GamePlayScreen(){
	addKeyListener(this);
	this.setVisible(true);
	this.setBackground(Color.BLACK);
	createDaemon();
	
}

	private void createDaemon() {
		
		Timer timer=new Timer();
		TimerTask task=new monitorDaemonGame();
		
		timer.schedule(task, 100,100);
		
	}
	class monitorDaemonGame extends TimerTask{
		public void run() {
			repaint();}
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(game_ends==false) {
		enemySpaceShip.huntuserspaceship(userSpaceShip);
		enemySpaceShip.hitbox.hit(0);
		enemySpaceShip.hitbox.delete_laser(0);
		
		userSpaceShip.hitbox.hit(1);
		userSpaceShip.hitbox.delete_laser(1);
		if(spaceshipENEMY.fire==true) {enemySpaceShip.fire(enemySpaceShip.getX(),enemySpaceShip.getY()+120);}
		userSpaceShip.getIcon().paintIcon(this,g,userSpaceShip.getX(),userSpaceShip.getY());
		enemySpaceShip.getIcon().paintIcon(this, g, enemySpaceShip.getX(),enemySpaceShip.getY());
		healthbars_enem(g);
		showLaserShootings(g);
		}
		if(userSpaceShip.hp<0) {
			game_ends=true;
			drawGameOver(g);
		}
		if(enemySpaceShip.hp<0) {
			game_ends=true;
			drawGameWon(g);
		}
		
	}

    private void drawGameOver(Graphics g) {

        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 30);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (MainClass.cosmosWidth - fm.stringWidth(msg)-20) / 2,
        		(MainClass.cosmosHeight-40)/ 2);
    }
    private void drawGameWon(Graphics g) {

        String msg = "You Win";
        Font small = new Font("Helvetica", Font.BOLD, 30);
        FontMetrics fm = getFontMetrics(small);
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (MainClass.cosmosWidth - fm.stringWidth(msg)-20) / 2,
        		(MainClass.cosmosHeight-40)/ 2);
    }
    
	
	

	private void healthbars_enem(Graphics g) {
		
		g.drawRect(10, 10, 765, 15);
		g.setColor(Color.red);
		g.fillRect(10,10,enemySpaceShip.hp,15);
		
	
	}
	
	
	private void showLaserShootings(Graphics g) {
		 Graphics2D g2d = (Graphics2D) g;
	    userSpaceShip.lasershooterl.forEach((tmp) ->{
	    if(tmp!=null) {
		g2d.setColor(userSpaceShip.gun.lasercolor);
		g2d.setStroke(new BasicStroke(3));
		g2d.drawLine(tmp.x,tmp.y,tmp.x,tmp.y-15);
		//g2d.drawRect(userSpaceShip.getX()+20,userSpaceShip.getY(),60,100);
		tmp.y=tmp.y-15;}
	});
		
	    
	enemySpaceShip.lasershooterl.forEach((tmp) ->{
		if(tmp!=null) {
		g2d.setColor(enemySpaceShip.gun.lasercolor);
		g2d.drawLine(tmp.x,tmp.y,tmp.x,tmp.y+15);
		//g2d.drawRect(enemySpaceShip.getX()+20,enemySpaceShip.getY(),60,135);
		tmp.y=tmp.y+15;}
	});
	
}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_W) userSpaceShip.moveUp();
		if(e.getKeyCode()==KeyEvent.VK_S) userSpaceShip.moveDown();
		if(e.getKeyCode()==KeyEvent.VK_A) userSpaceShip.moveLeft();
		if(e.getKeyCode()==KeyEvent.VK_D) userSpaceShip.moveRight();
		if(e.getKeyCode()==KeyEvent.VK_UP) userSpaceShip.moveUp();
		if(e.getKeyCode()==KeyEvent.VK_DOWN) userSpaceShip.moveDown();
		if(e.getKeyCode()==KeyEvent.VK_LEFT) userSpaceShip.moveLeft();
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) userSpaceShip.moveRight();
		if(e.getKeyCode()==KeyEvent.VK_B) {
			game_ends=false;
			SpaceShipSelectionBtnHandler.getClip2().stop();
			SelectSpaceShipScreen.getClip().setMicrosecondPosition(0);
			SelectSpaceShipScreen.getClip().start();
			SpaceFrame.cardlayout.next(SpaceFrame.spaceFramePanel);}
		if(e.getKeyCode()==KeyEvent.VK_SPACE) userSpaceShip.fire(userSpaceShip.getX(),userSpaceShip.getY());
		
		if(e.getKeyCode()==KeyEvent.VK_E) { System.out.print("\nENEMY HP:"+enemySpaceShip.hp);
		 System.out.print("\nuser HP:"+userSpaceShip.hp);}
		this.repaint();
	}

@Override
public void keyReleased(KeyEvent e) {}
@Override
public void keyTyped(KeyEvent e) {}
void setUserSpaceShip(spaceship use1) {
	userSpaceShip=use1;
	enemySpaceShip=new spaceshipENEMY();

}}

