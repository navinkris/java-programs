import java.util.ArrayList;
import java.util.List;

public class OnlineStoreApp {
  public static void main(String[] args) {
    var item1 = new Item(1);
    var item2 = new Item(2);
    var item3 = new Item(3);

    var itemOperationExecutor = new ItemOperationExecutor();
    itemOperationExecutor.queueOperation(new AddItemToBasketOperation(item1));
    itemOperationExecutor.queueOperation(new AddItemToBasketOperation(item2));
    itemOperationExecutor.queueOperation(new AddItemToBasketOperation(item3));
    itemOperationExecutor.queueOperation(new RemoveItemFromBasketOperation(item2));

    itemOperationExecutor.checkout();
  }
}

class Item {

  private final int id;

  public Item(int id) {
    this.id = id;
  }

  public void addToBasket() {
    System.out.println("Item "+ id + " added to basket.");
  }

  public void removeFromBasket() {
    System.out.println("Item "+ id + " removed from basket.");
  }
}

interface ItemOperation {

  void execute();
}

class ItemOperationExecutor {

  List<ItemOperation> itemOperations = new ArrayList<>();

  public void queueOperation(ItemOperation itemOperation) {
    itemOperations.add(itemOperation);
  }

  public void checkout() {
    itemOperations.forEach(ItemOperation::execute);
    itemOperations.clear();
  }
}

class AddItemToBasketOperation implements ItemOperation {

  private final Item item;

  public AddItemToBasketOperation(Item item) {
    this.item = item;
  }

  @Override
  public void execute() {
    item.addToBasket();
  }
}

class RemoveItemFromBasketOperation implements ItemOperation {

  private final Item item;

  public RemoveItemFromBasketOperation(Item item) {
    this.item = item;
  }

  @Override
  public void execute() {
    item.removeFromBasket();
  }
}



