import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
public class Player implements KeyListener{
	String answer = "Start";
	String line;
	int randomNum ;
	int count = 0;
	int answerCount = 0;
	private Object end;
	public void update(GameBetaApplet gba){
		gba.addKeyListener(this);
	}
	public void paint(Graphics g)  {
			Random randomGanarator = new Random();
			if (answer.equals("Start")) {
			randomNum = 1 + randomGanarator.nextInt(27);
			answer = "";
			}
			
			try {
				BufferedReader fileReader = new BufferedReader(new FileReader("QuestionsBeRich.txt"));
				for (int j = 0; j < randomNum; j++) {
				line = fileReader.readLine();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			String[] str = line.split("-");
			if (!answer.equals("")) {
				if (answer.equals(str[5])) {
					randomNum = 1 + randomGanarator.nextInt(27);
					answer = "";
					answerCount++;
				}else {
					count = -1;
					
				}

			}
			if (answerCount < 10){
				if (count >= 0 ) {
					
					g.setFont(new Font("TimesRoman", Font.BOLD, 40)); 
					g.setColor(Color.ORANGE);
					g.drawString(str[0], 20, 80);
					
					g.setFont(new Font("TimesRoman", Font.BOLD, 40 )); 
					g.drawString(str[1], 109, 375);				
					g.drawString(str[2], 109, 468);
					g.drawString(str[3], 900, 375);
					g.drawString(str[4], 900, 468);
					
					
				}
				if (count < 0 ) {
					
					g.setFont(new Font("TimesRoman", Font.BOLD, 80)); 
					g.setColor(Color.RED);
					g.drawString("...::: GAME OVER!!! :::...", 250, 120);
					g.setFont(new Font("TimesRoman", Font.ITALIC, 56));
					String result = "Отговори правилно на " + answerCount + " от 27 въпроса";
					g.drawString(result, 200, 180);
				
					
				}
			} else {
				g.setFont(new Font("TimesRoman", Font.BOLD, 80)); 
				g.setColor(Color.RED);
				g.drawString("ЧЕСТИТО!!!", 250, 120);
				g.setFont(new Font("TimesRoman", Font.ITALIC, 56));
				String result = "Отговори правилно на всички въпроси";
				g.drawString(result, 250, 180);
			}
			
	}
		


	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_A:{
				answer = "A";
				count +=1;
				break;
			}
			case KeyEvent.VK_B:{
				answer = "B";
				count +=1;
				break;
			}
			case KeyEvent.VK_C:{
				answer = "C";
				count +=1;
				break;
			}
			case KeyEvent.VK_D:{
				answer = "D";
				count +=1;
				break;
			}
			
		}	
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
}
