import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Bob {
    public static void main(String[] arg) throws IOException {
        File miDir =new File(".");
        String rutai = miDir.getCanonicalPath();
        String rutai2 = rutai+"\\bob.conf";
        //System.out.println(rutai2);
        FileReader lectorDeArchivo =null;
        try {
            //System.out.println(rutai);
            File archivo = new File(rutai2);
            if(archivo.exists()){
               // System.out.println("existe bob.conf!!!");
                lectorDeArchivo = new FileReader(archivo);
                BufferedReader lectorDeBuffer = new BufferedReader(lectorDeArchivo);
                String linea = lectorDeBuffer.readLine();
                String linea2 = lectorDeBuffer.readLine();
                System.out.println(linea2);
                ArrayList<String> contenidoDeBob = new ArrayList<>();
                while (linea2 != null) {
                    contenidoDeBob.add(linea2);
                    System.out.println(linea2);
                    linea2=lectorDeBuffer.readLine();
                }
                for (String aux :
                        contenidoDeBob) {
                    System.out.println(aux);
                }
                //System.out.println(archivo.getCanonicalPath());
                //System.out.println(archivo.getCanonicalPath().replace(" ",""));
                String[] arrayDeSubCadenas = linea.split("=");
                String subCadenaARevisar = arrayDeSubCadenas[0];
                for (String subCadena : arrayDeSubCadenas
                ) {
                    System.out.println(subCadena);
                }
                //System.out.println(subCadenaARevisar);
                if ("home dir".equals(subCadenaARevisar)){
                    //System.out.println("es igual a home dir");
                    String cadenaRuta = arrayDeSubCadenas[arrayDeSubCadenas.length-1];
                    //System.out.println(cadenaRuta);
                    File ruta = new File("un\\lugar\\escondido");
                    //System.out.println(ruta.isDirectory());
                    System.out.println(System.getProperty("os.name"));
                }
                else {
                    System.out.println("no es igual a homeDir =(");
                }
            } else {
                System.out.println("no existe bob.conf!!!");
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(null !=lectorDeArchivo){
                    lectorDeArchivo.close();
                }
            }
            catch (Exception e2){
                e2.printStackTrace();
            }

        }
        //String[] arrayDeRuta = rutai.split("\\\\");
        //for (String subCadena : arrayDeRuta
        //) {
        //    System.out.println(subCadena);
        //}
        //String fragmento=arrayDeRuta[0];
        //for (int i = 1; i < arrayDeRuta.length; i++) {
        //    fragmento = fragmento + "\\\\" + arrayDeRuta[i];
        //}
        //String nuevaRuta = "\""+ fragmento +"\\\\bob.conf"+"\"";
        //System.out.println(nuevaRuta);

        //try {

        // }
        //  catch (Exception e){
        //     e.printStackTrace();
        // }
    }



}

