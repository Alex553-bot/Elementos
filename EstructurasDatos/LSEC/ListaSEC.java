// interfaz para los nodos SE
package LSEC; 
public class ListaSEC<T extends Comparable> {
	public NodoSE<T> root; 
	public ListaSEC() {
		root = null; 
	}

	// size, get, add, delete
	public int size() {
		int s = 0; 
		if (root==null) return  0;
		if (root.next==root) return 1; 
		for (NodoSE<T> it = root.next; it!=root; it = it.next, s++); 
		return s+1; 
	}
	public int size2() {
		if (root==null) return 0;
		if (root.next==root) return 1; 
		return f(root.next)+1; 
	}
	public int f(NodoSE<T> nodoActual) {
		if (nodoActual == root) return 0; 
		return f(nodoActual.next)+1;
	}

	public T get(int i) {
		i = i%size(); 
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
		i%=size(); 
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
		if (nodoActual.next==root) {
			nodoActual.next = nuevo;
			nuevo.next = root; 
		} else addf(nodoActual.next, nuevo);
	}
	public void add2(T value) {
		NodoSE<T> it, nuevo = new NodoSE<T>(value); 
		for (it = root; it!=null && it.next!=root; it = it.next); 
		if (it==null) {
			root = nuevo; 
		} else {
			it.next = nuevo;
			nuevo.next = root; 
		}
	}

	public void delete(T value) {
		if (!find2(value)) return;
		if (root.value.compareTo(value)==0) {
			if (size()==1) {
				root = null; 
				return;
			}
			NodoSE<T> it = root;
			for (; it.next!=root; it = it.next);
			root = root.next; 
			it.next = root; 
		}
		delf(root, value); 
	}
	public int delf(NodoSE<T> nodoActual, T value) {
		if (nodoActual==root) return 0;
		if (nodoActual.value.compareTo(value)==0) return 1; 
		int sig = delf(nodoActual.next, value); 
		if (sig==1) {
			nodoActual.next = nodoActual.next.next;
		}
		return 0;
	}

	public void delete2(T value) {
		if (!find(value)) return;
		if (root.value.compareTo(value) == 0) {
			if (size()==1) {
				root = null; 
				return;
			}
			NodoSE<T> it = root;
			for (; it.next!=root; it = it.next);
			root = root.next; 
			it.next = root; 
		} else {
			NodoSE<T> it = root; 
			for (; ; it = it.next) {
				if (it.next.value.compareTo(value) == 0)
					it.next = it.next.next; 
			}
		}
	}

	public boolean find(T value) {
		if (root==null) return false;
		if (root.value.compareTo(value)==0) return true;
		return dfs(root.next, value); 
	}
	private boolean dfs(NodoSE<T> nodoActual, T value) {
		if (nodoActual==root) return false; 
		if (nodoActual.value.compareTo(value)==0) return true; 
		return dfs(nodoActual.next, value); 
	}
	public boolean find2(T value) {
		if (root==null) return false; 
		if (root.value.compareTo(value)==0) return true;
		for (NodoSE<T> it = root.next; it!=root; it = it.next) {
			if (it.value.compareTo(value)==0) return true;
		}
		return false;
	}

	public void print() {
		if (root==null) return; 
		System.out.print(root.value.toString()+" "); 
		for (NodoSE<T> it = root.next; it!=root; it = it.next)
			System.out.print(it.value.toString()+" "); 
		System.out.println();
	}
}