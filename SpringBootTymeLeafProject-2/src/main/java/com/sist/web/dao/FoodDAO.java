package com.sist.web.dao;

import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sist.web.entity.*;

@Repository 								// table명 , id의 데이터형 integer
public interface FoodDAO extends JpaRepository<FoodEntity,Integer> {

//	public FoodEntity findByFno(int fno);
	// SELECT * FROM food_location WHERE fno=1
	// insert, update, delete
	
	@Query(value = "SELECT * FROM food_location "
	        + "WHERE address LIKE CONCAT('%', :address, '%') "  // 수정된 부분
	        + "ORDER BY fno ASC "
	        + "LIMIT :start, 12", nativeQuery = true)
	public List<FoodEntity> foodFindData(@Param("address") String address,
	                                     @Param("start") Integer start);

	@Query(value = "SELECT CEIL(COUNT(*)/12.0) FROM food_location "
	        + "WHERE address LIKE CONCAT('%', :address, '%')",  // 수정된 부분
	        nativeQuery = true)
	public int foodFindTotalPage(@Param("address") String address);

	// 메소드를 사용할 수도 있고 @Query로 sql문 직접 쓸 수도 있다
	
					// findBy컬럼명(==fno)
	public FoodEntity findByFno(@Param("fno") Integer fno);
						// select * from food_location WHERE fno=10;
}


