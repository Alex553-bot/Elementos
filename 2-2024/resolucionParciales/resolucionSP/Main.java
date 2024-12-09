public class Main {
	public static void main(String[] args) {
/*		Arbol<Integer> root = new Arbol();
		root.data = 4; 
		root.padre = new Arbol();
		root.hijo = new Arbol();
		root.hno = new Arbol(); 

		root.hijo.data = 10; 
		root.hijo.hno = new Arbol();
		root.hijo.hijo = new Arbol(); 
		root.hijo.padre = root;

		root.hijo.hno.hno = new Arbol();
		root.hijo.hno.data = 5; 
		root.hijo.hno.padre = root;
		root.hijo.hno.hijo = new Arbol(); 
		
		root.hijo.hijo.data = 18;
		root.hijo.hijo.hno = new Arbol();
		root.hijo.hijo.hijo = new Arbol(); 
		root.hijo.hijo.padre = root.hijo;

		root.hijo.hno.hijo.data = 37; 
		root.hijo.hno.hijo.hijo = new Arbol(); 
		root.hijo.hno.hijo.hno = new Arbol(); 
		root.hijo.hno.hijo.padre = root.hijo.hno;
		System.out.println(root.bfs().toString());
	
		LDE<String> entrada = new LDE();
		entrada.add("a");
		entrada.add("b");
		entrada.add("c");
		entrada.add("d");
		entrada.add("e");

		for (int i= 0; i<5; i++) System.out.println(entrada.generar(i));
*/
		ArbolBin<Integer> root = new ArbolBin(1); 
		root.left=  new ArbolBin(2); 
		root.right= new ArbolBin(3); 
		root.right.left = new ArbolBin(4);
		System.out.println(root.is()); 
		

		root = new ArbolBin(1); 
		root.left=  new ArbolBin(2); 
		root.right= new ArbolBin(3); 
		root.left.left = new ArbolBin(4); 
		root.left.right = new ArbolBin(5);
		System.out.println(root.is()); 
	}
}