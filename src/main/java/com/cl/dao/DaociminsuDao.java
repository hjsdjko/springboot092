package com.cl.dao;

import com.cl.entity.DaociminsuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DaociminsuView;


/**
 * 到此民宿
 * 
 * @author 
 * @email 
 * @date 2024-03-30 15:16:06
 */
public interface DaociminsuDao extends BaseMapper<DaociminsuEntity> {
	
	List<DaociminsuView> selectListView(@Param("ew") Wrapper<DaociminsuEntity> wrapper);

	List<DaociminsuView> selectListView(Pagination page,@Param("ew") Wrapper<DaociminsuEntity> wrapper);
	
	DaociminsuView selectView(@Param("ew") Wrapper<DaociminsuEntity> wrapper);
	

}
