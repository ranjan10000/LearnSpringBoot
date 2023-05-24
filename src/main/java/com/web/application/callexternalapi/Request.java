package com.web.application.callexternalapi;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;

@Entity
public class Request {
	private Long menu_id;
	private String menu_name;
	private String menu_price;

	public Long getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(Long menu_id) {
		this.menu_id = menu_id;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public String getMenu_price() {
		return menu_price;
	}

	public void setMenu_price(String menu_price) {
		this.menu_price = menu_price;
	}

}
