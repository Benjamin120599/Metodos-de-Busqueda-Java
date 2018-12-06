import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 	Framework Collecciones Java
 * 
 * 	INTERFACES
 * 		Set		NO permite duplicadas
 * 		List	SI permite duplicadas
 * 		Map		NO permite duplicados de CLAVES (Pares CLAVE-VALOR)
 * 
 * 		Implementaciones
 * 			Set -> HashSet, LinkedHashSet, y Treeset
 * 			List -> ArrayList y LinkedList
 * 			Map -> HashMap, LinkedHashMap y TreeMap
 * 
 * 	CLASES
 * 		Vector
 * 		Queue
 * 		Dequeue
 * 		Stack
 *
 */

class Colecciones {
	
	public void Prueba() {
		
		ArrayList<Integer> numeros = new ArrayList<>();
		
		numeros.add(10);
		numeros.add(4);
		numeros.add(-9);
		numeros.add(32);
		numeros.add(-1);
		
		System.out.println(numeros.toString());
		Collections.sort(numeros);
		System.out.println(numeros.toString());
		
		ArrayList<String> nombres = new ArrayList<>();
		
		nombres.add("Luke");
		nombres.add("Leia");
		nombres.add("Anakyn");
		nombres.add("Obi Wan Kenobi");
		
		ArrayList<String> copiaNombres = (ArrayList<String>) nombres.clone();
		
		System.out.println(nombres.toString());
		Collections.sort(nombres);
		System.out.println(nombres.toString());
		
		System.out.println("======== Ordenamiento en orden Inverso ========");
		System.out.println(copiaNombres.toString());
		Collections.sort(copiaNombres, Collections.reverseOrder());
		System.out.println(copiaNombres.toString());
		
		
		System.out.println("================================================");
		
		class Alumno implements Comparable<Alumno> {
			String numControl;
			Integer edad;
			
			public Alumno(String numControl, int edad) {
				this.numControl = numControl;
				this.edad = edad;
			}

			@Override
			public String toString() {
				return "Alumno [numControl=" + numControl + ", edad=" + edad + ", getClass()=" + getClass()
						+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
			}

			/*
			@Override
			public int compareTo(Alumno o) {
				// TODO Auto-generated method stub
				return numControl.compareTo(o.numControl);
			}
			*/
			
			public int compareTo(Alumno o) {
				return edad.compareTo(o.edad);
			}
			
		}
		
		Alumno a1 = new Alumno("17", 20);
		Alumno a2 = new Alumno("1", 1);
		Alumno a3 = new Alumno("7", 56);
		Alumno a4 = new Alumno("878", 30);
		Alumno a5 = new Alumno("3", 7);
		
		ArrayList<Alumno> alumnos = new ArrayList<>();
		alumnos.add(a1);
		alumnos.add(a2);
		alumnos.add(a3);
		alumnos.add(a4);
		alumnos.add(a5);
		
		System.out.println(alumnos.toString());
		Collections.sort(alumnos);
		System.out.println(alumnos.toString());
		
		
		System.out.println(Collections.binarySearch(numeros, -1));
		System.out.println(Collections.binarySearch(alumnos, a3));
		
		
		//TAREA: Aplicar Binary Search en coleccion alumnos
	}
	
	
}

class HashCero {

	String[] arreglo;
	int tamaño, contador;
	
	public HashCero(int tam) {
		tamaño = tam;
	    arreglo = new String[tam];
	    Arrays.fill(arreglo, "-1");
	}
	
	public void funcionHash(String[] cadenaArreglo,String[] arreglo){
		int i;
	    for(i=0;i<cadenaArreglo.length;i++) {
	    	
	    	String elemento=cadenaArreglo[i];
	        int indiceArreglo=Integer.parseInt(elemento)%7;
	        System.out.println("El indice es "+ indiceArreglo+"  para el elemento "+ elemento);
	                                
	        while( arreglo[indiceArreglo] != "-1") {
	        	indiceArreglo++;
	            System.out.println("Ocurrio una colision para el indice "+(indiceArreglo-1)+" cambiar al indice "+ indiceArreglo);
	            indiceArreglo %= tamaño;
	        }
	        arreglo[indiceArreglo]=elemento;
	    }
	}

	public String buscarClave(String elemento){
	    int indiceArreglo=Integer.parseInt(elemento)%7;
	    int contador=0;

	    while(arreglo[indiceArreglo]!="-1"){
	    	if(arreglo [indiceArreglo] == elemento){
	    		System.out.println("  el elemento "+ elemento+" fue encontrado en la posicion "+indiceArreglo);
	    		return arreglo[indiceArreglo];
	    	}
	    	indiceArreglo++;
	    	indiceArreglo%=tamaño;
	    	contador++;
	    	if( contador>7){
	    		break;
	    	}
	    }
	    return null;
	 }  
}


