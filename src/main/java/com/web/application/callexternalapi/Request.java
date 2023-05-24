package com.web.application.callexternalapi;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;

@Entity
public class Request {
	private String menu_id;
	private String menu_name;
	private String menu_price;

	public String getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(String menu_id) {
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
