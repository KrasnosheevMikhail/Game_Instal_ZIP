public class InstallingTheGame {

    public void gameInstaller() {
        String path = "D:/Games";

        CreateFiles createFiles = new CreateFiles(path);

        createFiles.createDir();
        createFiles.setPath(path + "/src");
        createFiles.createDir();
        createFiles.setPath(path + "/res");
        createFiles.createDir();
        createFiles.setPath(path + "/res/drawables");
        createFiles.createDir();
        createFiles.setPath(path + "/res/vectors");
        createFiles.createDir();
        createFiles.setPath(path + "/res/icons");
        createFiles.createDir();
        createFiles.setPath(path + "/savegames");
        createFiles.createDir();
        createFiles.setPath(path + "/src/test");
        createFiles.createDir();
        createFiles.setPath(path + "/src/main");
        createFiles.createDir();
        createFiles.createFile("Main.java");
        createFiles.createFile("Utils.java");
        createFiles.setPath(path + "/temp");
        createFiles.createDir();
        createFiles.createFile("temp.txt");
        createFiles.logWriter();
    }
}
