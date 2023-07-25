package com.sist.dao;

import java.util.List;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import com.sist.vo.SeoulShopVO;

public class ShopDAO extends SqlSessionDaoSupport {

	/*
	 *  	<select id="shopLocationListData" resultType="SeoulShopVO">
		 		SELECT * FROM seoul_shop
		 	</select>
		 	<select id="shopDetailData" resultType="SeoulShopVO" parameterType="int">
		 		SELECT * FROM seoul_shop
		 		WHERE no=#{no}
		 	</select>
	 */
	public List<SeoulShopVO> shopLocationListData() {
		return getSqlSession().selectList("shopLocationListData");
	}
	
	
}
