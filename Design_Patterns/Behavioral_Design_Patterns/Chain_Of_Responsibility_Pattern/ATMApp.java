public class ATMApp {
  public static void main(String[] args) {
      var request = new WithdrawalRequest(20.0, WithdrawalRequest.Currency.USD);
      var atm = buildChain();
      atm.dispense(request);
  }

  private static ATM buildChain() {
    var euroATM = new EuroATM(null);
    var usDollarATM = new UsDollarATM(euroATM);
    return usDollarATM;
  }
}

class WithdrawalRequest {

  private final Double amount;
  private final Currency currency;
  
  public WithdrawalRequest(Double amount, Currency currency) {
    this.amount = amount;
    this.currency = currency;
  }

  public Double getAmount() {
    return amount;
  }

  public Currency getCurrency() {
    return currency;
  }

  public enum Currency {
    USD,
    EUR
  }
}

abstract  class ATM {

  public ATM nextATM;

  public ATM(ATM nextATM) {
    this.nextATM = nextATM;
  }

  public abstract void dispense(WithdrawalRequest request);
}

class EuroATM extends ATM {

  public EuroATM(ATM nextATM) {
    super(nextATM);
  }

  @Override
  public void dispense(WithdrawalRequest request) {
    if (request.getCurrency() == WithdrawalRequest.Currency.EUR) {
      System.out.println("Dispensing E " + request.getAmount());
    } else if (nextATM != null) {
      nextATM.dispense(request);
    }
  }
  
}

class UsDollarATM extends ATM {

  public UsDollarATM(ATM nextATM) {
    super(nextATM);
  }
  
  @Override
  public void dispense(WithdrawalRequest request) {
    if (request.getCurrency() == WithdrawalRequest.Currency.USD) {
      System.out.println("Dispensing $ " + request.getAmount());
    } else if (nextATM != null) {
      nextATM.dispense(request);
    }
  }

  
}