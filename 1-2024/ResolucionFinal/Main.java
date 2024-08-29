import java.util.*;
public class Main 
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); 
		//System.out.println(primerEjercicio(n));
		
		double a = sc.nextInt(), b = sc.nextInt(); 
		System.out.println(tercerEjercicio(n, a, b));
		sc.close();
	}
	public static double primerEjercicio(int n) {
		if (n==1) return 1; 
		return 1.0/((n*(n+1)/2))+primerEjercicio(n-1);
	}
	public static double tercerEjercicio(int n, double d1, double d2) {
		if (n==1) return d1*d2/2; 
		return d1*d2/2 - d1*d2/8 + tercerEjercicio(n-1, 2*d1, 2*d2); 
	}
}