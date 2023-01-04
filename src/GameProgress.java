import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) throws FileNotFoundException, IOException {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }

    public class saveGame {
        public static void main(String[] args) throws FileNotFoundException {
            FileOutputStream fos;
            fos = new FileOutputStream("C:/User/Meeting room/IdeaProjects/Ustanovka/Games/savegames/save3.dat");
            try {
                GameProgress GameProgress;
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                GameProgress = new GameProgress(100, 35, 10, 200);
                oos.writeObject(GameProgress);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


        }
    }

    try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("zip.zip"));
    FileInputStream fis = new FileInputStream("save3.dat"))

    {
        ZipEntry entry = new ZipEntry("packed_save3.dat");
        zout.putNextEntry(entry);
        byte[] buffer = byte[fis.available()];
        fis.read(buffer);
        zout.write(buffer);
        zout.closeEntry();
    } catch (Exception ex) {
        System.out.println(ex.getMessage());

    }

}