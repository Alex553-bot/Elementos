public class Main {
	public static void main(String[] args) {
		Lista<Integer> l = new Lista(new Integer(4));
		System.out.println(l.size());
		l.add(new Integer(123), 20);
		l.add(new Integer(332), 2122); 
		l.add(new Integer(4354), 1);
		l.imprimir();
		l.erase(123);
		l.imprimir();
		System.out.println(l.size()); 
	}
}