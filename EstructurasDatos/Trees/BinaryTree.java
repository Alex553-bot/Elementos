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

	public void podar(int n) {
		podar(this, 0, n); 
	}
	private void podar(BinaryTree<T> root, int i, int n) {
		if (root==null) return; 
		if (i==n-1) {
			root.right = root.left = null; 
		}
		podar(root.right, i+1, n); 
		podar(root.left, i+1, n); 
	}

	public boolean esDistribuido() 
	{
		return Math.abs(f(this, 0))<=1; 
	}
	private int f(BinaryTree<T> nodoActual, int r) {
		if (nodoActual==null) return r;
		if (nodoActual.left==null && nodoActual.right==null) 
			r--;
		else {
			r+=f(nodoActual.left, r)+f(nodoActual.right, r)+1;
		}
		return r;
	}

	public int suma(BinaryTree<T> root) {
		if (root==null) return 0; 
		return 1+suma(root.left)+suma(root.right);
	}

	public int internosVerdaderos() {
		return intf(left, false, 1)+intf(right, false, 0);
	}
	private int intf(BinaryTree<T> it, boolean entre, int i) {
		if (it==null) return 0;
		int res = 1;
		if (it.left==null && it.right==null) res = 0;
		if (i==0) {
			return intf(it.left, true, i)+intf(it.right, entre, i)+(entre? res: 0);
		} else {
			return intf(it.left, entre, i)+intf(it.right, true, i)+(entre? res: 0);
		}
	}
}