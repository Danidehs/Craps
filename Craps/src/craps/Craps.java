/**
 * Craps
 * Clase que contiene el menu, el metodo para mostrarlo
 * y el main del proyecto
 * @author Grupo 5
 * @version 1.0 , 18/02/2016
 * */
 
package craps;

import java.io.FileNotFoundException;
import java.util.Scanner;


public class Craps {

     /**
     * mostrarMenu
     * Metodo para mostrar el menu por pantalla y switch que permite
     * elegir que opcion escoger(Reglas, Jugar, Estadisticas o Salir)
     * @throws FileNotFoundException 
     */
    public void mostrarMenu() throws FileNotFoundException //Mostrar del menu inicial.
    {
        Scanner sc = new Scanner(System.in);
        int resp;
        System.out.println(" ");
        System.out.println(" Menu inicial:");
        System.out.println("(1)Reglas (2)Jugar (3)Registro de Partidas (4)Salir");
        resp = sc.nextInt();
        
        Partida p = new Partida();
        
    switch(resp){
    
    case 1:
                System.out.println(" =================== REGLAS =============");
            System.out.println(" El juego consiste en lanzar dos dados y la suma de las caras superiores determinara");
            System.out.println(" si el jugador gana, pierde o continua el juego hasta volver a salir dicho numero inicial.");
            System.out.println(" ");
            System.out.println(" La suma de la primera lanzada determinara:");
            System.out.println(" ");
            System.out.println(" - Si es igual a 2,3 o 12 (Craps) entonces el jugador pierde, la casa gana y finaliza el juego.");
            System.out.println(" ");
            System.out.println(" - Si es igual a 7 u 11 (Natural) entonces el jugador gana y finaliza el juego.");
            System.out.println(" ");
            System.out.println(" - Si es igual a 4,5,6,8,9 o 10; entonces eso se convierte en 'punto', termina esa tirada y pasa");
            System.out.println("   a la siguiente etapa del juego que se denomina 'Ronda'. Para que el jugador gane debe volver a");
            System.out.println("   obtener el mismo puntaje. Si sale 7 pierde, la casa gana y finaliza el juego.");
            mostrarMenu();
            break;
            
    case 2: //inicio de la partida.
            p.LanzarDados();
            break;
        
    case 3: //registro de partidas
            p.mostrarRegistro();
            mostrarMenu();
        break;
        
    case 4:
        break;
        
    default: 
        System.out.println("Has colocado un numero NO valido.");
        System.out.println("");
        mostrarMenu();
        break;    
        }
    
    }

    //Main
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(" Bienvenido al juego de azar, Craps!");
        Craps partida1 = new Craps();
        partida1.mostrarMenu();
        
        Partida hilonuevo = new Partida();
        hilonuevo.start();
        
        }
    }

