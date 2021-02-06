package application;

import services.OnlinePaymentService;
import services.PaypalService;

public class Program {

	public static void main(String[] args) {
		
		OnlinePaymentService ps = new PaypalService();
		
		System.out.println(ps.paymentFee(200.00));
		System.out.println(ps.interest(200.00, 3));

	}

}
