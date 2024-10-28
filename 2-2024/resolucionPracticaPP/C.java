import java.util.*;
public class C {
	static int n, k;
	static char [][]pat; 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt(); k = in.nextInt();
		char v[][] = new char[pow(n, k)][pow(n, k)];
		pat = new char[n][n];
		for (int i =0 ; i<n;i ++) {
			String s = in.next(); 
			pat[i] = s.toCharArray();
		}
		for (int i =0 ; i<v.length; i++)
		for (int j = 0; j<v.length; j++) v[i][j] = '.';
		f(k, v, 0, 0);
		for (int i =0 ; i<v.length; i++) {
			for (int j = 0; j<v.length; j++) System.out.print(v[i][j]);
			System.out.println();
		}
		in.close();
	}
	static int pow(int n, int k) {
		return (int)Math.pow(n, k);
	}
	static void f(int k, char v[][], int i, int j) {
		if (k==0) return;
		int len = pow(n, k)/n;
		for (int a = 0; a<n; a++)
		for (int b = 0; b<n; b++) {
			if (pat[a][b] == '.') f(k-1, v, i+a*len, j+b*len);
			else {
				for (int l = i+a*len; l<i+a*len+len; l++) 
				for (int r = j+b*len; r<j+b*len+len; r++) v[l][r] = '*';
			}
		}
	}
}