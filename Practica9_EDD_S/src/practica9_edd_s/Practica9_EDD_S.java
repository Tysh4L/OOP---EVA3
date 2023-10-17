package practica9_edd_s;

/**
 * Agenda telefónica con aplicación de método de ordenación y busqueda
 *
 * @author Danna Lopez
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Practica9_EDD_S {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        ArrayList<Contacto> agenda = new ArrayList<>();

        int opcion;
        do {
            System.out.println("\nMENU - AGENDA TELEFÓNICA");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Editar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Mostrar contactos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    agregarContacto(agenda, sc);
                    break;
                case 2:
                    buscarContacto(agenda, sc);
                    break;
                case 3:
                    editarContacto(agenda, sc);
                    break;
                case 4:
                    eliminarContacto(agenda, sc);
                    break;
                case 5:
                    mostrarContactos(agenda);
                    break;
                case 6:
                    System.out.println("Saliendo de la agenda telefónica.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (opcion != 6);

    }

    public static void agregarContacto(ArrayList<Contacto> agenda, Scanner sc) {
        System.out.print("Nombre del contacto: ");
        String nombre = sc.nextLine();

        //verificar si ya existe un contacto con el mismo nombre
        boolean nombreRepetido = false;
        for (Contacto contacto : agenda) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                nombreRepetido = true;
                break;
            }
        }
        
        if (nombreRepetido) {
            System.out.println("Ya existe un contacto con el mismo nombre. No se pudo agregar el contacto.");
        } else {
            System.out.print("Teléfono del contacto: ");
            String telefono = sc.nextLine();

            Contacto contacto = new Contacto(nombre, telefono);

            if (agenda.size() < 100) { //tamaño de la agenda
                agenda.add(contacto);
                System.out.println("Contacto agregado con éxito.");
            } else {
                System.out.println("La agenda llena. No se pudo agregar el contacto.");
            }
        }
    }

    public static void buscarContacto(ArrayList<Contacto> agenda, Scanner sc) {
        System.out.print("Buscar por nombre o teléfono: ");
        String consulta = sc.nextLine();

        boolean encontrado = false;

        //se ordenan los contactos antes de buscarse ya que se utiliza busqueda
        //binaria y deben estar ordenados, en este caso por el método quicksort
        quicksort(agenda, 0, agenda.size() - 1);

        int resultado = busquedaBinaria(agenda, consulta);
        if (resultado != -1) {
            System.out.println("Contacto encontrado:");
            System.out.println(agenda.get(resultado));
            encontrado = true;
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún contacto con ese nombre o teléfono.");
        }
    }

    public static int busquedaBinaria(ArrayList<Contacto> agenda, String consulta) {
        int izquierda = 0;
        int derecha = agenda.size() - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            int comparacion = agenda.get(medio).getNombre().compareToIgnoreCase(consulta);

            if (comparacion == 0) {
                return medio; //contacto encontrado
            } else if (comparacion < 0) {
                izquierda = medio + 1; //buscar en la mitad derecha
            } else {
                derecha = medio - 1; //buscar en la mitad izquierda
            }
        }

        return -1; //contacto no encontrado
    }

    public static void editarContacto(ArrayList<Contacto> agenda, Scanner sc) {
        System.out.print("Nombre del contacto a editar: ");
        String nombre = sc.nextLine();

        boolean encontrado = false;

        for (Contacto contacto : agenda) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Contacto encontrado:");
                System.out.println(contacto);

                System.out.print("Nuevo nombre (dejar en blanco para mantener el nombre actual): ");
                String nuevoNombre = sc.nextLine();
                if (!nuevoNombre.isEmpty()) {
                    contacto.setNombre(nuevoNombre);
                }

                System.out.print("Nuevo teléfono (dejar en blanco para mantener el teléfono actual): ");
                String nuevoTelefono = sc.nextLine();
                if (!nuevoTelefono.isEmpty()) {
                    contacto.setTelefono(nuevoTelefono);
                }

                System.out.println("Contacto actualizado con éxito.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún contacto con ese nombre.");
        }
    }

    public static void eliminarContacto(ArrayList<Contacto> agenda, Scanner sc) {
        System.out.print("Nombre del contacto a eliminar: ");
        String nombre = sc.nextLine();

        boolean eliminado = false;

        for (int i = 0; i < agenda.size(); i++) {
            if (agenda.get(i).getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Contacto encontrado y eliminado:");
                System.out.println(agenda.remove(i));
                eliminado = true;
                break; // Solo eliminamos el primer contacto encontrado
            }
        }

        if (!eliminado) {
            System.out.println("No se encontró ningún contacto con ese nombre.");
        } else {
            System.out.println("Contacto eliminado con éxito.");
        }
    }

    public static void mostrarContactos(ArrayList<Contacto> agenda) {
        if (agenda.isEmpty()) {
            System.out.println("La agenda está vacía.");
        } else {
            // Ordenar los contactos antes de mostrarlos
            quicksort(agenda, 0, agenda.size() - 1);

            System.out.println("\nLISTA DE CONTACTOS:");
            for (Contacto contacto : agenda) {
                System.out.println(contacto);
            }
        }
    }

    public static void quicksort(ArrayList<Contacto> agenda, int inicio, int fin) {
        if (inicio < fin) {
            int pivote = particion(agenda, inicio, fin);
            quicksort(agenda, inicio, pivote - 1);
            quicksort(agenda, pivote + 1, fin);
        }
    }

    private static int particion(ArrayList<Contacto> agenda, int inicio, int fin) {
        Contacto pivote = agenda.get(fin);
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (agenda.get(j).getNombre().compareToIgnoreCase(pivote.getNombre()) <= 0) {
                i++;
                Contacto temp = agenda.get(i);
                agenda.set(i, agenda.get(j));
                agenda.set(j, temp);
            }
        }

        Contacto temp = agenda.get(i + 1);
        agenda.set(i + 1, agenda.get(fin));
        agenda.set(fin, temp);

        return i + 1;
    }
}

class Contacto {

    private String nombre;
    private String telefono;

    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Teléfono: " + telefono;
    }
}
    

