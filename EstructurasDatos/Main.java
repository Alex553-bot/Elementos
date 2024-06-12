//import LDEC.*;
//import LDE.*; 

//import LSE.*; 
//import LSEC.*;

//import Queues.*;
//import Trees.*;

import Trees.*;
import java.util.ArrayList;
public class Main {
	public static void main(String[] args) {
		Persona personas[] = new Persona[20];
		for (int i= 0; i<20; i++) {
			String id = ""+(i%8);
			personas[i] = new Persona(id, "a", "b"); 
		}
		BinaryTree<Persona> censo =new BinaryTree<>(personas[0]);
		for (int i =1 ;i <20; i++) censo.add(personas[i]);
		BST<Persona> bst = new BST<Persona>(personas[0]);
		ArrayList<Persona> lista = new ArrayList();
		f(0, censo,bst, lista); 
		for (int i= 0; i<lista.size(); i++) System.out.println(lista.get(i).toString());
	}
	public static void f(int i, BinaryTree<Persona> root, BST<Persona> bst,ArrayList<Persona> lista) {
		if (root==null) return;
		root.value.nivel = i;
		BST<Persona> elemento = bst.find(root.value);
		if (elemento==null) bst.add(root.value);
		else {
			int comp = root.value.compareTo(elemento.value);
			if (comp==0) {
				if (root.value.nivel > elemento.value.nivel) {
					lista.add(elemento.value); 
					elemento.value = root.value;
				} else {
					lista.add(root.value); 
				}
			}
		}
		f(i+1, root.left, bst, lista); 
		f(i+1, root.right, bst, lista); 
	}
}