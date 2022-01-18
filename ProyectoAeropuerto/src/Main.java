
import java.util.Scanner;

public class Main {
    static Scanner entrada = new Scanner(System.in);
    final static int num = 4; //num Aeropuertos
    static Aeropuerto aeropuertos[] = new Aeropuerto[num];

    public static void main(String[] args) {
        
        insertarAeropuerto(aeropuertos);
        menu();
        
        
        //Insertar los datos del aeropuerto
    }
    
    public static void insertarAeropuerto(Aeropuerto aero[]){
        aero[0] = new AeropuertoPublico(80000000,"Jorge chavez","Lima","Perú"); //Crea el aeropuerto
        aero[0].insertarCompañia(new Compañia("AeroPeru")); //Crea compañia
        aero[0].insertarCompañia(new Compañia("LATAM"));
        aero[0].getCompañia("AeroPeru").insertarVuelo(new Vuelo("IB20","Lima","DF Mexico",160.90, 150)); //Al aeropuerto agrega la compañia y crea un vuelo de la compañia agregada
        aero[0].getCompañia("AeroPeru").insertarVuelo(new Vuelo("IB21","Lima","Buenos aires",180.99,120));
        aero[0].getCompañia("LATAM").insertarVuelo(new Vuelo("FC12","Lima","Londres",500.90,180));
        aero[0].getCompañia("AeroPeru").getVuelo("IB20").insertarPasajero(new Pasajero("Alejandro", "AH291745", "Peruana")); //Al aeropuerto agrega la compañia, a la compañia agraga un vuelo y del vuelo crea los pasajeros
        aero[0].getCompañia("AeroPeru").getVuelo("IB20").insertarPasajero(new Pasajero("Miguel", "AH294850", "Mexicana"));
        aero[0].getCompañia("LATAM").getVuelo("FC12").insertarPasajero(new Pasajero("Marta", "AC291435", "Colombiano"));
        
        aero[1] = new AeropuertoPrivado("Central Ciudad Real", "Ciudad real", "España");
        aero[1].insertarCompañia(new Compañia("AirEuropa"));
        String empresas[] = {"Cobreso1", "Anguila34"};
        ((AeropuertoPrivado)aero[1]).insertarEmpresas(empresas);
        aero[1].getCompañia("AirEuropa").insertarVuelo(new Vuelo("AE025","Madrid","Buenos Aires", 600, 130));
        aero[1].getCompañia("AirEuropa").getVuelo("AE025").insertarPasajero(new Pasajero("Efra", "DJ820424","Español"));
        
        aero[2] = new AeropuertoPublico(40000000,"El dorado","Bogota","Colombia");
        aero[2].insertarCompañia(new Compañia("AirAmerica"));
        aero[2].insertarCompañia(new Compañia("VuelaBogota"));
        aero[2].getCompañia("AirAmerica").insertarVuelo(new Vuelo("AE372","Bogota","Lima",120,175));
        aero[2].getCompañia("AirAmerica").getVuelo("AE372").insertarPasajero(new Pasajero("Liliana","PF37924","Colombiana"));
        aero[2].getCompañia("AirAmerica").getVuelo("AE372").insertarPasajero(new Pasajero("Mikael","HF38294","Peruana"));
        
        aero[3] = new AeropuertoPublico(30999999,"Aeropuerto Mexico","MexicoDf","Mexico");
        aero[3].insertarCompañia(new Compañia("AeroMexico"));
        aero[3].getCompañia("AeroMexico").insertarVuelo(new Vuelo("IB240","MexicoDF","Santiago", 300, 140));
        aero[3].getCompañia("AeroMexico").insertarVuelo(new Vuelo("IB394","Mexico DF","Lima",200, 155));
        aero[3].getCompañia("AeroMexico").getVuelo("IB240").insertarPasajero(new Pasajero("Marcos","MK3456","Chileno")); 
     
    }
    
    public static void menu(){
        int opcion;
        String nombreAeropuerto, nombreCompañia, origen, destino;
        Aeropuerto aeropuerto;
        Compañia compañia;
        
        do{
            System.out.println("\t.:Menú:.");
            System.out.println("1. Consultar los aeropuertos gestionados (Publicos o privados)");
            System.out.println("2. Ver empresas(Si es privado) p subvención(si es publico)");
            System.out.println("3. Listas de compañias de un aeropuerto");
            System.out.println("4. Lista de vuelos por compañia");
            System.out.println("5. Todos los posibbles vuelos de origen a destino");
            System.out.println("6. Salir");
            System.out.print("Opcion: ");
            opcion = entrada.nextInt();
            System.out.println(" ");
       
            switch (opcion){
                case 1: //Aeropuertos gestionados
                       mostrarAeropuertos(aeropuertos);
                    break;
                case 2: // Ver empresas o subvencion
                       mostrarPatrocinio(aeropuertos);
                    break;
                case 3: //Lista de compañias de un aeropuerto
                       entrada.nextLine();
                       System.out.print("Digite el nombre del aeropuerto: ");
                       nombreAeropuerto = entrada.nextLine();
                       aeropuerto = buscarAeropuerto(nombreAeropuerto, aeropuertos);
                       if(aeropuerto==null){
                           System.out.println("El aeropuerto no existe");
                       }
                       else{
                           mostrarCompañias(aeropuerto);
                       }
                    break;
                case 4: // List de vuelos de una compañia
                    entrada.nextLine();
                    System.out.print("Digite el nombre del aeropuerto: ");
                    nombreAeropuerto = entrada.nextLine();
                    aeropuerto = buscarAeropuerto(nombreAeropuerto, aeropuertos);
                    if(aeropuerto==null){
                           System.out.println("El aeropuerto no existe");
                       }
                       else{
                           System.out.print("Digite el nombre de la compañia: ");
                           nombreCompañia = entrada.nextLine();
                           compañia = aeropuerto.getCompañia(nombreCompañia);
                           mostrarVuelos(compañia);
                       }
                    
                    break;
                case 5: //Listar todos los posibles vuelos de Origen a Destino
                    entrada.nextLine();
                    System.out.print("Digite la ciudad origen: ");
                    origen = entrada.nextLine();
                    System.out.print("Digite la ciudad destino: ");
                    destino = entrada.nextLine();
                    mostrarVueloOrigenDestino(origen, destino, aeropuertos);
                    break;
                case 6: break;
                default: System.out.println("ERROR Ingrese la opcion nuevamente");
            }
        }while(opcion!=6);
    }
    
    
    public static void mostrarAeropuertos(Aeropuerto aeropuertos[]){
        for (int i=0;i<aeropuertos.length;i++){
            if(aeropuertos[i] instanceof AeropuertoPrivado){
                System.out.println("Aeropuerto Privado");
                System.out.println("Nombre: " +aeropuertos[i].getNombre());
                System.out.println("Ciudad: "+aeropuertos[i].getCiudad());
                System.out.println("Pais: "+aeropuertos[i].getPais());
            
            }
            else {
                System.out.println("Aeropuerto Publico");
                System.out.println("Nombre: " +aeropuertos[i].getNombre());
                System.out.println("Ciudad: "+aeropuertos[i].getCiudad());
                System.out.println("Pais: "+aeropuertos[i].getPais());   
            }
            
            System.out.println(" ");
        }
        
    }
    
