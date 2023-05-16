package eva3_9_leer_archivos_txt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danna
 */
public class EVA3_9_LEER_ARCHIVOS_TXT {

    final static String RUTA = "C:\\Archivos\\Prueba.txt";

    public static void main(String[] args) {
        try {
            // Lee archivos por completo, es ineficiente para archivos pesados
            readUsingFiles(RUTA);
            
            // Opcion ideal para leer archivos de texto
            readingUsingBufferedReader(RUTA);
            
            //  Es un hibrido con buffered, es util para abrir archivos los cuales no sean de texto
            readingUsingFileReader(RUTA);
            
            // Herramientas para procesar inputs que vienen del teclado
            readUsingScanner(RUTA);
        } catch (IOException ex) {
            ex.printStackTrace(); //Imprime todo el error
        }

    }

    /*
    FILES: Se lee todo el contenido del archivo y se
    transfiere a memoria principal (RAM)
    Util con archivos pequenos.
     */
    public static void readUsingFiles(String ruta) throws IOException {
        //CONSTRUIMOS LA RUTA EN BASE A LA CADENA DE TEXTO
        Path path = Paths.get(RUTA);
        /*List<String> todasLineas = Files.readAllLines(path);
        System.out.println("Resultado: ");
        //System.out.println(todasLineas.toString());
        for (int i = 0; i < todasLineas.size(); i++) {
            System.out.println(todasLineas.get(i));
        }*/
        byte[ ] bytes = Files.readAllBytes(path);
        System.out.println(new String(bytes));

    }

    /*readingUsingBufferedReader: Lee el archivo línea por línea
 Es usado en archivos grandes para no necesitar abrir todo el archivo. Los procesa por partes.
 Nos permite leerlo línea por línea.
 Mecanismo ideal para trabajar con multitarea (hilos) (a diferencia de Files)
     */
    public static void readingUsingBufferedReader(String ruta) throws IOException {
        System.out.println("Leer un archivo con buffered render: ");

        //Líneas obligatorias para el BufferedReader
        File file = new File(ruta); // Abre archivos
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        // Memoria temporal del buffer
        BufferedReader bufReader = new BufferedReader(inputStreamReader);
        String linea;
        while ((linea = bufReader.readLine()) != null) {
            System.out.println(linea);
        }
        bufReader.close(); // Al usar BufferedReader, hay que cerrarlo
    }

// readingUsingFileReader: No es recomendable para leer archivos de texto
    public static void readingUsingFileReader(String ruta) throws IOException {
        System.out.println("\n"+"Leer archivo usando file reader: ");
        File file = new File(ruta);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufReader = new BufferedReader(fileReader);
        String linea;
        while ((linea = bufReader.readLine()) != null) {
            System.out.println(linea);
        }
        bufReader.close();
        fileReader.close(); // Tambien tenemos que cerrarlo
    }

// readUsingScanner: Lee un archivo utilizando Scanner
    public static void readUsingScanner(String ruta) throws IOException {
        System.out.println("\n"+"Leer un archivo usando scanner: ");
        Path path = Paths.get(ruta);
        Scanner sc = new Scanner(path);
        while (sc.hasNextLine()) {
            String linea = sc.nextLine();
            System.out.println(linea);
        }
        sc.close(); // Es necesario cerrarlo para no bloquearlo
        //siempre al abrir un archivo hay que cerrarlo
    }

}
