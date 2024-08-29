public class BSTB<T extends Comparable> 
{
    public BSTB<T> left, right;
    public T data; 

    public int ult = -1;

    public BSTB() {}
    public BSTB(T data) {this.data = data;}
    
    public void add(T data) {
        add(this, new BSTB<>(data)); 
        balancear();
    }
    private void add(BSTB<T> it, BSTB<T> nuevo) {
        if (it.data.compareTo(nuevo.data) > 0) {
            if (it.left==null) it.left = nuevo;
            else add(it.left, nuevo); 
        } else {
            if (it.right==null) it.right = nuevo; 
            else add(it.right, nuevo);
        }    
    }
    public void balancear() {
        int l = niv(this.left), r = niv(this.right); 
        if (Math.abs(l-r)>1) {
            if (r>l) {
                BSTB<T> it = findm(this.right);
                it = it.left; 
                T aux = it.data;
                delete(aux);
                T aux2 = this.data;
                this.data = aux; 
                BSTB<T> nuevo = new BSTB<>(aux2); 
                nuevo.left = left; 
                left = nuevo;  
            } else {
                BSTB<T> it = findM(this.left);
                it = it.right; 
                T aux = it.data;
                delete(aux);
                T aux2 = this.data;
                this.data = aux; 
                BSTB<T> nuevo = new BSTB<>(aux2); 
                nuevo.right = right; 
                right = nuevo;  

            }
        }
    }
    public void delete(T data) {
        delete(this, data);
        balancear();
    }
    private T delete(BSTB<T> it, T data) {
        if (it==null) return null; 
        int comp = it.data.compareTo(data);
        if (comp==0) {
            BSTB<T> a = (it.left==null? findm(it): findM(it));
            BSTB<T> b= (a.left==null? a.right: a.left);
            it.data = b.data; 
            if (b.left==null) {
                a.left = b.right;
            } else {
                a.right = b.left;
            }
        } else {
            if (comp > 0) delete(it.left, data); 
            else delete(it.right, data);
        }
        return data;
    }
    public BSTB<T> findMinor() {
        if (this.right==null) return findM(this.left);
        return findm(this.right); 
    }

    private BSTB<T> findm(BSTB<T> it) {
        if (it==null) return null; 
        if (it.left==null) {
            it.ult = 1; 
            return it; 
        } 
        BSTB<T> sig = findm(it.left);
        if (sig.ult==-1) return sig;   
        it.ult = -1;
        return it; 
    }

    public int niv() {
        return niv(this);
    }
    private int niv(BSTB<T> it) {
        if (it==null) return 0;
        return 1+Math.max(niv(it.left), niv(it.right));
    }

    public BSTB<T> findMax() {
        if (this.left==null) return findm(this.right);
        return findM(this.left);
    }
    private BSTB<T> findM(BSTB<T> it) {
        if (it==null) return null; 
        if (it.right==null) {
            it.ult = 1;
            return it; 
        }
        BSTB<T> sig = findM(it.right);
        if (sig.ult==-1) return sig;
        it.ult =-1; 
        return it;
    }

    public void print() {
        print(this); 
    }
    private void print(BSTB<T> it) {
        if (it==null) return;
        System.out.println(it.data.toString());
        print(it.left); 
        print(it.right);
    }
}