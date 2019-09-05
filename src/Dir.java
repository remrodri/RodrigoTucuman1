import java.io.File;

class Dir implements Command{
    private String volume;
    private String name;
    private String path;

    Dir(String name, String path){
        this.name=name;
        this.path=path;
    }

    Dir(String volume,String name,String path){
        this.volume=volume;
        this.name=name;
        this.path=path;
    }

    String getPathWindows(){
        if (File.separatorChar == '\\'){
            return volume.replace("\"","")+":"+path.replace("\"","").replace("/","\\");
        }else {
            return path.replace("\"","");
        }

    }
    String getName() {
        return name;
    }
    String getPath() {
        return path;
    }
}
