package gui;
import spaceships.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

import spaceships.spaceshipZERO;

public class SpaceShipSelectionBtnHandler implements ActionListener {
	String name;
	static Clip clip2;
	public SpaceShipSelectionBtnHandler(String x) {
		name=x;
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		
		SelectSpaceShipScreen.getClip().stop();
		SpaceFrame.cardlayout.next(SpaceFrame.spaceFramePanel);
		SpaceFrame.gamePlayScreen.setFocusable(true);
		SpaceFrame.gamePlayScreen.requestFocus();
		PlayMusic("/audio/fighting.wav");
		if(name.equalsIgnoreCase("SZERO")) SpaceFrame.gamePlayScreen.setUserSpaceShip(new spaceshipZERO()); 
		if(name.equalsIgnoreCase("SALPHA")) SpaceFrame.gamePlayScreen.setUserSpaceShip(new spaceshipALPHA());
		if(name.equalsIgnoreCase("SBETA")) SpaceFrame.gamePlayScreen.setUserSpaceShip(new spaceshipBETA());
		if(name.equalsIgnoreCase("SGAMA")) SpaceFrame.gamePlayScreen.setUserSpaceShip(new spaceshipGAMMA());
		if(name.equalsIgnoreCase("SDELTA")) SpaceFrame.gamePlayScreen.setUserSpaceShip(new spaceshipDELTA());	
		if(name.equalsIgnoreCase("okay")) {
		SpaceShipSelectionBtnHandler.getClip2().stop();
		SelectSpaceShipScreen.getClip().setMicrosecondPosition(0);
		SelectSpaceShipScreen.getClip().start();
		SpaceFrame.cardlayout.next(SpaceFrame.spaceFramePanel);}
		
	}

	public  void PlayMusic(String filename)  {

			  try{
			  AudioInputStream audioInputStream =AudioSystem.getAudioInputStream(this.getClass().getResource(filename));
			  clip2 = AudioSystem.getClip();
			  clip2.open(audioInputStream);
			  clip2.loop(Clip.LOOP_CONTINUOUSLY);
			  clip2.start();
			 
			 }
			catch(Exception ex)
			{JOptionPane.showMessageDialog(null,"Error"); }

			    }
	public static Clip getClip2() {return clip2;}
}