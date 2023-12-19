package MainTaxiApp.Classes;

import MainTaxiApp.Interfaces.RideObserver;
import MainTaxiApp.Interfaces.RideSubject;

public class Ride implements RideSubject {
    private RideObserver[] observers;
    private int observerCount = 0;
    private boolean rideInProgress = false;

    public Ride(int maxObservers){

        this.observers = new RideObserver[maxObservers];
    }

    @Override
    public void addObserver(RideObserver observer) {
        if(observerCount < observers.length){
            observers[observerCount++] = observer;
        }else {
            System.out.println("Cannot add more observers.Observer limit reached.");
        }
    }

    @Override
    public void removeObserver(RideObserver observer) {
        for (int i = 0; i < observerCount; i++){
            if (observers[i] == observer){
                //shift elements to remove the observer
                System.arraycopy(observers, i + 1, observers, i, observerCount - i - 1);
                observers[--observerCount] = null;
                break;
            }
        }
    }

    @Override
    public void notifyObservers() {
        for (RideObserver observer : observers){
            if (observer != null){
                observer.update(this);
            }
        }
    }

    public void startRide(){
        rideInProgress = true;
        //notify observers when ride starts
        notifyObservers();
    }

    public void endRide(){
        rideInProgress = false;
        //notify observers when ride ends
        notifyObservers();
    }

    public boolean isRideInProgress(){

        return rideInProgress;
    }
}
