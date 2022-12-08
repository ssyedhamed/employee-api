package com.ssyedhamed.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "addresses")
public class Address {
	@Id
	@Column(name = "addr_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String landmark;
	private String city;
	private String state;
	@Column(name = "zipcode", length = 10)
	private int zipcode;
	@JsonBackReference
	@OneToOne(mappedBy = "address")
	private Employee emp;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(long id, String landmark, String city, String state, int zipcode) {
		super();
		this.id = id;
		this.landmark = landmark;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", landmark=" + landmark + ", city=" + city + ", state=" + state + ", zipcode="
				+ zipcode + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
}
