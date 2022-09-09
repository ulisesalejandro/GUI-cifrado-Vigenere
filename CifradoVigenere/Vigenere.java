public class Vigenere {

    public static String cifrar(String textoPlano) {
        // Separamos cada palabra del texto
        String[] frases = textoPlano.trim().split(" ");
        String cifrado = "";
        int ascciValAux;

        // Iteraremos cada frase
        for (int i = 0; i < frases.length; i++) {
            String aux_1 = "";
            String aux_2 = "";
            String aux_3 = "";

            // Iteramos cada letra de la palabra
            // Y si es asi le aumetamos 3 ascci a la derecha
            for (int j = 0; j < frases[i].length(); j++) {
                ascciValAux = (int) frases[i].charAt(j);

                //Verificar si es letra mayuscula o minuscula
                if ((ascciValAux >= 65 && ascciValAux <= 90)
                        || (ascciValAux >= 97 && ascciValAux <= 122)) {
                    aux_1 += (char) ((int) frases[i].charAt(j) + 3);
                } else {
                    aux_1 += frases[i].charAt(j);
                }
            }

            // Despues a la mitad de la frase se le desplaza
            // una posicion ascci a al izquierda
            aux_1 = truncado(aux_1);
            aux_2 = aux_1.substring((int) aux_1.length() / 2);

            for (int k = 0; k < aux_2.length(); k++) {
                aux_3 += (char) ((int) aux_2.charAt(k) - 1);
            }

            // Calcular texto cifrado
            cifrado += aux_1.substring(0, (int) aux_1.length() / 2);
            cifrado += aux_3 + " ";
        }// Cada frase

        //System.out.println(cifrado);
        return cifrado;
    }
    
    // Haremos el proceso inverso para decifrar
    public static String decifrar(String textoCifrado) {
        // Separamos cada palabra del texto
        String[] frases = textoCifrado.trim().split(" ");
        String decifrado = "";
        int ascciValAux;

        // Iteraremos cada frase
        for (int i = 0; i < frases.length; i++) {
            String aux_1 = "";
            String aux_2 = "";
            String aux_3 = "";
            
            aux_1 = frases[i].substring((int) frases[i].length() / 2);
            
            for (int k = 0; k < aux_1.length(); k++) {
                aux_2 += (char) ((int) aux_1.charAt(k) + 1);
            }
            
            aux_3 += frases[i].substring(0, (int) frases[i].length() / 2);
            aux_3 += aux_2;
            
            aux_3 = truncado(aux_3);

            for (int j = 0; j < aux_3.length(); j++) {
                ascciValAux = (int) aux_3.charAt(j);
                
                if ((ascciValAux >= 68 && ascciValAux <= 93)
                        || (ascciValAux >= 97 && ascciValAux <= 125)) {
                    decifrado += (char) ((int) aux_3.charAt(j) - 3);
                } else {
                    decifrado += aux_3.charAt(j);
                }
            }

            decifrado += " ";
        }// Cada frase

        //System.out.println(decifrado);
        return decifrado;
    }

    // Invertir String
    public static String truncado(String cadena) {
        String cadenaInvertida = "";
        for (int x = cadena.length() - 1; x >= 0; x--) {
            cadenaInvertida = cadenaInvertida + cadena.charAt(x);
        }
        return cadenaInvertida;
    }
}
