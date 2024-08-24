package com.cl.dao;

import com.cl.entity.FangjianxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FangjianxinxiView;


/**
 * 房间信息
 * 
 * @author 
 * @email 
 * @date 2024-03-30 15:16:06
 */
public interface FangjianxinxiDao extends BaseMapper<FangjianxinxiEntity> {
	
	List<FangjianxinxiView> selectListView(@Param("ew") Wrapper<FangjianxinxiEntity> wrapper);

	List<FangjianxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<FangjianxinxiEntity> wrapper);
	
	FangjianxinxiView selectView(@Param("ew") Wrapper<FangjianxinxiEntity> wrapper);
	

}
