package com.hand.entity;

import java.sql.Date;

public class Language extends Id {

	private String name;

	private Date last_update;

	public Language() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLast_update() {
		return last_update;
	}

	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}

}
