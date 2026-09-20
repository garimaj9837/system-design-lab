
public class PaymentDecoratorApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaymentSystem PaymentSystem= new loggerDecorator(new FraudCheckDecorator (new CardPayment()));
		PaymentSystem.pay(10);
	}

}

interface PaymentSystem{
	void pay(int amount);
}

class CardPayment implements PaymentSystem{

	@Override
	public void pay(int amount) {
		System.out.println("Payment of amount "+amount+" made via card payment method");
	}
}

class UpiPayment implements PaymentSystem{

	@Override
	public void pay(int amount) {
		System.out.println("Payment of amount "+amount+" made via upi payment method");
	}
	
}

abstract class Decorator implements PaymentSystem{
	PaymentSystem paymentSystem;
	
	Decorator(PaymentSystem paymentSystem){
		this.paymentSystem=paymentSystem;
	}
}

class loggerDecorator extends Decorator{

	loggerDecorator(PaymentSystem paymentSystem) {
		super(paymentSystem);
	}

	@Override
	public void pay(int amount) {
		System.out.println("logging enabled");
		paymentSystem.pay(amount);	
	}
	
}

class FraudCheckDecorator extends Decorator{

	FraudCheckDecorator(PaymentSystem paymentSystem) {
		super(paymentSystem);
	}

	@Override
	public void pay(int amount) {
		System.out.println("Fraud check enabled");
		paymentSystem.pay(amount);	
	}
	
}
