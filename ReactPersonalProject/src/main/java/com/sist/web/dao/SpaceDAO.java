package com.sist.web.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.SpaceEntity;

@Repository
public interface SpaceDAO extends JpaRepository<SpaceEntity,Integer> {

	public SpaceEntity findBySpaceId(int spaceId);
	
	@Query(value="SELECT * FROM space_list",nativeQuery=true)
	public List<SpaceEntity> spaceList();
	
	// 카테고리 이름 리스트
	@Query(value="SELECT DISTINCT category FROM space_list",nativeQuery=true)
	public List<String> spaceCateName();
	
	// 카테고리별 총 개수
	@Query(value="SELECT category, COUNT(*) FROM space_list WHERE category=:category GROUP BY category",nativeQuery=true)
	public int categoryCount(String category);
	
	// 카테고리별 공간 리스트
	public List<SpaceEntity> findByCategory(String category);
	
	
	// page
	@Query(value="SELECT * FROM space_list WHERE title LIKE CONCAT('%',:fd,'%') "
			+ "LIMIT :start, 20"
			,nativeQuery=true)
	public List<SpaceEntity> spaceFindData(@Param("fd") String fd,@Param("start") Integer start);
	
	
	@Query(value="SELECT CEIL(COUNT(*)/20.0) FROM space_list "
			+ "WHERE title LIKE CONCAT('%',:fd,'%')",nativeQuery=true)
	public int spaceFindTotalPage(String fd);

	
}
