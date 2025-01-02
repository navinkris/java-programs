public class ItemInventory {
  public static void main(String[] args) {
      var item1 = new StoreItem.StoreItemBuilder("Soap", 15.0)
              .shortDescription("Soap for body wash")
              .stockAvailable(10)
              .build();

      var item2 = new StoreItem.StoreItemBuilder("Shampoo", 35.0)
              .longDescription("Shampoo for hair wash")
              .packagingType("bottle")
              .build();

      addToItemRegistry(item1);
      addToItemRegistry(item2);
  }

  private static void addToItemRegistry(StoreItem storeItem) {
    System.out.println("A new item was added to the registry: \n" + storeItem);
  }
}

class StoreItem
{
  private final String name;
  private final Double price;
  private final String shortDescription;
  private final String longDescription;
  private final Integer stockAvailable;
  private final String packagingType;

  private StoreItem(StoreItemBuilder storeItemBuilder) {
    this.name = storeItemBuilder.name;
    this.price = storeItemBuilder.price;
    this.shortDescription = storeItemBuilder.shortDescription;
    this.longDescription = storeItemBuilder.longDescription;
    this.stockAvailable = storeItemBuilder.stockAvailable;
    this.packagingType = storeItemBuilder.packagingType;
    if (name == null || price == null) {
      throw new IllegalArgumentException("name and price must not be null");
    }
  }
  
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StoreItem{");
        sb.append("name=").append(name);
        sb.append(", price=").append(price);
        sb.append(", shortDescription=").append(shortDescription);
        sb.append(", longDescription=").append(longDescription);
        sb.append(", stockAvailable=").append(stockAvailable);
        sb.append(", packagingType=").append(packagingType);
        sb.append('}');
        return sb.toString();
    }

  public static class StoreItemBuilder {

    private final String name;
    private final Double price;
    private String shortDescription;
    private String longDescription;
    private Integer stockAvailable;
    private String packagingType;

    public StoreItemBuilder(String name, Double price) {
      this.name = name;
      this.price = price;
    }

    public StoreItemBuilder shortDescription(String shortDescription) {
      this.shortDescription = shortDescription;
      return this;
    }

    public StoreItemBuilder longDescription(String longDescription) {
      this.longDescription = longDescription;
      return this;
    }

    public StoreItemBuilder stockAvailable(Integer stockAvailable) {
      this.stockAvailable = stockAvailable;
      return this;
    }

    public StoreItemBuilder packagingType(String packagingType) {
      this.packagingType = packagingType;
      return this;
    }

    public StoreItem build() {
      return new StoreItem(this);
    }
  }
}