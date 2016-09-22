package clases;

import java.util.Scanner;

public class Tablero {
	Scanner sc = new Scanner(System.in);
	private int tam;
	private String [][] matriz;
	

	private int contadorDeBarcosRotos;
	private int contDataques;
	private int conBarcosUndidos;
	
	public Tablero(int tam){// constructor parametrizado del tablero, se le pasa el tamaño y se crea la matriz 
		this.tam = tam;
		this.matriz = new String [tam][tam];
		for(int i = 0;i<tam;i++){
			for(int j = 0;j<tam;j++)
				matriz[i][j]="o";			
		}
	}
	
	/*
	 * 		Bloque de Getters and Setters
	 */
	
	 
	public int getContadorDeBarcosRotos() {
		return contadorDeBarcosRotos;
	}

	public int getTam() {
		return tam;
	}

	public void setTam(int tam) {
		this.tam = tam;
	}

	public int getContDataques() {
		return contDataques;
	}
	
	public int getConBarcosUndidos() {
		return conBarcosUndidos;
	}
	/*
	 * 		Fin del bloque   Getters and Setters
	 */
	
	
	/*
	 * 		Bloque de validaciones de posciciones del barco en el tablero
	 */
	public boolean valPosVacia(int a, int b){
		if(this.matriz[a][b]=="o")
			return true;
		return false;
			
	}
	
	private boolean valESI(int f,int c,int f2,int c2){ //retorna verdadero si la posicion esta en la esquina superior izquierda y solo avanza una posicion hacia la derecha o hacia abajo.
		if((f==0&&c==0)&&(f+1==f2||c+1==c2))
			return true;
		else		
			return false;			
	}
	
	private boolean valESD(int f,int c,int f2,int c2){// retorna verdadero si la primera posicion esta en la esquina superior derecha y solo avanza una posicion hacia la izquierda o una hacia abajo.
		if((f==0&&c==9)&&(f+1==f2||c-1==c2))
			return true;
		else
			return false;
	}
	
	private boolean valEII(int f,int c,int f2,int c2){// retorna verdadero si la primera posicion esta en la esquina inferior izquierda y solo avanza una posicion hacia arriba o una hacia la derecha. 
		if((f==9&&c==0)&&(f-1==f2||c+1==c2))
			return true;
		else			
			return false;
	}
	
	private boolean valEID(int f,int c,int f2,int c2){// retorna verdadero si la primera posicion esta en la esquina inferiror derecha y solo avanza una posicion hacia arriba o una hacia la izquierda.
		if((f==9&&c==9)&&(f-1==f2||c-1==c2))
			return true;
		else		
			return false;
	}
	
	private boolean valMEDIO(int f,int c,int f2,int c2){// retorna verdadero si la primera posicion no esta en la primer ni ultima fila ni en la primer y ultima columna y la siquiente posicion solo puede avanzar un casillero hacia arriba o uno hacia abajo o uno hacia la derecha o uno hacia la izquierda.
		if(((f>0&&f<9)&&(c>0&&c<9))&&((f==f2&&((c+1==c2)||(c-1==c2)))||(c==c2&&((f+1==f2)||(f-1==f2)))))
				return true;
		else		
			return false;
	}
	
	public boolean sePuedeCargar(int f,int c,int f2, int c2){// Este metodo agrupa todas las validaciones posibles y si los valores coinciden con alguna de las validaciones el metodo retorna true de lo contrario false.
		if(valESI(f,c,f2,c2))
			return true;
		else if(valESD(f,c,f2,c2))
			return true;
		else if(valEII(f,c,f2,c2))
			return true;
		else if(valEID(f,c,f2,c2))
			return true;
		else if(valMEDIO(f,c,f2,c2))
			return true;
		else
			return false;
		
	}
	

	/*
	 * 		Fin del bloque
	 */
	
	
	/**
	 * 
	 * Bloque de operaciones en el tablero
	 */
	public void cargarBarco(Barco barco){
			this.matriz[barco.getFila()][barco.getColumna1()]="x";
			this.matriz[barco.getFila2()][barco.getColumna2()]="x";
	}

	
	public void mostrarTablero(){
		String [] abcd = {"","a","b","c","d","e","f","g","h","i","j"};
		
		for(int m=0;m<abcd.length;m++){
			System.out.print(" "+abcd[m]);
		}
		System.out.println("");
		for(int h=0;h<this.tam;h++){
			System.out.print(h+ " ");
			for(int j = 0;j<this.tam;j++){
				System.out.print(this.matriz[h][j]+" ");
		}
			System.out.println("");
		}
		System.out.println("------------------------------------------");
	}
		
	public void atacarBarco(int cantBarcos){
		int a;
		String c;
		System.out.println("Ingrese fila");
		a = sc.nextInt();
		System.out.println("Ingrese letra de la a=0 a la j=9 para la coordenada de la columna");
		c = sc.next();
		switch(c){	
		case "a" : c = "0";
		   break;
		case "A" : c = "0";
		   break;
		case "b" : c = "1";
		   break;
		case "B" : c = "1";
		   break;
		case "c" : c = "2";
		   break;
		case "C" : c = "2";
		   break;
		case "d" : c = "3";
		   break;
		case "D" : c = "3";
		   break;
		case "e" : c= "4";
		   break;
		case "E" : c= "4";
		   break;
		case "f" : c = "5";
		   break;
		case "F" : c = "5";
		   break;
		case "g" : c = "6";
		   break;
		case "G" : c = "6";
		   break;
		case "h" : c= "7";
		   break;
		case "H" : c = "7";
		   break;
		case "i" : c = "8";
		   break;
		case "I" : c = "8";
		   break;
		case "j" : c = "9";
		   break;
		case "J" : c = "9";
		   break;
		default : c = "-1";
	
		}
		int b = Integer.parseInt(c);
		if(valPosVacia(a,b)){
			this.matriz[a][b]="-";
			mostrarTablero();
			System.out.println("Fallo el disparo, no le pego a ningun barco, vuelva a intentar");
		}
		else if(this.matriz[a][b]=="-"){
			System.out.println("Esta posicion ya fue atacada");
			System.out.println("vuelva a atacar con otros valores");
			atacarBarco(cantBarcos);
		}
		else if(this.matriz[a][b]=="x"){
				this.matriz[a][b]="@";
				this.contadorDeBarcosRotos++;
				mostrarTablero();
				System.out.println("Dio en el blanco");
				System.out.println("Acaba de romper el barco, para undirlo definitivamente deve destruir la otra mitad, siga atacando la zona.");
				if((this.matriz[a][b]=="@")&&((this.matriz[a+1][b]=="@")||(this.matriz[a-1][b]=="@")||(this.matriz[a][b+1]=="@")||(this.matriz[a][b-1]=="@"))){
					this.conBarcosUndidos++;
					System.out.println("Barco undido");
					if(this.conBarcosUndidos==cantBarcos){
						System.out.println("");
						System.out.println("@@@@!!!!......¡¡¡PLAYER WINER¡¡¡....!!!!!@@@@");
						System.out.println("\n TODOS LOS BARCOS ENEMIGOS FUERON UNDIDOS");
					}
					else
						System.out.println("Barcos undidos hasta el momento: "+this.conBarcosUndidos);
				}
		}
		this.contDataques++;
		
	}
		
	
	
}
