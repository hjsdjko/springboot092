package com.cl.dao;

import com.cl.entity.DasaojiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DasaojiluView;


/**
 * 打扫记录
 * 
 * @author 
 * @email 
 * @date 2024-03-30 15:16:06
 */
public interface DasaojiluDao extends BaseMapper<DasaojiluEntity> {
	
	List<DasaojiluView> selectListView(@Param("ew") Wrapper<DasaojiluEntity> wrapper);

	List<DasaojiluView> selectListView(Pagination page,@Param("ew") Wrapper<DasaojiluEntity> wrapper);
	
	DasaojiluView selectView(@Param("ew") Wrapper<DasaojiluEntity> wrapper);
	

}
