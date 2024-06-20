 


/**
 * Write a description of class ListaCSE here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListaCSE<T> 
{
    private NodoSE<T> ini;
    
    public ListaCSE(){
        ini = null;
    }
    
    public boolean vacia(){
        return ini == null;
    }
    
    public void insertar(T dato){
        NodoSE<T> q,ult;
        q = new NodoSE<T>(dato);
        if(vacia()){
            ini = q;
            q.setSuc(q);
        }else{
            if(ini.getSuc().equals(ini)){
                ini.setSuc(q);
                q.setSuc(ini);
            }else{
                ult = getUlt(ini.getSuc());
                ult.setSuc(q);
                q.setSuc(ini);
            }
        }
    }
    
    private NodoSE<T> getUlt(NodoSE<T> q){
        NodoSE<T> res;
        if(q.getSuc().equals(ini)){
            res = q;
        }else{
            res = getUlt(q.getSuc());
        }
        return res;
    }
    
    public void insertar(T dato, int pos){
        NodoSE<T>  p,q,r;
        p = new NodoSE<T>(dato);
        if(vacia()){
            ini = p;
            ini.setSuc(ini);
        }else{
            if(pos==0){
                r = getUlt(ini);
                q = r.getSuc();
                r.setSuc(p);
                p.setSuc(q);
                ini = p;
            }else{
                r= buscar(ini,pos-1);
                q = r.getSuc();
                r.setSuc(p);
                p.setSuc(q);
            }
            
        }
    }
    
    private NodoSE<T> buscar(NodoSE<T> q, int pos){
        NodoSE<T> nodo;
        if(pos == 0){
            nodo = q;
        }else{
            nodo = buscar(q.getSuc(), pos-1);
        }
        return nodo;
    }
    
    public void eliminar(int pos){
        NodoSE<T> q,r,s;
        if(!vacia()){
            if(longitud() == 1){
                ini = null;
            }else{
                if(pos==0){
                    r = getUlt(ini);
                    q = r.getSuc();
                    s = q.getSuc();
                    r.setSuc(s);
                    ini = s;
                }else{
                    r = buscar(ini, pos-1);
                    q = r.getSuc();
                    s= q.getSuc();
                    r.setSuc(s);
                }
            }
        }
    }
    
    public void eliminar(T dato){
        NodoSE<T> q,r,s;
        if(!vacia()){
            if(longitud() == 1){
                ini = null;
            }else{
                if(ini.getDato().equals(dato)){
                    q = getUlt(ini);
                    s = ini.getSuc();
                    q.setSuc(s);
                    ini = ini.getSuc();
                }else{
                    q = buscar(ini.getSuc(),ini,dato);
                    if(q != null){
                        r = q.getSuc();
                        q.setSuc(r.getSuc());
                    }
                }
            }    
        }
    }
    
    private NodoSE<T> buscar(NodoSE<T> a, NodoSE<T> q, T dato){
        NodoSE<T> nodo;
        if(a.getDato().equals(dato)){
            nodo = q;
        }else{
            if(a.getSuc().equals(ini)){
                nodo = null;
            }else{
                nodo = buscar(a.getSuc(),q.getSuc(),dato);
            }
        }
        return nodo;
    }
    
    public T acceder(int pos){
        T dato;
        NodoSE<T> q;
        if(vacia()){
            dato = null;
        }else{
            q = buscar(ini,pos);
            dato = q.getDato();
        }
        return dato;
    }
    
    public T acceder(T dato){
        NodoSE<T> q;
        T datoR;
        if(vacia()){
            datoR = null;
        }else{
            q = buscar(ini, dato);
            if(q == null){
                datoR = null;
            }else{
                datoR = q.getDato();
            }          
        }
        return datoR;
    }
    
    private NodoSE<T> buscar(NodoSE<T> q, T dato){
        NodoSE<T> nodo;
        if(q.getDato().equals(dato)){
            nodo = q;
        }else{
            if(q.getSuc().equals(ini)){
                nodo = null;
            }else{
                nodo = buscar(q.getSuc(),dato);
            }
        }
        return nodo;
    }
    
    
    public int longitud(){
        int res;
        if(vacia()){
            res = 0;
        }else{
            res = contar(ini);
        }
        return res;
    }
    
    private int contar(NodoSE<T> q){
        int res;
        if(q.getSuc().equals(ini)){
            res = 1;
        }else{
            res = 1 + contar(q.getSuc());
        }
        return res;
    }
    
    public boolean buscar(T dato){
        boolean res;
        if(vacia()){
            res = false;
        }else{
            res = buscaR(ini,dato);
        }
        return res;
    }
    
    private boolean buscaR(NodoSE<T> q, T dato){
        boolean res;
        if(q.getDato().equals(dato)){
            res = true;
        }else{
            if(q.getSuc().equals(ini)){
                res = false;
            }else{
                res = buscaR(q.getSuc(), dato);
            }
        }
        return res;
    }
    
    public void vaciar(){
        ini = null;
    }

    public T antecesor(T dato){
        T datoR;
        NodoSE<T> q;
        boolean aux;
        if(vacia()){
            datoR = null;
        }else{
            aux = buscar(dato);
            if(aux == true){
                if(ini.getDato().equals(dato)){
                    datoR = null;
                }else{
                    q = buscar(ini.getSuc(),ini,dato);
                    datoR = q.getDato();
                }
            }else{
                datoR = null;
            }
        }
        return datoR;
    }
    
    public T sucesor(T dato){
        T datoR;
        NodoSE<T> q;
        boolean aux;
        if(vacia()){
            datoR = null;
        }else{
            aux = buscar(dato);
            if(aux == true){
                q = buscar(ini,dato);
                q = q.getSuc();
                datoR = q.getDato();
            }else{
                datoR = null;
            }
        }
        return datoR;
    }
    
    public void reemplazar(int pos, T dato){
        NodoSE<T> q;
        if(!vacia()){
            q = buscar(ini, pos);
            q.setDato(dato);
        }
    }
    
    public int indiceDe(T dato){
        int res;
        boolean aux;
        if(vacia()){
            res = -1;
        }else{
            aux = buscar(dato);
            if(aux == true){
                res = pos(ini,dato);
            }else{
                res = -1;
            }
        }
        return res;
    }
    
    private int pos(NodoSE<T> q, T dato){
        int res;
        if(q.getDato().equals(dato)){
            res = 0;
        }else{
            res = pos(q.getSuc(),dato) + 1;
        }
        return res;
    }
    
    public void swamp(int a, int b){
        T dato1;
        T dato2;
        if(!vacia()){
            dato1 = acceder(a);
            dato2 = acceder(b);
            reemplazar(b,dato1);
            reemplazar(a,dato2);
        }      
    }
    
    public String[] print(){
        String [] res = new String[longitud()];
        if(!vacia()){
            for(int i = 0; i < longitud(); i++){
                res[i] = "" + acceder(i);
            }
        }else{
            res = new String[0];
        }
        return res;
    }
}