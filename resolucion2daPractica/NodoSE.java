 


/**
 * Write a description of class NodoSE here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NodoSE<T>
{
    private T         dato;
    private NodoSE<T> suc;
    
    public NodoSE(T dato){
        this.dato = dato;
        suc = null;
    }
    
    public NodoSE<T> getSuc(){
        return suc;
    }
    
    public T getDato(){
        return dato;
    }
    
    public void setSuc(NodoSE<T> s){
        suc = s;
    }
    
    public void setDato(T d){
        dato = d;
    }
}