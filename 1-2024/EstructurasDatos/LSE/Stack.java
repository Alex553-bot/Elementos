package LSE;
public class Stack<T> {
    private NodoSE<T> root; 

    public Stack() {
        root = null; 
    }

    public int size() {
        NodoSE<T> it = root; 
        int s= 0; 
        for (; it!=null; it = it.next, s++);
        return s;
    }

    public void push(T valor) {
        NodoSE<T> nuevo = new NodoSE<T>(valor);
        nuevo.next = root; 
        root = nuevo;
    }

    public T top() {
        return root.value;
    }

    public void pop() {
        if (root==null) return;
        root = root.next;
    }
}
