package com.poc.model;

public class InvoiceCreatedEvent  {

    public final String paymentId;

    public final String orderId;
    
    public final String userToken;

	public InvoiceCreatedEvent(String paymentId, String orderId, String userToken) {
		super();
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.userToken = userToken;
	}


   
}
