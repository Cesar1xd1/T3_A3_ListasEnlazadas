import java.util.Scanner;

interface Correcion{
	Scanner input = new Scanner(System.in);
	
	public static int validacion() {
		int r = 0;
		boolean e = false;
		do {
			try {
				r = input.nextInt();
			} catch (java.util.InputMismatchException h) {
				System.out.println("Ups... Solo numeros porfavor, intenta de nuevo:");
				input.nextLine();
				e=true;
			}
			if (r>0) {
				e=false;
			}else {
				System.out.println("Solo numeros mayores a 0 por favor, intenta de nuevo:");
				e=true;
			}
		}while(e);
		return r;
	}
}








class Nodo{
			private int dato;
			private Nodo nodoSiguiente;
			
			public Nodo() {
			}
			public Nodo(int dato) {
				this.dato = dato;
			}
			
			public int getDato() {
				return dato;
			}
			public void setDato(int dato) {
				this.dato = dato;
			}
			public Nodo getNodoSiguiente() {
				return nodoSiguiente;
			}
			public void setNodoSiguiente(Nodo nodoSiguiente) {
				this.nodoSiguiente = nodoSiguiente;
			}
			
			@Override
			public String toString() {
				return "Nodo [dato=" + dato + ", nodoSiguiente=" + nodoSiguiente + "]";
			}
		}
class ListaEnlazada{
	Nodo nodoInicio;
	Nodo nodoFin;
	//Creacion
	public ListaEnlazada(){
		nodoInicio = nodoFin = null;
	}	
	
	public boolean listaVacia() {
		return (nodoInicio == null)&&(nodoFin == null);
	}
	
	public void mostrarCantidadElementos() {
		Nodo nodoActual = nodoInicio;
		int tim = 0;
		while(nodoActual != (null)){
			tim=tim+1;
			nodoActual=nodoActual.getNodoSiguiente();
		}
		System.out.println("La cantidad de elementos en la lista es: "+tim);
	}
	
	
	
	
	
	public void agregarElementoInicio(int dato){
		Nodo nuevoNodo=new Nodo(dato);
		if (this.listaVacia()) {
			this.nodoInicio=this.nodoFin=nuevoNodo;
		}else {
			
			nuevoNodo.setNodoSiguiente(nodoInicio);
			this.nodoInicio = nuevoNodo;
		}
	}
	
	public void agregarElementoFinal(int dato){
		Nodo nuevoNodo=new Nodo(dato);
		if (this.listaVacia()) {
			
		this.agregarElementoInicio(dato);
		}else {
			Nodo nodoActual;
			nodoActual = nodoInicio;
			while(nodoActual.getNodoSiguiente()!=null){
				
				nodoActual=nodoActual.getNodoSiguiente();
			}
			
			nodoActual.setNodoSiguiente(nuevoNodo);
		}
	}
	
	
	//El de clase
	public int eliminarDatoEspecifico(int dato) {
		if (nodoInicio==null) {
			
			return -1;
		}else if(nodoInicio==nodoFin&&nodoInicio.getDato()==dato){
			System.out.println("encontrado en el primer NODO");
			int n = nodoInicio.getDato();
			nodoInicio=nodoInicio.getNodoSiguiente();
			nodoFin=nodoInicio;
			return n;
		}else {
			Nodo nodoAnterior, nodoSiguiente;
			nodoAnterior = nodoInicio;
			nodoSiguiente = nodoInicio.getNodoSiguiente();
			
			if (nodoAnterior!=null&&nodoAnterior.getDato()==dato) {
				int n = nodoAnterior.getDato();
				nodoInicio=nodoAnterior.getNodoSiguiente();
				return n;
				
			}else {
				while(nodoSiguiente!=null && nodoSiguiente.getDato()!=dato){
					nodoAnterior = nodoAnterior.getNodoSiguiente();
					nodoSiguiente = nodoSiguiente.getNodoSiguiente();
				}
				
				if (nodoSiguiente!=null && nodoSiguiente.getDato()==dato) {
					int n = nodoSiguiente.getDato();
					nodoSiguiente = nodoSiguiente.getNodoSiguiente();
					nodoAnterior.setNodoSiguiente(nodoSiguiente);
					
					return n;
				}else {
					return -9999;
				}
			}
		}
	}
	
	public int eliminarDatoInicio() {
		if (this.listaVacia()) {
			return -1;
		
			}else try{
			
			
			Nodo nodoActual=nodoInicio;
			int r = nodoActual.getDato();
			nodoInicio=nodoActual.getNodoSiguiente();
			return r;
		}catch (Exception x) {
			return -1;
		}
	}
	
