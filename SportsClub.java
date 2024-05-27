// SportsClub.java
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SportsClub {
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
           FileWriter writer = new FileWriter("state.csv");
           for (Player player : players) {
               writer.write(player.getName() + "," + player.getAge() + "\n");
           }
           writer.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   public void restoreState() {
       try {
           FileReader reader = new FileReader("state.csv");
           BufferedReader bufferedReader = new BufferedReader(reader);
           String line;
           players.clear();
           while ((line = bufferedReader.readLine()) != null) {
               String[] data = line.split(",");
               String name = data[0];
               int age = Integer.parseInt(data[1]);
               Player player = new Player(name, age);
               players.add(player);
           }
           reader.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}