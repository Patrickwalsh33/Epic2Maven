package MainTaxiApp.Classes;

public class Taxi {
    private final String registration;
    private final String name;
    private int rating;
    private final String brand;
    private final String size;


    public Taxi(String registration, String name, int rating, String brand, String size){
        this.registration = registration;
        this.name = name;
        this.rating = rating;
        this.brand = brand;
        this.size = size;
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
    public void setRating(int rating){
        this.rating=rating;
    }
}
