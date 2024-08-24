package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DaoyouyuyueEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DaoyouyuyueView;


/**
 * 导游预约
 *
 * @author 
 * @email 
 * @date 2024-03-30 15:16:06
 */
public interface DaoyouyuyueService extends IService<DaoyouyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DaoyouyuyueView> selectListView(Wrapper<DaoyouyuyueEntity> wrapper);
   	
   	DaoyouyuyueView selectView(@Param("ew") Wrapper<DaoyouyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DaoyouyuyueEntity> wrapper);
   	

}

