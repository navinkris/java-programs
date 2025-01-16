public class Interpret_App {
  public static void main(String[] args) {
    var context = "_My Variable";
    var firstLetterShouldNotBeUnderscore = new FirstLetterShouldNotBeUnderscore();
    var result = firstLetterShouldNotBeUnderscore.interpret(context);
    System.out.println(result);
  }
}

interface Expression {

  String interpret(String context);
}

class NoWhiteSpace implements Expression {

  @Override
  public String interpret(String context) {
    return context.replaceAll(" ", "");
  }
}

class FirstLetterShouldBeLowerCase implements Expression {

  private final NoWhiteSpace noWhiteSpace = new NoWhiteSpace();

  @Override
  public String interpret(String context) {
    context = context.substring(0,1).toLowerCase() + context.substring(1);
    return noWhiteSpace.interpret(context);
  }
}

class FirstLetterShouldNotBeUnderscore implements Expression {

  private final FirstLetterShouldBeLowerCase firstLetterShouldBeLowerCase = new FirstLetterShouldBeLowerCase();

  @Override
  public String interpret(String context) {
    if (context.startsWith("_")) {
      context = context.substring(1);
    }
    return firstLetterShouldBeLowerCase.interpret(context);
  }
}