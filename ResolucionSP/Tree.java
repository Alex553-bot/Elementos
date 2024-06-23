import java.util.ArrayList;
public class Tree<T> 
{
    public ArrayList<Tree<T>> childs; 
    public T data; 
    public Tree<T> nextLeaf; 
    public Tree(T data) {
        this.data = data; 
        nextLeaf = null; 
        childs = new ArrayList<>();
    }

    public ArrayList<Tree<T>> leafs() {
        ArrayList<Tree<T>> v = new ArrayList<>();
        leafs(this, v); 
        return v;
    }
    private void leafs(Tree<T> it, ArrayList<Tree<T>> v) {
        if (it.childs.size()==0) dfs(it, v);
        else 
            leafs(it.childs.get(0), v);
    }
    private void dfs(Tree<T> it, ArrayList<Tree<T>> v) {
        if (it==null) return; 
        v.add(it); 
        dfs(it.nextLeaf, v);
    }
}