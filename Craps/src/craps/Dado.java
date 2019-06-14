/**
 * Dado
 * Clase que contiene el aleatorio y la
 * impresión de los dados
 * @author Grupo 5
 * @version 1.0 , 18/02/2016
 * */

package craps;
import java.util.Random;

public class Dado {
    
    private int Valortirada;

    public int getValortirada() {
        return Valortirada;
    }

    public void setValortirada(int Valortirada) {
        this.Valortirada = Valortirada;
    }

    /**
     * Aleatorio
     * Se utiliza para obtener los numeros de los
     * dados aleatoriamente 
     */ 
    public int Aleatorio()
    {
        
        Random rGenerador = new Random();
        
        Valortirada = rGenerador.nextInt(6)+1;
        
        return Valortirada;
        
    }
    
    /**
     * imprimirDados
     * Se utiliza para mostrar por pantalla los dados
     * obtenidos aleatoriamente 
     * @param n 
     */ 
    public void imprimirDados (int n){
        switch (n){
            case 1:
        System.out.println(" ___");
        System.out.println("|   |");
        System.out.println("| ° |");
        System.out.println(" ---");  
        break;    
        
        case 2:
        System.out.println(" ___");
        System.out.println("|°  |");
        System.out.println("|   |");
        System.out.println(" --°");
        break;
        
        case 3:
        System.out.println(" ___");
        System.out.println("|°  |");
        System.out.println("| ° |");
        System.out.println(" --°");
        break;
        
        case 4:
        System.out.println(" ___");
        System.out.println("|° °|");
        System.out.println("|   |");
        System.out.println(" °-°");
        break;
        
        case 5:
        System.out.println(" ___");
        System.out.println("|° °|");
        System.out.println("| ° |");
        System.out.println(" °-° ");
        break;
        
        case 6:
        System.out.println(" ___");
        System.out.println("|° °|");
        System.out.println("|° °|");
        System.out.println(" °-°");
        break;
        
        }
    }
}