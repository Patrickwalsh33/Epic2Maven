package MainTaxiApp.Interfaces;

import java.util.Observable;

public interface Observer {
    void update(Observable observedTaxi, Object location);
}
