public class BST<T extends Comparable>
{
    public BST<T> left; 
    public BST<T> right; 
    public T value; 

    public BST(T value) {
        this.value = value; 
        left = right = null; 
    }

    public void add(T value) {
        BST<T> leaf = new BST<T>(value);
        add(leaf, this);
    }
    public void add(BST<T> leaf, BST<T> root) {
        int comp = root.value.compareTo(leaf.value); 
        if (comp<=0) {
            if (root.right==null) root.right = leaf; 
            else add(leaf, root.right); 
        } else {
            if (root.left==null) root.left = leaf; 
            else add(leaf, root.left); 
        }
    }
    public void inorden() {
		inorden(this);
	}
    public BST<T> find(T data) {
        BST<T> nodo = new BST<>(data);        
        return find(nodo, this); 
    }
    public BST<T> find(BST<T> it, BST<T> root) {
        int comp = root.value.compareTo(it.value); 
        if (comp==0) return it; 
        if (comp<0) {
            if (root.right==null) return null; 
            return find(it, root.right);
        } else {
            if (root.left==null) return null; 
            return find(it, root.left);
        }
    }

	public void inorden(BST<T> root) {
		if (root==null) return;
		inorden(root.left); 
		System.out.print(root.value.toString()+" ");
		inorden(root.right);
	}

    public ListaDE<T> subsecuencia(T ini, T fin) {
        ListaDE<T> lista = new ListaDE<T>();
        ff(this, lista, ini, fin); 
        return lista;
    }
    private void ff(BST<T> arbolActual, ListaDE<T> res, T ini, T fin) {
        if (arbolActual==null) return; 
        int compFin = fin.compareTo(arbolActual.value); 
        int compIni = ini.compareTo(arbolActual.value);
        // a.comp(b) > 0 => a> b
        // a.comp(b) = 0 => a=b
        // a.comp(b) < 0 => a<b  
        int ok = 0;
        if (compFin < 0) ff(arbolActual.left, res, ini, fin); 
        else if (compIni <= 0) ff(arbolActual.left, res, ini, fin);
        if (compIni<=0 && compFin>=0) 
            res.add(arbolActual.value); 
        if (compIni > 0) {
            ff(arbolActual.right, res, ini, fin); 
        } else if (compFin >= 0) ff(arbolActual.right, res, ini, fin);
    }
}

/**
 * Observaciones: 
 * [ini, fin]
 * sub-arbol: 
 * T valor
 * left, right
 * valor esta dentro del intervalo? => si esta => agrego a mi respuesta
 * caso contrario => no lo agrego 
 * if (valor >= fin)
 *  siguientenodo -> left
 * else if (valor<=ini)
 *  siguiente nodo -> right
 *  else realizo ambos nodos
 * 
 */