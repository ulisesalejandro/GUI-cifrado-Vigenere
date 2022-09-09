import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Archivo {

    public String leer(File file) throws FileNotFoundException, IOException {
        BufferedReader obj = new BufferedReader(new FileReader(file));

        String strng;
        String salida = " ";
        while ((strng = obj.readLine()) != null) {
            salida += strng;
            System.out.println(strng);
        }

        obj.close();
        return salida.trim();
    }

    public String importar(String categoria, String extension) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        FileNameExtensionFilter imgFilter = new FileNameExtensionFilter(categoria, extension);
        fileChooser.setFileFilter(imgFilter);

        int result = fileChooser.showOpenDialog(null);

        if (result != JFileChooser.CANCEL_OPTION) {

            File fileName = fileChooser.getSelectedFile();

            if ((fileName == null) || (fileName.getName().equals(""))) {
                System.out.println("Error");
                return null;
            } else {
                try {
                    return this.leer(fileName);
                } catch (IOException ex) {
                    //Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }
    
    public int guardar(String categoria, String extension, String contenido){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        FileNameExtensionFilter imgFilter = new FileNameExtensionFilter(categoria, extension);
        fileChooser.setFileFilter(imgFilter);

        int result = fileChooser.showSaveDialog(null);

        if (result != JFileChooser.CANCEL_OPTION) {

            File fileName = fileChooser.getSelectedFile();

            if ((fileName == null) || (fileName.getName().equals(""))) {
                System.out.println("Error");
                return 2;
            } else {
                return escribir(fileName, contenido);
            }
        }
        return 2;
    }

    public static int escribir(File file, String contenido) {
        try {
            // Si el archivo existe regresa un 1
            if (file.exists()) {
                return 1;
            }

            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
            return 2;
        }
        return 0;
    }

}
