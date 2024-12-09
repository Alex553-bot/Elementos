import java.util.LinkedList;
import java.util.ArrayList;

public class Arbol<T> {
    public T                    data;
    public Arbol<T>             hijo;
    public Arbol<T>             hno;
    public Arbol<T>             padre;
    
    public Arbol(){
        data = null;
        hijo = null;
        padre = null;
        hno = null;
    }
    
    public boolean vacia(){
        return data == null;
    }
    public ArrayList<T> bfs() {
        if (vacia()) return new ArrayList<>();
        LinkedList<Arbol<T>> cola = new LinkedList<>();
        cola.add(this);
        ArrayList<T> res = new ArrayList<>();
        pre(cola, res);
        return res;
    }
    public ArrayList<T> pre(LinkedList<Arbol<T>> cola, ArrayList<T> res) {
        // proceso el nodo: 
        if (cola.size()==0) return res;
        Arbol<T> actual = cola.peek();
        cola.poll();
        if (actual.vacia()) {
            return pre(cola, res);
        }

        res.add(actual.data);
        actual.hno.f(cola);
        cola.add(actual.hijo);
        return pre(cola, res);
    }
    public void f(LinkedList<Arbol<T>> cola) {
        if (vacia()) return;
        cola.add(this);
        hno.f(cola);
    }
}