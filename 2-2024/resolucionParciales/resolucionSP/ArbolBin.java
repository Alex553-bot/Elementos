public class ArbolBin<T> {
	public T data; 
	public ArbolBin<T> left, right; 

	public ArbolBin(T data) {
		left = right = null; 
		this.data =data;
	}
	public boolean is() {
		return this.ok();
	}
	public boolean ok() {
		Pair<Integer,Integer> l = new Pair(0, 0), r = new Pair(0, 0);
		if (left==null && right==null) return true;
		if (left!=null) l = left.f(); 
		if (right!=null) r = right.f();
		boolean ok = true;
		if (l.b==r.b) {
			if (l.a!=Math.pow(2, l.b)-1 || r.a<Math.pow(2, r.b-1)-1) ok = false;
		} else if (l.b<r.b) {
			ok = false;
		} else if (l.b-r.b==1) {
			if (l.a<Math.pow(2, l.b-1)-1 || r.a!=Math.pow(2, r.b)-1) ok = false;
		} else {
			ok = false;
		}
		if (left!=null) ok&=left.ok(); 
		if (right!=null) ok&=right.ok();
		return ok;
	}
	private Pair<Integer, Integer> f() {
		Pair<Integer, Integer> actual = new Pair(1, 1), l = new Pair(0, 0), r = new Pair(0, 0);
		if (left!=null) l = left.f(); 
		if (right!=null) r = right.f();
		actual.a += l.a+r.a; 
		actual.b += Math.max(l.b, r.b);
		return actual;
	}
	

	static class Pair<T, K> {
		T a; 
		K b; 
		public Pair(T a, K b) {
			this.a = a; 
			this.b = b;
		}
	}
}