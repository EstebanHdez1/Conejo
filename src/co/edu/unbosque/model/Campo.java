package co.edu.unbosque.model;

import java.util.Arrays;

public class Campo {
	
	int[][] campo;
	Conejo co = new Conejo(0, 0, 0, "");
	int saltos = 0;
	int llegadai, llegadaj;
	
	public Campo(int p, int q, int u, int v) {
		campo = new int[p][q];
		campo[u][v] = 2;
		llegadai = u;
		llegadaj = v;
	}
	
	public static void impCampo(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j]+" | ");
				if(j==a[0].length-1) {
					System.out.println();
				}
			}
		}
		System.out.println("---------------");
	}
	
	public void solucion(int x, int y, int count, Conejo c) {
		c.setPosx(x);
		c.setPosy(y);
		c.setContador(count);
		c.setMovimiento((c.getMovimiento().equals("Vertical"))?"Horizontal":"Vertical");
		campo[c.getPosx()][c.getPosy()] = 1;
		impCampo(campo);
		System.out.println(count);
		if(co.getPosx() == llegadai && c.getPosy() == llegadaj) {
			System.out.println("El Conejo esta en el final");
			return;
		}
		
		if(co.getMovimiento().equals("Vertical")) {
			if(c.getContador() == 0) {
				if(c.getPosy() == 0) {
					campo[c.getPosx()][c.getPosy()] = 0;
					solucion(c.getPosx(),c.getPosy()+1,count+1,c);
				}else
				if(c.getPosy() == campo[0].length-1) {
					campo[c.getPosx()][c.getPosy()] = 0;
					solucion(c.getPosx(),c.getPosy()-1,count+1,c);
				}else
				if(c.getPosy() > 0 && c.getPosy() < campo[0].length-1) {
					campo[c.getPosx()][c.getPosy()] = 0;
					solucion(c.getPosx(),c.getPosy()+1,count+1,c);
					solucion(c.getPosx(),c.getPosy()-1,count+1,c);
				}
			}else {
				if(c.getPosy() == 0) {
					campo[c.getPosx()][c.getPosy()] = 0;
					solucion(c.getPosx(),c.getPosy()+1,count+1,c);
				}else
				if(c.getPosy() == campo[0].length-1) {
					campo[c.getPosx()][c.getPosy()] = 0;
					solucion(c.getPosx(),c.getPosy()-1,count+1,c);
				}else
				if(c.getPosy() > 0 && c.getPosy() < campo[0].length-1) {
					campo[c.getPosx()][c.getPosy()] = 0;
					solucion(c.getPosx(),c.getPosy()+1,count+1,c);
					solucion(c.getPosx(),c.getPosy()-1,count+1,c);
				}
			}
		}else {
			
		}
			
		
		
		
	}
	
}
