package com.cl.dao;

import com.cl.entity.JingdianjieshaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JingdianjieshaoView;


/**
 * 景点介绍
 * 
 * @author 
 * @email 
 * @date 2024-03-30 15:16:06
 */
public interface JingdianjieshaoDao extends BaseMapper<JingdianjieshaoEntity> {
	
	List<JingdianjieshaoView> selectListView(@Param("ew") Wrapper<JingdianjieshaoEntity> wrapper);

	List<JingdianjieshaoView> selectListView(Pagination page,@Param("ew") Wrapper<JingdianjieshaoEntity> wrapper);
	
	JingdianjieshaoView selectView(@Param("ew") Wrapper<JingdianjieshaoEntity> wrapper);
	

}
