import java.util.ArrayList;
public class Tree<T> {
    ArrayList<Tree<T>> childs;
    Tree<T> parent;
    public T value; 
    public Tree(T value) {
        this.value = value;
        parent = null;
        childs = new ArrayList<>();
    }
}