	public int eliminarDatoFinal() {
		if (this.listaVacia()) {
			return -1;
		}else try{
			//reasignacion
			Nodo nodoAnterior, nodoSiguiente;
			nodoAnterior = nodoInicio;
			
			
			nodoSiguiente = nodoInicio.getNodoSiguiente();
			
			if (nodoSiguiente==null) {
				int r = nodoInicio.getDato();
				nodoInicio=nodoFin=null;
				
				return r;
				
			}else {
				while(nodoSiguiente.getNodoSiguiente()!=null) {
					
					nodoAnterior = nodoAnterior.getNodoSiguiente();
					//Reasignacion
					
					nodoSiguiente = nodoSiguiente.getNodoSiguiente();
				}
				int r = nodoSiguiente.getDato();
				nodoAnterior.setNodoSiguiente(null);
				return r;
			}
		}catch (Exception h) {
			return -1;
		}
	}
	
	
	
	public void recorrerElementos() {
		Nodo nodoActual = nodoInicio;
		while(nodoActual!=null){
			System.out.print("["+nodoActual.getDato()+"]--> ");
			nodoActual=nodoActual.getNodoSiguiente();
		}
		System.out.println("");
		
		
		
		
		
	}
	
	
	
}
public class pruebaListasEnlazadas {

	public static void main(String[] args) {
		
ListaEnlazada le = new ListaEnlazada();
		int opcion=0;
		int dato;
		int n;
		
		boolean ex=false;
		boolean exx=false;
		
		
		
		
		do {
			System.out.println("========== MENU ==========");
			System.out.println("Digite 1 para Crear Lista");
			System.out.println("Digite 2 pra Verificar si la lista esta  vacia");
			System.out.println("Digite 3 para Insertar un dato");
			System.out.println("Digite 4 para Eliminar un dato");
			System.out.println("Digite 5 para Mostrar la cantidad de elementos en la lista");
			System.out.println("Digite 6 para Mostar la lista");
			System.out.println("Digite 7 para *SALIR*");
			opcion =  Correcion.validacion();
			
			switch (opcion) {
			
			case 1:
				le = new ListaEnlazada();
				System.out.println("La lista ha sido creada");
				break;
			case 2:
				System.out.println(le.listaVacia()?"La lista esta vacia":"La lista *NO* esta vacia");break;
			
			case 3:
				do {
					ex=false;
					System.out.println("Usted escogio =Insertar un dato=");
					System.out.println("=======================================");
					System.out.println("Digite 1 para Insertarlo al Inicio");
					System.out.println("Digite 2 para Insertarlo al Final");
					System.out.println("Digite 3 para *SALIR*");
					
					opcion = Correcion.validacion();
					
					switch (opcion) {
					case 1:
						System.out.println("Ingrese el dato:");
						dato = Correcion.validacion();
						le.agregarElementoInicio(dato);
						break;
					case 2:
						System.out.println("Ingrese el dato:");
						dato = Correcion.validacion();
						le.agregarElementoFinal(dato);
						break;
					case 3:
						ex=true;
						break;
					default:
						System.out.println("Ups... esta opcion es invalida");
						break;
					}
					
				} while (!ex);
			
				break;
			case 4:
				do {
					ex=false;
					System.out.println("Usted escogio =Eliminar un dato=");
					System.out.println("================================================");
					System.out.println("Digite 1 para Eliminarlo al Inicio");
					System.out.println("Digite 2 para Eliminarlo al Final");
					System.out.println("Digite 3 para eliminarlo en un lugar especifico");
					System.out.println("Digite 4 para *SALIR*");
					opcion =  Correcion.validacion();
					switch (opcion) {
					case 1:
						n=le.eliminarDatoInicio();
						System.out.println(n==-1?"La lista esta vacia":n==-9999?"No se pudo eliminar":n+" Se elimino satisfactoriamente");
						break;
					case 2:
						n=le.eliminarDatoFinal();
						System.out.println(n==-1?"La lista esta vacia":n==-9999?"No se pudo eliminar":n+" Se elimino satisfactoriamente");
						break;
					case 3:
						System.out.println("Ingrese el dato a eliminar:");
						dato = Correcion.validacion();
						n=le.eliminarDatoEspecifico(dato);
						System.out.println(n==-1?"La lista esta vacia":n==-9999?"No se pudo eliminar":n+" Se elimino satisfactoriamente");
						break;
					case 4:
						ex=true;
						break;
					default:
						System.out.println("Ups... Esta opcion es invalida");
						break;
					}
				} while (!ex);
				break;
			case 5:
				
				le.mostrarCantidadElementos();
				break;
			case 6: 
				System.out.println("Los datos en la lista son:");
				le.recorrerElementos();
				break;
			case 7:
				exx=true;
				break;
			default:
				System.out.println("Ups.. Esta opcion es invalida");
				break;
			}
		} while (!exx);
		System.out.println("El programa ha finalizado, gracias por usarlo ^^");
		
		
		
		
		
		
	}

}
