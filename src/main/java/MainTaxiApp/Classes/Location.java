package MainTaxiApp.Classes;

public class Location {
    private final int x;
    private final int y;
    private String mapPoint;

    public User userInLocation;

    public Taxi[] taxiInLocation={null,null};

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
        userInLocation=user;
        //System.out.println(user.getUsername()+" added to (" + x + "," + y + ")");
        mapPoint = "U\t";

    }
   public void addTaxi(Taxi taxi){
        //System.out.println(taxi.getRegistration()+" added to ("+x+","+y + ")");
        taxiInLocation[0]=taxi;
        mapPoint = "T\t";
    }
    public void addDrivingTaxi(Taxi driver){
        taxiInLocation[1]=driver;
        mapPoint ="D\t";
    }
    public void removeTaxi(){
        taxiInLocation[0]=null;
        mapPoint =".\t";
    }
    public void removeDriver(){
        taxiInLocation[1]=null;
        if (taxiInLocation[0]==null) {
            mapPoint=".\t";
        }else{mapPoint="T\t";}
    }

    public Taxi getTaxi(){
        return taxiInLocation[0];
        //If you get taxi is not null taxi is in location
    }
    public Taxi getDriver(){
        return taxiInLocation[1];
    }
    public void changeTaxiToDriver(){
        taxiInLocation[1]=taxiInLocation[0];
        taxiInLocation[0]=null;
        mapPoint="D\t";
    }



}
