package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JingdianjieshaoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JingdianjieshaoView;


/**
 * 景点介绍
 *
 * @author 
 * @email 
 * @date 2024-03-30 15:16:06
 */
public interface JingdianjieshaoService extends IService<JingdianjieshaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JingdianjieshaoView> selectListView(Wrapper<JingdianjieshaoEntity> wrapper);
   	
   	JingdianjieshaoView selectView(@Param("ew") Wrapper<JingdianjieshaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JingdianjieshaoEntity> wrapper);
   	

}

