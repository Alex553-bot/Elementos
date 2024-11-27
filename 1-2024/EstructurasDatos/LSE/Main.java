import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ;
		String s = sc.next();
		Pair<Integer, Integer> res = f(s, s.length());
		System.out.println(res.a+" "+res.b);
		sc.close();
	}
	static Pair<Integer,Integer> f(String t, int n) {
		int dp[] = new int[n], a[] = new int[n]; 
		for (int i = 0; i<n; i++) dp[i] = -1;
		Stack<Integer> stack = new Stack<>(); 
		char s[] =  t.toCharArray();
		for (int i = n-1; i>-1; i--) {
			if (s[i]==')') stack.push(i);
			else {
				if (stack.size()==0) continue;
				dp[i] = stack.top();
				stack.pop();
			}
		}
		while (stack.size()>0) {
			int i = stack.top();
			stack.pop();
			a[i] = 1;
		}

		Stack<Pair<Integer,Integer>> st = new Stack<>();
		for (int i = 0; i<n; i++) {
			st.push(new Pair(i, dp[i]));
			if (dp[i]!=-1) i = dp[i]; 
		}
		Stack<Integer> res = new Stack<>();
		res.push(-1);
		while (st.size()>0) {
			Pair<Integer,Integer> ac = st.top();
			st.pop();
			int nuevo = ac.b==-1? -1: ac.b-ac.a+1;
			if (res.top()==-1 || nuevo==-1) res.push(nuevo);
			else {
				nuevo+=res.top();
				res.pop();
				res.push(nuevo);
			}
		}
		Pair<Integer,Integer> respuesta = new Pair(0, 1);
		while (res.size()>0) {
			int top = res.top();
			res.pop();
			if (top>respuesta.a) {
				respuesta.a = top; respuesta.b = 1;
			} else if (top==respuesta.a) respuesta.b++; 
		}
		return respuesta;
	}



	static class Pair<T, K> {
		T a; 
		K b; 
		public Pair(T a, K b) {
			this.a = a; this.b =b;
		}
	} 

	static class Stack<T> {
    private NodoSE<T> root; 

    public Stack() {
        root = null; 
    }

    public int size() {
        NodoSE<T> it = root; 
        int s= 0; 
        for (; it!=null; it = it.next, s++);
        return s;
    }

    public void push(T valor) {
        NodoSE<T> nuevo = new NodoSE<T>(valor);
        nuevo.next = root; 
        root = nuevo;
    }

    public T top() {
        return root.value;
    }

    public void pop() {
        if (root==null) return;
        root = root.next;
    }
}
static class NodoSE<T> {
	T value; 
	NodoSE<T> next;

	public NodoSE(T value) {
		this.value = value;
		this.next = null; 
	}
}
}