package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.YoulanluxianDao;
import com.cl.entity.YoulanluxianEntity;
import com.cl.service.YoulanluxianService;
import com.cl.entity.view.YoulanluxianView;

@Service("youlanluxianService")
public class YoulanluxianServiceImpl extends ServiceImpl<YoulanluxianDao, YoulanluxianEntity> implements YoulanluxianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YoulanluxianEntity> page = this.selectPage(
                new Query<YoulanluxianEntity>(params).getPage(),
                new EntityWrapper<YoulanluxianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YoulanluxianEntity> wrapper) {
		  Page<YoulanluxianView> page =new Query<YoulanluxianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YoulanluxianView> selectListView(Wrapper<YoulanluxianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YoulanluxianView selectView(Wrapper<YoulanluxianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
