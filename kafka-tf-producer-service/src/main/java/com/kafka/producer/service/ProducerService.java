package com.kafka.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProducerService.class);

	private final KafkaTemplate<String, Weather> kafkaTemplate;

	@Autowired
	public ProducerService(KafkaTemplate<String, Weather> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	@Autowired
	private WeatherReportUtil weather;

	public void sendMessage() {
		String topic = "meenatopic";

		/*
		 * File file = new File("C:/KafkaProd/"); File[] files = file.listFiles(); for
		 * (File f : files) { System.out.println(f.getName()); String fileName =
		 * f.getName(); FileInputStream fis; try {
		 * 
		 * fis = new FileInputStream("C:/KafkaProd/" + fileName); byte[] filevalue = new
		 * byte[(int) file.length()]; fis.read(filevalue); fis.close();
		 * 
		 * String filecontent = new String(filevalue, "UTF-8");
		 * 
		 * System.out.println(filecontent);
		 */
		//while (true) {
			try {
				// for (Weather weather : CountryEnum.getCountryList()) {
				for (String city : CityConstant.CITY) {
					Weather wea=weather.getWeatherReport(city.trim());
					//Thread.sleep(1000);
					System.out.println("sending data='{}' to topic='{}'" + wea.toString() + "" + topic);
					Message<Weather> message = MessageBuilder.withPayload(wea)
							.setHeader(KafkaHeaders.TOPIC, topic).build();
					this.kafkaTemplate.send(message);

				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}


