public class Nodoo<T extends Comparable> implements Comparable {
    Nodoo<T> next; 
    T value; 
    int contador; 
    public Nodoo(T value) {
        contador = 1; 
        this.value = value; 
        next = null; 
    }

    public int compareTo(Object o) {
        Nodoo<T> otro = (Nodoo)o; 
        return otro.value.compareTo(value);
    }
}