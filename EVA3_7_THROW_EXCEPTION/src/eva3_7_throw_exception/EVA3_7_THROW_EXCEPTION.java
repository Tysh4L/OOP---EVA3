package eva3_7_throw_exception;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EVA3_7_THROW_EXCEPTION {

    public static void main(String[] args) {
        // TODO code application logic here
        Prueba obj = new Prueba();
        try {
            //checked: es forzoso detenerlas
            //unchecked: errores de logica, no forzoso resolverlas
            //int resu = 5 / 0;
            obj.capturarMayorCero(100);
            System.out.println("Introduce un valor");
            Scanner input = new Scanner(System.in);
            int valor = input.nextInt();
        } catch (Exception ex) {
            //NO ES BUENO USAR EXCEPTION, YA QUE ES
            //LA SUPER CLASE DE LAS EXCEPCIONES. VA
            //A CAPTURAR CUALQUIER EXCEPCION
            System.out.println(ex.getMessage());
        }
        //ARITHMETIC EXCEPTION ES "UNCHECKED" Y NO ES OBLIGATORIO 
        //CAPTURAR LA EXCEPCION
        try{
        obj.division(100, 0);
        }catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }
    }
    
}

class Prueba{
    //EXCEPTION ES CHECKED EXCEPTION, ESTAMOS OBLIGADOS A ATENDER 
    public void capturarMayorCero(int valor) throws Exception{
        if (valor <= 0) //VOY A GENERAR UNA EXCEPCION
                throw new Exception(valor + "es negativo, solo se aceptan valores positivos");
            System.out.println("El valor es: " + valor);
    }
    public int division(int x, int y) throws ArithmeticException{
        if (y == 0) 
            throw new ArithmeticException("El valor del divisior es cero, y es invalido");
        return x / y;
    }
}