package com.kafka.producer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public enum CountryEnum {

	CHENNAI("India", "tamil nadu", "Chennai", ThreadLocalRandom.current().nextInt(92, 105)+.3), VELLOR("India", "tamil nadu", "vellor", ThreadLocalRandom.current().nextInt(92, 105)+.5),
	KOVAI("India", "tamil nadu", "kovai", ThreadLocalRandom.current().nextInt(92, 105)+.4), TUTICORIN("India", "tamil nadu", "tuticorin", ThreadLocalRandom.current().nextInt(92, 105)+.6),
	MADURAI("India", "tamil nadu", "madurai", ThreadLocalRandom.current().nextInt(92, 105)+.5), SALEM("India", "tamil nadu", "salem", ThreadLocalRandom.current().nextInt(92, 105)+.7),
	Namakkal("India", "tamil nadu", "Namakkal", ThreadLocalRandom.current().nextInt(92, 105)+.7), Pammal("India", "tamil nadu", "pammal", ThreadLocalRandom.current().nextInt(92, 105)+.8),
	tambaram("India", "tamil nadu", "tambaram", ThreadLocalRandom.current().nextInt(92, 105)+.9), medavakkam("India", "tamil nadu", "medavakkam", ThreadLocalRandom.current().nextInt(92, 105)+.1),
	mouniya("SRILANKA", "tamil", "mouniya", ThreadLocalRandom.current().nextInt(92, 105)+.2), mullivaykal("SRILANKA", "tamil", "mullivaykal", ThreadLocalRandom.current().nextInt(92, 105)+.2),
	Jayawardenepura("SRILANKA", "Kolumbu", "Jayawardenepura", ThreadLocalRandom.current().nextInt(92, 105)+.5),
	mattakalapu("SRILANKA", "kolumbu", "mattakalapu", ThreadLocalRandom.current().nextInt(92, 105)+.0);

	private String country;
	private String state;
	private String city;
	private Double temp;

	private CountryEnum(String country, String state, String city, Double temp) {
		this.country = country;
		this.state = state;
		this.city = city;
		this.temp = temp;
	}

	public String getCountry() {
		return country;
	}

	public String getState() {
		return state;
	}

	public String getCity() {
		return city;
	}

	public Double getTemp() {
		return temp;
	}

	public static List<Weather> getCountryList() {
		List<Weather> weatherList = new ArrayList<Weather>();
		CountryEnum[] countries = CountryEnum.values();
		for (CountryEnum country : countries) {
			Weather weather = new Weather();
			weather.setCountry(country.getCountry());
			weather.setState(country.getState());
			weather.setCity(country.getCity());
			weather.setTemp(country.getTemp());
			weatherList.add(weather);
		}
		return weatherList;
	}

}
