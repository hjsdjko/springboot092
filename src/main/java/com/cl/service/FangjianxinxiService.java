package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.FangjianxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FangjianxinxiView;


/**
 * 房间信息
 *
 * @author 
 * @email 
 * @date 2024-03-30 15:16:06
 */
public interface FangjianxinxiService extends IService<FangjianxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FangjianxinxiView> selectListView(Wrapper<FangjianxinxiEntity> wrapper);
   	
   	FangjianxinxiView selectView(@Param("ew") Wrapper<FangjianxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FangjianxinxiEntity> wrapper);
   	

}

