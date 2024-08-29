import java.util.ArrayList; 
public class Persona 
{
	private ArrayList<Figura> cuerpo; 
	public Persona() {
		this.cuerpo = new ArrayList<>();
		for (int i =0 ; i<=5; i++) cuerpo.add(null);
		/*
			De este apartado se obtiene los siguiente: 
			0 => cabeza
			1 => mano izq
			2 => torso
			3 => mano derecha
			4 => pierna izq
			5 => pierna der
		*/ 
	}
	public void agregarPiernaDer(Figura f) {
		this.incluir(f, 5);
	}
	public void agregarPiernaIzq(Figura f) {
		this.incluir(f, 4);
	}

	public void agregarManoIzq(Figura f) {
		this.incluir(f, 1); 
	}
	public void agregarManoDer(Figura f) {
		this.incluir(f, 3);
	}

	public void agregarCabeza(Figura f) {
		this.incluir(f, 0);
	}

	public void agregarTorso(Figura f) {
		this.incluir(f, 2);
	}

	private void incluir(Figura f, int piv) {
		Circulo nuevo = (Circulo)f; 
		for (int i = 0; i<=5;i ++) {
			Circulo pieza = (Circulo)cuerpo.get(i);
			if (i == piv || pieza==null) continue; 
			if (nuevo.intersecta(pieza)) return ;
		}
		cuerpo.set(piv, nuevo); 
	}

	public void dibujar() {
		int n, m; // ancho y alto respectivamente
		n = m = 0; 
		int conjuntos[] = {0, 3, 5}; // para la division entre cabeza torso y piernas
		char caracteres[] = {'a', 'b', 'c', 'd', 'e', 'f'}; // para que el pintado se vea diferente
		int nn = cuerpo.size(); 
		int j =0, px = 0, py = 0; // conjunto actual 
		for (int i =0; i<nn; i++) {
			if (cuerpo.get(i) instanceof Circulo) { 
			// la funcion instanceof es una funcion que compara el objeto con una clase para saber si es su tipo
				Circulo pieza = (Circulo)cuerpo.get(i); // polimorfismo 
				int radio = pieza.getRadio();
				px += 2*radio; py = Math.max(py, 2*radio);
			}
			if (i==conjuntos[j]) {
				j++; 
				n = Math.max(px, n); m += py; // formula vista en clases.  
				px = py = 0; 
			}
		}	
		// por ultimo ya teniendo el panel para dibujar, lo llenamos: 
		n = m = 40; // utilizo esto dado que me puede dar un punto que puede ser x = 100, y = 100, por lo que lo limito directamente 
		char v[][] = new char[n+1][m+1];
		for (int i= 0 ; i<=n; i++) 
		for (j = 0;j <=m; j++) v[i][j] = ' ';
		for (int i=0; i<nn; i++) {
			if (cuerpo.get(i)==null) continue;
			System.out.print(i);
		}
		System.out.println();
		System.out.println(n+" "+m);
		for (int i =0; i<nn; i++) 
			if (cuerpo.get(i)!=null)
				v = cuerpo.get(i).pintar(v, caracteres[i]); 
		for (int i =0 ; i<=n; i++, System.out.println()) 
		for (j = 0; j<=m;j ++) 
			System.out.print(v[i][j]);
	}
}