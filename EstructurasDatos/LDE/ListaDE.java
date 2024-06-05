package LDE; 
public class ListaDE<T extends Comparable> 
{
	public NodoDE<T> root; 

	public ListaDE() {
		root = null; 
	}

	// recursivo: 
	public int size() {
		return f(root);
	}
	public int f(NodoDE<T> nodoActual) {
		if (nodoActual==null) return 0;
		return 1+f(nodoActual.next);
	}
	public int size2() {
		int s = 0;
		for (NodoDE<T> it = root; it!=null; it = it.next, s++); 
		return s;
	}

	// si existe => me pasa el indice
	// caso contrario me pasa: -1
	public int get(T value) {
		return ff(root, 0, value);	
	}
	private int ff(NodoDE<T> nodoActual, int i, T value) {
		if (nodoActual==null) return -1;
		if (nodoActual.value.compareTo(value)==0) return i; 
		return ff(nodoActual.next, i+1, value);
	}
	public int get2(T value) {
		int i = 0; 
		for (NodoDE<T> it = root; it!=null; i++, it = it.next)
			if (it.value.compareTo(value)==0) return i;
		return -1;
	}

	public void print() {
		fff(root);
	}
	public void fff(NodoDE<T> nodoActual) {
		if (nodoActual==null) {
			System.out.println();
			return;
		}
		System.out.print(nodoActual.value.toString()+" ");
		fff(nodoActual.next);
	}
	public void print2() {
		for (NodoDE<T> it = root; it!=null; it = it.next)
			System.out.print(it.value.toString()+" "); 
		System.out.println(); 
	}

	public void add(T value) {
		NodoDE<T> nuevo = new NodoDE<T>(value);
		int band = af(root, nuevo);
		if (band==1) {
			root = nuevo;
		}
	}
	public int af(NodoDE<T> nodoActual, NodoDE<T> nuevo) {
		if (nodoActual == null) {
			return 1;
		}
		//System.out.println(nodoActual.compareTo(nuevo)+" :"+nodoActual.value.toString()+" "+nuevo.value.toString()); 
		if (nodoActual.compareTo(nuevo) == 0) {
			nuevo.next = nodoActual; 
			nuevo.prev = nodoActual.prev; 
			nodoActual.prev = nuevo;
			if (nuevo.prev!=null) nuevo.prev.next = nuevo;
		} else {
			int band = af(nodoActual.next, nuevo);
			if (band==1) {
				nodoActual.next = nuevo; 
				nuevo.prev = nodoActual;
			}
		}
		return 0;
	}

	public void add2(T value) {
		NodoDE<T> nuevo = new NodoDE<T>(value);
		if (root==null) {
			root = nuevo; 
			return;
		}
		NodoDE<T> ant = root; 
		for (NodoDE<T> nodoActual = root; nodoActual!=null; nodoActual = nodoActual.next){
			if (nodoActual.compareTo(nuevo)==0) {
				nuevo.next = nodoActual; 
				nuevo.prev = nodoActual.prev; 
				nodoActual.prev = nuevo;
				if (nuevo.prev!=null) nuevo.prev.next = nuevo;
				return;
			}
			if (nodoActual==root) continue;
			ant = ant.next; 
		}
		ant.next = nuevo; 
		nuevo.prev = ant;
	}
	
	public void delete(T value) {
		if (root.value.compareTo(value) == 0) {
			root = root.next; 
			if (root!=null) root.prev = null; 
		} else delf(root.next, value); 
	}
	private void delf(NodoDE<T> nodoActual, T value) {
		if (nodoActual==null) return;
		if (nodoActual.value.compareTo(value)==0)  {
			NodoDE<T> sig = nodoActual.next; 
			NodoDE<T> ant = nodoActual.prev; 

			if (sig!=null) sig.prev = ant; 
			if (ant!=null) ant.next =sig;

		} else delf(nodoActual.next, value);
	}
}