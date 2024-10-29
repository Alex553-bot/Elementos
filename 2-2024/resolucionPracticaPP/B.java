import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int a[] = new int[n]; 
        int b[] = new int[n]; 
        for (int i =0; i<n; i++) {
            a[i] = sc.nextInt(); b[i] = sc.nextInt();
        } 
        int res[] = new int[3]; 
        int v[][] = new int[3][3]; 
        f(v, a, b, res);
        res[0] = 1;
        res[1] = Math.min(1, res[1]);
        res[2] = Math.min(1, res[2]);
        System.out.println(res[1]+" "+res[0]+" "+res[2]);
        sc.close(); 
    }
    private static int ok(int v[][]) {
        for (int i = 0, a = 1; i<3; i++) {
            for (int j = 0; j<3; j++) 
                a&=v[i][j]==v[i][0]? 1: 0; 
            if (a>0 && v[i][0]>0) return v[i][0];
        }
        for (int i = 0, a = 1; i<3; i++) {
            for (int j = 0; j<3; j++) 
                a&=v[j][i]==v[0][i]? 1: 0; 
            if (a>0 && v[0][i]>0) return v[0][i];
        }
        int a = 1; 
        for (int i=0; i<3; i++) 
            a&=v[i][i]==v[0][0]? 1: 0;
        if (a>0 && v[0][0]>0) return v[0][0]; 
        a = 1; 
        for (int i = 0, j = 2; i<3; i++, j--) 
            a&=v[i][j]==v[1][1]? 1: 0;
        if (a>0 && v[1][1]>0) return v[1][1];
        return 0;
    }
    private static void f(int v[][], int a[], int b[], int res[]) {
        f(v, a, b, res, 1);
    }
    private static void f(int v[][], int a[], int b[], int res[], int t) {
        int p = ok(v), z = 1; 
        if (p>0) {res[p]++; return;}
        for (int k = 1; k<10; k++) {
            int i = (k-1)/3, j = k-3*i-1; 
            if (v[i][j]>0) continue;
            int aux = 1;
            for (int x = 0; x<a.length; x++) 
            if (a[x]==k) {
                int ii = (b[x]-1)/3, jj = b[x]-ii*3-1; 
                aux&=v[ii][jj]>0? 1: 0;
            }
            if (aux==0) continue;
            v[i][j] = t; 
            f(v, a, b, res, 3-t);
            v[i][j] = 0;
            z = 0;
        }
        if (z==1) res[0]++; 
    }
}