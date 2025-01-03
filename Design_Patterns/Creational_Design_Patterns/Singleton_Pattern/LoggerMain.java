public class LoggerMain {
  public static void main(String[] args) {
      var dog = new Dog();
      dog.woof();

      var cat = new Cat();
      cat.meow();
  }
}

enum Logger {
  
  LOGMESSAGE;

  private Logger() {};
  
  public static Logger getInstance() {
    return LOGMESSAGE;
  }

  void log(String message) {
    System.out.println("Logging..."+ message);
  }
}

class Dog {
  public void woof() {
    var logger = Logger.getInstance();
    logger.log("Woof");
  }
}

class Cat {
  public void meow() {
    var logger = Logger.getInstance();
    logger.log("Meow");
  }
}
