public class DocumentViewer {
  
  public static void main(String[] args) {
    var textBlock = new TextDocument();
    textBlock.write("Hello, world! ");
    textBlock.save();
    textBlock.print();
    textBlock.write("How are you? ");
    textBlock.print();
    textBlock.undo();
    textBlock.print();
  }
}

class TextDocument {
  
  private String text = "";
  private TextDocumentState state = new TextDocumentState(text);

  public void write(String text) {
    this.text += text;
  }

  public void print() {
    System.out.println(text);
  }

  public void save() {
    state.setState(text);
  }

  public void undo() {
    text = state.getState();
  }
}

class TextDocumentState {

  private String state;

  public TextDocumentState(String state) {
    this.state = state;
  }

  public String getState() {
    return this.state;
  }

  public void setState(String state) {
    this.state = state;
  }
}