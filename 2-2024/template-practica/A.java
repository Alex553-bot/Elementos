import java.util.*;

//Pueden llamar a su clase como quieran
public class A{
    //Esta funcion es obligatoria, no cambiar, aqui es donde
    //realizan reciben los datos de entrada e imprimen los resultados
    // NO TOCAR ESTE METODO, DIRECTO TU RESPUESTA SOBRE EL METODO SOLVE()
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        String s = sc.next(); 
        System.out.println(solve(n, s));
        sc.close();
    }
    
    //Todos los metodos que vayan a hacer deben ser estaticos
    static int solve(int n, String s) {
        // aqui va tu solucion debes retornar lo que dice el OUTPUT
        // un entero que es el numero minimo de divisiones. 
        return 0;
    }
}
