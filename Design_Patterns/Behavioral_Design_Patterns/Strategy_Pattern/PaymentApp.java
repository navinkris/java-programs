public class PaymentApp {
  public static void main(String[] args) {
   var paymentGateway = new PaymentGateway();
   
   paymentGateway.payForCartItems(Payment.payByCard);
   paymentGateway.payForCartItems(Payment.payByCash);
  }
}

interface Payment {
  void pay();

  Payment payByCash = () -> System.out.println("Paying by cash");
  Payment payByCard = () -> System.out.println("Paying by card");
}

class PaymentGateway {
  
  public void payForCartItems(Payment payment) {
    payment.pay();
  }
}
