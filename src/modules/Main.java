package modules;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Main {

	//public static int contador = 0;
	public static JFrame frame;
	
	public static Nave nave;
	public static Scene miFrame;
	
  	
	public static void main(String[] args) {
		frame = new JFrame("Demo");
		miFrame = new Scene();
      	frame.add(miFrame);
      	frame.setSize(640, 480);
      	frame.setVisible(true);
      
      	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     	
		ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
		exec.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				//contador++;
				miFrame.Actualizar();
				frame.revalidate();
				frame.repaint();
				//System.out.println("Hello " + String.valueOf(Main.contador));
			}
		}, 0, 16, TimeUnit.MILLISECONDS);
     
   }

}
