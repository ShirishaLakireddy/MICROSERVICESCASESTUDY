package com.poc.daorepo;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.model.OrderCreateDTO;
import com.poc.model.Orders;

@Repository
public interface OrderCreateRepository extends JpaRepository<Orders, BigDecimal> {

}
