package com.poc.model;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateInitiateShippingCommand {

    @TargetAggregateIdentifier
    public final String shippingId;

    public final String orderId;

    public final String paymentId;
    
    public final String userToken;

	public CreateInitiateShippingCommand(String shippingId, String orderId, String paymentId, String userToken) {
		super();
		this.shippingId = shippingId;
		this.orderId = orderId;
		this.paymentId = paymentId;
		this.userToken = userToken;
	}


   
}
