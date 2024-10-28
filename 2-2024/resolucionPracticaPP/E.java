import java.util.*;
public class E {
	static int n, m;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt(); m = in.nextInt();
		int v[][] = new int[n][m]; 
		System.out.println(f(0, 0, v));

		in.close();
	}
	static int f(int i, int j, int v[][]) {
		if (j>=m) {
			if (i>=n)
			return 1;
			return f(i+1, 0, v);
		}
		if (i>=n) return 1;
		//System.out.println(i+" "+j);
		if (v[i][j]==1) return f(i, j+1, v);
		int res = 0; 

		if (j+1<m && v[i][j+1]==0) {
			v[i][j+1] = v[i][j] = 1;
			res+=f(i, j+2, v);
			v[i][j+1] = v[i][j] = 0;
		}
		if (i+1<n && v[i+1][j]==0) {
			v[i+1][j] = v[i][j] = 1;
			res+=f(i, j+1, v);
			v[i+1][j] = v[i][j] = 0;
		}

		return res;
	}
}