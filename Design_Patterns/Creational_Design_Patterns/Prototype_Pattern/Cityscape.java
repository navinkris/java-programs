
import java.util.List;

public class Cityscape {
  public static void main(String[] args) {
      
    BuildingType houseBuildingType = new BuildingType("House");
    Building house1 = new Building(21, houseBuildingType);
    Building house2 = house1.clone();
    Building house3 = house1.clone();
    Building house4 = house1.clone();
    Building house5 = house1.clone();
    houseBuildingType.setType("House with yard");

    BuildingType skyscarperBuildingType = new BuildingType("skyscarper");
    Building skyscraper1 = new Building(86, skyscarperBuildingType);
    Building skyscraper2 = skyscraper1.clone();
    Building skyscraper3 = skyscraper1.clone();
    Building skyscraper4 = skyscraper1.clone();
    Building skyscraper5 = skyscraper1.clone();

    List<Graphic> order = List.of(house1, house2, house3, house4, house5,
                                  skyscraper1, skyscraper2, skyscraper3, skyscraper4, skyscraper5);
    createCityscape(order);
  }

  private static void createCityscape(List<Graphic> graphics) {
    System.out.println("Constructing cityscape: ");
    graphics.forEach(System.out::println);
  }
}

abstract  class Graphic {

  private int heightInPixels;

  public Graphic(int heightInPixels) {
    this.heightInPixels = heightInPixels;
  }

  public int getHeightInPixels() {
      return heightInPixels;
  }
  
  public void setHeightInPixels(int heightInPixels) {
      this.heightInPixels = heightInPixels;
  }

  public abstract Graphic clone();
}

class Building extends Graphic {

  private BuildingType buildingType;

  public Building(int heightInPixels, BuildingType buildingType) {
    super(heightInPixels);
    this.buildingType = buildingType;
  }

  public BuildingType getBuildingType() {
      return buildingType;
  }

  public void setBuildingType(BuildingType buildingType) {
      this.buildingType = buildingType;
  }

  @Override
  public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("Building{");
      sb.append("buildingType=").append(buildingType);
      sb.append('}');
      return sb.toString();
  }

  @Override
  public Building clone() {
    return new Building(this.getHeightInPixels(), new BuildingType(this.getBuildingType().getType()));
  }
}

class BuildingType {
  
  private String type;

  public BuildingType(String type) {
      this.type = type;
  }

  public String getType() {
      return type;
  }

  public void setType(String type) {
      this.type = type;
  }

  @Override
  public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("BuildingType{");
      sb.append("type=").append(type);
      sb.append('}');
      return sb.toString();
  }

}

