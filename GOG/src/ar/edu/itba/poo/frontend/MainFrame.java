package ar.edu.itba.poo.frontend;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame {
	
	public static void startMainFrame(){
		JFrame mf = new JFrame("GOG");
		mf.setBounds(10,10,300,200);
		
		JButton btn = new JButton();
		
        mf.setVisible(true);
	}
}
