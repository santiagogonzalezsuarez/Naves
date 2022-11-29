package modules;

import java.awt.Color;
import java.awt.Graphics2D;

public class Enemigo implements Cosa {

	public double x;
	public double y;
	public double size;
	public double angle;
	public Scene scene;
	public int timerPrimerDisparo = 240;
	
	public Enemigo(Scene scene) {
		this.size = 15;
		this.x = 640 * Math.random();
		this.y = 480 * Math.random();
		this.angle = Math.random() * 360;
		this.scene = scene;
	}

	public void Actualizar() {
		if (this.timerPrimerDisparo > 0) {
			this.timerPrimerDisparo--;
		}
		if (this.timerPrimerDisparo == 0) {
			if (Math.random() * 100 < 1) {
				this.Disparar();
			}
		}
	}
	
	public void Disparar() {
		Bala bala = new Bala(this.x + size * Math.sin(angle * Math.PI / 180), this.y - size * Math.cos(angle * Math.PI / 180), this.angle);
		scene.cosas.add(bala);
	}

	public void Dibujar(Graphics2D g) {
		
		g.setColor(Color.YELLOW);
		g.fillOval((int)(this.x - this.size / 2), (int)(this.y - this.size / 2), (int)this.size, (int)this.size);
		
		double tamanoCabeza = 7;
		
		double cabezaX = this.x + (this.size / 2) * Math.sin(this.angle * Math.PI / 180);
		double cabezaY = this.y - (this.size / 2) * Math.cos(this.angle * Math.PI / 180); 

		g.setColor(Color.RED);
		g.fillOval((int)(cabezaX - tamanoCabeza / 2), (int)(cabezaY - tamanoCabeza / 2), (int)tamanoCabeza, (int)tamanoCabeza);
		
	}	
	
}
