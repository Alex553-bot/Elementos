import java.util.*;

//Pueden llamar a su clase como quieran
public class B{
    //Esta funcion es obligatoria, no cambiar, aqui es donde
    //realizan reciben los datos de entrada e imprimen los resultados
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int v[] = new int[n]; 
        for (int i=0 ; i<n;i ++) v[i] = sc.nextInt();
        int res[] = solve(n, v);
        for (int i =0 ; i<3; i++) System.out.print(res[i]+" ");
        System.out.println();
        sc.close();
    }
    
    //Todos los metodos que vayan a hacer deben ser estaticos
    static int[] solve(int n, int reglas[]) {
        // AQUI VA TU SOLUCION, TOMA EN CUENTA QUE LA SALIDA ES UN ARRAY ESTATICO DE 3 POSICIONES 
        // QUE ES LA RESPUESTA ESPECIFICADA EN EL OUTPUT FORMAT
        int res[] = new int[3];
        return res;
    }
}
