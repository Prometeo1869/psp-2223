package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @author Juan Cebrian
 *
 */
@RestController
public class GreetingController {
	
	private static final String template = "Hola, %s!";
	private final AtomicLong counter = new AtomicLong();
/**
 * Controller
 * 
 * @param name
 * @return
 */
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "Mundo") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
}
