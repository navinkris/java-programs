
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class App {
  
  public static void main(String[] args) {
    UserInterface redUserInterface = creatUserInterface("RED");
    UserInterface blueUserInterface = creatUserInterface("BLUE");
    
    System.out.println(redUserInterface);
    System.out.println(blueUserInterface);
  }

  private static UserInterface creatUserInterface(String color) {
      var userInterfaceFactory = FactoryMaker.createFactory(color);
      var button = userInterfaceFactory.createButton();
      var scrollbar = userInterfaceFactory.createScrollBar();
      return new UserInterface(button, scrollbar);
  }
}

class FactoryMaker {
  private static final Map<String, Supplier<UserInterfaceFactory>> userInterfaceFactories = new HashMap();

  static {
    userInterfaceFactories.put("BLUE", BlueUserInterfaceFactory::new);
    userInterfaceFactories.put("RED", RedUserInterfaceFactory::new);
  }

  public static UserInterfaceFactory createFactory(String color) {
    if(userInterfaceFactories.get(color) != null) {
      return userInterfaceFactories.get(color).get();
    } else {
      throw new IllegalArgumentException("Color not supported");
    }
  }
  
}

interface UserInterfaceFactory {
  Button createButton();
  ScrollBar createScrollBar();
}

class BlueUserInterfaceFactory implements UserInterfaceFactory {

    @Override
    public Button createButton() {
      return new BlueButton();
    }

    @Override
    public ScrollBar createScrollBar() {
      return new BlueScrollBar();
    }

}

class RedUserInterfaceFactory implements UserInterfaceFactory {

  @Override
  public Button createButton() {
    return new RedButton();
  }

  @Override
  public ScrollBar createScrollBar() {
    return new RedScrollBar();
  }

}

interface Button {
  String getColor();
}

interface ScrollBar {
  String getColor();
}

class RedButton implements Button {

    @Override
    public String getColor() {
      return "RED";
    }

}

class BlueButton implements Button {

    @Override
    public String getColor() {
      return "BLUE";
    }

}

class RedScrollBar implements ScrollBar {
  
  @Override
  public String getColor() {
    return "RED";
  }

}

class BlueScrollBar implements ScrollBar {

    @Override
    public String getColor() {
      return "BLUE";
    }

}

class UserInterface {
  private Button button;
  private ScrollBar scrollbar;

    public UserInterface(Button button, ScrollBar scrollbar) {
        this.button = button;
        this.scrollbar = scrollbar;
    }

    public Button getButton() {
        return button;
    }

    public ScrollBar getScrollbar() {
        return scrollbar;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserInterface{");
        sb.append("button=").append(button);
        sb.append(", scrollbar=").append(scrollbar);
        sb.append('}');
        return sb.toString();
    }

  
}