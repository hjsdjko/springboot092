package com.cl.dao;

import com.cl.entity.TuifangxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TuifangxinxiView;


/**
 * 退房信息
 * 
 * @author 
 * @email 
 * @date 2024-03-30 15:16:06
 */
public interface TuifangxinxiDao extends BaseMapper<TuifangxinxiEntity> {
	
	List<TuifangxinxiView> selectListView(@Param("ew") Wrapper<TuifangxinxiEntity> wrapper);

	List<TuifangxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<TuifangxinxiEntity> wrapper);
	
	TuifangxinxiView selectView(@Param("ew") Wrapper<TuifangxinxiEntity> wrapper);
	

}
