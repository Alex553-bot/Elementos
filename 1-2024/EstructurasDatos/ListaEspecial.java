import LDE.NodoDE;
public class ListaEspecial<T extends Comparable>
{

	NodoDE<T> ultimo; 
	NodoDE<T> primer; 

	int size = 0;

	public ListaEspecial() {
		ultimo = primer = null; 
	}

	public void add(T value) {
		NodoDE<T> nuevo = new NodoDE<T>(value);
		if (ultimo==null) ultimo = primer = nuevo; 
		else {
			ultimo.next = nuevo; 
			nuevo.prev = ultimo;
			ultimo = ultimo.next;
		}
		size++;
	}

	public void delete(int i) {
		NodoDE<T> it = null; 
		if (i<=size/2) {
			it = avanzar(i, primer); 
		} else it = retroceder(size-i-1, ultimo);
		if (it==null) return; 
		
		it.value = ultimo.value; 
		ultimo = ultimo.prev; 
		
		if (ultimo==null) primer = null; 
		else {
			ultimo.next = null;
		}
		size--;
	}
	private NodoDE<T> avanzar(int i, NodoDE<T> actual) {
		if (actual==null) return null;
		if (i==0) return actual; 
		return avanzar(i-1, actual.next);
	}
	private NodoDE<T> retroceder(int i, NodoDE<T> actual) {
		if (actual==null) return null; 
		if (i==0) return actual ;
		return retroceder(i-1, actual.prev);
	}

	public void print() {
		NodoDE<T> it = primer; 
		for (; it!=null; it = it.next) System.out.print(it.value.toString()+" "); 
		System.out.println();
	}
}