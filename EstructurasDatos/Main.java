public class Main {
	public static void main(String[] args) {
		Lista<Integer> l = new Lista(new Integer(4));
		System.out.println(l.size());
		l.add(new Integer(123));
		l.add(new Integer(332)); 
		l.add(new Integer(4354));
		l.add(new Integer(123));
		l.add(new Integer(345));
		l.add(new Integer(4354));
		l.add(new Integer(4354));
		l.imprimir();
		System.out.println(l.size()); 

		l.del();
		l.imprimir();
	}
	// 4, 123, 332, 4354
	// 332, 4354, 4, 123
}