package com.poc.model;


import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class UpdateOrderStatusCommand {

    @TargetAggregateIdentifier
    public final String orderId;

    public final String orderStatus;
    
    public final String userToken;

	public UpdateOrderStatusCommand(String orderId, String orderStatus, String userToken) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.userToken = userToken;
	}

    
}
