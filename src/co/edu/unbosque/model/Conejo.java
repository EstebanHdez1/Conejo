package co.edu.unbosque.model;

public class Conejo {
	
	int posx, posy, contador;
	String movimiento;
	
	public Conejo(int posx, int posy, int contador, String movimiento) {
		this.posx = posx;
		this.posy = posy;
		this.contador = contador;
		this.movimiento = movimiento;
	}

	public int getPosx() {
		return posx;
	}

	public void setPosx(int posx) {
		this.posx = posx;
	}

	public int getPosy() {
		return posy;
	}

	public void setPosy(int posy) {
		this.posy = posy;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public String getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(String movimiento) {
		this.movimiento = movimiento;
	}
	
}
