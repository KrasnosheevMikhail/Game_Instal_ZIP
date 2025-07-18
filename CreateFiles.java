import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class  CreateFiles {


    private String path;
    private StringBuilder logString = new StringBuilder();

    public CreateFiles(String path) {
        this.path = path;
    }
    public void setPath(String path) {
        this.path = path;
    }

    public void createFile(String name) {
        File file = new File(path + "/" + name);
        try {
            if (file.createNewFile()) {
                logString.append (" File created: " + name + "\n");
            } else logString.append (" File is not created: " + name + "\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
    public void createDir() {
        File dir = new File(path);
        if (dir.mkdir()) {
            logString.append (" Folder created: " + path + "\n");
        } else {
            logString.append (" Folder is not created: " + path + "\n");
        }

    }

    public void logWriter() {
        path = "D:/Games/temp/temp.txt";
        try (FileWriter lw = new FileWriter(path)) {
            lw.write(logString.toString());
            System.out.println(" Информация о создании файлов: " + path);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
