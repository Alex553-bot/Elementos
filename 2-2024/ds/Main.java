public class Main {
	public static void main(String[] args) {
		List lse = new List();
		lse.add(2);
		lse.add(4);
		lse.add(1); // 1 4 2
		System.out.println(lse.size());
		lse.print();
		System.out.println(lse.get(2));
		lse.erase(4);
		lse.print();
		lse.erase(1);
		lse.print();		
	}
}