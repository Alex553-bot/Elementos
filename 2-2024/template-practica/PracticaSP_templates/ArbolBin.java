public class ArbolBin<T>{
    public ArbolBin<T> izq;
    public T           raiz;
    public ArbolBin<T> der;
    
    public ArbolBin(){
        raiz = null;
        izq = null;
        der = null;
    }
    
    public boolean vacia(){
        return raiz == null;
    }
    
    public void insertar(T dato){
        Cola<ArbolBin<T>> cola;
        cola = new Cola<ArbolBin<T>>();
        cola.encolar(this);
        insertar(dato, cola);
    }
    private void insertar(T dato, Cola<ArbolBin<T>> cola){
        ArbolBin<T> arb;
        arb = cola.decolar();
        if(arb.vacia()){
            arb.raiz = dato;
            arb.izq = new ArbolBin<T>();
            arb.der = new ArbolBin<T>();
        }else{
            cola.encolar(arb.izq);
            cola.encolar(arb.der);
            insertar(dato,cola);
        }
    }
    
    public void entradaFast(T ar[]){
        int tam = ar.length;
        for(int i = 0; i < tam; i++){
            insertar(ar[i]);
        }
    }
}