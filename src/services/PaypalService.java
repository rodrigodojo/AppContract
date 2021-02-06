package services;

public class PaypalService implements OnlinePaymentService{
	
	private static final double PAYMENT_FEE = 0.02;
	private static final double MONTHY_INTEREST = 0.01;
	
	@Override
	public Double paymentFee(Double amount) {
		return amount * PAYMENT_FEE;
	}
	
	@Override
	public Double interest(Double amount, Integer mounths) {
		return amount * mounths * MONTHY_INTEREST;		
	}

}
