package services;

import java.util.Calendar;
import java.util.Date;

import entities.Contract;
import entities.Installement;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;
	
	public ContractService() {
	}
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public OnlinePaymentService getOnlinePaymentService() {
		return onlinePaymentService;
	}

	public void setOnlinePaymentService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, Integer mounths) {
		double basicQuota = contract.getTotalValue() / mounths;
		for(int i=1 ; i<=mounths ; i++) {
			double updatedQuota = basicQuota + onlinePaymentService.interest(basicQuota, i);
			double fullQuota = updatedQuota + onlinePaymentService.paymentFee(updatedQuota);
			Date dueDate = addMonths(contract.getDate(), i);
			contract.getInstallments().add(new Installement(dueDate,fullQuota));
		}
	}
	
	private Date addMonths(Date date, int N) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(calendar.MONTH, N);
		
		return calendar.getTime();
	}
}
