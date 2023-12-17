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
            System.out.println("You are at: (" + usersLocation.getX() + ", " + usersLocation.getY() + ")");
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

    public Taxi searchAlgorithm() {
            AppLogic size = new AppLogic();
            String taxiSize =(size.findSize()+"").toLowerCase();
        int searchRadius = 1; // Start with a small search radius
        Location nearestTaxiLocation=null;
        while (true) {
            nearestTaxiLocation = findNearestTaxi(usersLocation, searchRadius,taxiSize);

            if (nearestTaxiLocation != null) {
                System.out.println("Nearest taxi found at coordinates: (" + nearestTaxiLocation.getX() + ", " + nearestTaxiLocation.getY() + ")");
                break; // Exit the loop once a taxi is found
            } else {
                System.out.println("No taxi found within the current radius. Increasing search radius.");
                searchRadius++; // Increment the search radius for the next iteration
            }
        }
        return nearestTaxiLocation.getTaxi();
    }

    private Location findNearestTaxi(Location userLocation, int searchRadius,String size) {
        for (int i = Math.max(0, userLocation.getX() - searchRadius); i <= Math.min(mapRadius - 1, userLocation.getX() + searchRadius); i++) {
            for (int j = Math.max(0, userLocation.getY() - searchRadius); j <= Math.min(mapRadius - 1, userLocation.getY() + searchRadius); j++) {
                Location location = grid[i][j];

                //Debug prints
                System.out.println("Checking Location: (" + i + ", " + j + ") for a taxi. hasTaxi(map): " + location.hasTaxi());

                if (location.getTaxi()!=null&& location.getTaxi().getSize().equals(size)) {
                    return location; // Found a taxi within the search radius
                }
            }
        }

        return null; // No taxi found within the current search radius
    }
}

