import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        InstallingTheGame game = new InstallingTheGame();
        game.gameInstaller();


        GameProgress gp1 = new GameProgress(100, 30, 1, 3);
        GameProgress gp2 = new GameProgress(900, 80, 10, 35);
        GameProgress gp3 = new GameProgress(85, 200, 15, 90);

        String[] saves = new String[3];
        String fileName = "save";
        String zipName = "zipSaves";
        String path = "D:/Games/savegames";

        gp1.saveGame(path, fileName + "1.dat");
        saves[0] = fileName + "1.dat";
        gp2.saveGame(path, fileName + "2.dat");
        saves[1] = fileName + "2.dat";
        gp3.saveGame(path, fileName + "3.dat");
        saves[2] = fileName + "3.dat";

        gp1.zipGame(path, saves, zipName);

        gp1.deleteFile(path, fileName+ "1.dat");
        gp2.deleteFile(path, fileName+ "2.dat");
        gp3.deleteFile(path, fileName+ "3.dat");

        gp2.openZip(path, zipName);
        gp2.openProgress(path + "/" + fileName+ "2.dat");

    }
}