    public static void mostrarPatrocinio(Aeropuerto aeropuertos[]){
        String empresas[];
        
        for (int i=0;i<aeropuertos.length;i++){
            if(aeropuertos[i] instanceof AeropuertoPrivado){
                System.out.println("Aeropuerto Privado: "+aeropuertos[i].getNombre());
                empresas = ((AeropuertoPrivado)aeropuertos[i]).getListaEmpresas();
                System.out.println("Sus empresas son: ");
                for( int j=0;j<empresas.length;j++){
                    System.out.println(empresas[j]);
                }
            }
            else {
                System.out.println("Aeropuerto publico: "+aeropuertos[i].getNombre());
                System.out.println("Subvención: "+((AeropuertoPublico)aeropuertos[i]).getSubvencion());
            }
            System.out.println(" ");
        }
    }
    
    public static Aeropuerto buscarAeropuerto(String nombre, Aeropuerto aeropuertos[]){
        boolean encontrado = false;
        int i=0;
        Aeropuerto aero = null;
        
        if((!encontrado) && (i<aeropuertos.length)){
            if(nombre.equals(aeropuertos[i].getNombre())){
                encontrado = true;
                aero = aeropuertos[i];
            }
            i++;
        }
        return aero;
    }
        
    public static void mostrarCompañias(Aeropuerto aeropuerto){
        System.out.println("\nLas compañias del aeropuerto "+aeropuerto.getNombre());
        for(int i=0; i<aeropuerto.getNumCompañia();i++){
            System.out.println(aeropuerto.getCompañia(i).getNombre());
        }
    }
    
    public static void mostrarVuelos(Compañia compañia){
        Vuelo vuelo;
        System.out.println("Los vuelos de la compañia: "+compañia.getNombre());
        for(int i=0; i<compañia.getNumVuelo();i++){
            vuelo = compañia.getVuelo(i);
            System.out.println("identificador: "+vuelo.getIdentificador());
            System.out.println("Ciudad origen: "+vuelo.getCiudadOrigen());
            System.out.println("Ciudad destino: "+vuelo.getCiudadDestino());
            System.out.println("Precio: " +vuelo.getPrecio());
            System.out.println(" ");
        }
    }
    public static Vuelo[] buscarVuelosOrigenDestino(String origen, String destino, Aeropuerto aeropuertos[]){
        Vuelo vuelo;
        int contador = 0;
        Vuelo listaVuelos[];
        
        for(int i=0;i<aeropuertos.length;i++){
            for(int j=0;j<aeropuertos[i].getNumCompañia();j++){
                for(int k=0;k<aeropuertos[i].getCompañia(j).getNumVuelo();k++){
                    vuelo = aeropuertos[i].getCompañia(j).getVuelo(k);
                    if(origen.equals(vuelo.getCiudadOrigen()) && (destino.equals(vuelo.getCiudadDestino()))){
                       contador++;
                    }
                }
            }
        }
        
        listaVuelos = new Vuelo[contador];
        int q=0;
        for(int i=0;i<aeropuertos.length;i++){
            for(int j=0;j<aeropuertos[i].getNumCompañia();j++){
                for(int k=0;k<aeropuertos[i].getCompañia(j).getNumVuelo();k++){
                    vuelo = aeropuertos[i].getCompañia(j).getVuelo(k);
                    if(origen.equals(vuelo.getCiudadOrigen()) && (destino.equals(vuelo.getCiudadDestino()))){
                       listaVuelos[q] = vuelo;
                       q++;
                    }
                }
            }
        }
        
        return listaVuelos;
    }
     
    
    public static void mostrarVueloOrigenDestino(String origen, String destino, Aeropuerto aeropuertos[]){
     Vuelo vuelos[];
     vuelos = buscarVuelosOrigenDestino(origen, destino, aeropuertos);
     if(vuelos.length==0){
         System.out.println("No existen vuelos");
     }
     else{
         System.out.println("Vuelos encontrados: ");
         for(int i=0; i<vuelos.length;i++){
             System.out.println("Identificador: "+vuelos[i].getIdentificador());
             System.out.println("Precio: "+vuelos[i].getPrecio());
             System.out.println(" ");
         }
     }
    }
    
}

