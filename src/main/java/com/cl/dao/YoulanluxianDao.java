package com.cl.dao;

import com.cl.entity.YoulanluxianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YoulanluxianView;


/**
 * 游览路线
 * 
 * @author 
 * @email 
 * @date 2024-03-30 15:16:06
 */
public interface YoulanluxianDao extends BaseMapper<YoulanluxianEntity> {
	
	List<YoulanluxianView> selectListView(@Param("ew") Wrapper<YoulanluxianEntity> wrapper);

	List<YoulanluxianView> selectListView(Pagination page,@Param("ew") Wrapper<YoulanluxianEntity> wrapper);
	
	YoulanluxianView selectView(@Param("ew") Wrapper<YoulanluxianEntity> wrapper);
	

}
