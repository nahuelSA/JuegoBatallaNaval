package clases;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int tam = 10;
		int cantBarcos = 3;
		int opcion;
		Tablero t1 = new Tablero(tam);
		
		
		
		boolean condicion2 = true;
		boolean condicion3 = true;
		Barco [] barco = new Barco[cantBarcos];
		
			
		System.out.println("-------------------Bienvenido al clasico juego de estrategia Batalla Naval---------------");
		System.out.println("Instrucciones de juego:\n");
		
		System.out.println("Recuerde que el tablero es una matriz de 10 por 10, dicho tamaño puede ser modificado en el caso de ser necesario");
		System.out.println("Tambien deberá tener en cuenta que los barcos que cargue en el tablero, estarán representados por un caracter x,\n"
				+ ""+" los espacios vacios por un caracter como este o");
		System.out.println("Despues de la carga, se validaran que los datos sean correctos \n"
				+"en caso contrario se le pedira al jugador que vuelva a insertar los valores correspondientes");
		System.out.print("Una vez que compience el ataque, las posiciones que el jugador ataque y donde no haya un barco, se representaran con el simbolo -,\n"
				+"si el ataque coincide con la posicion \n"
				+ "de alguno de los barcos el simbolo para representar que el barco fue atacado es @ y por ultimo \n"
				+"cuando dos simbolos @@ se encuentren juntos, esto representa que el barco fue undido.\n");
		System.out.println("El juego finaliza cuando el participante unde todos los barcos del enemigo o cuando selecciona la opcion de salir\n"
				+"del juego\n\n");
		
		System.out.println("A continuación se le pediran que ingresen los valores para cargar los barcos en el trablero.");
		
		for(int i = 0;i<barco.length;i++){			
				boolean condicion = true;			
				while(condicion){
					barco[i]=new Barco();
					System.out.println("Ingrese un valor entero del 0 al 9 para cargar la fila del barco N° "+(i+1)+" : ");
					barco[i].setFila(sc.nextInt(),tam);
					if(barco[i].getFila()==(-1)){
						--i;
						System.out.println("El valor ingresado no corresponde a un posicion valida, vuelva a cargar..");
						break;
					}
					System.out.println("Ingrese un caracter de a hasta j para cargar la columna del barco N° "+(i+1)+" : ");
					barco[i].setColumna1(sc.next());
					if(barco[i].getColumna1()==(-1)){
						--i;
						System.out.println("El valor ingresado no corresponde a un posicion valida, vuelva a cargar..");
						break;
					}
					if((t1.valPosVacia(barco[i].getFila(),barco[i].getColumna1()))==false){
						--i;
						System.out.println("Vuelva a cargar las posciciones del barco con valores válidos..");
						break;
					}
					System.out.println("Ingrese un segundo valor del 0 al 9 para cargar la segunda fila del barco N° "+(i+1)+" : ");
					barco[i].setFila2(sc.nextInt(), tam);
					if(barco[i].getFila2()==(-1)){
						--i;
						System.out.println("El valor ingresado no corresponde a un posicion valida, vuelva a cargar..");
						break;
					}
					System.out.println("Ingrese un caracter de a hasta j para cargar la segunda columna del barco N° "+(i+1)+" : ");
					barco[i].setColumna2(sc.next());
					if(barco[i].getColumna2()==(-1)){
						--i;
						System.out.println("El valor ingresado no corresponde a un posicion valida, vuelva a cargar..");
						break;
					}
					if((t1.valPosVacia(barco[i].getFila2(),barco[i].getColumna2()))==false){
						System.out.println("vuelva a cargar el barco con datos validos:");
						--i;
						break;
					}
					if(t1.sePuedeCargar(barco[i].getFila(),barco[i].getColumna1(),barco[i].getFila2(),barco[i].getColumna2())){
						t1.cargarBarco(barco[i]);
						t1.mostrarTablero();
						System.out.println("Barco N° "+(i+1)+" cargado correctamente \n");
						condicion=false;
					}
					else{
						System.out.println("Ocurrio un error durante la carga, vuelva a cargar con datos validos...");
						--i;
						break;
					}
					
				}
			}
			
			while(condicion2){
				System.out.println("\n\nOpciones del juego");
				System.out.println("Ingrese una de las ciguientes opciones: ");
				System.out.println("- 1 atacar barco");
				System.out.println("- 2 cantidad de barcos undidos hasta el momento");
				System.out.println("- 3 cantidad de barcos rotos hasta el momento");
				System.out.println("- 4 cantidad de ataques realizados al enemigo");
				System.out.println("- 5 mostrar tablero");
				System.out.println("- 6 Salir del menu de opciones ");
				opcion = sc.nextInt();
				switch(opcion){
				case 1 : t1.atacarBarco(cantBarcos);
						 if(t1.getConBarcosUndidos()==cantBarcos){
							 System.out.println("Juego terminado");
							 condicion2=false;
						 }
						 break;
				case 2 : System.out.println("La cantidad de barcos undidos hasta el momento son "+t1.getConBarcosUndidos());
						 break;
				case 3 : System.out.println("La cantidad de barcos rotos hasta el momento son "+t1.getContadorDeBarcosRotos());
						 break;
				case 4 : System.out.println("La cantidad de ataques realizados hasta el momento son "+t1.getContDataques());
						 break;
				case 5 : t1.mostrarTablero();
						 break;	
				case 6 : condicion2=false;
						 break;		
				default : t1.atacarBarco(cantBarcos);
				}
				
			}			
		
			
		
	}
}
