package com.cs.compBagTracker.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="discs")
public class Discs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String discCompany;
	
	private String discName;
	
	private String type;
	
	private String speed;
	
	private String glide;
	
	private String turn;
	
	private String fade;
	
	private Date createdAt;
	
	private Date updatedAt;
	
	
	@JsonIgnore
	@ManyToMany(mappedBy="discsInBag")
	private List<Bags> bags = new ArrayList<>();
	
	
	
	public Discs() {}




	public Discs(Long id, String discCompany, String discName, String type, String speed, String glide, String turn,
			String fade, Date createdAt, Date updatedAt, List<Bags> bags) {
		super();
		this.id = id;
		this.discCompany = discCompany;
		this.discName = discName;
		this.type = type;
		this.speed = speed;
		this.glide = glide;
		this.turn = turn;
		this.fade = fade;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.bags = bags;
	}





	public Long getId() {
		return id;
	}






	public void setId(Long id) {
		this.id = id;
	}






	public String getDiscCompany() {
		return discCompany;
	}






	public void setDiscCompany(String company) {
		this.discCompany = company;
	}






	public String getDiscName() {
		return discName;
	}






	public void setDiscName(String discName) {
		this.discName = discName;
	}











	public String getSpeed() {
		return speed;
	}






	public void setSpeed(String speed) {
		this.speed = speed;
	}






	public String getGlide() {
		return glide;
	}






	public void setGlide(String glide) {
		this.glide = glide;
	}






	public String getTurn() {
		return turn;
	}






	public void setTurn(String turn) {
		this.turn = turn;
	}






	public String getFade() {
		return fade;
	}






	public void setFade(String fade) {
		this.fade = fade;
	}






	public Date getCreatedAt() {
		return createdAt;
	}






	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}






	public Date getUpdatedAt() {
		return updatedAt;
	}






	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}




	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
	
	

}