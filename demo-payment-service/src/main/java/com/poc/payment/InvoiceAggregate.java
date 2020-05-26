package com.poc.payment;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.poc.model.CreateInvoiceCommand;
import com.poc.model.InvoiceCreatedEvent;

@Aggregate
public class InvoiceAggregate {

	@AggregateIdentifier
	private String paymentId;

	private String orderId;

	private InvoiceStatus invoiceStatus;

	private String userToken;

	public InvoiceAggregate() {
	}

	@CommandHandler
	public InvoiceAggregate(CreateInvoiceCommand createInvoiceCommand) {
		AggregateLifecycle.apply(new InvoiceCreatedEvent(createInvoiceCommand.paymentId, createInvoiceCommand.orderId,
				createInvoiceCommand.userToken));
	}

	@EventSourcingHandler
	protected void on(InvoiceCreatedEvent invoiceCreatedEvent) {
		this.paymentId = invoiceCreatedEvent.paymentId;
		this.orderId = invoiceCreatedEvent.orderId;
		this.invoiceStatus = InvoiceStatus.PAID;
		this.userToken = invoiceCreatedEvent.userToken;
	}
}
