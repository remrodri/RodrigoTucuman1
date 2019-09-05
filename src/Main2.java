import java.io.File;

public class Main2 {
    public static void main(String[] args) {
        File file = new File("D:un1/lugar/escondido");
        FileProcesor fp = new FileProcesor(file);
        fp.procesarRuta();
    }
}
