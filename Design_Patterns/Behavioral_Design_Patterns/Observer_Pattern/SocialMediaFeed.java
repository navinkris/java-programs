
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class SocialMediaFeed {
  
  public static void main(String[] args) {
    var user1 = new User();
    var user2 = new User();
    var newsfeed = new Newsfeed();

    user1.addPropertyChangeListener(newsfeed);
    user2.addPropertyChangeListener(newsfeed);

    user1.setStatus("Going for a walk");
    user2.setStatus("Enjoying a coffee");

    newsfeed.printStatuses();
  }
}

class  Newsfeed implements PropertyChangeListener {
  
  private List<String> statuses = new ArrayList<>();

  public void printStatuses() {
    statuses.forEach(System.out::println);
  }

  @Override
  public void propertyChange(PropertyChangeEvent event) {
    statuses.add((String) event.getNewValue());
  }
}

class User {

  private String status;
  private PropertyChangeSupport support = new PropertyChangeSupport(this);

  public void setStatus(String status) {
    support.firePropertyChange("status", this.status, status);
    this.status = status;
  }

  public void addPropertyChangeListener(Newsfeed newsfeed) {
    support.addPropertyChangeListener(newsfeed);
  }
}
