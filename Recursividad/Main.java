import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main main  = new Main();
		int n = 12;
		int v[] = new int[4]; 
		int dp[] = new int[4];
		for (int i=0 ; i<n; i++) {
			if (i==3) continue;
			System.out.println(i);
		}

		sc.close();
	}

	public void ff(int v[], int dp[]) {
		int aux[] = new int[v.length];
		f(v, dp, 0, aux);
	}
	public void f(int v[], int dp[], int i, int aux[]) {
		if (i==v.length-1) {
			int ac = -1; 
			for (int j= 0;j <v.length;j ++) 
				if (dp[j]==0) ac  = j;
			aux[i] = v[ac];
			for (int j=0 ; j<v.length; j++) 
				System.out.print(aux[j]+" ");
			System.out.println();
			return;
		}
		for (int j = 0; j<v.length; j++) {
			if (dp[j]==1) continue;
			dp[j] = 1; 
			aux[i] = v[j];
			f(v, dp, i+1, aux);
			dp[j] = 0;
		}
	}

}
/**
 * ((A)y)x
 * (A) => a => a
 * 
 * abcde => edbca
 * (ay)x
 * (ay) => AY => YA
 * 
 * (ay)x => YAx
 * f => f-1 => f
 * 
 * 
 * abc(xYz)bde
 * abcZyXbde

(xy(abc)) => xyabc
(xyCBA)
abcYX
 * 
 */
#include <bits/stdc++.h>

using namespace std;
#define int long long
#define vi vector<int>
#define pb push_back
#define F first
#define S second
#define fast ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0)
const int N = 5e5+10; 
const int INF = 1e15;
vi bit(N+1, 0), grafo[N+1], dp(N+1), p(N+1), pinv(N+1);
string s;  
int lb(int i) {return i&(-i); }
void upd(int i, int x) {
    while (i<=N) bit[i]+=x, i+=lb(i);
}
int query(int i) {
    int sum = 0;
    while (i) sum+=bit[i], i-=lb(i);
    return sum;
}
vector<int> build(int j) {
    int i = j-1, len = 0; 
    vi hijos; 
    while (i>-1 && s[i]!='(') {
        if (s[i]==')') {
            vi aux = build(i);
            len+=aux.size(); 
            for (auto x: aux) hijos.pb(x), i = min(i, x);
        } 
        i--;
    }
    dp[i] = len;
    for (auto x: hijos) grafo[x].pb(i);
    p[i] = j;
    pinv[j] = i;
    return {i};
}
void f(int i) {
    if (s[i]=='(' || s[i]==')') return;
    int q = query(i);
    if (q&1) {
        if (s[i]>'Z') cout<<(char)(s[i]-32);
        else cout<<(char)(s[i]+32);
    } else cout<<s[i];
}
void impp(int i, int j); 
void imp(int i, int j); 
void solve() {
    cin>>s; 
    s = "F"+s; 
    int n = s.size();
    for (int i= 1; i<n; i++) grafo[i].clear(); 
    for (int i =n-1; i>-1; i--) 
    if (s[i]==')') {
        vi x = build(i); 
        i = x[0];
    }
    queue<int> cola; 
    
    for (int i = 1; i<n; i++) 
    if (!dp[i] && s[i]=='(') cola.push(i);
    vi auxi(n+1, 0);
    
    while (cola.size()) {
        int i = cola.front();
        cola.pop();
        if (auxi[i]) continue;
        auxi[i]  = 1;
        upd(i, 1);
        upd(p[i]+1, -1);
        for (auto x: grafo[i]) {
            dp[x]--;
            if (dp[x]<=0) cola.push(x);
        }
    }    
    for (int i= 1; i<n; i++) {
        if (s[i]!='(' && s[i]!=')') {
            f(i);
        } else if (s[i]=='(') imp(i, p[i]), i = p[i]-1;
    }
}
signed main() {
    fast;
    int t=1; //cin>>t;
    while (t--) solve();
    return 0;
}
void impp(int i, int j) {
    for (int k = i+1; k<j; k++)
    if (s[k]=='(') imp(k, p[k]), k = p[k]-1; 
    else if (s[k]!=')') f(k);
}
void imp(int i, int j) {
    for (int k = j-1; k>i; k--) {
        if (s[k]==')') impp(pinv[k], k), k = pinv[k]+1;
        else if (s[k]!=')')
            f(k);
    }
}
