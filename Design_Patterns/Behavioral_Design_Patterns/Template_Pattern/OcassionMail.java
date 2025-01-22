public class OcassionMail {
  public static void main(String[] args) {
    var wemail = new WelcomeEmail();
    wemail.welcomePortion();
    wemail.messagePortion();
    wemail.footerPortion();

    var goodbyeEmail = new GoodbyeEmail();
    goodbyeEmail.welcomePortion();
    goodbyeEmail.messagePortion();
    goodbyeEmail.footerPortion();
  }
}

abstract class Email {

  public void welcomePortion() {
    System.out.println("Hello,");
  }

  public abstract void messagePortion();

  public void footerPortion() {
    System.out.println("Thanks");
  }
}

class WelcomeEmail extends Email {

  @Override
  public void messagePortion() {
    System.out.println("Welcome to the group!");
  }
}

class GoodbyeEmail extends Email {

  @Override
  public void messagePortion() {
    System.out.println("We are sorry to see you go!");
  }
}
