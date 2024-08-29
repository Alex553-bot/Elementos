import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 
public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        ListaCSE<Integer> lista = new ListaCSE<Integer>();
        int n = sc.nextInt();
        int v[] = new int[n];
        for (int i=0;i<n; i++) lista.insertar(sc.nextInt());
        int q = sc.nextInt();
        
        for (; q>0; q--) {
            int a = sc.nextInt(), b = sc.nextInt();
            lista.swamp(a, b);
            //lista.print();
            for (int i=0 ; i<lista.print().length; i++) 
                System.out.print(lista.print()[i]+" ");
            System.out.println();
            //System.out.println(lista.print());
        }
        sc.close();
    }
}