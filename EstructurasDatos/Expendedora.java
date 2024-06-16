import Queues.*; 
public class Expendedora
{
	private Queue<Papa> gancho1; 
	private Queue<Gomita> gancho2; 
	private Queue<Nacho> gancho3; 
	private int X = 1;
	public Expendedora() {
		gancho1 = new Queue<Papa>(); 
		gancho2 = new Queue<Gomita>(); 
		gancho3 = new Queue<Nacho>(); 
	}

	public void add(Producto productos[]) {
		for (Producto p: productos) {
			if (p instanceof Papa) gancho1.push((Papa)p); 
			else if (p instanceof Nacho) gancho3.push((Nacho)p);
			else gancho2.push((Gomita)p);
		}
		advertencias();
	}
	public Producto vender(int opcion) {
		Producto x = null; 
		switch (opcion) {
			case 1: x = gancho1.pop(); break;
			case 2: x = gancho2.pop(); break;
			case 3: x = gancho3.pop(); break;
			default:  x = null;
		}
		advertencias();
		return null;
	}

	private void advertencias() {
		if (gancho1.size()<=X) System.out.println("Falta productos de tipo papas"); 
		if (gancho2.size()<=X) System.out.println("Falta productos de tipo gomitas"); 
		if (gancho3.size()<=X) System.out.println("Falta productos de tipo nachos"); 
	}
}