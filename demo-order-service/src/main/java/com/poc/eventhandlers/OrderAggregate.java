package com.poc.eventhandlers;

import java.math.BigDecimal;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.factory.annotation.Autowired;

import com.poc.daorepo.OrdersRepository;
import com.poc.model.CreateOrderCommand;
import com.poc.model.ItemType;
import com.poc.model.OrderCreatedEvent;
import com.poc.model.OrderStatus;
import com.poc.model.OrderUpdatedEvent;
import com.poc.model.UpdateOrderStatusCommand;

@Aggregate
public class OrderAggregate {

	@AggregateIdentifier
	private String orderId;

	private ItemType itemType;

	private BigDecimal price;

	private String currency;

	private OrderStatus orderStatus;

	@Autowired
	private OrdersRepository ordersRepository;

	public OrderAggregate() {
	}

	@CommandHandler
	public OrderAggregate(CreateOrderCommand createOrderCommand) {

		AggregateLifecycle.apply(new OrderCreatedEvent(createOrderCommand.orderId, createOrderCommand.itemType,
				createOrderCommand.price, createOrderCommand.currency, createOrderCommand.orderStatus, createOrderCommand.userToken));

	}

	@EventSourcingHandler
	protected void on(OrderCreatedEvent orderCreatedEvent) {
		this.orderId = orderCreatedEvent.orderId;
		this.itemType = ItemType.valueOf(orderCreatedEvent.itemType);
		this.price = orderCreatedEvent.price;
		this.currency = orderCreatedEvent.currency;
		this.orderStatus = OrderStatus.valueOf(orderCreatedEvent.orderStatus);

	}

	@CommandHandler
	protected void on(UpdateOrderStatusCommand updateOrderStatusCommand) {
		AggregateLifecycle.apply(new OrderUpdatedEvent(updateOrderStatusCommand.orderId,
				updateOrderStatusCommand.orderStatus, updateOrderStatusCommand.userToken));
	}

	@EventSourcingHandler
	protected void on(OrderUpdatedEvent orderUpdatedEvent) {
		this.orderId = orderUpdatedEvent.orderId;
		this.orderStatus = OrderStatus.valueOf(orderUpdatedEvent.orderStatus);
	}
}
