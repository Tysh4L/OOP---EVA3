package eva3_1_unchecked_exceptions;

import java.util.Scanner;

public class EVA3_1_UNCHECKED_EXCEPTIONS {

    public static void main(String[] args) {
        // TODO code application logic here
        //SON TODAS DE RUNTIMEEXCEPTION
        //ARITHMETIC EXCEPTION:
        //division entre cero
        System.out.println("INICIANDO EL PORGRAMA");
        int x = 5, y = 0;
        System.out.println("INICIALIZANDO LAS VARIABLES");
        int resu = x / y;
        System.out.println("CALCULANDO");
        System.out.println("Division = " + resu);
        
        //InputMismatchException; Error de captura de datos
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce un numero");
        int nume = input.nextInt();
        System.out.println("Tu numero es: " + nume);
        
        
        //INDEXOUTOFBOUNDS EXCEPTION
        int[] arreglo = new int[5];//0 - (N-1)
        arreglo[0] = 100;
        arreglo[1] = 200;
        arreglo[2] = 300;
        arreglo[3] = 400;
        arreglo[4] = 500;
        arreglo[5] = 600;//error de logica: 5 no es una posicion valida
        
        //NULLPOINTER EXCEPTION
        Prueba objPrueba = null;
        System.out.println("Valor de x = " + objPrueba.x);

        
    }
    
}

class Prueba{
    public int x = 100;
}