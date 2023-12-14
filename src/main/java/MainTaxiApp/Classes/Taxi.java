package MainTaxiApp.Classes;

public class Taxi {
    private final String registration;
    private final String name;
    private final int rating;
    private final String brand;
    private final String size;
    private final int seats;


    public Taxi(String registration, String name, int rating, String brand, String size, int seats){
        this.registration = registration;
        this.name = name;
        this.rating = rating;
        this.brand = brand;
        this.size = size;
        this.seats = seats;
    }

    public String getRegistration() {
        return registration;
    }
    public String getName() {
        return name;
    }
    public int getRating() {
        return rating;
    }
    public String getBrand() {
        return brand;
    }
    public String getSize() {
        return size;
    }
    public int getSeats() {
        return seats;
    }

    /*method to calculate distance between user and taxi
    using pythagoras theorem */


}
