import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
        ArbolTriBP<Integer> tree = new ArbolTriBP<Integer>(20);
        tree.insertar(10); 
        tree.insertar(7); 
        tree.insertar(30);
        tree.insertar(11); 
        tree.insertar(9);
        tree.insertar(21); 
        tree.insertar(2);
        tree.insertar(15); 
        tree.print(); 
        System.out.println();
        tree.insertar(1); 
        tree.print(); 

        sc.close();
	}
    public static int f(int n) {
        return f("", 1, n, 0);
    }
    public static int f(String s, int i, int n, int x) {
        s += ""+i;
        int res = 0;
        x+=i; x%=3;
        System.out.println(s+" "+x);
        res = (x==0? 1: 0);
        if (i==n) return res;
        return res+f(s, i+1, n, x);
    }
    public static int ffor(String s, int i) {
        if (s.length()==i) return 0;
        int x = s.charAt(i)-'0'+ffor(s, i+1);
        x%=3;
        return x;
    }
}

/**
 * propiedades matematica: 
 * a = b = c; 
 * b = c y ademas a-b<3^nivel
 * 
 */