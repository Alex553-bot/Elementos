import java.util.Scanner; 
public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//int n = in.nextInt(); 
		//int b = in.nextInt();
		int n = in.nextInt(); String v[] = new String[n]; 
		for (int i =0 ; i<n; i++) v[i] = in.next(); 
		System.out.println(verif(v));
		//System.out.println(f(n, b));
		//int n = in.nextInt(), m = in.nextInt(); 
		//int v[][] = new int[n][m]; 
		//System.out.println(a(v, n, m));
		in.close();
	}

	static int a(int v[][], int n, int m) {
		// colocado de totem: 
		int res = 0;
		for (int i = 0; i<n; i++)
		for (int j = 0; j<m; j++) 
		if (prime(i+j)) {
			v[i][j] = 1; 
			res+=b(v, n, m); 
			v[i][j] = 0;
		}	
		return res;
	}
	static int b(int v[][], int n, int m) {
		int res =0 ; 
		for (int i = 0; i<n; i++)
		for (int j = 0;j <m; j++) 
			if (v[i][j]==0 && (i+j)%2==0) {
				v[i][j] = 1; 
				res+=c(v, n, m); 
				v[i][j] = 0;
			}
		return res;
	}
	static int c(int v[][], int n, int m) {
		int res = 0; 
		for (int i =0 ; i<n; i++) 
		for (int j = 0; j<m; j++) 
			res+=(v[i][j]==0? 1: 0);
		return res;
	}
	static boolean prime(int x, int i) {
		if (i*i>x) return true;
		if (x%i==0) return false;
		return prime(x, i+1);
	}
	static boolean prime(int x) {
		return prime(x, 2);
	}
	static void ffffor(String aux[], String v[], int i, int n) {
		if (i==n) return; 
		aux[i+1] = v[i]; 
		ffffor(aux, v, i+1, n);
	}
	static boolean verif(String v[]) {
		int n = v.length; 
		String aux[] =new String[n + 2]; 
		boolean vis[] = new boolean[n+2]; 
		vis[0] = vis[n+1] = true;
		ffffor(aux, v, 0, n);
		aux[0] = aux[n+1] = "gX";
		return verif(0, aux, n+2, vis); 
	}
	static boolean verif(int i, String v[], int n, boolean vis[]) {
		if (i==n) return true;
		int j = conj(i+1, v, n); 
		if (j==i+1) {
			if (!vis[i]) return false;
			return verif(i+1, v, n, vis); 
		}
		if (!vis[i]) vis[i] = true;
		else if (!vis[j]) vis[j] = true;
		else return false;
		return verif(j, v, n, vis);
	}// g1, g2
	static int conj(int i, String v[], int n) {
		if (i==n) return n; 
		if (v[i].length() == 2 && v[i].charAt(0)=='g') return i; 
		return conj(i+1, v, n);
	}
	/*
	static int f(int n, int b) {
		return f(n, b, 1); 
	}
	static int f(int n, int b, int x) {
		if (n==0) return 0;
		if (x>n) return -1; 
		int y = f(n, b, x*b); 
		if (y==-1) return f(n-x, b)+1;
		return y; 
	}*/
	int f(int n, int b) {
		if (n==0) return 0; 
		int x = pow(n, b, 1); 
		return f(n-x, b)+1;
	}

	static int pow(int n, int b, int x) {
		if (n<x) return -1; 
		int y  = pow(n, b, x*b); 
		if (y==-1) return x; 
		return y;
	}





	//static int n, v[], k;
	//static int ires, jres, len; 

	//public static void main(String[] args) {
	//	Scanner in  = new Scanner(System.in); 
	//	//n = in.nextInt(); 
	//	//v = new int[n]; 
	//	//for (int i =0 ; i<n; i++ ) v[i] = in.nextInt();
	//	//len = 0; ires = 0; jres = 0;
	//	//f(0, 0); 
	//	//for (int i = ires; i<=jres; i++) System.out.print(v[i]+" "); 
	//	//System.out.println();
	//	//len = 0; ires = 0; jres = 0;
	//	//ff(0);
	//	//for (int i = ires; i<=jres; i++) System.out.print(v[i]+" "); 
	//	//System.out.println();
	//	int n = in.nextInt(); 
	//	System.out.println(hanoi(n)); 
	//}
	/*
	static boolean verificar(int i, int j, boolean ok) {
		if (i>=j) return true;
		if (Math.abs(v[i]-v[i+1])>k) return false;
		if (ok) {
			return verificar(i+1, j, v[i]<=v[i+1]); 
		} else {
			if (v[i]<=v[i+1]) return false;
			return verificar(i+1, j, ok);
		}
	}
	static void f(int i, int j) {
		if (i>=n || j>=n || j<i) return;
		if (verificar(i, j, true)) {
			if (len < (j-i+1)) {len = j-i+1; ires = i; jres = j;}
		}
		f(i+1, j);
		f(i, j+1);
	}
	static int subida(int j) { 
		if (j>=n-1) return n-1;
		if (Math.abs(v[j]-v[j+1])>k) return j;  
		if (v[j] <= v[j+1]) return subida(j+1); 
		return bajada(j);  
	}
	static int bajada(int j) {
		if (j>=n-1) return n-1; 
		if (v[j] <= v[j+1]) return j; 
		return bajada(j+1); 
	}
	static void ff(int i) {
		if (i>=n) return;
		int j = subida(i); 
		System.out.println(i+" "+j);
		if (len < (j-i+1)) {len = j-i+1; ires = i; jres = j; }
		if (i==j) j++;
		ff(j); 
	}
	static int hanoi(int n) {
		if (n<=2) return 1; // [caso base]
		int res = 0; 
		res+=hanoi(n-2); // inicio (primer pivote) -> medio (segundo pivote)
		res+=hanoi(2); // los mas grandes
		res+=hanoi(n-2); // medio -> fin. 
		return res;
	}*/
}