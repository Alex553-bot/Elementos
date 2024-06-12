package Trees; 
public class BinaryTree<T>
{
	public BinaryTree<T> left; 
	public BinaryTree<T> right;
	public T value;  

	public BinaryTree(T valor) {
		value = valor; 
	}


	public void pre() {
		pre(this);
	}
	public void pre(BinaryTree<T> root) {
		if (root==null) return;
		System.out.print(root.value.toString()+" ");
		pre(root.left); 
		pre(root.right);
	}
	public void inorden() {
		inorden(this);
	}
	public void inorden(BinaryTree<T> root) {
		if (root==null) return;
		inorden(root.left); 
		System.out.print(root.value.toString()+" ");
		inorden(root.right);
	}
	public void post() {
		post(this);
	}
	public void post(BinaryTree<T> root) {
		if (root==null) return;
		post(root.left); 
		post(root.right);
		System.out.print(root.value.toString()+" ");
	}

	public void add(T value) {
		add(this, new BinaryTree<T>(value)); 
	}
	public void add(BinaryTree<T> root, BinaryTree<T> nuevo) {
		int left = suma(root.left), right = suma(root.right); 
		if (left==right) {
			if (root.left==null) root.left = nuevo; 
			else add(root.left, nuevo); 
		} else {
			if (root.right==null) root.right =nuevo; 
			else add(root.right, nuevo);
		}
	} 

	public int suma(BinaryTree<T> root) {
		if (root==null) return 0; 
		return 1+suma(root.left)+suma(root.right);
	}
}