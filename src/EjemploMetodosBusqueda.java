import java.util.Scanner;

class MetodosDeBusqueda {
	
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
				case 0:
					System.out.println("Saliendo...");
					break;
			}
			
		}while(opcion != 0);
		
		

	}

}
