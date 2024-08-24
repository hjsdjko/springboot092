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


import com.cl.dao.DaoyouyuyueDao;
import com.cl.entity.DaoyouyuyueEntity;
import com.cl.service.DaoyouyuyueService;
import com.cl.entity.view.DaoyouyuyueView;

@Service("daoyouyuyueService")
public class DaoyouyuyueServiceImpl extends ServiceImpl<DaoyouyuyueDao, DaoyouyuyueEntity> implements DaoyouyuyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DaoyouyuyueEntity> page = this.selectPage(
                new Query<DaoyouyuyueEntity>(params).getPage(),
                new EntityWrapper<DaoyouyuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DaoyouyuyueEntity> wrapper) {
		  Page<DaoyouyuyueView> page =new Query<DaoyouyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DaoyouyuyueView> selectListView(Wrapper<DaoyouyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DaoyouyuyueView selectView(Wrapper<DaoyouyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
