package com.cl.dao;

import com.cl.entity.DaoyoufuwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DaoyoufuwuView;


/**
 * 导游服务
 * 
 * @author 
 * @email 
 * @date 2024-03-30 15:16:06
 */
public interface DaoyoufuwuDao extends BaseMapper<DaoyoufuwuEntity> {
	
	List<DaoyoufuwuView> selectListView(@Param("ew") Wrapper<DaoyoufuwuEntity> wrapper);

	List<DaoyoufuwuView> selectListView(Pagination page,@Param("ew") Wrapper<DaoyoufuwuEntity> wrapper);
	
	DaoyoufuwuView selectView(@Param("ew") Wrapper<DaoyoufuwuEntity> wrapper);
	

}
