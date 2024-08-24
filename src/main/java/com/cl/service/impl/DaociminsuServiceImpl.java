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


import com.cl.dao.DaociminsuDao;
import com.cl.entity.DaociminsuEntity;
import com.cl.service.DaociminsuService;
import com.cl.entity.view.DaociminsuView;

@Service("daociminsuService")
public class DaociminsuServiceImpl extends ServiceImpl<DaociminsuDao, DaociminsuEntity> implements DaociminsuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DaociminsuEntity> page = this.selectPage(
                new Query<DaociminsuEntity>(params).getPage(),
                new EntityWrapper<DaociminsuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DaociminsuEntity> wrapper) {
		  Page<DaociminsuView> page =new Query<DaociminsuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DaociminsuView> selectListView(Wrapper<DaociminsuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DaociminsuView selectView(Wrapper<DaociminsuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
