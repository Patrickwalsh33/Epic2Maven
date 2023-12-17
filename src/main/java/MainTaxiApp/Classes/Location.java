package MainTaxiApp.Classes;

public class Location {
    private final int x;
    private final int y;
    private String mapPoint;

    public Taxi taxiInLocation=null;

    public User userInLocation=null;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public String getMapPoint() {
        return mapPoint;
    }

    public Location(int x, int y){
        this.x = x;
        this.y = y;
        this.mapPoint = ".\t";
    }
    public void addUser(User user){
        System.out.println(user.getUsername()+" added to (" + x + "," + y + ")");
        mapPoint = "U\t";

    }
   public void addTaxi(Taxi taxi){
        System.out.println(taxi.getRegistration()+" added to ("+x+","+y + ")");
        this.taxiInLocation=taxi;
        mapPoint = "T\t";
    }

    public boolean hasTaxi() {
        return this.getMapPoint().equals("T\t");
    }

    public Taxi getTaxi(){
        return taxiInLocation;
        //if get taxi is not null taxi is in location
    }



}
