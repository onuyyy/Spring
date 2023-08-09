package com.sist.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import com.sist.dao.MusicDAO;
import java.util.*;
import com.sist.vo.*;

public interface MusicMapper {

	@Select("SELECT * FROM genie_music "
			+ "WHERE cno=#{cno} "
			+ "ORDER BY mno ASC")
	public List<MusicVO> musicListData(int cno);

	@Select("SELECT * FROM genie_music "
			+ "WHERE mno=#{mno}")
	public MusicVO musicDetailData(int mno);
	
}
