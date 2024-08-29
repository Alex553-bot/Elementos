public abstract class Figura 
{
	protected Punto centro; 
	public Figura(int x, int y) {
		this.centro = new Punto(x, y);
	}
	public abstract char[][] pintar(char [][]v, char ch); 
	public Punto getCentro() {return this.centro;}
}