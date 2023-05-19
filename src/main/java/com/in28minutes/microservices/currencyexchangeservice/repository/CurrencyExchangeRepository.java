package com.in28minutes.microservices.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.in28minutes.microservices.currencyexchangeservice.bean.CurrencyExchange;

public interface CurrencyExchangeRepository  extends JpaRepository<CurrencyExchange, Long>{

	CurrencyExchange findByFromAndTo(String from, String to);
	
}
