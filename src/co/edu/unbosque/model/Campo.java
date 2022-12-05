package co.edu.unbosque.model;

public class Campo {
	
	int[][] campo;
	Conejo co = new Conejo(0, 0, 0);
	int saltos = 0;
	int llegadai, llegadaj;
	Boolean ab = null;
	int d = 1; //Tamaño saltos derecha izquierda
	int a = 1; //Tamaño saltos arriba abajo
	
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
	
	public void solucion(int x, int y, int count) {
		if(llegadai%d != 0 || llegadaj%a != 0) {
			System.out.println("No se pueden hacer los movimientos");
			System.exit(0);
			return;
		}
		co.setPosx(x);
		co.setPosy(y);
		co.setContador(count);
		campo[co.getPosx()][co.getPosy()] = 1;
		impCampo(campo);
		System.out.println("Saltos: "+count);
		if(co.getPosx() == llegadai && co.getPosy() == llegadaj) {
			System.out.println("El Conejo esta en el final");
			System.exit(0);
			return;
		}
		
		double dis = distan(x, y, llegadai, llegadaj);
		System.out.println("Dis: "+dis);
		
		//Contador 0
		if(co.getContador() == 0) {
			//Si esta pegado a la izquierda se mueve a la derecha
			if(co.getPosy() == 0) {
				campo[co.getPosx()][co.getPosy()] = 0;
				ab=false;
				solucion(co.getPosx(),co.getPosy()+d,count+1);
			}else
			//Si esta pegadoa la derecha se mueve a la izquierda
			if(co.getPosy() == campo[0].length-1) {
				campo[co.getPosx()][co.getPosy()] = 0;
				ab=false;
				solucion(co.getPosx(),co.getPosy()-d,count+1);
			}else
			//Si esta en el centro se mueve a la derecha o izquierda dependiendo de la llegada
			if(co.getPosy() > 0 && co.getPosy() < campo[0].length-1) {
				//iz
				if(llegadaj < co.getPosy()) {
					campo[co.getPosx()][co.getPosy()] = 0;
					ab=false;
					solucion(co.getPosx(),co.getPosy()-d,count+1);
				}
				//dere
				if(llegadaj > co.getPosy()) {
					campo[co.getPosx()][co.getPosy()] = 0;
					ab=false;
					solucion(co.getPosx(),co.getPosy()+d,count+1);
				}
				
			}
		}

		
		if(ab != null) {
			if(ab==true) {
				if(co.getPosy() == llegadaj) {
					if(co.getPosy() == campo.length-1) {
						campo[co.getPosx()][co.getPosy()] = 0;
						ab=false;
						solucion(co.getPosx(),co.getPosy()-d,count+1);
					}
					if(co.getPosy() == 0) {
						campo[co.getPosx()][co.getPosy()] = 0;
						ab=false;
						solucion(co.getPosx(),co.getPosy()+d,count+1);
					}

				}
				if(co.getPosy() > 0 && co.getPosy() < campo[0].length-1) {
					//iz
					if(llegadaj < co.getPosy()) {
						campo[co.getPosx()][co.getPosy()] = 0;
						ab=false;
						solucion(co.getPosx(),co.getPosy()-d,count+1);
					}
					//dere
					if(llegadaj > co.getPosy()) {
						campo[co.getPosx()][co.getPosy()] = 0;
						ab=false;
						solucion(co.getPosx(),co.getPosy()+d,count+1);
					}
					
				}
			}
			if(ab==false) {
				System.out.println("entre false");
				
				if(co.getPosx() == llegadai) {

					if(co.getPosx() == campo.length-1) {
						campo[co.getPosx()][co.getPosy()] = 0;
						ab=true;
						solucion(co.getPosx()-a,co.getPosy(),count+1);
					}
					if(co.getPosx() == 0) {
						campo[co.getPosx()][co.getPosy()] = 0;
						ab=true;
						solucion(co.getPosx()+a,co.getPosy(),count+1);
					}
					if(co.getPosx() > 0 && co.getPosx() < campo.length-1) {
						if(llegadai < co.getPosx()) {
							campo[co.getPosx()][co.getPosy()] = 0;
							ab=true;
							solucion(co.getPosx()+a,co.getPosy(),count+1);
						}
						if(llegadai > co.getPosx()) {
							campo[co.getPosx()][co.getPosy()] = 0;
							ab=true;
							solucion(co.getPosx()-a,co.getPosy(),count+1);
						}else
						if(co.getPosx() == llegadai) {
							campo[co.getPosx()][co.getPosy()] = 0;
							ab=true;
							solucion(co.getPosx()+a,co.getPosy(),count+1);
						}
					}
				}

				if(co.getPosx() > 0 || co.getPosx() < campo.length-1) {
					//abajo
					if(llegadai < co.getPosx()) {
						campo[co.getPosx()][co.getPosy()] = 0;
						ab=true;
						System.out.println("entre abajo");
						solucion(co.getPosx()-a,co.getPosy(),count+1);
					}
					//arriba
					if(llegadai > co.getPosx()) {
						campo[co.getPosx()][co.getPosy()] = 0;
						ab=true;
						System.out.println("entre arriba");
						solucion(co.getPosx()+a,co.getPosy(),count+1);
					}
					
				}
			}
		}
		
		if(dis == 1.0) {
			if(llegadaj == co.getPosy()) {
				campo[co.getPosx()][co.getPosy()] = 0;
				solucion(co.getPosx()+a,co.getPosy(),count+1);
			}
			
		}
		
	}
	
	public double distan(int x, int y, int u, int v) {
		double dis = ((Math.sqrt(Math.pow(x-u,2)+Math.pow(y-v,2))));
		return dis;
	}
	
}
