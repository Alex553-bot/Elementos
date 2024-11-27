package ds;
public class List<T> {
	Node<T> top ; 
	public List() {
		top = new Node('a');
	}
	public void add(T x) {
		add2(x);
		//Node nuevo = new Node(x); 
		//nuevo.next = top.next;
		//top.next = nuevo;
	}
	public void add2(T x) {
		add2(new Node(x), top);
	}
	private Node add2(Node nuevo, Node actual) {
		if (actual==null) return nuevo;
		Node listaNueva = add2(nuevo, actual.next);
		actual.next = listaNueva;
		return actual;
	}
	public T get(int i) {
		if (i<0 || i>=size()) return null;
		return get(i, top.next);
	}
	private T get(int i, Node actual) {
		if (i==0) return (T)actual.data;
		return get(i-1, actual.next);
	}
	/*
	public void erase(T x) {
		erase(x, top);
	}
	private void erase(T x, Node actual) {
		if (actual==null) return;
		erase(x, actual.next);
		if (actual.next!=null) 
			actual.next = actual.next.next;
	}*/
	public int size() {
		return fsize(top.next);
		//return itsize();
	}
	private int fsize(Node actual) {
		if (actual==null) return 0;
		return 1+fsize(actual.next);
	}
	private int itsize() {
		int s = 0;
		for (Node actual = top.next; 
			actual!=null; 
			actual = actual.next, s++);
		return s;
	}
	public void print() {
		print(top.next);
	}
	private void print(Node actual) {
		if (actual==null) {System.out.println(); return;}
		System.out.print(actual.data+" ");
		print(actual.next);
	}

	public List reverse() {
		return reverse(top.next);
	}
	private List reverse(Node actual) {
		if (actual==null) return new List();
		List listaNueva = reverse(actual.next);
		listaNueva.add(actual.data);
		return listaNueva;
	}

	public boolean cycle() {
		return cycle(top, top.next);
	}
	private boolean cycle(Node tortuga, Node liebre) {
		if (tortuga==null || liebre==null || liebre.next==null) 
			return false;
		if (tortuga==liebre) 
			return true;
		return cycle(tortuga.next, liebre.next.next);
	}
	public void mal() {
		mal(top.next, 0);
	}
	private void mal(Node actual, int i) {
		if (actual==null) return;
		if (i==2) {actual.next = top.next;return;}
		mal(actual.next, i+1);
	}


	public String gen() {
		return fgen(top.next);		
	}
	String fgen(Node lse) {
		if (lse==null) return "";
		String s = fgen(lse.next);
		s+=lse.data.toString();;
		return s;
	}
}