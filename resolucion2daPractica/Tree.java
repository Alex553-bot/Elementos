import java.util.ArrayList;
public class Tree<T extends Comparable> implements Comparable
{
    public ArrayList<Tree<T>> childs = new ArrayList<>(); 
    public T data;
    int i = 0;
    public Tree() {
    }
    public int compareTo(Object o) {return 0;}
    public Tree<T> find(T data) {
        return ffind(this, data); 
    }
    private Tree<T> ffind(Tree<T> it, T data) {
        if (it==null) return null;
        if (it.data.compareTo(data)==0) return it;
        for (int i=0 ; i<it.childs.size(); i++) {
            Tree<T> x = ffind(it.childs.get(i), data); 
            if (x!=null) return x; 
        }
        return null;
    }
    public void mirarArbol(Tree<T> root) {
        if (root == null) {
            return;
        }

        Queue<Tree<T>> queue = new Queue<>();
        queue.push(root);
        int nivel = 0; 
        while (queue.size()>0) {
            Tree<T> it = queue.top(); 
            queue.pop();
            if (nivel==it.i) {
                System.out.println(); 
                nivel++;
            }
            System.out.print(it.data.toString()+" ");
            for (int i=0 ; i<it.childs.size(); i++) 
                queue.push(it.childs.get(i));
        }
    }

}