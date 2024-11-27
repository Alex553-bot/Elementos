import java.util.LinkedList;
import java.util.Scanner;
public class Main {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int a[] = new int[n], b[] = new int[n], col[] = new int[n+1];
	LinkedList<Integer> hijos[]= new LinkedList[n+1];
	for (int i = 1; i<=n; i++) hijos[i] = new LinkedList();
	for (int i = 0; i<n-1; i++) {
		a[i] = in.nextInt(); b[i] = in.nextInt();
		col[b[i]] = 1;
		hijos[a[i]].add(b[i]);
	}
	int pg = -1; 
	for (int i = 1; i<=n; i++) if (col[i]==0) pg = i;	
	LinkedList<Pair<Integer, Tree<Integer>>> pq = new LinkedList<>();
	pq.push(new Pair(pg, null)); 
	Tree<Integer> root = null;
	int X = in.nextInt();
	Tree<Integer> xx = null;
	while (pq.size()>0) {
		Pair<Integer,Tree<Integer>> ac = pq.pop();
		Integer x = ac.a;Tree<Integer> nodoParent = ac.b; 
		Tree<Integer> actual = new Tree(x);
		if (root==null) root = actual; 
		else {
			nodoParent.childs.add(actual);
			actual.parent = nodoParent;
		}
		while (hijos[x].size()>0) {
			int y = hijos[x].pop();
			pq.add(new Pair(y, actual));
		}
		if (X==x) xx = actual;

	}


		pq.add(new Pair(0, xx));
		int v[] = new int[n+1]; 
		for (int i =0 ; i<=n; i++) v[i] = n+1;
		while (pq.size()>0) {
			Pair<Integer, Tree<Integer>> ac = pq.pop();
			Tree<Integer> ax = ac.b; Integer puntaje = ac.a;
			if (ax==null) continue;
			System.out.println(ax.value); 
			if (ax==null || puntaje > v[ax.value]) continue; 
			v[ax.value] = puntaje; 
			for (int i =0 ; i<ax.childs.size(); i++) 
				pq.push(new Pair(puntaje+1, ax.childs.get(i)));
				pq.push(new Pair(puntaje+1, ax.parent));
		} 
		for (int i= 1; i<=n; i++) System.out.print(v[i]+" ");
		System.out.println();

}
	/**
	public static void main(String[] args) {
		BST<Integer> t = new BST(1);
		for (int i = 2; i<=5;i ++) t.add(i);
		t.inorden();
		System.out.println();
		LinkedList<Pair<BST<Integer>, Integer>> pq = new LinkedList<>();
		int x = 3;
		while (t.value!=x) {
			if (t.value>x) t = t.left; 
			else t = t.right;
		}
		pq.add(new Pair(t, 0));
		int v[] = new int[6]; 
		for (int i =0 ; i<6; i++) v[i] = 6;
		while (pq.size()>0) {
			Pair<BST<Integer>,Integer> ac = pq.pop();
			BST<Integer> a = ac.a; Integer puntaje = ac.b;
			if (a==null) continue;
			System.out.println(a.value); 
			if (a==null || puntaje > v[a.value]) continue; 
			v[a.value] = puntaje; 
			pq.add(new Pair(a.left, puntaje+1)); 
			pq.add(new Pair(a.right, puntaje+1)); 
			pq.add(new Pair(a.parent, puntaje+1));
		} 
		for (int i= 1; i<=5; i++) System.out.print(v[i]+" ");
		System.out.println();
	}**/
	static class Pair<T, K> {
		T a; K b; 
		public Pair(T a, K b) {
			this.a = a; this.b = b;
		}
	}
}