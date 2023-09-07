package com.sist.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="space_list")
public class SpaceEntity {

	/*
	 * SPACE_ID int 
		TITLE text 
		SUBJECT text 
		PHONE text 
		ADDRESS text 
		LATITUDE double 
		LONGITUDE double 
		PRICE int 
		MIN_GUEST int 
		MAX_GUEST int 
		STARTTIME int 
		ENDTIME int 
		DESCRIPTION text 
		CATEGORY text 
		POSTER text
	 */
	
	@Id
	@Column(name = "space_id")
	private int spaceId;

	
	private int price,min_guest,max_guest,starttime,endtime;
	private double latitude,longitude;
	private String title,subject,phone,address,description,category,poster;
	
}
