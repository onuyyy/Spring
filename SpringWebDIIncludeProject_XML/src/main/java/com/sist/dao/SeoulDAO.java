package com.sist.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.mapper.*;
import com.sist.vo.*;

@Repository
public class SeoulDAO {

	@Autowired
	private SeoulMapper mapper;
	
	/*
	 * 	@Select("SELECT no,title,poster,num "
			+ "FROM (SELECT no,title,poster,rownum as num "
			+ "FROM (SELECT no,title,poster "
			+ "FROM seoul_location "
			+ "ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")*/
		public List<SeoulVO> seoulLocationListData(Map map) {
			return mapper.seoulLocationListData(map);
		}
		
	
	/*	@Select("SELECT CEIL(COUNT(*)/12.0) FROM seoul_location") */
		public int seoulLocationTotalPage() {
			return mapper.seoulLocationTotalPage();
		}

		
			// seoul_shop
		/*
		 * 	@Select("SELECT no,title,poster,address,hit, num "
			+ "FROM (SELECT no,title,poster,address,hit,rownum as num "
			+ "FROM (SELECT no,title,poster,address,hit "
			+ "FROM seoul_shop "
			+ "ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} and #{end}")*/
			public List<SeoulShopVO> seoulShopListData(Map map) {
				return mapper.seoulShopListData(map);
			}
			
//			@Select("SELECT CEIL(COUNT(*)/12.0) FROM seoul_shop")
			public int seoulShopTotalPage() {
				return mapper.seoulShopTotalPage();
			}
		
			
			// seoul_nature		
//			@Select("SELECT no,title,poster,address,hit,num "
//					+ "FROM (SELECT no,title,poster,address,hit,rownum as num "
//					+ "FROM (SELECT no,title,poster,address,hit "
//					+ "FROM seoul_nature "
//					+ "ORDER BY no ASC)) "
//					+ "WHERE num BETWEEN #{start} AND #{end}")
			public List<SeoulNatureVO> seoulNatureListData(Map map) {
				return mapper.seoulNatureListData(map);
			}
		
//			@Select("SELECT CEIL(COUNT(*)/12.0) FROM seoul_nature")
			public int seoulNatureTotalPage() {
				return mapper.seoulNatureTotalPage();
			}
			
			
			
}
