public class LDE<T> {
	public Node<T> root; 
	public LDE(){
		root = null;
	}

	public void add(T data) {
		Node it = root; 
		if (root==null) {
			root = new Node(data);
			return;
		}
		while (it.next!=null) it = it.next;
		it.next = new Node(data);
		it.next.prev =it;
	}

	public String generar(int i) {
		Dequeue<String> cola = new Dequeue();
		cola.add("la "+root.data.toString()+" que estaba sentada cantando debajo del agua, agua;");
		return f(root, cola, i);
	}

	public String f(Node<T> actual, Dequeue<String> cola, int i) {
		Node<T> ant = actual.prev;
		if (ant!=null) cola.addF("la "+actual.data.toString()+" a la "+ant.data.toString()+",");
		if (i==0) {
			// procesar y retornar: 
			if (actual.next==null) {
				cola.add("cuando la "+actual.data.toString()+" salio ni el mismo diablo la hizo callar.");
			} else {
				cola.add("cuando la "+actual.data.toString()+" salio a cantar vino la "+actual.next.data.toString()+" y la hizo callar;");
			}
			String res = "";
			while (!cola.empty()) 
				res = cola.pop()+res;
			return res;
		}
		return f(actual.next, cola, i-1);
	}
}