import java.applet.*;
import java.awt.*;
public class GameBetaApplet extends Applet implements Runnable {
	
	private static final long serialVersionUID = 1L;
	Thread thread = new Thread(this);
	boolean running = true;
	Player p;
	Image dbImage;
	Graphics dbg;
	public void init(){
		setSize(1400,500);
		p = new Player();
	}
	public void start(){thread.start();}
	public void destroy(){running=false;}
	public void stop(){running=false;}
	public void run(){
		while(running){
			repaint();
			p.update(this);
			try {
				thread.sleep(20);
			} catch (InterruptedException e) {
				System.out.println("Error");
			}
		}
	}
	public void update(Graphics g){
		dbImage = createImage(1400,500);
		dbg = dbImage.getGraphics();
		paint(dbg);
		g.drawImage(dbImage,0,0,this);
		
	}
	public void paint(Graphics g){
		p.paint(g);
	}
}
