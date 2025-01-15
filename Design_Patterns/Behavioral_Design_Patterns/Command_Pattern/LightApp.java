public class LightApp {
  public static void main(String[] args) {
      var light = new Light();
      light.isOn();
      var lightCommandExecutor = new LightCommandExecutor();
      lightCommandExecutor.execute(new TurnOnLightCommand(light));
      light.isOn();
      lightCommandExecutor.execute(new TurnOffLightCommand(light));
      light.isOn();
      lightCommandExecutor.execute(new TurnOnLightCommand(light));
      light.isOn();
  }
}

class Light {

  private boolean isOn = false;

  public void turnOnLight() {
    isOn = true;
  }

  public void turnOffLight() {
    isOn = false;
  }

  public void isOn() {
    System.out.println("Light is "+ (isOn ? "on" : "off") + ".");
  }

}

interface LightCommand {
  void execute();
}

class TurnOnLightCommand implements LightCommand {

  private final Light light;

    public TurnOnLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
      light.turnOnLight();
    }
}

class TurnOffLightCommand implements LightCommand {

  private final Light light;

    public TurnOffLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
      light.turnOffLight();
    }
}

class LightCommandExecutor {

  public void execute(LightCommand lightCommand) {
    lightCommand.execute();
  }
}