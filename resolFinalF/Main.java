public class Main 
{
	public static void main(String[] args) {
		int n, m; 
		n = 12; m= 8; 
		int mapa[][] = new int[n][m]; 
		int col[][] = new int[n][m];
		mapa[2][3] = 1; 
		mapa[5][6] = 3; 
		mapa[8][6] = 1; 
		mapa[8][0] = 1; 
		mapa[4][1] = 1; 

		mapa[4][5] = 1; 
		System.out.println(f(mapa, 4, 5, col)); 
		for (int i= 0; i<n; i++, System.out.println()) 
		for (int j= 0; j<m; j++) 
			System.out.print((col[i][j] == 1? '*': ' '));
			/*
		BST<Integer> bst = new BST<Integer>(10);
		for (int i= 1; i<=20; i++) 
			bst.add(i); 
		ListaDE<Integer> lista = bst.subsecuencia(5, 13); 
		lista.print();
		System.out.println();
		bst.inorden();
		System.out.println(ff(20));*/
	}
	public static String ff(int n) {
		if (n == 1) return "0";
		if (n==2) return "8";
		return "8"+ff(n-2);
	}
	public static int f(int mapa[][], int i, int j, int col[][]) 
	{
		if (col[i][j] == 1) return 0;
		if (mapa[i][j]==0) {
			col[i][j] = 1; 
			return 1; 
		}
		int d = mapa[i][j]; 
		int res =0;
		mapa[i][j] =0; 
		//for (int x = i-d; x<=i+d; x++)
		//for (int y = j-d; y<=j+d; y++) {
		//	if (Math.min(x, y)<0 || x>=mapa.length || y>=mapa[0].length) continue;
		//	System.out.println(x+" "+y);
		//	res+=f(mapa, x, y, col);
		//}

		res+=fforx(
			Math.max(i-d, 0), 
			Math.max(j-d, 0), 
			Math.min(i+d+1, mapa.length), 
			Math.min(j+d+1, mapa[0].length), 
			mapa, 
			col
		);
		return res;
	}
	public static int fforx(int i, int j, int n, int m, int mapa[][], int col[][]) {
		if (i>=n) return 0;
		int res = ffory(i, j, n, m, mapa, col);
		return res+fforx(i+1, j, n, m, mapa, col);
	} 
	public static int ffory(int i, int j,int n, int m, int mapa[][], int col[][]) {
		if (j>=m) return 0;
		int res = f(mapa, i, j, col); 
		res += ffory(i, j+1, n, m, mapa, col);
		return res;
	} 
	
}
/**
 * (i, j) = d
 * (x, y) => (x', y')
 * x = i-d
 * x' = i+d
 * y = j-d
 * y' = j+d
 * 
 */

/**
 * observaciones: 
 * caso n = 1: 0; 
 * caso n = 2: 8; 
 * default 8+f(n-2); 
 * 
 * existe un orden para poner los circulso: 
 * 
 */