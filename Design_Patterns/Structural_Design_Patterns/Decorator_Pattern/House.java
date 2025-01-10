public class House {
  public static void main(String[] args) {
      
    var room = new BasicRoom();
    room.printFurniture();

    System.out.println();

    var roomWithCouch = new RoomWithCouch(room);
    roomWithCouch.printFurniture();
    
    System.out.println();

    var roomWithTable = new RoomWithTable(roomWithCouch);
    roomWithTable.printFurniture();
  }
}

interface Room {
  void printFurniture();
}

class BasicRoom implements Room {

  @Override
  public void printFurniture() {
    System.out.println("Carpet");
  }

}

abstract class RoomDecorator implements Room {

  private final Room room;

  public RoomDecorator(Room room) {
    this.room = room;
  }

  @Override
  public void printFurniture() {
    room.printFurniture();
  }
}

class RoomWithCouch extends RoomDecorator {
  
  public RoomWithCouch(Room room) {
    super(room);
  }

  @Override
  public void printFurniture() {
    super.printFurniture();
    System.out.println("Couch");
  }
}

class RoomWithTable extends RoomDecorator {
  
  public RoomWithTable(Room room) {
    super(room);
  }

  @Override
  public void printFurniture() {
    super.printFurniture();
    System.out.println("Table");
  }
}

