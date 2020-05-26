package com.poc.model;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateInvoiceCommand{

    @TargetAggregateIdentifier
    public final String paymentId;

    public final String orderId;
    
    public final String userToken;

	public CreateInvoiceCommand(String paymentId, String orderId, String userToken) {
		super();
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.userToken = userToken;
	}

   
}
