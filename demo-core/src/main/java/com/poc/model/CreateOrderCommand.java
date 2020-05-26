package com.poc.model;

import java.math.BigDecimal;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateOrderCommand {

    @TargetAggregateIdentifier
    public final String orderId;

    public final String itemType;

    public final BigDecimal price;

    public final String currency;

    public final String orderStatus;

    public final String userToken;

	public CreateOrderCommand(String orderId, String itemType, BigDecimal price, String currency, String orderStatus,
			String userToken) {
		super();
		this.orderId = orderId;
		this.itemType = itemType;
		this.price = price;
		this.currency = currency;
		this.orderStatus = orderStatus;
		this.userToken = userToken;
	}

    
}
