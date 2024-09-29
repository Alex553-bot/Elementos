import java.util.Scanner; 
import java.util.ArrayList;
public class Main 
{
	public static void main(String[] args) {
		int n; 
		Scanner sc = new Scanner(System.in); 
		n = sc.nextInt(); 
		int a[]= new int[n]; 
		for (int i =0 ; i<n; i++) a[i] = sc.nextInt(); 
		ArrayList<Integer> v = maxmini(a, 0, n);
		System.out.println(v.get(0)+" "+v.get(1)); 
	}
	public static void f(int a[], int i, int j) {
		if (j-i==1) return; 
		int mid = (i+j)/2; 
		int left[] = new int[mid-i], right[] = new int[j-mid]; 
		f(a, i, mid); // [i, mid)
		f(a, mid, j);  // [mid, j)
		for (int k = i; k<mid; k++) left[k-i] = a[k]; 
		for (int k = mid; k<j; k++) right[k-mid] = a[k];
		int x = 0, y = 0; 
		while (x<left.length || y<right.length) {
			if (x<left.length && y<right.length) {
				if (left[x]<=right[y]) a[i++] = left[x++]; 
				else a[i++] = right[y++];
			} else if (x<left.length) {
				a[i++] = left[x++]; 
			} else a[i++] = right[y++]; 
		}
	}
	// f(a, 0, n)
	public static ArrayList<Integer> maxmini(int a[], int i, int j) {
		int n = j-i; 
		ArrayList<Integer> res = new ArrayList<>();
		if (i>=j) {
			res.add(-1); res.add(1000000);
			return res;
		} 
		if (n==1) {
			res.add(a[i]); res.add(a[i]);
			return res;
		}
		int diff = (n+2)/3; 
		int m1 = i+diff, m2 = j-diff; 
		ArrayList<Integer> v1 = maxmini(a, i, m1); 
		ArrayList<Integer> v2 = maxmini(a, m1, m2); 
		ArrayList<Integer> v3 = maxmini(a, m2, j);
		res.add(Math.max(v1.get(0), Math.max(v2.get(0), v3.get(0))));
		res.add(Math.min(v1.get(1), 
			Math.min(v2.get(1), 
					 v3.get(1))));
		return res;
	}
}

// x, y, z
// x = minimo, 
// y = medio 
// z = maximo, 
// 5, 3, 5 => 3, 5, 5