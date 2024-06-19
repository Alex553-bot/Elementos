import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String v[] = new String[n];
        for (int i=0; i<n; i++) v[i] = sc.next();

        String[][] res = ordenar(v);
        
        for (int i=0 ; i<res.length; i++, System.out.println()) 
        for (int j = 0; j<res[i].length; j++) System.out.print(res[i][j]+" "); 

        sc.close();
    }
    public static String[][] ordenar(String[] s) {
        Arrays.sort(s);
        ArrayList<Stack<String>> dp = new ArrayList<>();
        for (int i=0 ; i<s.length; i++) {
            int ok = 0; 
            for (int j =0 ; j<dp.size(); j++) 
            if (dp.get(j).top().compareTo(s[i]) < 0) {
                ok = 1; 
                dp.get(j).push(s[i]);
                break;
            }
            if (ok == 0) {
                Stack<String> aux = new Stack<>();
                aux.push(s[i]); 
                dp.add(aux);
            }
        }
        String res[][] = new String[dp.size()][];
        for (int i=0 ; i<res.length; i++) {
            String v[] = new String[dp.get(i).size()];
            for (int j = 0; j<v.length; j++, dp.get(i).pop()) 
                v[j] = dp.get(i).top();
                Arrays.sort(v);
                res[i] = v;
        }

        return res;
    }
}
