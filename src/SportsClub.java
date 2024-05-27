// SportsClub.java
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SportsClub implements java.io.Serializable {
    private List<Player> players;

    public SportsClub() {
        players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public void saveState() {
        try {
            FileOutputStream fileOut = new FileOutputStream("state.csv");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(players);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void restoreState() {
        try {
            FileInputStream fileIn = new FileInputStream("state.csv");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            players = (List<Player>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
