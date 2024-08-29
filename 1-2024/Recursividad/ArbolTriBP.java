import java.util.*;
public class ArbolTriBP<T extends Comparable<T>>
{
	private T raiz;
	private ArbolTriBP<T> izq, med, der;
	public ArbolTriBP(){
		raiz = null;
		izq = med = der = null;
	}
	public ArbolTriBP(T d) {
		raiz = d; 
		izq = med = der = null;
	}
	public void insertar(T d){
		// debes definirlo
		if (izq==null || med==null || der==null) {
			if (izq==null) izq = new ArbolTriBP<T>(d);
			else if (med==null) med = new ArbolTriBP<T>(d);
			else der = new ArbolTriBP<T>(d);
			ordenar(this);
		} else {
		int x = insertar(this, d);
		if (x==0) {
			ArbolTriBP<T> it = this; 
			while (it.getLeft()!=null) it = it.getLeft();
			it.setLeft(new ArbolTriBP<T>(d));
		}

		}
	}
	private int insertar(ArbolTriBP<T> it, T d) {
		if (it==null) return 0;
		if (it.getLeft()==null) {
			it.setLeft(new ArbolTriBP<T>(d));
			return 1;
		}
		if (it.getLeft().getLeft()==null) {
			//System.out.println("estoy en parent de una hoja "+it.getValue().toString()+" "+d.toString());
			if (it.getMid()==null) {
				//System.out.println("entro al medio y lo pongo");
				it.setMid(new ArbolTriBP<T>(d));
				ordenar(it); 
				return 1;
			} else if (it.getRight()==null) {
				//System.out.println("entro a la derecha y lo pongo");
				it.setRight(new ArbolTriBP<T>(d));
				ordenar(it);
				return 1;
			} 
			//System.out.println("no lo puse");
			return 0;
		}
		if (insertar(it.getLeft(), d) == 1) return 1; 
		else if(insertar(it.getMid(), d)==1) return 1;
		else if (insertar(it.getRight(), d)==1) return 1; 
		return 0;
	}
	private void ordenar(ArbolTriBP<T> it) {
		ArbolTriBP<T> left = it.getLeft();
		ArbolTriBP<T> mid = it.getMid();
		ArbolTriBP<T> right = it.getRight();
		if (mid!=null && left.getValue().compareTo(mid.getValue()) > 0) {
			ArbolTriBP<T> aux = left; 
			left = mid; 
			mid = aux;	
		}
		if (right!=null && left.getValue().compareTo(right.getValue()) > 0) {
			ArbolTriBP<T> aux = left; 
			left = right; 
			right = aux;	
		}
		if (mid!=null && right!=null && mid.getValue().compareTo(right.getValue()) > 0) {
			ArbolTriBP<T> aux = mid; 
			mid = right; 
			right = aux;	
		}
		it.setLeft(left); 
		it.setMid(mid); 
		it.setRight(right);
	}
	public void print() {
		System.out.println(raiz.toString());
		if (izq!=null)
		System.out.print(" "+izq.getValue().toString()+" ");
		if (med!=null)
		System.out.print(med.getValue().toString()+" ");
		if (der!=null)
		System.out.print(der.getValue().toString()+" ");
		System.out.println();	
		if (izq!=null)
		izq.print(); 
		if (med!=null)
		med.print(); 
		if (der!=null)
		der.print();
	}
	public T getValue() {return raiz;}
	public ArbolTriBP<T> getLeft() {return izq;}
	public ArbolTriBP<T> getMid() {return med;}
	public ArbolTriBP<T> getRight() {return der;}
	public void setLeft(ArbolTriBP<T> izq) {
		this.izq = izq;
	}
	public void setMid(ArbolTriBP<T> med) {
		this.med = med;
	}
	public void setRight(ArbolTriBP<T> der) {
		this.der = der;
	}
}