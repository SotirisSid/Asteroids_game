package gui;
import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import spaceships.spaceshipALPHA;
import spaceships.spaceshipBETA;
import spaceships.spaceshipDELTA;
import spaceships.spaceshipGAMMA;
import spaceships.spaceshipZERO;


@SuppressWarnings("serial")
public class SelectSpaceShipScreen extends JPanel implements ActionListener{
	public static Clip clip;
	private static final long serialVersionUID = 1L;
	SelectSpaceShipScreen(){
	this.setLayout( new BorderLayout(0, 0) );
	this.add(createNorthPanel(), BorderLayout.NORTH);
	this.add(createCenterPanel(), BorderLayout.CENTER);
	this.add(createSouthPanel(),BorderLayout.SOUTH);
	PlayMusic();
	 
	}
	
	private JPanel createSouthPanel() {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(200, 200));
		panel.setBackground(Color.BLACK);
		return panel;
	}

	private JPanel createNorthPanel()
	{
	JPanel panel = new JPanel();
	panel.setPreferredSize(new Dimension(200, 200));
	JLabel label = new JLabel("Please choose your Spaceship ");
	label.setFont(new Font("Arcade Classic", Font.PLAIN, 25));
	label.setForeground(Color.WHITE);
	panel.setBackground(Color.BLACK);
	panel.add(label );
	return panel;
	}
private JPanel createCenterPanel() {
 JButton btnspacezero=new JButton();
 JButton btnspacealpha=new JButton();
 JButton btnspacebeta=new JButton();
 JButton btnspacegamma=new JButton();
 JButton btnspacedelta=new JButton();
 
btnspacezero.addActionListener(new SpaceShipSelectionBtnHandler("SZERO"));
btnspacealpha.addActionListener(new SpaceShipSelectionBtnHandler("SALPHA"));
btnspacebeta.addActionListener(new SpaceShipSelectionBtnHandler("SBETA"));
btnspacegamma.addActionListener(new SpaceShipSelectionBtnHandler("SGAMA"));
btnspacedelta.addActionListener(new SpaceShipSelectionBtnHandler("SDELTA"));


btnspacezero.setIcon(new ImageIcon(spaceshipZERO.img));
btnspacealpha.setIcon(new ImageIcon(spaceshipALPHA.img));
btnspacebeta.setIcon(new ImageIcon(spaceshipBETA.img));
btnspacegamma.setIcon(new ImageIcon(spaceshipGAMMA.img));
btnspacedelta.setIcon(new ImageIcon(spaceshipDELTA.img));

 makeBtnsTransparent(btnspacezero);
 makeBtnsTransparent(btnspacealpha);
 makeBtnsTransparent(btnspacebeta);
 makeBtnsTransparent(btnspacegamma);
 makeBtnsTransparent(btnspacedelta);
 
 
 JPanel panel=new JPanel();
 panel.setLayout(new GridLayout()); 
 panel.setBackground(Color.BLACK);
 panel.add(btnspacezero);
 panel.add(btnspacealpha);
 panel.add(btnspacebeta);
 panel.add(btnspacegamma);
 panel.add(btnspacedelta);
 
 
return panel;
 
 
}
public static Clip getClip() {return clip;}

public void PlayMusic()  {
	  try{
	  AudioInputStream audioInputStream =AudioSystem.getAudioInputStream(this.getClass().getResource("/audio/intro.wav"));
	  clip = AudioSystem.getClip();
	  clip.open(audioInputStream);
	  clip.loop(Clip.LOOP_CONTINUOUSLY);
	  clip.start();
	
	 }
	catch(Exception ex)
	{JOptionPane.showMessageDialog(null,"Error"); }

	    }

private void makeBtnsTransparent(JButton btnspace) {
	btnspace.setBorderPainted(false);
	btnspace.setBackground(Color.BLACK);
	btnspace.setOpaque(false);
	btnspace.setContentAreaFilled(false);
}


@Override
public void actionPerformed(ActionEvent e) {

}





}
