package com.kafka.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.producer.service.ProducerService;
import com.kafka.producer.service.Weather;
import com.kafka.producer.service.WeatherReportUtil;

@RestController
public class ProducerController {
	
	@Autowired
	private ProducerService producerService;
	@Autowired
	private WeatherReportUtil weather;
	@Autowired
	private Environment env;
	@GetMapping("/send")
	public boolean sendMessage() {
		System.out.println(env.getProperty("kafka.bootstrap.servers"));
		producerService.sendMessage();
		return true;
	}
	@GetMapping("/send/{city}")
	public Weather sendMessage(@PathVariable String city) {
		Weather wea = null;
		try {
			wea=weather.getWeatherReport(city);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wea;
	}
}
