public class Queue<T extends Comparable> 
{
	private NodoDE<T> first; 
	private NodoDE<T> end;
	private int size; 
	public Queue() {
		first = end = null; 
	}

	public void push(T valor) {
		NodoDE<T> nuevo = new NodoDE<T>(valor);
		if (first==null) {
			first = nuevo; 
			end = first; 
		} else {
			end.next = nuevo; 
			nuevo.prev = end; 
			end = end.next; 
		}
		size++; 
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

	public T back() {
		if (end==null) return null; 
		return end.value;
	}

	public void print() {
		for (NodoDE<T> it = first; it!=null; it = it.next) {
			System.out.print(it.value.toString()+" ");
		}
		System.out.println();
	}
}