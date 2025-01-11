public class MessageApp {
  public static void main(String[] args) {
    Facade facade = new Facade();
    facade.connectCSandPrintMessage();
  }
}

class Facade {
  
  public void connectCSandPrintMessage() {
    var client = new Client();
    client.connectToServer();

    var clientServer = new ClientServer();
    clientServer.authenticateClient();
    clientServer.routeToRecipient();

    var recipientServer = new RecipientServer();
    recipientServer.authenticateRecipient();
    recipientServer.sendMessage();

    var recipient = new Recipient();
    recipient.receiveMessage();
  }
}

class Client {

  public void connectToServer() {
      System.out.println("Connecting to server...");
  }

}

class ClientServer {

  public void authenticateClient() {
      Authenticator authenticator = new Authenticator();
      authenticator.authenticate();
  }

  public void routeToRecipient() {
      System.out.println("Routing to recipient...");
  }

}

class Recipient {

  public void receiveMessage() {
      System.out.println("Message received");
  }

}

class RecipientServer {

  public void authenticateRecipient() {
      System.out.println("Authenticating recipient...");
  }

  public void sendMessage() {
      System.out.println("Sending message...");
  }

}

class Authenticator {


  public void authenticate() {
      System.out.println("Authenticating client...");
  }

}
