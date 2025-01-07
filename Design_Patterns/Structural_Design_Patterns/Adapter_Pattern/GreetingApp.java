public class GreetingApp {
  public static void main(String[] args) {
      var englishLocalizedMessage = new EnglishLocalizedMessage();
      var greeting = new Greeting(englishLocalizedMessage);
      greeting.sayMessage();

      var frenchLocalizedMessage = new FrenchLocalizedMessageAdapter();
      var greeting2 = new Greeting(frenchLocalizedMessage);
      greeting2.sayMessage(); 
  }
}

class Greeting {

  private final LocalizedMessage localizedMessage;

  public Greeting(LocalizedMessage localizedMessage) {
    this.localizedMessage = localizedMessage;
  }

  public void sayMessage() {
    localizedMessage.sayHello();
  }
}

interface LocalizedMessage {
  void sayHello();
}

class EnglishLocalizedMessage implements LocalizedMessage {

  @Override
  public void sayHello(){
    System.out.println("Hello");
  }
}
class FrenchLocalizedMessage {

  public void sayBonjour() {
    System.out.println("Bonjour");
  }
}

class FrenchLocalizedMessageAdapter extends FrenchLocalizedMessage implements LocalizedMessage {

  @Override
  public void sayHello() {
    sayBonjour();
  }

  @Override
  public void sayBonjour() {
    System.out.println("In french saying Hello: Bonjour");
  }
}


