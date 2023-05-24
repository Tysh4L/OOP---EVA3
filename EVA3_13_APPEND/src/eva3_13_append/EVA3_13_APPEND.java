package eva3_13_append;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EVA3_13_APPEND {

    public static void main(String[] args) {
        String ruta = "C:\\Users\\danna\\OneDrive\\Documentos\\Archivos";

        try {
            //writeUsingFiles(ruta+"archivoFiles.txt" ,"Prueba de escritura de Files \n");
            //FilesWriter
            //writeUsingFileWriter(ruta+"archivoFileWriter.txt", "Prueba de fileWriter\n");

            writeUsingBufferedWriter(ruta + "archivoBufWriter.txt", "PruebaBufferedWriter" + " txt.example");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void writeUsingBufferedWriter(String ruta, String datos) throws IOException {
        File file = new File(ruta);
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufWriter = new BufferedWriter(fileWriter);

        for (int i = 0; i < 10; i++) {
            System.out.println("\n hola");
            bufWriter.write((i + 1) + " " + datos);
            bufWriter.write("\n holaaa");
        }
        bufWriter.close();
        fileWriter.close();
    }
}
