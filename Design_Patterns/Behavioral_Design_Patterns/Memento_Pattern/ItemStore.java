public class ItemStore {
  public static void main(String[] args) {
    var item = new Item(20);
    item.save();
    System.out.println("Item price is " + item.getPrice());
    item.setPrice(10);
    System.out.println("Item price is " + item.getPrice());
    item.undo();
    System.out.println("Item price is "+ item.getPrice());
  }
}

class Item {

  private int price;
  private ItemState state = new ItemState(price);

  public Item(int price) {
    this.price = price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getPrice() {
    return price;
  }

  public void save() {
    state.setPrice(price);
  }

  public void undo() {
    price = state.getPrice();
  }

}

class ItemState {

  private int price;

  public ItemState(int price) {
    this.price = price;
  }

  public int getPrice() {
    return this.price;
  }

  public void setPrice(int price) {
    this.price = price;
  }
}
