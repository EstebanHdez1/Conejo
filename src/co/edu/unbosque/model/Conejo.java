package co.edu.unbosque.model;

public class Conejo {
	
	int posx, posy, contador;
	
	public Conejo(int posx, int posy, int contador) {
		this.posx = posx;
		this.posy = posy;
		this.contador = contador;
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
	
}
