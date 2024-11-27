public class BST<T extends Comparable>
{
    public BST<T> left; 
    public BST<T> right; 
    public BST<T> parent; 
    public T value; 

    public BST(T value) {
        this.value = value; 
        left = right = null; 
    }

    public void add(T value) {
        BST<T> leaf = new BST<T>(value);
        add(leaf, this);
    }
    public void add(BST<T> leaf, BST<T> root) {
        int comp = root.value.compareTo(leaf.value); 
        if (comp<=0) {
            if (root.right==null) {
                root.right = leaf;
                leaf.parent = root; 
            } 
            else add(leaf, root.right); 
        } else {
            if (root.left==null) {
                root.left = leaf;
                leaf.parent = root;
            } 
            else add(leaf, root.left); 
        }
    }
    public void inorden() {
		inorden(this);
	}
    public BST<T> find(T data) {
        BST<T> nodo = new BST<>(data);        
        return find(nodo, this); 
    }
    public BST<T> find(BST<T> it, BST<T> root) {
        int comp = root.value.compareTo(it.value); 
        if (comp==0) return it; 
        if (comp<0) {
            if (root.right==null) return null; 
            return find(it, root.right);
        } else {
            if (root.left==null) return null; 
            return find(it, root.left);
        }
    }

	public void inorden(BST<T> root) {
		if (root==null) return;
		inorden(root.left); 
		System.out.print(root.value.toString()+" ");
		inorden(root.right);
	}
}