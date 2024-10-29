import java.util.*;
public class B {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(f(in.nextInt()));
		in.close();
	}
	static int f(int n) {
		if (n==1) return 6;
		if (n==2) return 15;
		return 12+f(n-1);
	}
}