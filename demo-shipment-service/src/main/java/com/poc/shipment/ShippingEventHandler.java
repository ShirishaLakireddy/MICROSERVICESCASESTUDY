package com.poc.shipment;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

import com.poc.model.OrderShippedEvent;
import com.poc.model.OrderShippedFailedEvent;

@Service
public class ShippingEventHandler {

	@EventHandler
	public void on(OrderShippedEvent orderShippedEvent) {

		System.out.println("ShippingEventHandler :: orderShippedEvent " + orderShippedEvent.shippingId);
		System.out.println("ShippingEventHandler :: orderShippedEvent user token" + orderShippedEvent.userToken);

	}

	@EventHandler
	public void on(OrderShippedFailedEvent orderShippedFailedEvent) {

		System.out.println("ShippingEventHandler :: orderShippedFailedEvent " + orderShippedFailedEvent.shippingId);

		System.out.println("ShippingEventHandler :: orderShippedFailedEvent user token" + orderShippedFailedEvent.userToken);

	}

}
