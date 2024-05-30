package LSE; 
public class Nodo<T extends Comparable> implements Comparable
{
    public Nodo<T> next; 
    T value; 
    public Nodo(T value) {
        this.value = value; 
    }
    public int compareTo(Object o) {
        Nodo<T> otro = (Nodo)o; 
        return value.compareTo(otro.value);
    }
}