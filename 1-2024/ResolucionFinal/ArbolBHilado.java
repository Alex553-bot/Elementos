public class ArbolBHilado<T>  {
	private Hilo<T> raiz; 
	private ArbolBHilado<T> izq, der; 
	public ArbolBHilado() {
		raiz = null; 
		izq = der = null; 
	}
	public void insertar(T dato) {
		Cola<ArbolBHilado> cola; 
		cola = new Cola<ArbolBHilado>(); 
		if (vacia()) {
			raiz = new Hilo<T>(dato); 
			izq = new ArbolBHilado<T>(); 
			der = new ArbolBHilado<T>();
			raiz.setHilo(raiz); 
		} else {
			cola.insertar(this); 
			insertar(cola, dato); 
		}
	}
	private void insertar(Cola<ArbolBHilado> c, T dato) {
		ArbolBHilado<T> arb; 
		arb = c.decolar(); 
		if (arb.vacia()) {
			arb.setRaiz(new Hilo<T>(dato)); 
			arb.setIzq(new ArbolBHilado<T>()); 
			arb.setDer(new ArbolBHilado<T>()); 			
			arb.getRaiz().setHilo(raiz);
		} else {
			c.encolar(arb.getIzq()); 
			c.encolar(arb.getDer()); 
			insertar(c, dato);
		}
	}
}
class Hilo<T> {
	private T dato; 
	private Hilo<T> hilo; 
	// implementar los getters y setters
}