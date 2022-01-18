
public class Vuelo {
    private String identificador;
    private String ciudadOrigen;
    private String ciudadDestino;
    private double precio;
    private int maxPasajero;
    private int nActualPasajeros;
    private Pasajero listaPasajero[];

    public Vuelo(String identificador, String ciudadOrigen, String ciudadDestino, double precio, int maxPasajero) {
        this.identificador = identificador;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.precio = precio;
        this.maxPasajero = maxPasajero;
        this.nActualPasajeros = 0; //Al iniciar va a ser 0, desps se aumenta en otro metodo
        this.listaPasajero = new Pasajero[maxPasajero];
        
    }
    
    public void insertarPasajero(Pasajero pasajero){
        listaPasajero[nActualPasajeros] = pasajero; //mete el pasajero en el arreglo
        nActualPasajeros++;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public double getPrecio() {
        return precio;
    }

    public int getMaxPasajero() {
        return maxPasajero;
    }

    public int getnActualPasajeros() {
        return nActualPasajeros;
    }
    
    public Pasajero getPasajero(int i){ //EL entero que devuelve es el numero del pasajero y el metodo devuelve un pasajero
        return listaPasajero[i]; //Si i es 20, pues devuelve el pasajero 20
    } 
    
    public Pasajero getPasajero(String pasaporte){
        boolean encontrado = false;
        int i=0;
        Pasajero pas=null;
        while ((encontrado==false)&&(i<listaPasajero.length)){ //Se puede usar tambien pasaporte.equals(listaPasajeros[i].getPasaporte()
            if(pasaporte == listaPasajero[i].getPasaporte()){
                encontrado = true;
                pas = listaPasajero[i];
            }
            i++;
        }
        return pas;
    }
    
    
}
