package com.poc.service;

import java.util.concurrent.CompletableFuture;

import com.poc.model.OrderCreateDTO;

public interface OrderCommandService {

    public CompletableFuture<String> createOrder(OrderCreateDTO orderCreateDTO);

}
