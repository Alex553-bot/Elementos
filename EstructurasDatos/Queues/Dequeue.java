package Queues;

public class Dequeue<T extends Comparable>
{
	private NodoDE<T> first; 
	private NodoDE<T> end; 

	public Dequeue() {
		first = end = null; 
	}

	public void push_front(T valor) {
		NodoDE<T> nuevo = new NodoDE<T>(valor);
		if (first==null) {
			first = nuevo; 
			end = first; 
		} else {
			nuevo.next = first; 
			first.prev = nuevo; 
			first = nuevo;
		}
	}
	public void push_back(T valor) {
		NodoDE<T> nuevo = new NodoDE<T>(valor);
		if (first==null) {
			first = nuevo; 
			end = first; 
		} else {
			end.next = nuevo; 
			nuevo.prev = end; 
			end = end.next; 
		}
	}

	public int size() {
		int s = 0;
		for (NodoDE<T> it = first; it!=null; it = it.next, s++);
		return s;
	}

	public T top() {
		if (first==null) return null; 
		return first.value;
	}

	public T back() {
		if (end==null) return null; 
		return end.value;
	}

	public T pop_front() {
		if (first==null) return null; 
		T valor = first.value; 

		first = first.next;
		if (first!=null) {
			first.prev = null; 
		} else {
			end = null; 
		}

		return valor; 
	}
	public T pop_back() {
		if (first==null) return null; 
		T valor = end.value; 

		end = end.prev; 
		if (end!=null) {
			end.next = null; 
		} else {
			first = null; 
		}

		return valor; 
	}

	public void print() {
		for (NodoDE<T> it = first; it!=null; it = it.next) {
			System.out.print(it.value.toString()+" ");
		}
		System.out.println();
	}


}