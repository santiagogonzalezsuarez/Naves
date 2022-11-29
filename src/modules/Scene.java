package modules;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Scene extends JPanel implements KeyListener {
	
	public List<Cosa> cosas = new ArrayList<Cosa>();
	
	public Scene() {
		
		this.cosas.add(new Nave(300, 300, this));
		
		for (int i = 0; i < 20; ++i) {
			this.cosas.add(new Enemigo(this));
		}
		
		this.setFocusable(true);
		this.requestFocus();
		this.addKeyListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D graphic2d = (Graphics2D) g;
		
		graphic2d.setColor(Color.BLACK);
		graphic2d.fillRect(0, 0, 640, 480);
		
		for (int i = cosas.size() - 1; i >= 0; --i) {
			cosas.get(i).Dibujar(graphic2d);
		}
	}
	
	public void keyPressed(KeyEvent e) {
	    int key = e.getKeyCode();
	    
	    switch (key) {
    	case KeyEvent.VK_RIGHT:
    		Teclado.Derecha = true;
    		break;
    	case KeyEvent.VK_LEFT:
    		Teclado.Izquierda = true;
    		break;
    	case KeyEvent.VK_UP:
    		Teclado.Arriba = true;
    		break;
    	case KeyEvent.VK_DOWN:
    		Teclado.Abajo = true;
    		break;
    	case KeyEvent.VK_SPACE:
    		Teclado.Disparo = true;
    		break;
	    }
	    
	}

	public void keyReleased(KeyEvent e) {
	    int key = e.getKeyCode();
   
	    switch (key) {
    	case KeyEvent.VK_RIGHT:
    		Teclado.Derecha = false;
    		break;
    	case KeyEvent.VK_LEFT:
    		Teclado.Izquierda = false;
    		break;
    	case KeyEvent.VK_UP:
    		Teclado.Arriba = false;
    		break;
    	case KeyEvent.VK_DOWN:
    		Teclado.Abajo = false;
    		break;
    	case KeyEvent.VK_SPACE:
    		Teclado.Disparo = false;
    		break;
	    }
	}
	
	public void keyTyped(KeyEvent e) {}

	public void Actualizar() {
		for (int i = cosas.size() - 1; i >= 0; --i) {
			cosas.get(i).Actualizar();
		}
	}
	
}
