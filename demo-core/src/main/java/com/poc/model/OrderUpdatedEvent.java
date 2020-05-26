package com.poc.model;


public class OrderUpdatedEvent {

    public final String orderId;

    public final String orderStatus;
    
    public final String userToken;

	public OrderUpdatedEvent(String orderId, String orderStatus, String userToken) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.userToken = userToken;
	}


}
