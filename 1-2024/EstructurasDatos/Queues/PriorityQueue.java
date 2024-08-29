package Queues; 
public class PriorityQueue<T extends Comparable> 
{
	private NodoDE<T> first; 
	private NodoDE<T> end;
	private int size; 
	public PriorityQueue() {
		first = end = null; 
	}

	public void push(T valor) {
		NodoDE<T> nuevo = new NodoDE<T>(valor);
	
		if (f(first, nuevo) == 1) 
			first = nuevo;

		if (end==null) end = first; 
		if (end.next!=null) end = end.next;
		size++; 
	}
	private int f(NodoDE<T> nodoActual, NodoDE<T> nuevo) {
		if (nodoActual == null) {
			return 1;
		}
		if (nodoActual.compareTo(nuevo) < 0) {
			nuevo.next = nodoActual; 
			nuevo.prev = nodoActual.prev; 
			nodoActual.prev = nuevo;
			if (nuevo.prev!=null) nuevo.prev.next = nuevo;
		} else {
			int band = f(nodoActual.next, nuevo);
			if (band==1) {
				nodoActual.next = nuevo; 
				nuevo.prev = nodoActual;
			}
		}
		return 0;
	}

	public T pop() {
		if (first==null) return null; 
		T valor = first.value; 

		first = first.next;
		if (first!=null) {
			first.prev = null; 
		} else {
			end = null; 
		}

		size--;

		return valor; 
	}

	public int size() {
		return size;
	}

	public T top() {
		if (first==null) return null; 
		return first.value;
	}

	public void print() {
		for (NodoDE<T> it = first; it!=null; it = it.next) {
			System.out.print(it.value.toString()+" ");
		}
		System.out.println();
	}

}