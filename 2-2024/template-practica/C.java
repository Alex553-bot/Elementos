import java.util.*;

//Pueden llamar a su clase como quieran
public class C{
    //Esta funcion es obligatoria, no cambiar, aqui es donde
    //realizan reciben los datos de entrada e imprimen los resultados
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        String patron[] = new String[n]; 
        for (int i =0 ; i<n; i++) patron[i] = sc.next();
        String respuesta[] = solve(n, k, patron);
        for (int i =0 ; i<respuesta.length; i++) System.out.println(respuesta[i]);
        sc.close();
    }
    
    //Todos los metodos que vayan a hacer deben ser estaticos
    static String[] solve(int n, int k, String patron[]) {
        // AQUI VA TU SOLUCION AL PROBLEMA, LA SALIDA ES UN ARRAY ESTATICO DE STRINGS 
        // TOMAR EN CUENTA QUE DEBE SER EXACTAMENTE COMO DICE EL OUTPUT DEL EJERCICIO. 
        String res[] = new String[1];
        return res;
    }
}
