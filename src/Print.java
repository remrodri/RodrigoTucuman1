import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Print implements Command
{
    private File dir;
    Print(Dir dir){

        this.dir=new File("D:"+dir.getPath().replace("\"","").replace("/","\\"));
    }
    void printPath(){
        System.out.println(dir.getPath());
    }

    void printFiles(){
        try (Stream<Path> walk = Files.walk(Paths.get(dir.getPath()))) {
            List<String> result = walk.filter(Files::isDirectory)
                    .map(Path::toString).collect(Collectors.toList());
            result.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void printDirs(){

        try (Stream<Path> walk = Files.walk(Paths.get(dir.getPath()))) {
            List<String> result = walk.filter(Files::isRegularFile).map(Path::toString).collect(Collectors.toList());
            result.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
