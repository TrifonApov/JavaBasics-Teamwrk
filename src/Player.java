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
	public void update(GameBetaApplet gba){
		gba.addKeyListener(this);
	}
	public void paint(Graphics g)  {
			Random randomGanarator = new Random();
			if (answer.equals("Start")) {
			randomNum = 1 + randomGanarator.nextInt(5);
			answer = "Choose the correct answer. Press  A,B,C or D  button.";
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
			if (!answer.equals("Choose the correct answer. Press  A,B,C or D  button.")) {
				if (answer.equals(str[5])) {
					randomNum = 1 + randomGanarator.nextInt(5);
					answer = "Choose the correct answer. Press  A,B,C or D  button.";
				}else {
					count = -1;
				}

			}
			if (count >= 0 ) {
				//g.drawImage("/backGraund.jpg", 10, 40, 500, 100, null);
				g.setFont(new Font("TimesRoman", Font.BOLD, 40)); 
				g.setColor(Color.ORANGE);
				g.drawString(str[0], 20, 40);
				g.setFont(new Font("TimesRoman", Font.BOLD, 20 ));
				g.drawString(answer, 200, 150);
				g.setFont(new Font("TimesRoman", Font.BOLD, 40 )); 
				g.drawString("A - " + str[1], 180, 200);
				g.drawString("C - "+str[3], 180, 300);
				g.drawString("B - "+str[2], 420, 200);
				g.drawString("D - "+str[4], 420, 300);
				
			}
			if (count < 0 ) {
				g.setFont(new Font("TimesRoman", Font.BOLD, 40)); 
				g.setColor(Color.RED);
				g.drawString("...::: GAME OVER!!! :::...", 200, 200);
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
