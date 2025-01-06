import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class BikeManufacturer {
  public static void main(String[] args) {
    Bike roadBike = buildBike("ROAD");
    Bike mountainBike = buildBike("MOUNTAIN");

    System.out.println(roadBike);
    System.out.println(mountainBike);
  }

  private static Bike buildBike(String bikeType) {
    var bikeFactory = FactoryMaker.createFactory(bikeType);
    var handleBars = bikeFactory.createHandleBars();
    var pedals = bikeFactory.createPedals();
    var frontTire = bikeFactory.createTire();
    var backTire = bikeFactory.createTire();
    return new Bike(backTire, frontTire, handleBars, pedals);
  } 
}

class FactoryMaker {

  private static final Map<String, Supplier<BikeFactory>> bikeTypes = new HashMap();

  static {
    bikeTypes.put("ROAD", RoadBikeFactory::new);
    bikeTypes.put("MOUNTAIN", MountainBikeFactory::new);
  }

  public static BikeFactory createFactory(String bikeType) {
    if(bikeTypes.get(bikeType) != null) {
      return bikeTypes.get(bikeType).get();
    } else {
      throw new IllegalArgumentException("Bike type not supported");
    }
  }

}

class Bike {
  private HandleBars handleBars;
  private Pedals pedals;
  private Tire frontTire;
  private Tire backTire;

  public Bike(Tire backTire, Tire frontTire, HandleBars handleBars, Pedals pedals) {
    this.backTire = backTire;
    this.frontTire = frontTire;
    this.handleBars = handleBars;
    this.pedals = pedals;
  }

  public HandleBars getHandleBars() {
      return handleBars;
  }

  public Pedals getPedals() {
      return pedals;
  }

  public Tire getFrontTire() {
      return frontTire;
  }

  public Tire getBackTire() {
      return backTire;
  }

  @Override
  public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("Bike{");
      sb.append("handleBars=").append(handleBars);
      sb.append(", pedals=").append(pedals);
      sb.append(", frontTire=").append(frontTire);
      sb.append(", backTire=").append(backTire);
      sb.append('}');
      return sb.toString();
  }
}

interface HandleBars {
  String getType();
}

interface Pedals {
  String getType();
}

interface Tire {
  int getWidth();
}

class RoadBikeHandlers implements HandleBars{

    @Override
    public String getType() {
      return "DROP";
    }

}

class RoadBikePedals implements Pedals {

    @Override
    public String getType() {
      return "SPD-SL";
    }

}

class RoadBikeTire implements Tire {

    @Override
    public int getWidth() {
      return 23;
    }

}

class MountainBikeHandlers implements HandleBars {

    @Override
    public String getType() {
      return "FLAT";
    }

}

class MountainBikePedals implements  Pedals {

    @Override
    public String getType() {
      return "SPD";
    }

}

class MountainBikeTire implements Tire {

    @Override
    public int getWidth() {
      return 29;
    }

}

interface BikeFactory {

  HandleBars createHandleBars();
  Pedals createPedals();
  Tire createTire();

}

class RoadBikeFactory implements  BikeFactory {

    @Override
    public HandleBars createHandleBars() {
      return new RoadBikeHandlers();
    }

    @Override
    public Pedals createPedals() {
      return  new RoadBikePedals();
    }

    @Override
    public Tire createTire() {
      return new RoadBikeTire();
    }

}

class MountainBikeFactory implements  BikeFactory {

  @Override
  public HandleBars createHandleBars() {
    return new MountainBikeHandlers();
  }

  @Override
  public Pedals createPedals() {
    return new MountainBikePedals();
  }

  @Override
  public Tire createTire() {
    return new MountainBikeTire();
  }

}