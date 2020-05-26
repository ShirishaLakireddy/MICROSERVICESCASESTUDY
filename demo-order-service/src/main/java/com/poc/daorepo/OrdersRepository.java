package com.poc.daorepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, String> {

}