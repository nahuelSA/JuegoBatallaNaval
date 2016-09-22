package clases;

public class Barco {

	private int fila;
	private String columna1;
	private int fila2;
	private String columna2;
	
	
	
	
	public Barco(int fila, String columna1, int fila2, String columna2) {
		
		this.fila = fila;
		this.columna1 = columna1;
		this.fila2 = fila2;
		this.columna2 = columna2;
	}
	
	

	public Barco() {
	}



	public void setFila(int fila,int tam) { 
		if(fila>=0&&fila<tam)
			this.fila = fila;
		else			
			this.fila = -1;
	}
	
	public void setFila2(int fila2,int tam) {
		if(fila2>=0&&fila2<tam)
			this.fila2 = fila2;
		else
			this.fila2 = -1;			
	}
	public int getFila() {
		return fila;
	}
	
	public int getFila2() {
		return fila2;
	}
	
	
	
	public void setColumna1(String columna1) {
			switch(columna1){			
				case "a" : this.columna1 = "0";
				   break;
				case "b" : this.columna1 = "1";
				   break;
				case "c" : this.columna1 = "2";
				   break;
				case "C" : this.columna1 = "2";
				   break;
				case "d" : this.columna1 = "3";
				   break;
				case "D" : this.columna1 = "3";
				   break;
				case "e" : this.columna1 = "4";
				   break;
				case "E" : this.columna1 = "4";
				   break;
				case "f" : this.columna1 = "5";
				   break;
				case "F" : this.columna1 = "5";
				   break;
				case "g" : this.columna1 = "6";
				   break;
				case "G" : this.columna1 = "6";
				   break;
				case "h" : this.columna1 = "7";
				   break;
				case "H" : this.columna1 = "7";
				   break;
				case "i" : this.columna1 = "8";
				   break;
				case "I" : this.columna1 = "8";
				   break;
				case "j" : this.columna1 = "9";
				   break;
				case "J" : this.columna1 = "9";
				   break;
				default : this.columna1 = "-1";
			}
			
	}
	
	public int getColumna1() {	
		return Integer.parseInt(columna1);
	}
	
	public void setColumna2(String columna2) {
			switch(columna2){
				case "a" : this.columna2 = "0";
				   break;
				case "b" : this.columna2 = "1";
				   break;			
				case "c" : this.columna2 = "2";
				   break;
				case "d" : this.columna2 = "3";
				   break;
				case "e" : this.columna2 = "4";
				   break;				
				case "f" : this.columna2 = "5";
				   break;				
				case "g" : this.columna2 = "6";
				   break;			
				case "h" : this.columna2 = "7";
				   break;				
				case "i" : this.columna2 = "8";
				   break;			
				case "j" : this.columna2 = "9";
				   break;
				default : this.columna1 = "-1";
			}
	}
	public int getColumna2() {
		return Integer.parseInt(columna2);
	}
	
	
	
	
	
	
	
	
	
}
