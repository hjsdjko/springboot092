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


import com.cl.dao.DasaojiluDao;
import com.cl.entity.DasaojiluEntity;
import com.cl.service.DasaojiluService;
import com.cl.entity.view.DasaojiluView;

@Service("dasaojiluService")
public class DasaojiluServiceImpl extends ServiceImpl<DasaojiluDao, DasaojiluEntity> implements DasaojiluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DasaojiluEntity> page = this.selectPage(
                new Query<DasaojiluEntity>(params).getPage(),
                new EntityWrapper<DasaojiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DasaojiluEntity> wrapper) {
		  Page<DasaojiluView> page =new Query<DasaojiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DasaojiluView> selectListView(Wrapper<DasaojiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DasaojiluView selectView(Wrapper<DasaojiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
