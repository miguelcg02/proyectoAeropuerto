
public class AeropuertoPublico extends Aeropuerto{
    private double subvencion;

    public AeropuertoPublico(String nombre, String ciudad, String pais) {
        super(nombre, ciudad, pais);
    }

    public AeropuertoPublico(String nombre, String ciudad, String pais, Compañia[] c, double subvencion) {
        super(nombre, ciudad, pais, c);
        this.subvencion = subvencion;
    }

    public AeropuertoPublico(double subvencion, String nombre, String ciudad, String pais) {
        super(nombre, ciudad, pais);
        this.subvencion = subvencion;
    }

    public double getSubvencion() {
        return subvencion;
    }
    
    
    
}
