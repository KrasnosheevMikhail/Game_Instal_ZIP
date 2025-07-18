import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress {" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }

    public void createFile(String path,String name) {
        File file = new File(path + "/" + name);
        try {
            file.createNewFile();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void saveGame(String path, String name) {
        try (FileOutputStream fos = new FileOutputStream(path + "/" + name);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void zipGame(String path, String[] filesName, String zipName) throws IOException {

        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(path + "/" + zipName + ".zip"))) {
            for (String file : filesName) {
                File f = new File(path + "/" + file);

                if (!f.exists() || !f.isFile()) {
                    continue;
                }

                try (FileInputStream fis = new FileInputStream(f);
                     BufferedInputStream bis = new BufferedInputStream(fis)) {
                    ZipEntry entry = new ZipEntry(file);
                    zout.putNextEntry(entry);

                    byte[] buffer = new byte[fis.available()];
                    int len;
                    while ((len = bis.read(buffer)) != -1) {
                        zout.write(buffer, 0, len);
                    }
                    zout.closeEntry();
                }
            }
        }
    }

    public void deleteFile(String path, String name) {
        File file = new File(path + "/" + name);
        file.delete();

    }

    public void openZip(String path, String zipName){

        try (ZipInputStream zin = new ZipInputStream(new
                FileInputStream(path + "/" + zipName + ".zip"))) {
            ZipEntry entry;
            String name;
            while ((entry = zin.getNextEntry()) != null) {
                name = entry.getName();
                FileOutputStream fout = new FileOutputStream(path + "/" + name);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void openProgress(String path) {
        GameProgress gp = null;

        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
             gp = (GameProgress) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(gp);

    }
}

