package com.hand.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class Film extends Id {

	private String title;

	private String description;

	private Date release_year;

	private Long language_id;

	private Long original_language_id;

	private Long rental_duration;

	private double rental_rate;

	private Long length;

	private double replacement_cost;

	private String rating;

	private String special_features;

	private Timestamp last_update;

	// 表中没有的字段，需要在页面中一起显示，所以加进来
	private String language;

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getRelease_year() {
		return release_year;
	}

	public void setRelease_year(Date release_year) {
		this.release_year = release_year;
	}

	public Long getLanguage_id() {
		return language_id;
	}

	public void setLanguage_id(Long language_id) {
		this.language_id = language_id;
	}

	public Long getOriginal_language_id() {
		return original_language_id;
	}

	public void setOriginal_language_id(Long original_language_id) {
		this.original_language_id = original_language_id;
	}

	public Long getRental_duration() {
		return rental_duration;
	}

	public void setRental_duration(Long rental_duration) {
		this.rental_duration = rental_duration;
	}

	public double getRental_rate() {
		return rental_rate;
	}

	public void setRental_rate(double rental_rate) {
		this.rental_rate = rental_rate;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}

	public double getReplacement_cost() {
		return replacement_cost;
	}

	public void setReplacement_cost(double replacement_cost) {
		this.replacement_cost = replacement_cost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecial_features() {
		return special_features;
	}

	public void setSpecial_features(String special_features) {
		this.special_features = special_features;
	}

	public Timestamp getLast_update() {
		return last_update;
	}

	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}

}
