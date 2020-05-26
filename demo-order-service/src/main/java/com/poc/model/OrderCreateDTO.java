package com.poc.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderCreateDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private BigDecimal id;

	private String itemType;

	private BigDecimal price;

	private String currency;

	public OrderCreateDTO(String itemType, BigDecimal price, String currency) {
		super();
		this.itemType = itemType;
		this.price = price;
		this.currency = currency;
	}

	public OrderCreateDTO() {
		super();
		// TODO Auto-generated constructor stub
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

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

}
