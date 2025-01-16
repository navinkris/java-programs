public class InterpretPeriodApp {
  public static void main(String[] args) {
      var context = "hello world";
      var lastLetterShouldBePeriod = new LastLetterShouldBePeriod();
      var result = lastLetterShouldBePeriod.interpret(context);
      System.out.println(result);
  }
}

interface Expression {
  
  String interpret(String context);
}

class StartsWithCapitalLetter implements Expression {

  @Override
  public String interpret(String context) {
    return context.substring(0,1).toUpperCase() + context.substring(1);
  }
}

class LastLetterShouldBePeriod implements Expression {

  private final StartsWithCapitalLetter startsWithCapitalLetter = new StartsWithCapitalLetter();

  @Override
  public String interpret(String context) {
    context = context + ".";
    return startsWithCapitalLetter.interpret(context);
  }
}
