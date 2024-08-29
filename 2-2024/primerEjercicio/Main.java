import java.util.*; 
public class Main 
{
	public static void main(String[] args) {
		Persona p = new Persona();
		p.agregarCabeza(	new Circulo(2, 2,  10));
		p.agregarTorso(		new Circulo(5, 10, 10));
		p.agregarManoIzq(	new Circulo(2, 9,  3)); 
		p.agregarManoDer(	new Circulo(2, 9,  17)); 
		p.agregarPiernaDer(	new Circulo(2, 17, 13));
		p.agregarPiernaIzq(	new Circulo(2, 17, 8));   
		p.dibujar(); 
	}
}