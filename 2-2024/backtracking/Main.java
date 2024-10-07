import java.util.Scanner; 
public class Main {
	private static int n;
	private static String estado = "RLDU";
	/**
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		n = sc.nextInt();
		int mapa[][] = new int[n][n]; 
		for (int i =0 ; i<n; i++) {
			String s = sc.next(); 
			for (int j = 0; j<n; j++) {
				char c = s.charAt(j); 
				if (c=='M') mapa[i][j] = 1; 
			}
		}

		char aux[][] = new char[n][n]; 
		ffor(0, n, aux); 
		f(0, 0, n-1, n-1, mapa, aux); 

		//for (int i =0 ; i<n; i++) {
		//	for (int j = 0; j<n; j++) System.out.print(aux[i][j]); 
		//	System.out.println();
		//}  
		pprint(0, 0, aux);
	}**/

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt(); 
		// complete search : 
		boolean v[][] = new boolean[n][n];
		for (int i =0 ; i<n; i++) 
		for (int j = 0; j<n; j++) v[i][j] = false;  
		System.out.println(nqueen(v)); 
	}
	public static int nqueen(boolean v[][]) {
		return nqueen(v, 0);
	}
	public static int nqueen(boolean [][]v, int x) {
		if (x>=v.length) return 1; 
		int res = 0; 
		int n = v.length; 
		for (int y = 0; y<v.length; y++) 
			if (v[x][y]==false) {
				// marcar posiciones
				for (int i = x; i<n; i++) v[i][y] = true; 
				for (int i = x, j = y; i<n && j>=0; i++, j--) v[i][j] = true; 
				for (int i = x, j = y; i<n && j<n; i++, j++) v[i][j] = true; 
				res+=nqueen(v, x+1); 
				// desmarcado posiciones
				for (int i = x; i<n; i++) v[i][y] = false; 
				for (int i = x, j = y; i<n && j>=0; i++, j--) v[i][j] = false; 
				for (int i = x, j = y; i<n && j<n; i++, j++) v[i][j] = false; 
			}
		return res;
	}

	public static void ffor(int i, int n, char aux[][]) {
		if (i>=n) return;
		// operacion especifica.
		fffor(i, 0, n, aux);
		ffor(i+1, n, aux); 
	}
	public static void fffor(int i, int j, int n, char aux[][]) {
		if (j>=n) return; 
		aux[i][j] = 'a'; 
		fffor(i, j+1, n, aux); 
	}


	public static int f(int x, int y, int dx, int dy, int mapa[][], char aux[][])  {
		if (x==dx && y==dy) return 1; 
		if (aux[x][y]!='a' || mapa[x][y] == 1) return 0; 
		int kx[] = new int[4]; 
		int ky[] = new int[4];
		kx[0] = kx[1] = ky[2] = ky[3] = 0; 
		ky[0] = kx[2] = 1; 
		kx[3] = ky[1] -1; 
		for (int k = 0; k<4; k++) {
			int i = x+kx[k], j = y+ky[k]; 
			if (Math.min(i, j)<0 || Math.max(i, j) >= n) continue;
			// marcado 
			aux[x][y] = estado.charAt(k); 
			int respuesta = f(i, j, dx, dy, mapa, aux); 
			// llamada de estados . 
			if (respuesta == 1) {
				return 1; 
			}
			// desmarcado
			aux[x][y] = 'a'; 
		}
		return 0;
	}

	public static void pprint(int x, int y, char aux[][]) {
		if (aux[x][y]=='a') return;
		System.out.print(aux[x][y]); 
		int kx[] = new int[4]; 
		int ky[] = new int[4];
		kx[0] = kx[1] = ky[2] = ky[3] = 0; 
		ky[0] = kx[2] = 1; 
		kx[3] = ky[1] -1; 
		for (int k = 0; k<4; k++) {
			int i = x+kx[k], j = y+ky[k]; 
			if (estado.charAt(k) == aux[x][y]) {
				pprint(i, j, aux);
				return; 
			}
		}
	}

}