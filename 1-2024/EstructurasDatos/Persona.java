public class Persona implements Comparable {
    String id, name, dir;
    int nivel = 0;

    public Persona(String id, String name, String dir) {
        this.id = id; 
        this.name = name; 
        this.dir = dir;
    }
    public int compareTo(Object o) {
        Persona b = (Persona)o ; 
        if (b.id==id) {
            if (b.name==name && dir==b.dir) return 0;
            return 1; 
        }
        return id.compareTo(b.id);
    }
    @Override
    public String toString() {
        return id+" "+name+" "+dir;
    }
}
