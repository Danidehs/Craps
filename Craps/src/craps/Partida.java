/**
 * Partida
 * Clase que contiene los metodos del juego, las condiciones de
 * valor de los dados, los turnos, el lanzamiento de los dados,
 * cuando gana el jugador, la computadora o la casa; y el codigo
 * del archivo de texto con el que se guardan e imprimen las 
 * estadisticas.
 * @author Grupo 5
 * @version 1.0 , 18/02/2016
 * */

package craps;

import java.util.*;
import java.io.*;


public class Partida extends Thread{
    
    private long resultado; //tiempo total de partida.
    private int sumatirada1;
    private String ganador;

    public long getResultado() {
        return resultado;
    }

    public void setResultado(long n) {
        this.resultado = n;
    }
    
    public int getSumatirada1() {
        return sumatirada1;
    }

    public void setSumatirada1(int n) {
        this.sumatirada1 = n;
    }

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String n) {
        this.ganador = n;
    }
    
    
    //Archivo de texto
    File f = new File("Registro.txt");
    ArrayList<Partida> cosas =new ArrayList<Partida>();
              Partida            objeto = null;
    
    //Constructor
    public Partida(int sumatirada1,String ganador, long resultado){
        this.sumatirada1 = sumatirada1;
        this.ganador = ganador;
        this.resultado = resultado;
    }   
    
    public Partida (){
    }
    
    /**
     * LanzarDados
     * Metodo con el que se realizan todos los movimientos del juego:
     * el lanzamiento de los dados, las condiciones para ganar o perder
     * al momento de la tirada inicial, la etapa "Ronda" y como se gana
     * o se pierde y el timer para contar el tiempo de cada juego
     */  
    public void LanzarDados (){ 
        
    int n1, n2;
        
    //Comienza a contar la duracion del juego
    long tiempoinicial = Calendar.getInstance().getTimeInMillis();
           
    
    System.out.println(" ");
    System.out.println("INICIO DE PARTIDA");
    System.out.println(" ");
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese su nombre: ");
    String nombre = sc.next(); //nombre del jugador.
    System.out.println(" ");
    
    Dado dado1 = new Dado();
    Dado dado2 = new Dado();
    
    Random rd = new Random ();
    int turno = rd.nextInt(2);   

        switch(turno){
            
            //Caso para la tirada de salida del jugador
            case 0:
                System.out.println("El jugador/a "+nombre+ " inicia la partida.");
                System.out.println(" ");
                n1 = dado1.Aleatorio();
                n2 = dado2.Aleatorio();
                dado1.imprimirDados(n1);
                dado2.imprimirDados(n2);
                int valorTotal = dado1.getValortirada() + dado2.getValortirada(); //Suma del valor de cada dado
                    if (valorTotal == 7 || valorTotal == 11){
                        System.out.println("El valor total de la tirada de salida es "+valorTotal);
                        System.out.println(" ");
                        System.out.println("¡¡ Felicidades "+nombre+", has ganado !!");
                        setGanador(nombre="jugador");
                        break;
                    }
                    else{
                    System.out.println("El valor total de la tirada de salida es: "+valorTotal);
                    turno = 1;}
                break;
            
            //Caso para la tirada de salida del computador
            case 1:
                System.out.println("El computador inicia la partida.");
                System.out.println(" ");
                n1 = dado1.Aleatorio();
                n2 = dado2.Aleatorio();
                dado1.imprimirDados(n1);
                dado2.imprimirDados(n2);
                valorTotal = dado1.getValortirada() + dado2.getValortirada();
                    if (valorTotal == 7 || valorTotal == 11){
                        System.out.println("El valor total de la tirada de salida es "+valorTotal);
                        System.out.println(" ");
                        System.out.println("¡¡ El computador ha ganado !!");
                        setGanador(nombre="computador");
                        break;
                    }
                    else {
                    System.out.println("El valor total de la tirada de salida es: "+valorTotal);
                    turno = 0;}
                    break; 
        }
    
        //Valor de la tirada inicial
        int TiradaSalida = dado1.getValortirada() + dado2.getValortirada(); //Valor de la tirada inicial.
        if(TiradaSalida != 7 && TiradaSalida!= 11){
        Scanner reader = new Scanner(System.in);
        
        //Valor del punto al iniciarse la ronda
        int punto = TiradaSalida; 
        
        
        switch (punto){
            
            case 2:
            case 3:
            case 12:
                System.out.println(" ");
                System.out.println("¡¡ La casa gana !!");
                //Ganador que sera registrado en txt
                setGanador(nombre="casa");
            break;
       
            default:    
                System.out.println(" ");
                System.out.println("Presione cualquier letra para continuar al siguiente turno:");
                char c = reader.next().charAt(0);
                System.out.println(" ");
                int ValorInicial = punto; //Auxiliar para validar caso de ganar el juego.
                
            do {
                switch(turno){
                    
                    //Turno del jugador
                    case 0:     
                        System.out.println(" ");
                        System.out.println("El jugador/a "+nombre+" escoge si lanza los dados (0) o cede su turno (1)");
                        int opcion = sc.nextInt();
                        
                        if (opcion == 0){
                        n1 = dado1.Aleatorio();
                        n2 = dado2.Aleatorio();
                        dado1.imprimirDados(n1);
                        dado2.imprimirDados(n2);
                        punto = dado1.getValortirada() + dado2.getValortirada();
                        System.out.println("El valor total de la tirada es: "+punto);
                        if(punto != TiradaSalida){
                        System.out.println(" ");
                        System.out.println("Presione cualquier letra para continuar al siguiente turno:");
                        c = reader.next().charAt(0);
                        System.out.println(" ");}
                        turno = 1;                           
                            
                        }
                        
                        //El jugador cede el turno
                        else if (opcion == 1){  
                        System.out.println(" ");
                        System.out.println("El computador lanza los dados: ");
                        n1 = dado1.Aleatorio();
                        n2 = dado2.Aleatorio();
                        dado1.imprimirDados(n1);
                        dado2.imprimirDados(n2);
                        punto = dado1.getValortirada() + dado2.getValortirada();
                        System.out.println("El valor total de la tirada es: "+punto);
                        
                        turno = 0;
                            }
                        break;
                      
                    //Turno del computador
                    case 1:          
                        
                        System.out.println("El computador lanza los dados: ");
                        n1 = dado1.Aleatorio();
                        n2 = dado2.Aleatorio();
                        dado1.imprimirDados(n1);
                        dado2.imprimirDados(n2);
                        punto = dado1.getValortirada() + dado2.getValortirada();
                        System.out.println("El valor total de la tirada es: "+punto);
                        turno = 0;
                        break;                      
                }
            }while(punto != 7 && punto != TiradaSalida); 
            
                if (punto == 7){
                   System.out.println(" ");
                   System.out.println("¡¡ La casa gana !!");
                   //Ganador (casa) que sera registrado en txt
                    setGanador(nombre="casa");
                }
                if (punto == TiradaSalida && punto != 2 && punto != 3 && punto != 12){
                    if(turno == 1){
                       System.out.println(" ");
                       System.out.println("¡¡ Felicidades "+nombre+ ", has ganado !!");
                        //Ganador (jugador) que sera registrado en txt
                       setGanador(nombre="jugador");
                    } else if (turno == 0){
                       System.out.println(" ");
                       System.out.println("¡¡ El computador ha ganado !!");
                       //Ganador (computador) que sera registrado en txt
                        setGanador(nombre="computador");
                    }
                }
            }             
          }
        
                  
        setSumatirada1(TiradaSalida);
        
        
        long tiempofinal = Calendar.getInstance().getTimeInMillis();
        //Se establece el tiempo total de duracion con el Setter
        setResultado((tiempofinal - tiempoinicial) / 1000);
        System.out.println("El tiempo de juego transcurrido es de " +getResultado()+ " segundos.");
            
        insertar();
       }
    
    
    /**
     * detxtaObjeto
     * Metodo con el que se convierte los strings
     * que lee del archivo de texto y los numeros, para
     * convertirlos en int para que puedan ser usados y
     * leidos por el programa
     */ 
    public void detxtaObjeto(){
        try {
            String linea = null;
            BufferedReader LeerFichero = new BufferedReader(new FileReader(f));
            
            while( (linea =LeerFichero.readLine()) != null){
                StringTokenizer tokens = new StringTokenizer(linea," ");
                String sumatirada1 = tokens.nextToken();
                String ganador = tokens.nextToken();
                String resultado = tokens.nextToken();
                
                // Transformo los tipos de string a su tipo de variable correspondiente
                int sumaOperar=Integer.parseInt(sumatirada1);
                long tiempoResultado=Long.parseLong(resultado);
                // Constructor que crea el objeto
                objeto = new Partida(sumaOperar, ganador, tiempoResultado);
                // Se agrega al vector para poder modificar
                cosas.add(objeto);
                
            }
            LeerFichero.close();
        } catch (Exception e) {
        }
    }
    
    /**
     * insertar
     * Metodo con el que se guardan los datos del programa
     * que se usaran en la estadistica en el archivo de texto
     */   
    public void insertar(){
        try {
            BufferedWriter Fescribe=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f,true)));
            
            Fescribe.write(getSumatirada1()+" "+getGanador()+" "+getResultado()+"\r\n");  
            System.out.println("");
            System.out.println("Se ha sido registrado correctamente la partida."); 
            
                    
            //Cierra el flujo de escritura  
            Fescribe.close();   
        } catch (Exception e) {
        }
    }
    
    /**
     * mostrarRegistro
     * Metodo con el que se establecen las condiciones para 
     * las estadisticas y se muestran por pantalla, al presionar
     * 3 en la opcion de Menu
     */   
    public void mostrarRegistro(){
        if (cosas.isEmpty()){
            detxtaObjeto();
        }
        // Variables para acumuladores
        int win1tirada=0;
        int lose1tirada=0;
        int wincpu=0;
        int winjug=0;
        int totalpartidas=0;
        long acumtiempo=0;
        
        for(Partida n:cosas){
            if(n.getSumatirada1()==7 || n.getSumatirada1()==11){
                win1tirada++;
            }else if (n.getSumatirada1()==2 || n.getSumatirada1()==3 || n.getSumatirada1()==12){
                lose1tirada++;
            }  
            if("computador".equals(n.getGanador())){
                wincpu++;
            } 
            if("jugador".equals(n.getGanador())){
                winjug++;
            }
            totalpartidas++;
            acumtiempo = acumtiempo + n.getResultado();
        }    
        
        //Tiempo promedio
        long tiempopromedio = acumtiempo / totalpartidas;
            
        if(totalpartidas>=20){
            System.out.println("");
            System.out.println("================ REGISTRO ===================");
            System.out.println("");
            
            //Juegos ganados en tirada de salida
            System.out.println("Juegos que se ganan en la tirada de salida:");
            System.out.println("- Se han ganado en el primer tiro: "+win1tirada+" de "+totalpartidas+" partidas.");
            System.out.println("  Es decir, el "+win1tirada*100/totalpartidas+"% de partidas.");
            System.out.println("");
            
            //juegos perdidos en tirada de salida
            System.out.println("Juegos que se pierden en la tirada de salida:");
            System.out.println("- Se han perdido en el primer tiro: "+lose1tirada+" de "+totalpartidas+" partidas.");
            System.out.println("  Es decir, el "+lose1tirada*100/totalpartidas+"% de partidas.");
            System.out.println("");
            
            // Estadistica de juegos ganados y perdidos de los jugadores
            System.out.println("Juegos ganados y perdidos de jugadores con sus porcentajes:");
            System.out.print("- El computador ha ganado "+wincpu+" partidas de "+totalpartidas);
            int porcentajecompu = (wincpu*100)/totalpartidas;
            System.out.println(". El "+porcentajecompu+"% de las partidas");
            System.out.print("- El jugador ha ganado "+winjug+" partidas de "+totalpartidas);
            System.out.println(". El "+(winjug*100/totalpartidas)+"% de las partidas");
            
            // Promedios y duracion de partida.
            System.out.println("");
            System.out.println("Posibildades de ganar en el primer turno: ");
            System.out.println("- Se tiene un "+win1tirada*100/totalpartidas+"% de ganar.");
            System.out.println("");
            System.out.println("Promedio de duracion del juego por turno: ");
            System.out.println("- Se tiene un promedio de "+tiempopromedio+" segundos de duracion por partida.");
            System.out.println("");
            System.out.println("Mejoran las oportunidades de ganar con la duracion del juego?");
            System.out.println("No, la duracion del juego no influye en las oportunidades de ganar. ");
            System.out.println("");
        
        } else {
            System.out.print("No se han registrado suficientes part");
            System.out.println("idas para mostrar las estadisticas.");
        }
    }
    
}
                
    

    
    
    
    
