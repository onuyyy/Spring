package com.sist.web.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sist.web.entity.SeoulLocationEntity;

@Repository
public interface SeoulLocationDAO extends JpaRepository<SeoulLocationEntity,Integer>{
	
	@Query(value="SELECT * FROM seoul_location "
			+ "WHERE address LIKE CONCAT('%',:address,'%') "
			+ "LIMIT :start, 12",nativeQuery=true)
	public List<SeoulLocationEntity> seoulLocationFindData(@Param("address") String address,
															@Param("start") Integer start);
	
	@Query(value="SELECT CEIL(COUNT(*)/12.0) FROM seoul_location "
			+ "WHERE address LIKE CONCAT('%',:address,'%')",nativeQuery=true)
	public int seoulLocationFindTotalPage(@Param("address") String address);
	
}
