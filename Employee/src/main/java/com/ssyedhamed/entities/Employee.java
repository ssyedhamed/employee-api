package com.ssyedhamed.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.Getter;

@Entity
@Table(name = "employee_details")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eid")
	private long id;
	@Column(name = "e_name")
	private String name;
	@Column(name = "e_role")
	private String role;
	@Column(name="e_description", length = 2000)
	private String about;
	@Column(name="e_joiningDate")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate joiningDate;
	@Column(name="e_exp")
	private int experience;// in years
	@OneToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name = "addr_id")
	@JsonManagedReference
	private Address address;
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Employee(long id, String name, String role, String about, LocalDate joiningDate, int experience, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.about = about;
		this.joiningDate = joiningDate;
		this.experience = experience;
		this.address=address;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public LocalDate getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", role=" + role + ", about=" + about + ", joiningDate="
				+ joiningDate + ", experience=" + experience + "]";
	}
	
}
