package MainTaxiApp.Classes;

public interface RideSubject {
    void addObserver(RideObserver observer);
    void removeObserver(RideObserver observer);
    void notifyObservers();
}
