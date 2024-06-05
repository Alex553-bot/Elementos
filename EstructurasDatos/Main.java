//import LDEC.*;
//import LDE.*; 

import LSE.*; 
//import LSEC.*;

public class Main {
	public static void main(String[] args) {


		String s = "()(()))))";

		int n = s.length();

		Stack<Integer> st = new Stack<Integer>();

		int d[] = new int[n]; 
		for (int i=0; i<n; i++) 
		if (s.charAt(i)=='(') {
			st.push(i);
			d[i] = -1;
		} else {
			if (st.size()==0) d[i] = -1; 
			else d[i] = st.top();
			st.pop();
		}

		int res = 0, ant = 0; 

		for (int i= n-1; i>-1; i--) {
			if (d[i]==-1) continue;
			int j = d[i]; 

			System.out.println(ok(d, j, i)+" "+j+" "+i);
			if (ok(d, j, i)) ant+=Math.abs(i-j)+1;
			else {
				res = Math.max(res, ant+2); 
				ant = 0;
			}
			i = j;
		}
		res = Math.max(res, ant);
		System.out.println();


		System.out.println(res);
	}
	public static boolean ok(int d[], int i, int j) {
		if (j-i==1) return true;
		boolean res = true;
		for (int k = j-1; k>i; k--) {
			int jx = k, ix = d[k]; 
			if (d[k]==-1) return false;
			res&=ok(d, ix, jx); 
			k = ix;
		}
		return res; 
	}
}