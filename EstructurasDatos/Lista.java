public class Lista<T extends Comparable> 
{
	Nodo<T> root; 
	public Lista(T dato) {
		root = new Nodo<T>(dato);
	}
	public T get(int i) {
		Nodo<T> it = root; 
		while (i-- > 0)  {
			it = it.next;
		}
		if (it==null) return null;
		return it.dato; 
	}
	public Nodo<T> ind(int i) {
		Nodo<T> it = root; 
		while (i-- > 0)  {
			it = it.next;
		}
		if (it==null) return null;
		return it; 
	}
	public void add(T nuevo, int i) {
		Nodo<T> x = new Nodo<T>(nuevo);
		if (i>size()) {
			i = size()-1;
		} else if (i<=0) {
			i = 0;
		} 
		Nodo<T> a = root;
		while (i-- > 0) a=a.next; 
		if (size()==1) {
			x.prev = root; 
			x.next = root; 
			root.next = x; 
			root.prev = x;
			root = x;  
		} else {
			Nodo<T> b = a.prev;
			x.prev = b; 
			x.next = a;
			a.prev = x; 
			b.next = x; 	
			if (i==0) root = x; 
		}
	}
	public int size() {
		int s = 0;
		if (root==null) return s; 
		Nodo it = root;
		Nodo itt = root.next;  
		s = 1;
		while (it!=itt) {s++; itt = itt.next;} 
		return s;
	}
	public void erase(T valor) {
		Nodo<T> it = root;
		while (it!=null && it.dato.compareTo(valor)!=0) 
			it = it.next;
		if (it==null) return; 
		if (it==root) {
			if (size()==1) return;
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
		Nodo<T> it = root.prev; 
		Nodo<T> itt = root; 
		while (true) {
			System.out.println(itt.dato.toString()); 
			if (it==itt) break; 
			itt = itt.next;
		}
	}	
}