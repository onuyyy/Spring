package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroundVO {

	/*
	 * GNO	NUMBER
		GNAME	VARCHAR2(100 BYTE)
		GADDR	VARCHAR2(300 BYTE)
		GIMAGE	VARCHAR2(4000 BYTE)
		GNOTICE	CLOB
		GPRICE	NUMBER
		FOOTBALL_RESERVE_DAY	VARCHAR2(200 BYTE)
	 */
	
//	private int gno,gprice;
//	private String gname,gaddr,gimage,gnotice;
	
	//"SELECT gno, goods_name, goods_image, TO_CHAR(cprice, '999,999') as dbcprice
	
	private int gno;
	private String goods_name,goods_image;
	
}
