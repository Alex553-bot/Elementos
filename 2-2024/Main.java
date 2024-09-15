public class Main {
	public static void main(String[] args) {
		for (int i = 0; i<5; i++) 
		for (int l = 0; l<i+1; l++) 
		for (int k = 0; k<i+1; k++) System.out.println(i+" "+l+" "+k+" "+conteoG(i, l, k)); 
	}
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
	}
}