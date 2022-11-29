package modules;

import java.awt.Color;
import java.awt.Graphics2D;

public class Bala implements Cosa {

	public double x;
	public double y;
	public double size;
	public double angle;
	
	public Bala(double x, double y, double angle) {
		this.size = 5;
		this.angle = angle;
		this.x = x;
		this.y = y;
	}
	
	public void Actualizar() {
		Avanzar(5);
	}
	
	public void Avanzar(double distance) {
		this.x += distance * Math.sin(angle * Math.PI / 180);
		this.y -= distance * Math.cos(angle * Math.PI / 180);
	}	
	
	public void Dibujar(Graphics2D g) {
		
		double x1 = this.x + (size / 2) * Math.sin(angle * Math.PI / 180);
		double y1 = this.y - (size / 2) * Math.cos(angle * Math.PI / 180);
		double x2 = this.x + (size / 2) * Math.sin((angle + 180) * Math.PI / 180);
		double y2 = this.y - (size / 2) * Math.cos((angle + 180) * Math.PI / 180);
		
		g.setColor(Color.GREEN);
		g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
		
	}
	
}
