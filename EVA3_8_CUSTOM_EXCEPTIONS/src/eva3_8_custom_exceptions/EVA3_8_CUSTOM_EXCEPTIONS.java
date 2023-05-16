
package eva3_8_custom_exceptions;

public class EVA3_8_CUSTOM_EXCEPTIONS {

    public static void main(String[] args) {
        // TODO code application logic here
        Persona perso = new Persona();
        perso.setNombre("Danna");
        perso.setApellido("Lopez");
        try{
            perso.setEdad(-10);
        }catch(DatoEntradaCheckedEx e){
            System.out.println(e.getMessage());
        
        }
    }
    
}

class Persona{
    private String nombre;
    private String apellido;
    private int edad;

    public Persona() {
        this.nombre = "--";
        this.apellido = "--";
        setEdad(edad);
    }

    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad < 0) 
            //throw new DatoEntradaException(); //UNCHECKED
            throw new DatoEntradaCheckedEx();
        this.edad = edad;
    }
}

class DatoEntradaException extends RuntimeException{

    public DatoEntradaException() {
        super("Dato de entrada incorrecto. El valor debe ser positivo.");
    }


}

class DatoEntradaCheckedEx extends Exception{

    public DatoEntradaCheckedEx() {
        super("Dato de entrada incorrecto. El valor debe ser positivo.");
    }

    

}
