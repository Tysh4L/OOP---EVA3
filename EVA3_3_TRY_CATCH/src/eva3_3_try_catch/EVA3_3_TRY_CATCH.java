package eva3_3_try_catch;

public class EVA3_3_TRY_CATCH {

    public static void main(String[] args) {
        // TODO code application logic here
        int x = 5, y = 0;
        try{
            int resu = x/y;
            System.out.println("El resultado es = " + resu);
        }catch(ArithmeticException e){
            System.out.println("Excepcion: " + e.getMessage());
        }
        System.out.println("Fin del programa");
    }
}
