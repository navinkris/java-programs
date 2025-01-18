public class TrafficLightApp {
  public static void main(String[] args) {
    
    var trafficLight = new TrafficLight();
    var pedestrianCrossingLight = new PedestrianCrossingLight();

    var mediator = new Mediator(trafficLight, pedestrianCrossingLight);

    mediator.changeTrafficLightToAmber();
    mediator.changeTrafficLightToGreen();
    mediator.changeTrafficLightToAmber();
    mediator.changeTrafficLightToRed();
  }
}

class TrafficLight {

  public enum Color {
    RED, AMBER, GREEN
  }

  private Color color = Color.RED;

  public void changeToRed() {
    color = Color.RED;
    System.out.println("Traffic light is red");
  }

  public void changeToAmber() {
    color = Color.AMBER;
    System.out.println("Traffic light is amber");
  }

  public void changeToGreen() {
    color = Color.GREEN;
    System.out.println("Traffic light is green");
  }
}

class PedestrianCrossingLight {

  public enum Color {
    RED, GREEN
  }

  private Color color = Color.RED;

  public void changeToRed() {
    color = Color.RED;
    System.out.println("Pedestrian crossing light is red");
  }

  public void changeToGreen() {
    color = Color.GREEN;
    System.out.println("Pedestrian crossing light is green");
  }
}

class Mediator{

  private TrafficLight trafficLight;
  private PedestrianCrossingLight pedestrianCrossingLight;

  public Mediator(TrafficLight trafficLight, PedestrianCrossingLight pedestrianCrossingLight) {
    this.trafficLight = trafficLight;
    this.pedestrianCrossingLight = pedestrianCrossingLight;
  }

  public void changeTrafficLightToRed() {
    trafficLight.changeToRed();
    pedestrianCrossingLight.changeToGreen();
  }

  public void changeTrafficLightToAmber() {
    trafficLight.changeToAmber();
  }

  public void changeTrafficLightToGreen() {
    trafficLight.changeToGreen();
    pedestrianCrossingLight.changeToRed();
  }
}
