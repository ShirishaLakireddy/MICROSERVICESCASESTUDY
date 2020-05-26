package com.poc.daorepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.model.JwtResponse;

@Repository
public interface JwtResponseRepository extends JpaRepository<JwtResponse, Long> {

	JwtResponse findByUsername(String subject);

}
