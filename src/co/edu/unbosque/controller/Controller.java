package co.edu.unbosque.controller;

import co.edu.unbosque.model.Campo;

public class Controller {
	
	Campo cam;
	public Controller() {
		//Posición Conejo
		int x = 1;
		int y = 1;
		//Posición Llegada
		int u = 1;
		int v = 10;
		
		//Tamaño Campo [10,10], Punto Llegada [u,v]
		cam = new Campo(10, 10, u-1, v-1);
		//Posición del conejo [x,y]
		cam.solucion(x-1, y-1,0);
	}
	
}
