import java.util.*;
public class A {
	static int n;
	static String s;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt(); 
		s = in.next();

		int v[] = new int[n];
		System.out.println(f(0, 0, v));

		in.close();
	}
	static boolean palindrome(int i, int j) {
		boolean ok = true;
		while (i<=j) 
			ok&=s.charAt(i++)==s.charAt(j--); 
		return ok;
	}
	static int f(int i, int j, int v[]) {
		if (i>=n) {
			for (int k = 0; k<j; k++) {
				int piv = (k>0? v[k-1]+1: 0);
				if (!palindrome(piv, v[k])) return n;
			}
			return j;
		}
		int res = n;
		if (i<n-1) res = f(i+1, j, v);
		v[j] = i; 
		res = Math.min(res, f(i+1, j+1, v));
		return res;
	}
}