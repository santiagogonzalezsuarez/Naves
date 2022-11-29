package modules;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class Nave implements Cosa {

	public double x;
	public double y;
	public double size;
	public double angle;
	public Scene scene;
	public int tiempoProximaBala = 0;
	
	public Nave(double x, double y, Scene scene) {
		this.size = 30;
		this.angle = 0;
		this.x = x;
		this.y = y;
		this.scene = scene;
	}

	public void SetSize(double size) {
		this.size = size;
	}
	
	public void Actualizar() {
		if (Teclado.Izquierda) {
			GirarIzquierda(5);
		}
		if (Teclado.Derecha) {
			GirarDerecha(5);
		}
		if (Teclado.Arriba) {
			Avanzar(3);
		}
		if (Teclado.Disparo) {
			if (tiempoProximaBala <= 0) {
				Disparar();
				tiempoProximaBala = 15;
			}
		}
		if (tiempoProximaBala > 0) {
			tiempoProximaBala--;
		}
	}
	
	public void GirarIzquierda(double angle) {
		this.angle -= angle;
	}
	
	public void GirarDerecha(double angle) {
		this.angle += angle;
	}
	
	public void Avanzar(double distance) {
		this.x += distance * Math.sin(angle * Math.PI / 180);
		this.y -= distance * Math.cos(angle * Math.PI / 180);
	}
	
	public void Dibujar(Graphics2D g) {
		
		Polygon p = new Polygon();
	
		g.setColor(Color.BLUE);
		
		p.addPoint((int)(x + size * Math.sin((angle * Math.PI / 180))), (int)(y + size * (0 - Math.cos((angle * Math.PI / 180)))));
		p.addPoint((int)(x + size * Math.sin((angle * Math.PI / 180) + (120 * Math.PI / 180))), (int)(y + size * (0 - Math.cos((angle * Math.PI / 180) + (120 * Math.PI / 180)))));
		p.addPoint((int)(x + size * Math.sin((angle * Math.PI / 180) + (240 * Math.PI / 180))), (int)(y + size * (0 - Math.cos((angle * Math.PI / 180) + (240 * Math.PI / 180)))));

		g.fillPolygon(p);
		
		g.setColor(Color.RED);
		
		double tamanoCabeza = 7;
		
		double cabezaX = this.x + (this.size - tamanoCabeza) * Math.sin(this.angle * Math.PI / 180);
		double cabezaY = this.y - (this.size - tamanoCabeza) * Math.cos(this.angle * Math.PI / 180); 

		g.setColor(new Color(192, 255, 192));
		g.fillOval((int)(cabezaX - tamanoCabeza / 2), (int)(cabezaY - tamanoCabeza / 2), (int)tamanoCabeza, (int)tamanoCabeza);
		
	}
	
	public void Disparar() {
		Bala bala = new Bala(this.x + size * Math.sin(angle * Math.PI / 180), this.y - size * Math.cos(angle * Math.PI / 180), this.angle);
		scene.cosas.add(bala);
	}
}
