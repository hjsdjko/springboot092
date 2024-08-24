package com.cl.dao;

import com.cl.entity.DaoyouyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DaoyouyuyueView;


/**
 * 导游预约
 * 
 * @author 
 * @email 
 * @date 2024-03-30 15:16:06
 */
public interface DaoyouyuyueDao extends BaseMapper<DaoyouyuyueEntity> {
	
	List<DaoyouyuyueView> selectListView(@Param("ew") Wrapper<DaoyouyuyueEntity> wrapper);

	List<DaoyouyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<DaoyouyuyueEntity> wrapper);
	
	DaoyouyuyueView selectView(@Param("ew") Wrapper<DaoyouyuyueEntity> wrapper);
	

}
