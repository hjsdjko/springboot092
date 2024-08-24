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


import com.cl.dao.DaoyoufuwuDao;
import com.cl.entity.DaoyoufuwuEntity;
import com.cl.service.DaoyoufuwuService;
import com.cl.entity.view.DaoyoufuwuView;

@Service("daoyoufuwuService")
public class DaoyoufuwuServiceImpl extends ServiceImpl<DaoyoufuwuDao, DaoyoufuwuEntity> implements DaoyoufuwuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DaoyoufuwuEntity> page = this.selectPage(
                new Query<DaoyoufuwuEntity>(params).getPage(),
                new EntityWrapper<DaoyoufuwuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DaoyoufuwuEntity> wrapper) {
		  Page<DaoyoufuwuView> page =new Query<DaoyoufuwuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DaoyoufuwuView> selectListView(Wrapper<DaoyoufuwuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DaoyoufuwuView selectView(Wrapper<DaoyoufuwuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
