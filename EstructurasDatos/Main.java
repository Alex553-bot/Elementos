//import LDEC.*;
//import LDE.*; 

import LSE.*; 
//import LSEC.*;

//import Queues.*;
//import Trees.*;

import Trees.BinaryTree;
//import java.util.ArrayList;
public class Main {
	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<Integer>(1);
		for (int i= 2; i<=16; i++) tree.add(i);
		tree.right.left.right.left = new BinaryTree<Integer>(4);  
		System.out.println(tree.internosVerdaderos()); 
 	}
 	public static BinaryTreeDecision<String> crearArbol(String[] listaDecision) {
		// parent i: 
		// su hijo SI: i*2
		// su hijo NO: i*2+1
		return f(listaDecision, 1);
	} 
	public static BinaryTreeDecision<String> f(String[] v, int i) {
		if (i>=v.length+1) return null; 
		if (v[i-1]==null) return null;
		BinaryTreeDecision<String> left = f(v, i*2); 
		BinaryTreeDecision<String> right = f(v, i*2+1); 

		if (left==null && right==null) return new BinaryTreeDecision<String>(v[i-1]);
		else {
			return new BinaryTreeDecision<String>(v[i-1], left, right);
		}   	
	}


}