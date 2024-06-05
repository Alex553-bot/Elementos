// interfaz para los nodos SE
package LSE;
public class ListaSE<T extends Comparable> {
	public NodoSE<T> root; 
	public ListaSE() {
		root = null; 
	}

	// size, get, add, delete
	public int size() {
		int s = 0; 
		for (NodoSE<T> it = root; it!=null; it = it.next, s++); 
		return s; 
	}
	public int size2() {
		return f(root); 
	}
	public int f(NodoSE<T> nodoActual) {
		if (nodoActual == null) return 0; 
		return f(nodoActual.next)+1;
	}

	public T get(int i) {
		NodoSE<T> ac = ff(i, root); 
		if (ac==null) return null; 
		return ac.value;
	}
	public NodoSE<T> ff(int i, NodoSE<T> nodoActual) {
		if (i==0) return nodoActual;
		if (nodoActual==null) return null; 
		return ff(i-1, nodoActual.next);
	}

	public T get2(int i) {
		NodoSE<T> it = root; 
		for (; i>0 && it!=null; i--, it = it.next); 
		if (it==null) return null; 
		return it.value;
	}

	public void add(T value) {
		addf(root, new NodoSE<T>(value));
	}
	public void addf(NodoSE<T> nodoActual, NodoSE<T> nuevo) {
		if (nodoActual==null) {
			root = nuevo; 
			return;
		} 
		if (nodoActual.next==null) {
			nodoActual.next = nuevo; 
		} else addf(nodoActual.next, nuevo);
	}

	public void add2(T value) {
		NodoSE<T> it, nuevo = new NodoSE<T>(value); 
		for (it = root; it!=null && it.next!=null; it = it.next); 
		if (it==null) {
			root = nuevo; 
		} else {
			it.next = nuevo;
		}
	}

	public void delete(T value) {
		delf(root, value); 
	}
	public int delf(NodoSE<T> nodoActual, T value) {
		if (nodoActual==null) return -1; 
		if (nodoActual.value.compareTo(value)==0) return 1; 
		int sig = delf(nodoActual.next, value); 
		if (sig==1) {
			if (nodoActual.next!=null)
				nodoActual.next = nodoActual.next.next;
			else
				nodoActual.next = null;   
		}
		return 0;
	}

	public void delete2(T value) {
		if (root.value.compareTo(value) == 0) {
			root = root.next; 
		} else {
			NodoSE<T> it = root; 
			for (; it!=null && it.next!=null; it = it.next) {
				if (it.next.value.compareTo(value) == 0)
					it.next = it.next.next; 
			}
		}
	}
}