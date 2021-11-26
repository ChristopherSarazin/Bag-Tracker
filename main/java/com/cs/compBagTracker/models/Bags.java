package com.cs.compBagTracker.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "golfbag")
public class Bags {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String bagname;
	
	private String courseCondition;
	
	private String courseType;
	
	private Date createdAt;
	
	private Date updatedAt;
	

	@ManyToMany
	@JoinTable(
			name = "discsInBag",
			joinColumns = @JoinColumn(name="bag_id"),
			inverseJoinColumns = @JoinColumn(name="disc_id")
			)
	private List<Discs> discsInBag = new ArrayList<>();

	public Bags() {}

	public Bags(Long id, String bagname, String courseCondition, String courseType, Date createdAt, Date updatedAt,
			List<Discs> discsInBag) {
		super();
		this.id = id;
		this.bagname = bagname;
		this.courseCondition = courseCondition;
		this.courseType = courseType;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.discsInBag = discsInBag;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBagname() {
		return bagname;
	}

	public void setBagname(String bagname) {
		this.bagname = bagname;
	}

	public String getCourseCondition() {
		return courseCondition;
	}

	public void setCourseCondition(String courseCondition) {
		this.courseCondition = courseCondition;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
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

	public List<Discs> getDiscsInBag() {
		return discsInBag;
	}


	public void discsInBag(Discs disc) {
		discsInBag.add(disc);
		
	}
	
	public void removeDiscsFromBag(Discs disc) {
		discsInBag.remove(disc);
	}




	
}