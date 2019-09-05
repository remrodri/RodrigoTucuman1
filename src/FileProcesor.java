import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class FileProcesor {
    private File ruta;
    private Dir myDir;
    private Tool tool;
    private String volume;

    FileProcesor(File file) {
        ruta = new File(file,"bob.conf");
    }

    void procesarRuta(){
        if (!ruta.exists()){
            System.out.println("no existe esa ruta, se establecera el directorio actual como ruta por defecto");
            ruta = new File(".");
            System.out.println(ruta);
        }else{
            try {
                Scanner scannerContent = new Scanner(ruta);
                String line;
                while (scannerContent.hasNextLine()){
                    line = scannerContent.nextLine();
                    if(!line.equals("")){
                        procesarContenido(line);
                    }
                }
            }
            catch (FileNotFoundException e){
                System.out.println("Error");
                e.printStackTrace();
            }
        }
    }

    private void procesarContenido(String line) {
            String[] fragmentedLine=line.split(" ");
                switch (fragmentedLine[0]){
                    case  "volume":
                        if (estoyEnWindows()) {
                            volume = fragmentedLine[1];
                            System.out.println(volume);
                        }
                        break;
                    case "dir": fragmentedLine = fragmentedLine[1].split("=");
                        if (estoyEnWindows()) {
                            myDir = new Dir(volume,fragmentedLine[0], fragmentedLine[1]);
                        }else {
                            myDir = new Dir(fragmentedLine[0], fragmentedLine[1]);
                        }
                    break;
                    case "print": Print p=new Print(myDir);
                        if(fragmentedLine[1].equals(myDir.getName())){
                                    p.printPath();
                                    }else{if (fragmentedLine[1].equals(myDir.getName()+".files")){
                                            p.printFiles();
                                            }else{if (fragmentedLine[1].equals(myDir.getName()+".dirs")){
                                                    p.printDirs();
                                            }
                                    }
                    }
                    break;
                    case "tool": tool=new Tool(fragmentedLine[1],fragmentedLine[2],fragmentedLine[3],fragmentedLine[4]);
                    break;
                    case "apply": if(tool.getTipo().equals("compilador")){

                    if (tool.getNombre().equals("\"javac\"")){
                    if (tool.getTipoNombre1().equals("java")){
                    if (tool.getTipoNombre2().equals("class")){
                        if(fragmentedLine[2].equals(myDir.getName()+".files")){
                            if (estoyEnWindows()){
                                Apply a = new Apply(myDir.getPathWindows());
                                a.applyJavac();
                            }
                                //a.applyJavac();

                        }
                    }
                    }
                    }
                    }
                    break;
                    }
        }
    private boolean estoyEnWindows(){
        return File.separatorChar == '\\';
    }
}
