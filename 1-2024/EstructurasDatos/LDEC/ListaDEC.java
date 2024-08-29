package LDEC; 
public class ListaDEC<T extends Comparable> 
{
	public Nodo<T> root; 

	public int size() {
		if (root==null) return 0;
		return f(root);
	}
	public int f(Nodo<T> nodoActual) {
		int res = 1; 
		if (nodoActual!=root.prev) 
			res+=f(nodoActual.next);
		return res; 		
	}

	// ingenua 
	public int size2() {
		if (root==null) return 0;
		int res =0 ;
		for (Nodo<T> it = root; it!=root.prev; it = it.next, res++);
		return res; 
	}
	// respuesta correcta
	public int size3() {
		if (root == null) return 0; 
		int res =0 ;
		Nodo<T> it = root.prev; 
		do {
			res++; 
			it = it.next;		
		} while (it!=root.prev); 
		return res; 	
	}

	public int get(T valor) {
		int n = size(); 
		return ff(root, valor, 0, n); 
	}
	private int ff(Nodo<T> nodoActual, T valor, int i, int n) {
		if (i==n) {
			return -1; 
		}
		if (nodoActual.value.compareTo(valor)==0) {
			return i; 
		} 
		return ff(nodoActual.next, valor, i+1, n);
	}
	public int get2(T valor) {
		if (root==null) return -1;
		return fff(root, valor, 0);
	}
	private int fff(Nodo<T> nodoActual, T valor, int i) {
		if (nodoActual.value.compareTo(valor)==0) return i; 
		if (nodoActual==root.prev) return -1; 
		return fff(nodoActual.next, valor, i+1);
	}

	public int get3(T valor) {
		if (root==null) return -1; 
		Nodo<T> it = root.prev; 
		int i =0; 
		do {
			it = it.next; 
			if (it.value.compareTo(valor)==0) return i;
			i++; 
		} while (it!=root.prev);
		return -1; 
	}

	public void add(T valor) {
		Nodo<T> nuevo = new Nodo<T>(valor);
		if (root==null) {
			root = nuevo;
			return;
		}
		if (root==root.next) {
			System.out.println(valor.toString()+"$");
			root.next = nuevo; 
			root.prev = nuevo; 
			nuevo.next = root; 
			nuevo.prev = root; 
			//if (root.compareTo(nuevo)!=-1) root = nuevo;
			return;
		}
		ffff(root, nuevo);
	}
	private void ffff(Nodo<T> nodoActual, Nodo<T> nuevo) {
		if (root.prev==nodoActual || 
			nodoActual.compareTo(nuevo)!=-1) {
			Nodo<T> a = nodoActual; 
			Nodo<T> b = a.prev; 
			Nodo<T> n = nuevo;
			n.next = a; 
			b.next = n; 
			n.prev = b; 
			a.prev = n;
			return;
		}
		ffff(nodoActual.next, nuevo);
	}

	public void print() {
		print1(root); 
	}
	private void print1(Nodo<T> it) {
		System.out.print(it.value.toString()+" ");
		if (it==root.prev) return;
		print1(it.next); 
	}

	public void del(T valor) {
		if (root==null) return;
		if (root==root.next && root.value.compareTo(valor)==0) {
			root = null;
		} else if (root.next.next==root) {
			if (root.value.compareTo(valor)==0) {
				root = root.next; 
			} 
			root.next = root; 
			root.prev = root; 
		}  else {
			fffff(root, valor); 
		}
	}
	private void fffff(Nodo<T> it, T valor) {
		if (valor.compareTo(it.value)==0) {
			it.prev.next = it.next; 
			it.next.prev = it.prev; 
			if (root==it) root = it; 
			return;
		}
		fffff(it.next, valor);
	}
}