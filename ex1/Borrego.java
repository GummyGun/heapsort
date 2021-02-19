package t4.ex1;

public class Borrego implements Comparable<Borrego> {
    public Borrego(int value, String nombre){
        this.kilos=value;
        this.nombre= new String(nombre);
    }
    private final int kilos;
    private final String nombre;


    @Override
    public String toString() {
        return String.format("%d kilos: borrego %s. ¡Mbaaah!", kilos, nombre);
    }

    @Override
    public int compareTo(Borrego o) {
        if(this.kilos>o.kilos){
            return 1;
        }else if(this.kilos<o.kilos){
            return -1;
        }
        int ret;
        if ((ret=this.nombre.compareTo(o.nombre))!=0) {
            return ret;
        }
        return 0;

    }
}
