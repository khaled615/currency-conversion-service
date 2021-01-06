package com.in45minutes.microservices;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.netflix.ribbon.proxy.annotation.ClientProperties;

//@FeignClient(name="currency-exchange-service", url="localhost:8000")
//A cause du Ribbon, nous configurions l'URL d'une autre manniére.
@FeignClient(name="currency-exchange-service")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}") 
	public CurrencyConversionBean retrieveExchangeValue
	(@PathVariable("from") String from, @PathVariable("to") String to); 
		
	
}
