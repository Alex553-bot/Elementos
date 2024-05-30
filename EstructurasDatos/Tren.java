public class Tren<T extends Comparable> {
    private Nodo<T> first, mid, end; 
    public Tren() {
        first = mid = end = null; 
    }

    public int size() {
        int s = 0; 
        for (Nodo<T> it = first; it!=null; it = it.next, s++); 
        return s; 
    }

    public boolean existe(T el) {
        boolean res = false; 
        for (Nodo<T> it = first; it!=null && !res; it = it.next) 
            res |= it.value.compareTo(el)==0;
        return res; 
    }

    public void add(T x) {
        if (existe(x)) {
            for (Nodo<T> it = first; it!=null; it = it.next) 
            if (it.value.compareTo(x)==0) {
                it.contador++; 
                break; 
            }
        } else {
            Nodo<T> nuevo = new Nodo<T>(x);
            if (end!=null) {
                if ((size()&1) == 0 && size()>3) {
                    mid = mid.next; 
                }
                end.next = nuevo; 
                end = end.next;
            } else {
                first = mid = end = nuevo; 
            }
        }
    }

    public void print() {
        for (Nodo<T> it = first; it!=null; it = it.next) {
            System.out.print(it.value.toString()+" "); 
        } 
        System.out.println();
        for (Nodo<T> it = first; it!=null; it = it.next) {
            System.out.print(it.contador+" "); 
        } 
        System.out.println();
        System.out.println(first.value.toString());
        System.out.println(mid.value.toString());
        System.out.println(end.value.toString());
    }
}