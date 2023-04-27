package eva3_2_.exception_propagation;

public class EVA3_2_EXCEPTION_PROPAGATION {

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("INICIA MAIN");
        A();
        System.out.println("TERMINA MAIN");
    }
    
        public static void A(){
            System.out.println("INICIA A");
            B();
            System.out.println("TERMINA A");
        
        }
        
        public static void B(){
            System.out.println("INICIA B");
            C();
            System.out.println("TERMINA B");
        
        }
        
         public static void C(){
            System.out.println("INICIA C");
            int x = 5, y = 0;
            int resu = x/y;
            System.out.println("RESULTADO = " + resu);
            System.out.println("TERMINA C");
        
        }
    }
    