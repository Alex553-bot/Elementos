import java.util.*;

//Pueden llamar a su clase como quieran
public class E{
    //Esta funcion es obligatoria, no cambiar, aqui es donde
    //realizan reciben los datos de entrada e imprimen los resultados
    // NO TOCAR ESTE METODO
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        System.out.println(solve(n, m));
        sc.close();
    }
    
    //Todos los metodos que vayan a hacer deben ser estaticos
    static int solve(int n, int m) {
        // AQUI VA TU SOLUCION
        return 0;
    }
}
