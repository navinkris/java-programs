public class LoginAuthenticator {
  
  public static void main(String[] args) {
    var loginPage = new LoginPage();

    loginPage.logInUser(Authenticator.passwordAuthenticator);
    loginPage.logInUser(Authenticator.singleSignonAuthenticator);
  }
}

interface Authenticator {
  void logIn();

  Authenticator passwordAuthenticator = () -> System.out.println("Logging in with username and password.");
  Authenticator singleSignonAuthenticator = () -> System.out.println("Logging in with single sign-on.");
}

class LoginPage {
  
  public void logInUser(Authenticator authenticator) {
    authenticator.logIn();
  }

}
