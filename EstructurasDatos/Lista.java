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
		}  //[1, 2, 3, 4], 5
		else {
			x.prev = it.prev; 
			it.prev.next = x; 
			it.prev = x; 
			x.next = it; 
		}
	}
	private void add(T nuevo, int i) {
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
			System.out.print(itt.dato.toString()+" "); 
			if (it==itt) break; 
			itt = itt.next;
		}
		System.out.println();
	}	

	public void desp(char c, int k) {
		k = k%size();
		Nodo<T> it = root; 
		while (k-- > 0) {
			if (c=='D') it = it.prev; 
			else it = it.next; 
		}

		//Nodo<T> itt = root; 
		//while (itt.next!=null) itt = itt.next; 
		//itt.next = root; 
		
		root = it; 
	}
	public void del() {
		Nodo<T> it = root; 
		Nodo<T> itt = it.next; 
		while (itt!=root) {
			while (itt!=root && itt.dato.compareTo(it.dato) == 0) 
				itt = itt.next; 
			
			if (itt==root) {
				root.prev = it; 
				it.next = root;
				break; 
			} else if (itt==it.next) {
				it = itt; 
				itt = itt.next; 
				continue;
			} 
			else {
				itt.prev = it; 
				it.next = itt; 
			}
			it = itt; 
			itt = itt.next; 
		}
		System.out.println("a");
	}
}



/**
 * 

	1 1 2 3 5 6 6
	del(); 
	=> 1 2 3 5 6

	l: 
		ordenada => ordena? 
		=> O(n*n*n): 
			ordenamiento X
			l.add(x)?? 
			[x] que corresponda

	2 casos: 
	1 caso: es que exista un elemento proximo que sea 
		nodo actual -> nodo diferente
	2 caso: no existe un proximo elemento: 
		nodo actual -> null; 
	int size;

	it = elemento A: 
	itt = elemento A: it.value == itt.value && itt!=null) itt = itt.next; 

	lista simple enlace: 
		it.next = itt; 
	lista doble enlace: 
		if (it.next!=itt) : continue; 
		else: 
			it.next.prev = null; 
			itt.prev.next = null;
			it.next = itt; 
			itt.prev = it; 	
	LSEC: 
	root; 
		it = elemento A: 
		itt = elemento A: it.value == itt.value && itt!=root) itt = itt.next; 
		it.next = itt; //itt sea otro valor o caso contrario itt=root;

	LDEC: 
		it = elemento A: 
		itt = elemento A: it.value == itt.value && itt!=root) itt = itt.next; 
		
		if (itt==it.next ||itt==root) {
			root.prev.next = null; 
			root.prev = it; 
			it.next.prev = null; 
			it.next = root; 
		} else: 
			itt.prev.next = null; 
			itt.prev = it; 
			it.next.prev = null; 
			it.next = itt; 

		<= seguir avanzando 
		> agregalo aqui // antes del elemento
 */