
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class WeatherFeed {

  public static void main(String[] args) {

    var location1 = new Location();
    var location2 = new Location();
    var weatherUpdates = new WeatherUpdates();

    location1.addPropertyChangeListener(weatherUpdates);
    location2.addPropertyChangeListener(weatherUpdates);

    location1.setWeatherEvent("Risk of flooding");
    location2.setWeatherEvent("Risk of drought");
  
    weatherUpdates.printUpdates();
  }
}

class WeatherUpdates implements PropertyChangeListener{

  private List<String> weatherUpdates = new ArrayList<>();

  public void printUpdates() {
    weatherUpdates.forEach(System.out::println);
  }

  @Override
  public void propertyChange(PropertyChangeEvent event) {
    weatherUpdates.add((String) event.getNewValue());
  }
}

class Location {
  
  private String weatherEvent;

  private PropertyChangeSupport support = new PropertyChangeSupport(this);

  public void setWeatherEvent(String weatherEvent) {
    support.firePropertyChange("weatherEvent", this.weatherEvent, weatherEvent);
    this.weatherEvent = weatherEvent;
  }

  public void addPropertyChangeListener(WeatherUpdates weatherUpdates) {
    support.addPropertyChangeListener(weatherUpdates);
  }
}
