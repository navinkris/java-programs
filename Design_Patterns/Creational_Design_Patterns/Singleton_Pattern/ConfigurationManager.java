import java.util.HashMap;
import java.util.Map;

public class ConfigurationManager {
  public static void main(String[] args) {
    ConfigManagerSingleton config1 = ConfigManagerSingleton.getInstance();
    ConfigManagerSingleton config2 = ConfigManagerSingleton.getInstance();

    System.out.println("API URL: " + config1.getSettings("apiUrl"));
    System.out.println("Timeout: " + config1.getSettings("timeout"));

    config2.setSetting("timeout", "6000");
    
    System.out.println("Updated Timeout: " + config1.getSettings("timeout"));
    System.out.println("Are config1 and config2 the same instance? " + (config1 == config2));
  }
}

class ConfigManagerSingleton {

  private static ConfigManagerSingleton instance;

  private Map<String, String> settings;

  private ConfigManagerSingleton() {
    settings = new HashMap<>();
    settings.put("apiUrl", "https://api.example.com");
    settings.put("timeout", "5000");
    settings.put("environment", "production");
    System.out.println("ConfigurationManager initialized.");
  }

  public static ConfigManagerSingleton getInstance() {
    if(instance == null) {
      synchronized (ConfigManagerSingleton.class) {
        if (instance == null) {
          instance = new ConfigManagerSingleton();
        }
      }
    }
    return instance;
  }

  public String getSettings(String key) {
    return settings.getOrDefault(key, "Key not found");
  }

  public void setSetting(String key, String value) {
    settings.put(key, value);
  }
}