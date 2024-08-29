public class Circulo extends Figura 
{
	private int radio; 
	public Circulo(int radio, int x, int y) {
		super(x, y);
		this.radio = radio; 
	}
	public int getRadio() {return this.radio;}

	/*
		El recorrido es sencillo, voy de centro.x -radio hasta centro.x+radio 
		y para 'y' voy de centro.y - radio hasta centro.y+radio
		para saber si debo pintar el punto solo utilizo la ecuacion del circulo 
		x^2+y^2 = radio^2;
	*/
	public char[][] pintar(char [][]v, char ch) {
		int x = super.centro.getX(), y = super.centro.getY();
		int xi = Math.max(0, x-radio), xf = Math.min(v.length-1, x+radio); 
		int yi = Math.max(0, y-radio), yf = Math.min(v[0].length-1, y+radio); 
		for (int i= xi; i<=xf; i++) 
		for (int j = yi; j<=yf; j++) 
		if (estaDentro(i, j)) 
			v[i][j] = ch;
		return v; 
	}	
	private boolean estaDentro(int i, int j) {
		int x = super.centro.getX()-i, y = super.centro.getY()-j;
		double dis = Math.sqrt(x*x+y*y); 
		return dis<=radio; 
	}
	// para saber si un circulo intersecta con mi circulo actual, realizo el mismo recorrido del pintado pero si un punto cae en ambos 
	// ya no me interesa mirarlo
	public boolean intersecta(Circulo b) {
		int x = super.centro.getX(), y = super.centro.getY();
		int xi = Math.max(0, x-radio), xf = x+radio; 
		int yi = Math.max(0, y-radio), yf = y+radio; 
		for (int i= xi; i<=xf; i++) 
		for (int j = yi; j<=yf; j++) 
		if (estaDentro(i, j) && b.estaDentro(i, j)) 
			return true;
		return false;		
	}
}