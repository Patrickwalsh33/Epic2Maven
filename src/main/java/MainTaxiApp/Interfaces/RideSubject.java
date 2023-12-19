package MainTaxiApp.Interfaces;

import MainTaxiApp.Interfaces.RideObserver;

public interface RideSubject {
    void addObserver(RideObserver observer);
    void removeObserver(RideObserver observer);
    void notifyObservers();
}
