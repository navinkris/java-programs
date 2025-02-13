class MyClassLoader extends ClassLoader {
  @Override
  public Class<?> findClass(String name) {
    return defineClass(name, new byte[0], 0, 0);
  }
}

public class CustomclassLoaderExample {
  public static void main(String[] args) throws ClassNotFoundException{
    MyClassLoader loader = new MyClassLoader();
    Class<?> myClass = loader.findClass("CustomclassLoaderExample");
    System.out.println("Class loaded: "+ myClass.getName());
  }
}
