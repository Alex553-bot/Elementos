package LDE; 
public class ListaDE<T extends Comparable> 
{
	Nodo<T> root; 
	public ListaDE(T dato) {
		root = new Nodo<T>(dato);
	}
	public T get(int i) {
		Nodo<T> it = root; 
		for (; i>0; i--, it = it.next); 
		if (it==null) return null;
		return it.dato; 
	}
	public Nodo<T> ind(int i) {
		Nodo<T> it;
		for (it = root; i>0; i--, it = it.next);  
		if (it==null) return null;
		return it; 
	}
	public void add(T nuevo) {
		Nodo<T> x = new Nodo<T>(nuevo); 

		Nodo<T> it = root; 
		while (it.next!=root && it.dato.compareTo(x.dato) < 1)
			it = it.next;
		if (it.next==root && it.dato.compareTo(x.dato) < 1) {
			it.next = x; 
			x.prev = it; 
			x.next = root; 
			root.prev = x; 
		} 
		else {
			x.prev = it.prev; 
			it.prev.next = x; 
			it.prev = x; 
			x.next = it; 
		}
	}
	public int size() {
		int s = 0;
		for (Nodo<T> it = root; it!=null; it = it.next, s++); 
		return s;
	}
	public void erase(T valor) {
		Nodo<T> it = root;
		while (it!=null && it.dato.compareTo(valor)!=0) 
			it = it.next;
		if (it==null) return; 
		if (it==root) {
			if (size()==1) {
				root = null; 
				return;
			}
			Nodo<T> cola = root.prev;
			cola.next = root.next;
			root.next.prev = cola; 
			root = root.next; 
		} else {
			Nodo<T> ant = it.prev; 
			it.prev = (ant==null? null: ant.prev); 
			if (ant!=null) {
				ant.next = it.next; 
			}	
		}
	}
	public void imprimir() {
		for (Nodo<T> it = root; it!=null; it = it.next) {
			System.out.print(it.dato+" "); 
		}
		System.out.println();
	}	
}