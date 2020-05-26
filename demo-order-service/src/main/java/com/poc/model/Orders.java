package com.poc.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Orders {

	@Id
	private String orderId;

	private String itemType;

	private BigDecimal price;

	private String currency;

	private String orderStatus;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(String orderId, String itemType, BigDecimal price, String currency, String orderStatus) {
		super();
		this.orderId = orderId;
		this.itemType = itemType;
		this.price = price;
		this.currency = currency;
		this.orderStatus = orderStatus;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", itemType=" + itemType + ", price=" + price + ", currency=" + currency
				+ ", orderStatus=" + orderStatus + "]";
	}

}