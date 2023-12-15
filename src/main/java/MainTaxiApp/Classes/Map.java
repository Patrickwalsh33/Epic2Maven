package MainTaxiApp.Classes;

import java.util.Random;

public class Map {
    TextHandler text = new TextHandler();
    private final LinkedList<Taxi> taxis =text.readTaxiData(text.getTAXIS_FILE_PATH());

    LinkedList<Location> taxisOnMap = new LinkedList<>();
        private final Location[][] grid;
        private Location usersLocation;
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
            usersLocation=grid[random.nextInt(radius)][random.nextInt(radius)];
            usersLocation.addUser(currentUser);
            int numberOfTaxi = random.nextInt(11)+10;
            taxis.moveToFirst();
            for(int i=0; i<numberOfTaxi; i++) {
                Location newTaxi=grid[random.nextInt(radius)][random.nextInt(radius)];
                newTaxi.addTaxi(taxis.getData());
                taxisOnMap.insert(newTaxi);
                taxis.moveToNext();
            }
        }
        public void callTaxiToUser(){
        }
        public void taxiRide(){

        }
        public Taxi findClosestTaxi(){
           int x=usersLocation.getX();
           int y=usersLocation.getY();
           int distance=40;
           Location closestTaxi;
           for(int i=0; i<taxisOnMap.size();i++){
               if((taxisOnMap.getData().getX()+taxisOnMap.getData().getY())<distance){
                   distance=(taxisOnMap.getData().getX()+taxisOnMap.getData().getY();
                   closestTaxi=taxisOnMap.getData();
               }
           }
         return closestTaxi;
        }
}

