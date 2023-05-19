package com.in28minutes.microservices.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.currencyexchangeservice.bean.CurrencyExchange;
import com.in28minutes.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {
	
	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class); 
	
	
	@Autowired
	private CurrencyExchangeRepository repository;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieExchangeValue(@PathVariable String from, @PathVariable String to) {
		
		logger.info("retriveExchangeValue called with {} to {}", from, to);
		
		CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
		if (currencyExchange == null) {
			throw new RuntimeException("unable to find data for from: " + from + " and to: " + to);
		}
		currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
		return currencyExchange;
	}
	
}
