package LSE; 
public class Atleta implements Comparable {
    int a, b, c; 
    String nombre; 
    String pais; 
    public Atleta(String name, String pais, int oro, int plata, int bronze) {
        nombre = name; 
        this.pais = pais; 
        a = oro; 
        b = plata; 
        c = bronze; 
    }
    public int compareTo(Object o) {
        Atleta otro = (Atleta)o; 
        int s = a+b+c; 
        int so = otro.a+otro.b+otro.c; 
        if (s > so) return 1; 
        else if (s==so) {
            if (a>otro.a) return 1;
            else if (a<otro.a) return -1;  
            if (b>otro.b) return 1;
            else if (b<otro.b) return -1;  
            if (c>otro.c) return 1;
            else if (c<otro.c) return -1; 
            return 0;
        }
        return -1;
    }
    @Override
    public String toString() {
        return nombre+" "+pais+" "+a+" "+b+" "+c+" T:"+(a+b+c);
    }
}