class MetodosDeBusqueda {
	
	public MetodosDeBusqueda() {
	}
	
	public void busquedaSecuencial(int[] numeros) {
		
		Scanner entrada = new Scanner(System.in);
		boolean existe = false;
		
		System.out.println("Ingrese el número a buscar.");
		int numBuscado = entrada.nextInt();
		
		for(int b=0; b<numeros.length; b++) {
			if(numeros[b] == numBuscado) {
				System.out.println("El número si existe en la posición "+b+1);
				break;
			} else {
				existe=true;
			}
		}
 		
		if(existe==true) {
			System.out.println("El número no existe.");
		}
		
	}
	
	public int busquedaBinanria(int numeros[], int elemento) {
		
		int centro, primero, valorCentro, ultimo;
		primero = 0;
		ultimo = numeros.length-1;
		
		while(primero <= ultimo) {
			centro = (primero + ultimo)/2;
			valorCentro = numeros[centro];
			System.out.println("Comparando "+elemento+" con "+numeros[centro]);
			
			if(elemento == valorCentro) {
				return centro;
			} else if(elemento < valorCentro) {
				ultimo = centro - 1;
			} else {
				primero = centro + 1;
			}
		}
		
		return -1;
	}
	 
	public int[] vector100() {
		int[] vector = new int[100];
		int numeroAleatorio = 0;
		for(int i=0; i<vector.length; i++) {
			numeroAleatorio = (int)(Math.random() * 1000) + 1;
			vector[i] = numeroAleatorio;
		}
		return vector;
	}
	
	public void mostrarVector(int[] vector) {
		
		long contador = 0;
		for(int i=0; i<vector.length; i++) {
			if(contador == 20) {
				System.out.println("["+vector[i]+"] -- ");
				contador=0;
			} else {
				System.out.print("["+vector[i]+"] -- ");
			}
			contador++;
		}
		
	}
}


public class EjemploMetodosBusqueda {

	public static void main(String[] args) {
		
		MetodosDeBusqueda mb = new MetodosDeBusqueda();
		int[] arreglo1 = mb.vector100();
		
		mb.mostrarVector(arreglo1);
		
		Scanner entrada = new Scanner(System.in);
		int opcion = 0;
		
		int[] numeros = {100, 34, 56, 73, 90, 200, 199, 11, 91, 123};
		
		do {
			
			System.out.println("               M E N Ú");
			System.out.println();
			System.out.println("1) Búsqueda Secuencial.");
			System.out.println("2) Búsqueda Binaria.");
			System.out.println("3) Búsqueda Por Funciones Hash. ");
			System.out.println("4) Búsqueda Por Colecciones.");
			System.out.println("0) Salir.");
			System.out.println();
			System.out.println("Elija una opción: ");
			opcion = entrada.nextInt();
			
			switch(opcion) {
			
				case 1:
					System.out.println();
					System.out.println("---------------------------------------------------------------------------------");
					System.out.println();
					
					System.out.println("=========== BUSQUEDA SECUENCIAL ===========\n");
					mb.busquedaSecuencial(arreglo1.clone());
					break;
				case 2:
					System.out.println();
					System.out.println("---------------------------------------------------------------------------------");
					System.out.println();
					
					System.out.println("=========== BUSQUEDA BINARIA ===========\n");
					System.out.println();
					System.out.println("Ingrese el número a buscar.");
					int numBuscado = entrada.nextInt();
					
					System.out.println(mb.busquedaBinanria(numeros.clone(), numBuscado));
					break;
				case 3:
					HashCero hash = new HashCero(8);
					
					System.out.println();
					System.out.println("---------------------------------------------------------------------------------");
					System.out.println();
					String[] elementos = {"20", "33", "21", "12", "14", "56", "100"};
				    hash.funcionHash(elementos, hash.arreglo);
					System.out.println("=========== BUSQUEDA POR FUNCIONES HASH ===========\n");
					System.out.println();
					entrada.nextLine();
					System.out.println("Ingrese el número a buscar.");
					String numBus = entrada.nextLine();
					
					String buscado = hash.buscarClave(numBus);
					
					if(buscado == null) {
						System.out.println("El elemento "+numBus+" no se encuentra en la tabla.");
					}
				case 4:
					Colecciones col = new Colecciones();
					col.Prueba();
					break;
					
				case 0:
					System.out.println("Saliendo...");
					break;
			}
			
		}while(opcion != 0);
		
		

	}

}
