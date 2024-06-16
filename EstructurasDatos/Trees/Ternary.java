package Trees; 
public class Ternary<T extends Comparable> 
{
	private T raiz;
	private Ternary<T> left, mid, right;

	public Ternary(T value) {
		raiz = value;
	}

	public void add(T x) {
		Ternary<T> nuevo = new Ternary<T>(x); 
		add(this, nuevo); 
	}
	private void add(Ternary<T> root, Ternary<T> nuevo) {
		int comp = root.getValue().compareTo(nuevo.getValue()); 
		if (comp==0) {
			Ternary<T> auxiliar = root.mid();
			nuevo.setMid(auxiliar); 
			root.setMid(nuevo);
		} else if (comp>0) {
			if (root.left()==null) root.setLeft(nuevo); 
			else add(root.left(), nuevo); 
		} else {
			if (root.right()==null) root.setRight(nuevo); 
			else add(root.right, nuevo); 
		}
	}
	
	public int rep() {
		return f(this); 
	}
	private int f(Ternary<T> root) {
		if (root==null) return 0;
		int s = f(root.left()); 
		if (root.mid()!=null) s++; 
		s+=f(root.right());
		return s;
	} 

	public T getValue() {return raiz;}
	
	public Ternary<T> mid(){return mid;}
	public Ternary<T> left(){return left;}
	public Ternary<T> right(){return right;}	
	
	public void setMid(Ternary<T> t) {
		mid = t; 
	}
	public void setLeft(Ternary<T> t) {
		left = t; 
	}
	public void setRight(Ternary<T> t) {
		right = t; 
	}
	public void print() {
		ino(this); 
	}
	private void ino(Ternary<T> root) {
		if (root==null) return;
		ino(root.left());
		System.out.print(root.getValue().toString()+" "); 
		ino(root.mid()); 
		ino(root.right());
	} 
}