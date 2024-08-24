package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DasaojiluEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DasaojiluView;


/**
 * 打扫记录
 *
 * @author 
 * @email 
 * @date 2024-03-30 15:16:06
 */
public interface DasaojiluService extends IService<DasaojiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DasaojiluView> selectListView(Wrapper<DasaojiluEntity> wrapper);
   	
   	DasaojiluView selectView(@Param("ew") Wrapper<DasaojiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DasaojiluEntity> wrapper);
   	

}

