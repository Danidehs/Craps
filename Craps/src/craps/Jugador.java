/**
 * Jugador
 * Clase que contiene la tirada del jugador, el constructor
 * por defecto y los Getter and Setter de la tirada de salida.
 * @author Grupo 5
 * @version 1.0 , 18/02/2016
 * */

package craps;

public class Jugador {
    
    private int TiradaSalida;

    
    public Jugador (int tirada){
        TiradaSalida = tirada;
    }
    
    public int getTiradaSalida() {
        return TiradaSalida;
    }

    public void setTiradaSalida(int TiradaSalida) {
        this.TiradaSalida = TiradaSalida;
    }
    
    public Jugador(){}
    
              
}
