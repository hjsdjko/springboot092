package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YoulanluxianEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YoulanluxianView;


/**
 * 游览路线
 *
 * @author 
 * @email 
 * @date 2024-03-30 15:16:06
 */
public interface YoulanluxianService extends IService<YoulanluxianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YoulanluxianView> selectListView(Wrapper<YoulanluxianEntity> wrapper);
   	
   	YoulanluxianView selectView(@Param("ew") Wrapper<YoulanluxianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YoulanluxianEntity> wrapper);
   	

}

