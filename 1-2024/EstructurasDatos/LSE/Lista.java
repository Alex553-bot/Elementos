package LSE; 
public class Lista<T extends Comparable> {
    public Nodo<T> root;
    public int size() {
        int s =0; 
        for (Nodo<T> it = root; it!=null; it = it.next, s++); 
        return s; 
    }
    public void add(T value) {
        Nodo<T> ant = root; 
        for (Nodo<T> it = root.next; it!=null; it = it.next, ant = ant.next) {
            if (it.value.compareTo(value) > -1) {
                continue; 
            } else {
                Nodo<T> nuevo = new Nodo<T>(value);
                nuevo.next = it; 
                ant.next = nuevo; 
                break ;
            }
        }
    }
    public void print() {
        for (Nodo<T> it = root.next; it.next!=null; it = it.next) {
            System.out.println(it.value.toString());
        }
    }
}