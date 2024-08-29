public class BinaryTreeDecision<T>
{
	public T dato; 
	public BinaryTreeDecision<T> left; 
	public BinaryTreeDecision<T> right;
	public BinaryTreeDecision() {
	} 
	public BinaryTreeDecision(T data) {
		this.dato = data;
	}
	public BinaryTreeDecision(T data, BinaryTreeDecision<T> left, BinaryTreeDecision<T> right) {
		this.left = left; 
		this.right = right; 
		this.dato = data;
	}

	public void print() {
		ff(this); 
	}
	public void ff(BinaryTreeDecision<T> nodoActual) {
		if (nodoActual==null) return; 

		System.out.println(nodoActual); 
		ff(nodoActual.left); 
		ff(nodoActual.right); 		
	} 
	@Override
	public String toString() {
		String res = dato.toString()+"\n";
		if (left!=null) res+="SI: "+left.dato.toString()+"\n";
		if (right!=null) res+="NO: "+right.dato.toString()+"\n";
		return res;
	}

}