import java.util.*;
public class A {
	static int n;
	static String s;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int l = in.nextInt(), r = in.nextInt();
		System.out.println(f(l, r));

		in.close();
	}
	static boolean prime(int n) {
		static boolean prime(2, n);
	}
	static boolean prime(int i, int n) {
		if (i*i > n) return true;
		return (n%i != 0) && prime(i+1, n);
	}
	static int sum(int n) {
		if (n==0) return 0;
		return (n%10)+sum(n/10);
	}
	static int f(int l, int r) {
		if (l>r) return 0;
		int res = 0; 
		if (prime(l)) res = sum(l);
		return res+f(l+1, r);
	}
}