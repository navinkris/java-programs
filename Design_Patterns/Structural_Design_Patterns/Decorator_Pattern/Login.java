public class Login {
  public static void main(String[] args) {
    var user = new BasicUser();
    user.printPrivileges();

    System.out.println();

    var adminUser = new AdminUser(user);
    adminUser.printPrivileges();

    System.out.println();

    var developerUser = new DeveloperUser(adminUser);
    developerUser.printPrivileges();
  }
}

interface User {
  void printPrivileges();
}

abstract class UserDecorator implements User {
  
  private final User user;

  public UserDecorator(User user) {
    this.user = user;
  }

  @Override
  public void printPrivileges() {
    user.printPrivileges();
  }

}

class BasicUser implements User {
  
  @Override
  public void printPrivileges() {
    System.out.println("Can log in");
  }
}

class AdminUser extends UserDecorator {

  public AdminUser(User user) {
    super(user);
  }

  @Override
  public void printPrivileges() {
    super.printPrivileges();
    System.out.println("Can create new users");
  }
}

class DeveloperUser extends UserDecorator {

  public DeveloperUser(User user) {
    super(user);
  }

  @Override
  public void printPrivileges() {
    super.printPrivileges();
    System.out.println("Can deploy to production");
  }
}
