package com.poc.eventhandlers;

import java.util.UUID;

import javax.inject.Inject;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;

import com.poc.model.CreateInvoiceCommand;
import com.poc.model.CreateShippingCommand;
import com.poc.model.InvoiceCreatedEvent;
import com.poc.model.OrderCreatedEvent;
import com.poc.model.OrderShippedEvent;
import com.poc.model.OrderShippedFailedEvent;
import com.poc.model.OrderStatus;
import com.poc.model.OrderUpdatedEvent;
import com.poc.model.UpdateOrderStatusCommand;

@Saga
public class OrderManagementSaga {

	@Inject
	private transient CommandGateway commandGateway;

	@StartSaga
	@SagaEventHandler(associationProperty = "orderId")
	public void handle(OrderCreatedEvent orderCreatedEvent) {
		String paymentId = UUID.randomUUID().toString();
		System.out.println("Saga invoked");

		// associate Saga
		SagaLifecycle.associateWith("paymentId", paymentId);

		System.out.println("order id" + orderCreatedEvent.orderId);

		// send the commands
		commandGateway
				.send(new CreateInvoiceCommand(paymentId, orderCreatedEvent.orderId, orderCreatedEvent.userToken));
	}

	@SagaEventHandler(associationProperty = "paymentId")
	public void handle(InvoiceCreatedEvent invoiceCreatedEvent) {
		String shippingId = UUID.randomUUID().toString();

		System.out.println("Saga continued");

		// associate Saga with shipping
		SagaLifecycle.associateWith("shipping", shippingId);

		// send the create shipping command
		commandGateway.send(new CreateShippingCommand(shippingId, invoiceCreatedEvent.orderId,
				invoiceCreatedEvent.paymentId, invoiceCreatedEvent.userToken));
	}

	@SagaEventHandler(associationProperty = "orderId")
	public void handle(OrderShippedEvent orderShippedEvent) {
		commandGateway.send(new UpdateOrderStatusCommand(orderShippedEvent.orderId, String.valueOf(OrderStatus.SHIPPED),
				orderShippedEvent.userToken));
	}

	@SagaEventHandler(associationProperty = "orderId")
	public void handle(OrderShippedFailedEvent orderShippedFailedEvent) {
		commandGateway.send(new UpdateOrderStatusCommand(orderShippedFailedEvent.orderId,
				String.valueOf(OrderStatus.REJECTED), orderShippedFailedEvent.userToken));
	}

	@SagaEventHandler(associationProperty = "orderId")
	public void handle(OrderUpdatedEvent orderUpdatedEvent) {
		SagaLifecycle.end();
	}
}
