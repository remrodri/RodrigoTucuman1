import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Apply implements Command {
    private File dir;
    Apply(String path){
        dir = new File(path);
    }
    void applyJavac() {
        System.out.println(dir.isDirectory());
        try (Stream<Path> walk = Files.walk(Paths.get(dir.getPath()))) {
            List<String> result = walk.filter(Files::isRegularFile).map(Path::toString).collect(Collectors.toList());
            for (String s : result){
                if (s.endsWith(".java")){
                    compilar(s);
                }}

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void compilar(String linea){

        ProcessBuilder pb = new ProcessBuilder("javac",linea);
        try {
            pb.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }




    }


    }
