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
        mapPoint = "U\t";

    }
    public void removeUser(){
        userInLocation=null;
        if (taxiInLocation[0]==null) {
            mapPoint=".\t";
        }else{mapPoint="T\t";}

    }
   public void addTaxi(Taxi taxi){
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
