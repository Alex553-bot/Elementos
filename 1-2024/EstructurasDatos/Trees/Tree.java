package Trees; 
import LSE.*;
public class Tree<T extends Comparable> implements Comparable {
    ListaSE<Tree<T>> childs; 
    public T value; 
    public Tree(T value) {
        this.value = value;
    }

    public int compareTo(Object o) {
        Tree<T> b = (Tree<T>)o; 
        return value.compareTo(b.value);
    }
}