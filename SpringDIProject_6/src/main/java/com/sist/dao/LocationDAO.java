package com.sist.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.SeoulLocationVO;


public class LocationDAO extends SqlSessionDaoSupport {
	/*
	 * 	 <sql id="select-sql">
	 	 	SELECT no,title,address,msg
	 		FROM seoul_location
		 </sql>
		 
	 	<select id="locationListData" resultType="locationVO">
			<include refid="select-sql"/>
	 			ORDER BY no ASC
	 	</select>
	 	
	 	<select id="locationDetailData" resultType="locationCO" parameterType="int">
			<include refid="select-sql"/>
	 			WHERE no=#{no}
	 	</select>
	 */
	public List<SeoulLocationVO> locationListData() {
		return getSqlSession().selectList("locationListData");	// id 명칭 넣어줌 => 해당 sql문장 실행
	}
	
	public SeoulLocationVO locationDetailData(int no) {
		return getSqlSession().selectOne("locationDetailData",no);	
	}

}
