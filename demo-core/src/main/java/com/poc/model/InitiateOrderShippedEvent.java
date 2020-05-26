package com.poc.model;


public class InitiateOrderShippedEvent {

    public final String shippingId;

    public final String orderId;

    public final String paymentId;

    public final String userToken;

	public InitiateOrderShippedEvent(String shippingId, String orderId, String paymentId, String userToken) {
		super();
		this.shippingId = shippingId;
		this.orderId = orderId;
		this.paymentId = paymentId;
		this.userToken = userToken;
	}

}
