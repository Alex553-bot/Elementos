import java.util.ArrayList;
public class Arbol<T>{
    public T                    raiz;
    public ArrayList<Arbol<T>>  hijos;
    
    public Arbol(){
        raiz = null;
        hijos = new ArrayList<>();
    }
    
    public boolean vacia(){
        return raiz == null;
    }
}