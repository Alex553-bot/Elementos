import java.util.*;

//Pueden llamar a su clase como quieran
public class D{
    //Esta funcion es obligatoria, no cambiar, aqui es donde
    //realizan reciben los datos de entrada e imprimen los resultados
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt(), r = sc.nextInt();
        System.out.println(solve(l, r));
        sc.close();
    }
    
    //Todos los metodos que vayan a hacer deben ser estaticos
    static int solve(int l, int r) {
        // AQUI VA TU SOLUCION
        return 0;
    }
}
