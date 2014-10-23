package ar.edu.itba.poo.slick;

import java.util.LinkedList;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

public class Console {

	private static LinkedList<String> console;
	private String fontPath;
	private static int LINES = 6;
	private UnicodeFont consoleFont;
	
	public Console() {
		console = new LinkedList<String>();
		fontPath = new String("data/cour.ttf");
		
		try {
			consoleFont = new UnicodeFont(fontPath, 15, true, false);
			consoleFont.addAsciiGlyphs();
			consoleFont.addGlyphs(400, 600);
			consoleFont.getEffects().add(new ColorEffect(java.awt.Color.WHITE));
			consoleFont.loadGlyphs();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void add(String message){
		
		if(console.size() < LINES)
			console.addLast(message);
		else{
			console.removeFirst();
			console.addLast(message);	
		}
			
	}

	public void draw() {
		int i = 0;
		for (String string : console) {
			consoleFont.drawString(0, i*15, string);
			i++;
		}
	}

}
