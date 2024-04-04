package com.example.demo.model;

import org.hibernate.annotations.SQLInsert;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Alienobject {
	
	@Id
	private int aid;
	private String aname;
	private String company;
	private String employeeid;
	private String tech;
	
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + ", company=" + company + ", employeeid=" + employeeid
				+ ", tech=" + tech + "]";
	}
	
	

}

