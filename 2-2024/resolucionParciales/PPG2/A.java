import java.util.*;
public class A {
	static int n, m;
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		n = in.nextInt(); m = in.nextInt();
		int v[][] = new int[n][m]; 
		fill(v, 0);
		System.out.println(f(0, 0, v));

		in.close();
	}
	static void fill(int v[][], int i) {
		if (i>=n) return;
		ffill(v, i, 0);
		fill(v, i+1);		
	}
	static void ffill(int v[][], int i, int j) {
		if (j>=m) return;
		v[i][j] = in.nextInt();
		if (v[i][j]>6) v[i][j] = 1;
		else v[i][j] = 0;
		ffill(v, i, j+1);
	}
	static int f(int i, int j, int v[][]) {
		if (j>=m) {
			if (i>=n) return 0;
			return f(i+1, 0, v);
		}
		if (i>=n) return 1;
		if (v[i][j]==1) return f(i, j+1, v);
		int res = 0; 

		if (j+1<m && v[i][j+1]==0) {
			v[i][j+1] = v[i][j] = 1;
			res=Math.max(res, f(i, j+2, v)+1);
			v[i][j+1] = v[i][j] = 0;
		}
		if (i+1<n && v[i+1][j]==0) {
			v[i+1][j] = v[i][j] = 1;
			res=Math.max(res, f(i, j+1, v)+1);
			v[i+1][j] = v[i][j] = 0;
		}

		return res;
	}
}