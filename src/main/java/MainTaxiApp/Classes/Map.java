package MainTaxiApp.Classes;

import java.util.Random;

import static MainTaxiApp.Classes.AppLogic.anythingToContinue;

public class Map {


    TextHandler text = new TextHandler();
    private final LinkedList<Taxi> taxis =text.readTaxiData(text.getTAXIS_FILE_PATH());

    LinkedList<Location> taxisOnMap = new LinkedList<>();
        private final Location[][] grid;
        private Location usersLocation;
        private final int mapRadius;

        private Taxi chosenTaxi;



        public Map(int radius, User currentUser){
            this.grid = new Location[radius][radius];
            this.mapRadius = radius;
            for(int i=0; i < radius; i++) {
                for (int j = 0; j < radius; j++) {
                    this.grid[i][j] = new Location(i, j);
                }
            }
            addTaxisAndUsersToMap(radius,currentUser);
            printMap(usersLocation);
        }

        public void printMap(Location usersLoc){
            for(int i=0; i<mapRadius; i++) {
                for (int j = 0; j < mapRadius; j++) {
                    Location location = grid[j][i];
                    System.out.print(location.getMapPoint());
                }
                System.out.println();
            }
            if(usersLoc!=null)
            {System.out.println("You are at: (" + usersLoc.getX() + ", " + usersLoc.getY() + ")");}
        }
        public void addTaxisAndUsersToMap(int radius, User currentUser){
            Random random = new Random();
            int numberOfTaxi = random.nextInt(11)+10;
            taxis.moveToFirst();
            for(int i=0; i<numberOfTaxi; i++) {
                Location newTaxi=grid[random.nextInt(radius)][random.nextInt(radius)];
                newTaxi.addTaxi(taxis.getData());
                taxisOnMap.insert(newTaxi);
                taxis.moveToNext();
            }
            usersLocation=grid[random.nextInt(radius)][random.nextInt(radius)];
            usersLocation.addUser(currentUser);
            currentUser.setUsersLocation(usersLocation);
        }

    private Location searchAlgorithm() {
            AppLogic size = new AppLogic();
            String taxiSize =(size.findSize()+"").toLowerCase();
        int searchRadius = 1; // Start with a small search radius
        Location nearestTaxiLocation=null;
        while (true) {
            nearestTaxiLocation = findNearestTaxi(usersLocation, searchRadius,taxiSize);

            if (nearestTaxiLocation != null) {
                nearestTaxiLocation.changeTaxiToDriver();
                System.out.println("Nearest taxi found at coordinates: (" + nearestTaxiLocation.getX() + ", " + nearestTaxiLocation.getY() + ")");
                break; // Exit the loop once a taxi is found
            } else {
                //System.out.println("No taxi found within the current radius. Increasing search radius.");
                searchRadius++; // Increment the search radius for the next iteration
            }//test
        }
        System.out.println("Driver name: "+nearestTaxiLocation.getDriver().getName()+"\n" +
                "Brand of taxi: "+nearestTaxiLocation.getDriver().getBrand()+"\n" +
                "Registration: "+nearestTaxiLocation.getDriver().getRegistration()+"\n" +
                nearestTaxiLocation.getDriver().getName()+" is a "+nearestTaxiLocation.getDriver().getRating()+" star driver.");
        this.chosenTaxi=nearestTaxiLocation.getDriver();
        return nearestTaxiLocation;
    }

    private Location findNearestTaxi(Location userLocation, int searchRadius,String size) {
        for (int i = Math.max(0, userLocation.getX() - searchRadius); i <= Math.min(mapRadius - 1, userLocation.getX() + searchRadius); i++) {
            for (int j = Math.max(0, userLocation.getY() - searchRadius); j <= Math.min(mapRadius - 1, userLocation.getY() + searchRadius); j++) {
                Location location = grid[i][j];

                //Debug prints
                //System.out.println("Checking Location: (" + i + ", " + j + "));

                if (location.getTaxi()!=null&& location.getTaxi().getSize().equals(size)) {
                    return location; // Found a taxi within the search radius
                }
            }
        }

        return null; // No taxi found within the current search radius
    }
    public void moveTaxiToUser()  {
        Location nearestTaxi = searchAlgorithm();
        anythingToContinue();
        moveTaxisOnTheMap(usersLocation,nearestTaxi,usersLocation);
        System.out.println("The taxi has arrived and has picked you up.");
    }
    public void moveTaxiAndUserToLocation(int x,int y,Login newLogin)  {
        User user1 = newLogin.getCurrentUser();
        Ride ride = new Ride(1);
        ride.addObserver(user1);
        ride.startRide();
        System.out.println("Busy today mate ?");
        System.out.println("Beginning drive to destination.");
            Location destination = grid[x][y];
            moveTaxisOnTheMap(destination,usersLocation,null);
        System.out.println("You have arrived at your destination.");
        ride.endRide();
    }

    public Taxi getChosenTaxi() {

            return chosenTaxi;
    }

    public void moveTaxisOnTheMap(Location destination, Location taxiLocation, Location user) {
        while (!taxiLocation.equals(destination)) {
            int deltaX = Integer.compare(destination.getX(), taxiLocation.getX());
            int deltaY = Integer.compare(destination.getY(), taxiLocation.getY());

            Location oldtaxiLocation = taxiLocation;
            taxiLocation = grid[taxiLocation.getX() + deltaX][taxiLocation.getY() + deltaY];
            taxiLocation.addDrivingTaxi(oldtaxiLocation.getDriver());
            oldtaxiLocation.removeDriver();
            printMap(user);

            System.out.println("Taxi is now at (" + taxiLocation.getX() + "," + taxiLocation.getY() + ")");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }

    public Location[][] getGrid() {

            return grid;
    }

    public Location getUsersLocation() {

            return usersLocation;
    }
}


