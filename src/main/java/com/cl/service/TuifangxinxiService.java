package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.TuifangxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TuifangxinxiView;


/**
 * 退房信息
 *
 * @author 
 * @email 
 * @date 2024-03-30 15:16:06
 */
public interface TuifangxinxiService extends IService<TuifangxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TuifangxinxiView> selectListView(Wrapper<TuifangxinxiEntity> wrapper);
   	
   	TuifangxinxiView selectView(@Param("ew") Wrapper<TuifangxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TuifangxinxiEntity> wrapper);
   	

}

