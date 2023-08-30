package com.sist.web.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.vo.*;

@Repository
@Mapper			// MappaerFactoryBean => interface 구현해줌
public interface FoodMapper {

	public List<CategoryVO> categoryListData();	// 구현
	
}
