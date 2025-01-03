public class PrintSpoolerMain {
  public static void main(String[] args) {
      var documentPrinter = new DocumentPrinter();
      documentPrinter.printDocument();
      var imagePrinter = new ImagePrinter();
      imagePrinter.printImage();
  }
}

enum PrintSpooler {
  
  INSTANCE;

  private PrintSpooler() {};

  public static PrintSpooler getInstance() {
    return INSTANCE;
  }

  void print(String docType) {
    System.out.println("Printing... "+docType);
  }
}

class DocumentPrinter {
  public void printDocument() {
    var spooler = PrintSpooler.getInstance();
    spooler.print("Document");
  }
}

class ImagePrinter {
  public void printImage() {
    var spooler = PrintSpooler.getInstance();
    spooler.print("Image");
  }
}