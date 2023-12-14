package MainTaxiApp.Classes;

import java.util.Random;

public class Map {
    TextHandler text = new TextHandler();
    private final LinkedList<Taxi> taxis =text.readTaxiData(text.getTAXIS_FILE_PATH());
        private final Location[][] grid;
        private final int mapRadius;
        public Map(int radius, User currentUser){
            this.grid = new Location[radius][radius];
            this.mapRadius = radius;
            for(int i=0; i < radius; i++) {
                for (int j = 0; j < radius; j++) {
                    this.grid[i][j] = new Location(i, j);
                }
            }
            addTaxisAndUsersToMap(radius,currentUser);

        }

        public void printMap(){
            for(int i=0; i<mapRadius; i++) {
                for (int j = 0; j < mapRadius; j++) {
                    Location location = grid[j][i];
                    System.out.print(location.getMapPoint());
                }
                System.out.println();
            }
        }
        public void addTaxisAndUsersToMap(int radius, User currentUser){
            Random random = new Random();
            grid[random.nextInt(radius)][random.nextInt(radius)].addUser(currentUser);
            int numberOfTaxi = random.nextInt(11)+10;
            taxis.moveToFirst();
            for(int i=0; i<numberOfTaxi; i++) {
                grid[random.nextInt(radius)][random.nextInt(radius)].addTaxi(taxis.getData());
                taxis.moveToNext();
            }
        }
}
