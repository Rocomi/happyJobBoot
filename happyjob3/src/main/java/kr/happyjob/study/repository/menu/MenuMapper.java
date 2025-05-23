package kr.happyjob.study.repository.menu;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.happyjob.study.vo.menu.MainmenuVO;

@Mapper
public interface MenuMapper {
	List<MainmenuVO> mainmenusearch(Map<String, Object> paramMap);
	int mainmenusearchtotalcnt(Map<String, Object> paramMap);
	
	List<MainmenuVO> submenusearch(Map<String, Object> paramMap);
	int submenusearchtotalcnt(Map<String, Object> paramMap);
	
	int mainmenudupcheck(Map<String, Object> paramMap);
	
	int mainmenuinsert(Map<String, Object> paramMap);
	
	int mainmenuipdate(Map<String, Object> paramMap);	
	
	int mainmenudelete(Map<String, Object> paramMap);	
	
	MainmenuVO mainmenudetail(Map<String, Object> paramMap);
	
	MainmenuVO submenuselect(Map<String, Object> paramMap);
	
	int submenuinsert(Map<String, Object> paramMap);
	
	int submenuipdate(Map<String, Object> paramMap);
	
	int submenudelete(Map<String, Object> paramMap);
	
	
}

