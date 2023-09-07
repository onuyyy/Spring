package com.sist.web.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity		// table과 연결되어 있는 객체이다 
@Table(name="seoul_location")
@Getter
@Setter
public class SeoulEntity {

	@Id
	private int no;
	private int hit;
	private String title,poster,msg,address; 
	
}
