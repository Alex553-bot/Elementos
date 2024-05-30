//import LDEC.*;
//import LDE.*; 

//import LSE.*; 
//import LSEC.*;

public class Main {
	public static void main(String[] args) {
		/**
		 * CRUD: 
		 * create // agregar un nuevo elemento
		 * read  // obtener los elementos, size, obtener uno solo, ...
		 * update  // actualizacion elemento
		 * delete // eliminar elementos 
		 */

		/**
		Atleta a1 = new Atleta("JOSE ALMAGRO", "PERU", 12, 4, 54);
		Atleta a2 = new Atleta("JORGE ALMAGRO", "PERU", 132, 54, 5);
		Atleta a3 = new Atleta("ROSALIA ALMAGRO", "PERU", 14, 53, 4);
		Atleta a4 = new Atleta("REY ", "PERU", 123, 54, 554);
		Atleta a5 = new Atleta("TOMY ", "PERU", 2, 0, 5);
		Lista<Atleta> med = new Lista<>();
		Atleta inicio =  new Atleta("INF", "", 1000, 1000, 1000);
		Nodo<Atleta> f = new Nodo<Atleta>(inicio);
		f.next = new Nodo<Atleta>(new Atleta("F", "", -1, -1, -1));

		med.root = f;

		med.add(a1);
		med.add(a2);
		med.add(a3);
		med.add(a4);
		med.add(a5);
		med.print();
		*/
		ListaSE<Integer> lista = new ListaSE<Integer>();
		NodoSE<Integer> primerElemento = new NodoSE<Integer>(2); 
		primerElemento.next = new NodoSE<Integer>(123); 
		lista.root = primerElemento;
		//System.out.println(lista.size()); 
		//System.out.println(lista.size2()); 

		lista.add(1235); 
		lista.add2(152343);

		System.out.println(lista.get(0).toString()); 
		System.out.println(lista.get2(1).toString()); 

		System.out.println(lista.get(2).toString()); 
		System.out.println(lista.get2(3).toString()); 


System.out.println();
		lista.delete(123);
		System.out.println(lista.get2(1).toString()); 
System.out.println();

		lista.delete2(1235);		
		System.out.println(lista.get2(1).toString()); 
	}
	// 4, 123, 332, 4354
	// 332, 4354, 4, 123
}