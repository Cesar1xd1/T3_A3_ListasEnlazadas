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
	
	public void agregarElementoAlInicio(int dato){
		Nodo nuevoNodo=new Nodo(dato);
		if (this.listaVacia()) {
			this.nodoInicio=this.nodoFin=nuevoNodo;
		}else {
			nuevoNodo.setNodoSiguiente(nodoInicio);
			this.nodoInicio = nuevoNodo;
		}
	}
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
					return -99999;
				}
			}
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
		
	}

}
