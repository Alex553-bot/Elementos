import ds.*;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		String s = sc.next();
		int n = s.length(); 
		ListaLSE<Character> lse = new ListaLSE<>();
		for (int i = 0; i<n; i++) {
			char c = s.charAt(i);
			if (f(c)) {
				char x = i==0? 'z': lse.get(0);
				if (!d(x)) 
					lse.add(new Character(x = i+1<n? (s.charAt(i+1)=='i'? 'u': 'i') : 'u')); 
				lse.add(new Character(c));
				lse.add(new Character(x));
			} else lse.add(new Character(c));
		}

		System.out.println(lse.gen());


		sc.close();
	}
	static boolean f(char c) {
		return c=='a' || c=='e'||c=='o';
	}
	static boolean d(char c) {
		return c=='i'||c=='u';
	}
/*








// clase 22-09
	public static int hanoi(int n) {
		if (n==0) return 0; 
		return 1+2*hanoi(n-1);
	}
	public static void printHanoi(int n, int a, int b) {
		int c = 6-(a+b) ; 
		if (n==1) {
			System.out.println("Mover de pivote "+a+" hacia "+b); 
		} else {
			printHanoi(n-1, a, c); 
			printHanoi(1, a, b); 
			printHanoi(n-1, c, b);
		}
	}
	public static void generar(int i, String a[], ArrayList<String> res) {
		if (i==a.length) {
			// imprimir res
			printArray(0, res);
		} else {
			generar(i+1, a, res); 
			res.add(a[i]); 
			generar(i+1, a, res);
			res.remove(a[i]);
		}
	}
	public static void printArray(int i, ArrayList<String> res) {
		if (i==res.size()) {
			System.out.println();
			return;
		}
		System.out.print(res.get(i)+" "); 
		printArray(i+1, res);
	}
	public static void printArray2(int i, String res[], int n) {
		if (i==res.length) {
			System.out.println();
			return;
		}
		System.out.print(res[i]+" "); 
		printArray2(i+1, res, n);
	}
	// {"", "", ""}
	public static void generar2(
		int i, 
		String a[], 
		String res[], 
		int j
	) {
		if (i==a.length) {
			// imprimir res
			printArray2(0, res, j);
		} else {
			generar2(i+1, a, res, j); 
			res[j] = a[i]; 
			generar2(i+1, a, res, j+1);
			res[j] = "";
		}
	}

	public static void printt(String a[], int i, boolean aux[]) {
		if (i==a.length) {
			System.out.println(); 
		} else {
			if (aux[i])
				System.out.print(a[i].toString()); 
			printt(a, i+1, aux);
		}
	}
	public static void f(String a[]) {
		boolean aux[] = new boolean[a.length];
		f(a, 0, aux); 
	}
	private static void f(String a[], int i, boolean aux[]) {
		int n = a.length; 
		if (i==n) {
			printt(a, 0, aux);
		} else {
			f(a, i+1, aux); 
			aux[i] = true; 
			f(a, i+1, aux); 
			aux[i] = false; 
		}
	}



// clase 15-09
	public static int conteoG(int n, int l, int k) {
		if (n<0) return 0; 
		if (n==0) return 1; 
		if (l==k) return l==0? 0: conteoG(n-k, l, k); 
		return (l==0? 0: conteoG(n-l, l, k))+(k==0? 0: conteoG(n-k, l, k)); 
	}
	public static int conteo2(int n, int k) {
		if (n<0) return 0; 
		if (n==0) return 1; 
		if (k>n || k<1) return 1; 
		return conteo2(n-1, k)+conteo2(n-k, k); 
	}
	public static int conteo(int n) {
		return fib(n+1);
	}
	public static int fib(int n) {
		if (n==0) return 0; 
		if (n==1) return 1; 
		if (n<0) return -1; 
		return fib(n-1)+fib(n-2); 
	}
	public static boolean llena(int n, int k) {
		if (n==0) return true; 
		if (n<0 || k<=0) return false;
		return llena(n-k, k);
	}*/
}