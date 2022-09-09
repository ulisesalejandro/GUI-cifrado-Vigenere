import javax.swing.JOptionPane;

public class Controller {

    public String openFileTextPlain() {
        return new Archivo().importar("Texto plano", "txt");
    }
    
    public String openFileCifrado(){
        return new Archivo().importar("Cifrado vigenere", "vge");
    }

    public String cifrarTexto(String textoPlano) {
        return Vigenere.cifrar(textoPlano);
    }

    public String decifrarTexto(String textoCifrado) {
        return Vigenere.decifrar(textoCifrado);
    }

    public void guardarPlano(String textoPlano) {

        int r = new Archivo().guardar("Texto Plano", "txt", textoPlano);
        if (r == 1) {
            JOptionPane.showMessageDialog(null, "Ya existe un archivo con ese nombre",
                    "Archivo ya existe", JOptionPane.ERROR_MESSAGE);
        }else if(r == 0){
            JOptionPane.showMessageDialog(null, "Archivo guardado con exito",
                    "Archivo guardado", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void guardarEncriptado(String textoCidrado) {
        int r = 0;
        r = new Archivo().guardar("cifrado", "vge", textoCidrado);
        if (r == 1) {
            JOptionPane.showMessageDialog(null, "Ya existe un archivo con ese nombre",
                    "Archivo ya existe", JOptionPane.ERROR_MESSAGE);
        }else if(r == 0){
            JOptionPane.showMessageDialog(null, "Archivo guardado con exito",
                    "Archivo guardado", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
