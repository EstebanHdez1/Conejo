package co.edu.unbosque.controller;

import co.edu.unbosque.model.Campo;
import co.edu.unbosque.model.Conejo;

public class Controller {
	
	Campo cam;
	Conejo con = new Conejo(0, 0, 0, "Vertical");
	
	public Controller() {
		int x = 3;
		int y = 2;
		int u = 2;
		int v = 2;
		
		cam = new Campo(3, 3, u-1, v-1);
		cam.solucion(x-1, y-1,0,con.setMovimiento("Vertical"));
	}
	
}
