package gui;

import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SpaceFrame extends JFrame {
	private static final long serialVersionUid=1L;
	static int width;
	static int height;
	static SelectSpaceShipScreen selectSpaceshipScreen=new SelectSpaceShipScreen();
	static GamePlayScreen gamePlayScreen= new GamePlayScreen();
	static CardLayout cardlayout=new CardLayout();
	static JPanel spaceFramePanel= new JPanel();
	
	
	public SpaceFrame(int width,int height) {
		SpaceFrame.width=width;
		SpaceFrame.height=height;
		this.setSize(width,height);
		this.setTitle("Asteroids Arcade");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setFocusable(true);
		setupMasterPanel();
		setResizable(false);
		this.setVisible(true);
	}
	void setupMasterPanel() {
		spaceFramePanel.setLayout(cardlayout);
		spaceFramePanel.add(selectSpaceshipScreen);
		spaceFramePanel.add(gamePlayScreen);
		this.add(spaceFramePanel);
		
		
	}
	

}
