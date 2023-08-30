package com.sist.web.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/*
 * NO int 
	TITLE text 
	POSTER text 
	MSG text 
	ADDRESS text 
	HIT int
 */

@Getter
@Setter
@Entity
@Table(name="seoul_location")
public class SeoulLocationEntity {

	@Id
	private int no;
	
	private int hit;
	private String title,poster,msg,address;
	
}
