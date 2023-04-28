package eva3_4_multiples_excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EVA3_4_MULTIPLES_EXCEPCIONES {

    public static void main(String[] args) {
        // TODO code application logic here
        int x, y;
        do{
            try{
                Scanner input = new Scanner(System.in);
                System.out.println("Introduce el valor (entero) de x:");
                x = input.nextInt();
                System.out.println("Introduce el valor (intero) de y:");
                y = input.nextInt();
                int resu = x / y;
                System.out.println("La division de " + x + "/" + y + " es: " + resu);
                break;
            }catch(InputMismatchException e){
                System.out.println("La captura es incorrecta: " + e.getMessage());
                System.out.println("Vuelva a capturar");
            }catch(ArithmeticException e){
                System.out.println("No se puede dividir entre 0: " + e.getMessage());
                System.out.println("Vuelva a capturar");
            }
        }while(true);
            System.out.println("Valor de x = " + x);
        
      
            System.out.println("PROGRAMA TERMINADO CON EXITO");
    }
    
}
