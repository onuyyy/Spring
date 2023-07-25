package com.sist.dao;

import java.util.*;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class SeoulDAO extends SqlSessionDaoSupport {

	/*
	 * 	 	<select id="seoulListData" resultType="SeoulLocationVO" parameterType="hashMap">
 				SELECT no,title,address,num 
 				FROM (SELECT no,title,address rownum as num
 				FROM no,title,address
 				FROM seoul_location ORDER BY no ASC))
 				WHERE num BETWEEN #{start} AND #{end}
 			</select>
	 */	
	public List<SeoulLocationVO> seoulListData(Map map) {
		
		return getSqlSession().selectList("seoulListData",map);
	}
	
	
	/*
	 *  	<select id="seoulTotalPage" resultType="int">
 				SELECT CEIL(COUNT(*)/10.0) FROM seoul_location
 			</select>	
	 */
	public int seoulTotalPage() {
		return getSqlSession().selectOne("seoulTotalPage");
	}
	
	/*
	 *  	<select id="seoulFindData" resultType="SeoulLocationVO" parameterType="string">
 				SELECT no,title,address,msg
 				FROM seoul_location
 				WHERE title LIKE '%'||#{title}||'%'
 			</select>	
	 */
	public List<SeoulLocationVO> seoulFindData(String title) {
		return getSqlSession().selectList("seoulFindData",title);
	}
}
