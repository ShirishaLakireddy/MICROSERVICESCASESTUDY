package com.poc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.daorepo.OrderCreateRepository;
import com.poc.model.OrderCreateDTO;
import com.poc.model.OrderUpdatedEvent;
import com.poc.model.Orders;
import com.poc.service.OrderCommandService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/api/orders")
@Api(value = "Order Commands", description = "Order Commands Related Endpoints", tags = "Order Commands")
public class OrderCommandController {

	@Autowired
	private OrderCreateRepository orderCreateRepository;

	private OrderCommandService orderCommandService;

	public OrderCommandController(OrderCommandService orderCommandService) {
		this.orderCommandService = orderCommandService;
	}

	@PostMapping("/create")
	public CompletableFuture<String> createOrder(@RequestBody OrderCreateDTO orderCreateDTO) {
		return orderCommandService.createOrder(orderCreateDTO);
	}

	@GetMapping("/all")
	public List<Orders> getALLOrders() {
		System.out.println("In getALLOrders");
		List<Orders> ordersList= new ArrayList();
		ordersList = orderCreateRepository.findAll();
		System.out.println("In getALLOrders"+ ordersList.size());
		return ordersList;
	}
}
